package com.facebook.react.views.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ReactHorizontalScrollView extends HorizontalScrollView implements ReactClippingViewGroup {
    public static Field sScrollerField = null;
    public static boolean sTriedToGetScrollerField = false;
    public boolean mActivelyScrolling;
    public Rect mClippingRect;
    public float mDecelerationRate = 0.985f;
    public boolean mDisableIntervalMomentum = false;
    public boolean mDragging;
    public Drawable mEndBackground;
    public int mEndFillColor = 0;
    public FpsListener mFpsListener = null;
    public final OnScrollDispatchHelper mOnScrollDispatchHelper = new OnScrollDispatchHelper();
    public String mOverflow = "hidden";
    public boolean mPagedArrowScrolling = false;
    public boolean mPagingEnabled = false;
    public Runnable mPostTouchRunnable;
    public ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
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
    public final Rect mTempRect = new Rect();
    public final VelocityHelper mVelocityHelper = new VelocityHelper();
    public int pendingContentOffsetX = -1;
    public int pendingContentOffsetY = -1;

    public ReactHorizontalScrollView(Context context, FpsListener fpsListener) {
        super(context);
        this.mFpsListener = fpsListener;
        this.mScroller = getOverScrollerFromParent();
    }

    private OverScroller getOverScrollerFromParent() {
        if (!sTriedToGetScrollerField) {
            sTriedToGetScrollerField = true;
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                sScrollerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                FLog.w("ReactNative", "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(");
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
            FLog.w("ReactNative", "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to get mScroller from HorizontalScrollView!", e);
        }
    }

    private int getSnapInterval() {
        int i = this.mSnapInterval;
        if (i != 0) {
            return i;
        }
        return getWidth();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (!this.mPagingEnabled || this.mPagedArrowScrolling) {
            super.addFocusables(arrayList, i, i2);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i, i2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            boolean z = true;
            if (!(getScrollDelta(view) == 0)) {
                int scrollDelta = getScrollDelta(view);
                view.getDrawingRect(this.mTempRect);
                if (scrollDelta == 0 || Math.abs(scrollDelta) >= this.mTempRect.width()) {
                    z = false;
                }
                if (!z && !view.isFocused()) {
                }
            }
            arrayList.add(view);
        }
    }

    public boolean arrowScroll(int i) {
        if (!this.mPagingEnabled) {
            return super.arrowScroll(i);
        }
        boolean z = true;
        this.mPagedArrowScrolling = true;
        if (getChildCount() > 0) {
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus(), i);
            View childAt = getChildAt(0);
            if (childAt == null || findNextFocus == null || findNextFocus.getParent() != childAt) {
                smoothScrollToNextPage(i);
            } else {
                if (!(getScrollDelta(findNextFocus) == 0)) {
                    int scrollDelta = getScrollDelta(findNextFocus);
                    findNextFocus.getDrawingRect(this.mTempRect);
                    if (!(scrollDelta != 0 && Math.abs(scrollDelta) < this.mTempRect.width() / 2)) {
                        smoothScrollToNextPage(i);
                    }
                }
                findNextFocus.requestFocus();
            }
        } else {
            z = false;
        }
        this.mPagedArrowScrolling = false;
        return z;
    }

    public void draw(Canvas canvas) {
        if (this.mEndFillColor != 0) {
            View childAt = getChildAt(0);
            if (!(this.mEndBackground == null || childAt == null || childAt.getRight() >= getWidth())) {
                this.mEndBackground.setBounds(childAt.getRight(), 0, getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mScrollEnabled || (keyCode != 21 && keyCode != 22)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    public void fling(int i) {
        int signum = (int) (Math.signum(this.mOnScrollDispatchHelper.mXFlingVelocity) * ((float) Math.abs(i)));
        if (this.mPagingEnabled) {
            flingAndSnap(signum);
        } else if (this.mScroller != null) {
            this.mScroller.fling(getScrollX(), getScrollY(), signum, 0, 0, Integer.MAX_VALUE, 0, 0, ((getWidth() - ViewCompat.getPaddingStart(this)) - getPaddingEnd()) / 2, 0);
            postInvalidateOnAnimation();
        } else {
            super.fling(signum);
        }
        handlePostTouchScrolling(signum, 0);
    }

    public final void flingAndSnap(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = i;
        if (getChildCount() > 0) {
            if (this.mSnapInterval == 0 && this.mSnapOffsets == null) {
                double snapInterval = (double) getSnapInterval();
                double scrollX = (double) getScrollX();
                double predictFinalScrollPosition = (double) predictFinalScrollPosition(i);
                double d = scrollX / snapInterval;
                int floor = (int) Math.floor(d);
                int ceil = (int) Math.ceil(d);
                int round = (int) Math.round(d);
                int round2 = (int) Math.round(predictFinalScrollPosition / snapInterval);
                if (i6 > 0 && ceil == floor) {
                    ceil++;
                } else if (i6 < 0 && floor == ceil) {
                    floor--;
                }
                if (i6 > 0 && round < ceil && round2 > floor) {
                    round = ceil;
                } else if (i6 < 0 && round > floor && round2 < ceil) {
                    round = floor;
                }
                double d2 = ((double) round) * snapInterval;
                if (d2 != scrollX) {
                    this.mActivelyScrolling = true;
                    reactSmoothScrollTo((int) d2, getScrollY());
                    return;
                }
                return;
            }
            int i7 = 0;
            int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
            int predictFinalScrollPosition2 = predictFinalScrollPosition(i);
            if (this.mDisableIntervalMomentum) {
                predictFinalScrollPosition2 = getScrollX();
            }
            int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
            boolean z = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
            if (z) {
                predictFinalScrollPosition2 = max - predictFinalScrollPosition2;
                i6 = -i6;
            }
            List<Integer> list = this.mSnapOffsets;
            if (list != null) {
                i5 = list.get(0).intValue();
                List<Integer> list2 = this.mSnapOffsets;
                i4 = list2.get(list2.size() - 1).intValue();
                i2 = max;
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
                i4 = max;
                i3 = (int) (Math.floor(d3) * snapInterval2);
                i2 = Math.min((int) (Math.ceil(d3) * snapInterval2), max);
                i5 = 0;
            }
            int i9 = predictFinalScrollPosition2 - i3;
            int i10 = i2 - predictFinalScrollPosition2;
            int i11 = i9 < i10 ? i3 : i2;
            int scrollX2 = getScrollX();
            if (z) {
                scrollX2 = max - scrollX2;
            }
            if (this.mSnapToEnd || predictFinalScrollPosition2 < i4) {
                if (this.mSnapToStart || predictFinalScrollPosition2 > i5) {
                    if (i6 > 0) {
                        i6 += (int) (((double) i10) * 10.0d);
                        predictFinalScrollPosition2 = i2;
                    } else if (i6 < 0) {
                        i6 -= (int) (((double) i9) * 10.0d);
                        predictFinalScrollPosition2 = i3;
                    } else {
                        predictFinalScrollPosition2 = i11;
                    }
                } else if (scrollX2 > i5) {
                    predictFinalScrollPosition2 = i5;
                }
            } else if (scrollX2 < i4) {
                predictFinalScrollPosition2 = i4;
            }
            int min = Math.min(Math.max(0, predictFinalScrollPosition2), max);
            if (z) {
                min = max - min;
                i6 = -i6;
            }
            OverScroller overScroller = this.mScroller;
            if (overScroller != null) {
                this.mActivelyScrolling = true;
                int scrollX3 = getScrollX();
                int scrollY = getScrollY();
                if (i6 == 0) {
                    i6 = min - getScrollX();
                }
                if (min == 0 || min == max) {
                    i7 = width / 2;
                }
                overScroller.fling(scrollX3, scrollY, i6, 0, min, min, 0, 0, i7, 0);
                postInvalidateOnAnimation();
                return;
            }
            reactSmoothScrollTo(min, getScrollY());
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

    public final int getScrollDelta(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    }

    public final void handlePostTouchScrolling(int i, int i2) {
        if ((this.mSendMomentumEvents || this.mPagingEnabled || isScrollPerfLoggingEnabled()) && this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                ReactYogaConfigProvider.emitScrollEvent(this, ScrollEventType.MOMENTUM_BEGIN, (float) i, (float) i2);
            }
            this.mActivelyScrolling = false;
            AnonymousClass1 r3 = new Runnable() {
                /* class com.facebook.react.views.scroll.ReactHorizontalScrollView.AnonymousClass1 */
                public boolean mSnappingToPage = false;

                public void run() {
                    ReactHorizontalScrollView reactHorizontalScrollView = ReactHorizontalScrollView.this;
                    if (reactHorizontalScrollView.mActivelyScrolling) {
                        reactHorizontalScrollView.mActivelyScrolling = false;
                        ViewCompat.postOnAnimationDelayed(reactHorizontalScrollView, this, 20);
                        return;
                    }
                    reactHorizontalScrollView.updateStateOnScroll(reactHorizontalScrollView.getScrollX(), ReactHorizontalScrollView.this.getScrollY());
                    ReactHorizontalScrollView reactHorizontalScrollView2 = ReactHorizontalScrollView.this;
                    if (!reactHorizontalScrollView2.mPagingEnabled || this.mSnappingToPage) {
                        ReactHorizontalScrollView reactHorizontalScrollView3 = ReactHorizontalScrollView.this;
                        if (reactHorizontalScrollView3.mSendMomentumEvents) {
                            ReactYogaConfigProvider.emitScrollEvent(reactHorizontalScrollView3, ScrollEventType.MOMENTUM_END, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        }
                        ReactHorizontalScrollView reactHorizontalScrollView4 = ReactHorizontalScrollView.this;
                        reactHorizontalScrollView4.mPostTouchRunnable = null;
                        if (reactHorizontalScrollView4.isScrollPerfLoggingEnabled()) {
                            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactHorizontalScrollView4.mFpsListener);
                            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactHorizontalScrollView4.mScrollPerfTag);
                            reactHorizontalScrollView4.mFpsListener.disable(reactHorizontalScrollView4.mScrollPerfTag);
                            return;
                        }
                        return;
                    }
                    this.mSnappingToPage = true;
                    reactHorizontalScrollView2.flingAndSnap(0);
                    ViewCompat.postOnAnimationDelayed(ReactHorizontalScrollView.this, this, 20);
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

    public void onDraw(Canvas canvas) {
        getDrawingRect(this.mRect);
        String str = this.mOverflow;
        if (((str.hashCode() == 466743410 && str.equals("visible")) ? (char) 0 : 65535) != 0) {
            canvas.clipRect(this.mRect);
        }
        super.onDraw(canvas);
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
                if (isScrollPerfLoggingEnabled()) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mFpsListener);
                    AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mScrollPerfTag);
                    this.mFpsListener.enable(this.mScrollPerfTag);
                }
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

    public void onMeasure(int i, int i2) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        int computeHorizontalScrollRange;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null && !overScroller.isFinished() && this.mScroller.getCurrX() != this.mScroller.getFinalX() && i >= (computeHorizontalScrollRange = computeHorizontalScrollRange() - getWidth())) {
            this.mScroller.abortAnimation();
            i = computeHorizontalScrollRange;
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

    public boolean pageScroll(int i) {
        boolean pageScroll = super.pageScroll(i);
        if (this.mPagingEnabled && pageScroll) {
            handlePostTouchScrolling(0, 0);
        }
        return pageScroll;
    }

    public final int predictFinalScrollPosition(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.mDecelerationRate);
        overScroller.fling(getScrollX(), getScrollY(), i, 0, 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0, 0, ((getWidth() - ViewCompat.getPaddingStart(this)) - getPaddingEnd()) / 2, 0);
        return overScroller.getFinalX();
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
        int scrollDelta;
        if (!(view2 == null || this.mPagingEnabled || (scrollDelta = getScrollDelta(view2)) == 0)) {
            scrollBy(scrollDelta, 0);
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

    public final void smoothScrollToNextPage(int i) {
        int width = getWidth();
        int scrollX = getScrollX();
        int i2 = scrollX / width;
        if (scrollX % width != 0) {
            i2++;
        }
        int i3 = i == 17 ? i2 - 1 : i2 + 1;
        if (i3 < 0) {
            i3 = 0;
        }
        reactSmoothScrollTo(i3 * width, getScrollY());
        handlePostTouchScrolling(0, 0);
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
