package com.facebook.react.views.scroll;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import java.util.List;

public class ReactScrollView extends ScrollView implements ReactClippingViewGroup, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener {
    public static Field sScrollerField = null;
    public static boolean sTriedToGetScrollerField = false;
    public boolean mActivelyScrolling;
    public Rect mClippingRect;
    public View mContentView;
    public float mDecelerationRate = 0.985f;
    public boolean mDisableIntervalMomentum = false;
    public boolean mDragging;
    public Drawable mEndBackground;
    public int mEndFillColor = 0;
    public FpsListener mFpsListener = null;
    public final OnScrollDispatchHelper mOnScrollDispatchHelper = new OnScrollDispatchHelper();
    public String mOverflow = "hidden";
    public boolean mPagingEnabled = false;
    public Runnable mPostTouchRunnable;
    public ReactViewBackgroundManager mReactBackgroundManager;
    public final Rect mRect = new Rect();
    public boolean mRemoveClippedSubviews;
    public boolean mScrollEnabled = true;
    public String mScrollPerfTag;
    public final OverScroller mScroller;
    public boolean mSendMomentumEvents;
    public int mSnapInterval = 0;
    public List<Integer> mSnapOffsets;
    public boolean mSnapToEnd = true;
    public boolean mSnapToStart = true;
    public StateWrapper mStateWrapper;
    public final VelocityHelper mVelocityHelper = new VelocityHelper();
    public int pendingContentOffsetX = -1;
    public int pendingContentOffsetY = -1;

    public ReactScrollView(ReactContext reactContext, FpsListener fpsListener) {
        super(reactContext);
        this.mFpsListener = fpsListener;
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mScroller = getOverScrollerFromParent();
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(33554432);
    }

    private int getMaxScrollY() {
        return Math.max(0, this.mContentView.getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    private OverScroller getOverScrollerFromParent() {
        if (!sTriedToGetScrollerField) {
            sTriedToGetScrollerField = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                sScrollerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                FLog.w("ReactNative", "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = sScrollerField;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            FLog.w("ReactNative", "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to get mScroller from ScrollView!", e);
        }
    }

    private int getSnapInterval() {
        int i = this.mSnapInterval;
        if (i != 0) {
            return i;
        }
        return getHeight();
    }

    public void draw(Canvas canvas) {
        boolean z = false;
        if (this.mEndFillColor != 0) {
            View childAt = getChildAt(0);
            if (!(this.mEndBackground == null || childAt == null || childAt.getBottom() >= getHeight())) {
                this.mEndBackground.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        getDrawingRect(this.mRect);
        String str = this.mOverflow;
        if (str.hashCode() != 466743410 || !str.equals("visible")) {
            z = true;
        }
        if (z) {
            canvas.clipRect(this.mRect);
        }
        super.draw(canvas);
    }

    public final void enableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mFpsListener);
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.enable(this.mScrollPerfTag);
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mScrollEnabled || (keyCode != 19 && keyCode != 20)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    public void fling(int i) {
        float signum = Math.signum(this.mOnScrollDispatchHelper.mYFlingVelocity);
        if (signum == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            signum = Math.signum((float) i);
        }
        int abs = (int) (((float) Math.abs(i)) * signum);
        if (this.mPagingEnabled) {
            flingAndSnap(abs);
        } else if (this.mScroller != null) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, abs, 0, 0, 0, Integer.MAX_VALUE, 0, ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            super.fling(abs);
        }
        handlePostTouchScrolling(0, abs);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010d, code lost:
        if (getScrollY() <= r5) goto L_0x010f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x015f  */
    public final void flingAndSnap(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        OverScroller overScroller;
        if (getChildCount() > 0) {
            if (this.mSnapInterval == 0 && this.mSnapOffsets == null) {
                double snapInterval = (double) getSnapInterval();
                double scrollY = (double) getScrollY();
                double predictFinalScrollPosition = (double) predictFinalScrollPosition(i);
                double d = scrollY / snapInterval;
                int floor = (int) Math.floor(d);
                int ceil = (int) Math.ceil(d);
                int round = (int) Math.round(d);
                int round2 = (int) Math.round(predictFinalScrollPosition / snapInterval);
                if (i > 0 && ceil == floor) {
                    ceil++;
                } else if (i < 0 && floor == ceil) {
                    floor--;
                }
                if (i > 0 && round < ceil && round2 > floor) {
                    round = ceil;
                } else if (i < 0 && round > floor && round2 < ceil) {
                    round = floor;
                }
                double d2 = ((double) round) * snapInterval;
                if (d2 != scrollY) {
                    this.mActivelyScrolling = true;
                    reactSmoothScrollTo(getScrollX(), (int) d2);
                    return;
                }
                return;
            }
            int maxScrollY = getMaxScrollY();
            int predictFinalScrollPosition2 = predictFinalScrollPosition(i);
            if (this.mDisableIntervalMomentum) {
                predictFinalScrollPosition2 = getScrollY();
            }
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            List<Integer> list = this.mSnapOffsets;
            int i7 = 0;
            if (list != null) {
                i5 = list.get(0).intValue();
                List<Integer> list2 = this.mSnapOffsets;
                i4 = list2.get(list2.size() - 1).intValue();
                i2 = maxScrollY;
                i3 = 0;
                for (int i8 = 0; i8 < this.mSnapOffsets.size(); i8++) {
                    int intValue = this.mSnapOffsets.get(i8).intValue();
                    if (intValue <= predictFinalScrollPosition2 && predictFinalScrollPosition2 - intValue < predictFinalScrollPosition2 - i3) {
                        i3 = intValue;
                    }
                    if (intValue >= predictFinalScrollPosition2 && intValue - predictFinalScrollPosition2 < i2 - predictFinalScrollPosition2) {
                        i2 = intValue;
                    }
                }
            } else {
                double snapInterval2 = (double) getSnapInterval();
                double d3 = ((double) predictFinalScrollPosition2) / snapInterval2;
                i2 = Math.min((int) (Math.ceil(d3) * snapInterval2), maxScrollY);
                i4 = maxScrollY;
                i3 = (int) (Math.floor(d3) * snapInterval2);
                i5 = 0;
            }
            int i9 = predictFinalScrollPosition2 - i3;
            int i10 = i2 - predictFinalScrollPosition2;
            int i11 = i9 < i10 ? i3 : i2;
            if (this.mSnapToEnd || predictFinalScrollPosition2 < i4) {
                if (this.mSnapToStart || predictFinalScrollPosition2 > i5) {
                    if (i > 0) {
                        i6 = i + ((int) (((double) i10) * 10.0d));
                        i5 = i2;
                    } else if (i < 0) {
                        i6 = i - ((int) (((double) i9) * 10.0d));
                        i5 = i3;
                    } else {
                        i6 = i;
                        i5 = i11;
                    }
                    int min = Math.min(Math.max(0, i5), maxScrollY);
                    overScroller = this.mScroller;
                    if (overScroller != null) {
                        this.mActivelyScrolling = true;
                        int scrollX = getScrollX();
                        int scrollY2 = getScrollY();
                        if (i6 == 0) {
                            i6 = min - getScrollY();
                        }
                        if (min == 0 || min == maxScrollY) {
                            i7 = height / 2;
                        }
                        overScroller.fling(scrollX, scrollY2, 0, i6, 0, 0, min, min, 0, i7);
                        postInvalidateOnAnimation();
                        return;
                    }
                    reactSmoothScrollTo(getScrollX(), min);
                    return;
                }
            } else if (getScrollY() < i4) {
                i6 = i;
                i5 = i4;
                int min2 = Math.min(Math.max(0, i5), maxScrollY);
                overScroller = this.mScroller;
                if (overScroller != null) {
                }
            }
            i5 = predictFinalScrollPosition2;
            i6 = i;
            int min22 = Math.min(Math.max(0, i5), maxScrollY);
            overScroller = this.mScroller;
            if (overScroller != null) {
            }
        }
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void getClippingRect(Rect rect) {
        Rect rect2 = this.mClippingRect;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(rect2);
        rect.set(rect2);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public final void handlePostTouchScrolling(int i, int i2) {
        if ((this.mSendMomentumEvents || this.mPagingEnabled || isScrollPerfLoggingEnabled()) && this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                enableFpsListener();
                ReactYogaConfigProvider.emitScrollEvent(this, ScrollEventType.MOMENTUM_BEGIN, (float) i, (float) i2);
            }
            this.mActivelyScrolling = false;
            AnonymousClass1 r3 = new Runnable() {
                /* class com.facebook.react.views.scroll.ReactScrollView.AnonymousClass1 */
                public boolean mSnappingToPage = false;

                public void run() {
                    ReactScrollView reactScrollView = ReactScrollView.this;
                    if (reactScrollView.mActivelyScrolling) {
                        reactScrollView.mActivelyScrolling = false;
                        ViewCompat.postOnAnimationDelayed(reactScrollView, this, 20);
                        return;
                    }
                    reactScrollView.updateStateOnScroll(reactScrollView.getScrollX(), ReactScrollView.this.getScrollY());
                    ReactScrollView reactScrollView2 = ReactScrollView.this;
                    if (!reactScrollView2.mPagingEnabled || this.mSnappingToPage) {
                        ReactScrollView reactScrollView3 = ReactScrollView.this;
                        if (reactScrollView3.mSendMomentumEvents) {
                            ReactYogaConfigProvider.emitScrollEvent(reactScrollView3, ScrollEventType.MOMENTUM_END, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        }
                        ReactScrollView reactScrollView4 = ReactScrollView.this;
                        reactScrollView4.mPostTouchRunnable = null;
                        if (reactScrollView4.isScrollPerfLoggingEnabled()) {
                            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactScrollView4.mFpsListener);
                            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactScrollView4.mScrollPerfTag);
                            reactScrollView4.mFpsListener.disable(reactScrollView4.mScrollPerfTag);
                            return;
                        }
                        return;
                    }
                    this.mSnappingToPage = true;
                    reactScrollView2.flingAndSnap(0);
                    ViewCompat.postOnAnimationDelayed(ReactScrollView.this, this, 20);
                }
            };
            this.mPostTouchRunnable = r3;
            ViewCompat.postOnAnimationDelayed(this, r3, 20);
        }
    }

    public final boolean isScrollPerfLoggingEnabled() {
        String str;
        return (this.mFpsListener == null || (str = this.mScrollPerfTag) == null || str.isEmpty()) ? false : true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public void onChildViewAdded(View view, View view2) {
        this.mContentView = view2;
        view2.addOnLayoutChangeListener(this);
    }

    public void onChildViewRemoved(View view, View view2) {
        this.mContentView.removeOnLayoutChangeListener(this);
        this.mContentView = null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                ReactYogaConfigProvider.notifyNativeGestureStarted(this, motionEvent);
                ReactYogaConfigProvider.emitScrollEvent(this, ScrollEventType.BEGIN_DRAG, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                this.mDragging = true;
                enableFpsListener();
                return true;
            }
        } catch (IllegalArgumentException e) {
            FLog.w("ReactNative", "Error intercepting touch event.", e);
        }
        return false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.pendingContentOffsetX;
        if (i5 == -1) {
            i5 = getScrollX();
        }
        int i6 = this.pendingContentOffsetY;
        if (i6 == -1) {
            i6 = getScrollY();
        }
        reactScrollTo(i5, i6);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int maxScrollY;
        if (this.mContentView != null && getScrollY() > (maxScrollY = getMaxScrollY())) {
            reactScrollTo(getScrollX(), maxScrollY);
        }
    }

    public void onMeasure(int i, int i2) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        int maxScrollY;
        OverScroller overScroller = this.mScroller;
        if (!(overScroller == null || this.mContentView == null || overScroller.isFinished() || this.mScroller.getCurrY() == this.mScroller.getFinalY() || i2 < (maxScrollY = getMaxScrollY()))) {
            this.mScroller.abortAnimation();
            i2 = maxScrollY;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mActivelyScrolling = true;
        if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
            if (this.mRemoveClippedSubviews) {
                updateClippingRect();
            }
            OnScrollDispatchHelper onScrollDispatchHelper = this.mOnScrollDispatchHelper;
            ReactYogaConfigProvider.emitScrollEvent(this, ScrollEventType.SCROLL, onScrollDispatchHelper.mXFlingVelocity, onScrollDispatchHelper.mYFlingVelocity);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        this.mVelocityHelper.calculateVelocity(motionEvent);
        if ((motionEvent.getAction() & 255) == 1 && this.mDragging) {
            updateStateOnScroll(getScrollX(), getScrollY());
            VelocityHelper velocityHelper = this.mVelocityHelper;
            float f = velocityHelper.mXVelocity;
            float f2 = velocityHelper.mYVelocity;
            ReactYogaConfigProvider.emitScrollEvent(this, ScrollEventType.END_DRAG, f, f2);
            this.mDragging = false;
            handlePostTouchScrolling(Math.round(f), Math.round(f2));
        }
        return super.onTouchEvent(motionEvent);
    }

    public final int predictFinalScrollPosition(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.mDecelerationRate);
        overScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, getMaxScrollY(), 0, ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        return overScroller.getFinalY();
    }

    public void reactScrollTo(int i, int i2) {
        scrollTo(i, i2);
        updateStateOnScroll(i, i2);
        setPendingContentOffsets(i, i2);
    }

    public void reactSmoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2);
        updateStateOnScroll(i, i2);
        setPendingContentOffsets(i, i2);
    }

    public void requestChildFocus(View view, View view2) {
        if (view2 != null) {
            Rect rect = new Rect();
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        super.requestChildFocus(view, view2);
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setDecelerationRate(float f) {
        this.mDecelerationRate = f;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - f);
        }
    }

    public void setDisableIntervalMomentum(boolean z) {
        this.mDisableIntervalMomentum = z;
    }

    public void setEndFillColor(int i) {
        if (i != this.mEndFillColor) {
            this.mEndFillColor = i;
            this.mEndBackground = new ColorDrawable(this.mEndFillColor);
        }
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public void setPagingEnabled(boolean z) {
        this.mPagingEnabled = z;
    }

    public final void setPendingContentOffsets(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getWidth() == 0 || childAt.getHeight() == 0) {
            this.pendingContentOffsetX = i;
            this.pendingContentOffsetY = i2;
            return;
        }
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.mClippingRect == null) {
            this.mClippingRect = new Rect();
        }
        this.mRemoveClippedSubviews = z;
        updateClippingRect();
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public void setScrollPerfTag(String str) {
        this.mScrollPerfTag = str;
    }

    public void setSendMomentumEvents(boolean z) {
        this.mSendMomentumEvents = z;
    }

    public void setSnapInterval(int i) {
        this.mSnapInterval = i;
    }

    public void setSnapOffsets(List<Integer> list) {
        this.mSnapOffsets = list;
    }

    public void setSnapToEnd(boolean z) {
        this.mSnapToEnd = z;
    }

    public void setSnapToStart(boolean z) {
        this.mSnapToStart = z;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mClippingRect);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).updateClippingRect();
            }
        }
    }

    public final void updateStateOnScroll(int i, int i2) {
        if (this.mStateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("contentOffsetLeft", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) i));
            writableNativeMap.putDouble("contentOffsetTop", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) i2));
            this.mStateWrapper.updateState(writableNativeMap);
        }
    }
}
