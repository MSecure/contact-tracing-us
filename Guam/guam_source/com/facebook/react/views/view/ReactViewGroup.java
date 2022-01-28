package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.Animation;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;

public class ReactViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactZIndexedViewGroup {
    public static final int ARRAY_CAPACITY_INCREMENT = 12;
    public static final int DEFAULT_BACKGROUND_COLOR = 0;
    public static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
    public static final Rect sHelperRect = new Rect();
    public View[] mAllChildren = null;
    public int mAllChildrenCount;
    public float mBackfaceOpacity = 1.0f;
    public String mBackfaceVisibility = "visible";
    public ChildrenLayoutChangeListener mChildrenLayoutChangeListener;
    public Rect mClippingRect;
    public final ViewGroupDrawingOrderHelper mDrawingOrderHelper;
    public Rect mHitSlopRect;
    public int mLayoutDirection;
    public boolean mNeedsOffscreenAlphaCompositing = false;
    public OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    public String mOverflow;
    public Path mPath;
    public PointerEvents mPointerEvents = PointerEvents.AUTO;
    public ReactViewBackgroundDrawable mReactBackgroundDrawable;
    public boolean mRemoveClippedSubviews = false;

    public static final class ChildrenLayoutChangeListener implements View.OnLayoutChangeListener {
        public final ReactViewGroup mParent;

        public ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup, AnonymousClass1 r2) {
            this.mParent = reactViewGroup;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.mParent.getRemoveClippedSubviews()) {
                this.mParent.updateSubviewClipStatus(view);
            }
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
        setClipChildren(false);
        this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
    }

    private void addInArray(View view, int i) {
        View[] viewArr = this.mAllChildren;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(viewArr);
        View[] viewArr2 = viewArr;
        int i2 = this.mAllChildrenCount;
        int length = viewArr2.length;
        if (i == i2) {
            if (length == i2) {
                View[] viewArr3 = new View[(length + 12)];
                this.mAllChildren = viewArr3;
                System.arraycopy(viewArr2, 0, viewArr3, 0, length);
                viewArr2 = this.mAllChildren;
            }
            int i3 = this.mAllChildrenCount;
            this.mAllChildrenCount = i3 + 1;
            viewArr2[i3] = view;
        } else if (i < i2) {
            if (length == i2) {
                View[] viewArr4 = new View[(length + 12)];
                this.mAllChildren = viewArr4;
                System.arraycopy(viewArr2, 0, viewArr4, 0, i);
                System.arraycopy(viewArr2, i, this.mAllChildren, i + 1, i2 - i);
                viewArr2 = this.mAllChildren;
            } else {
                System.arraycopy(viewArr2, i, viewArr2, i + 1, i2 - i);
            }
            viewArr2[i] = view;
            this.mAllChildrenCount++;
        } else {
            throw new IndexOutOfBoundsException("index=" + i + " count=" + i2);
        }
    }

    private void dispatchOverflowDraw(Canvas canvas) {
        float f;
        boolean z;
        float f2;
        float f3;
        float f4;
        float f5;
        String str = this.mOverflow;
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode == 466743410 && str.equals("visible")) {
                    c = 0;
                }
            } else if (str.equals("hidden")) {
                c = 1;
            }
            if (c == 0) {
                Path path = this.mPath;
                if (path != null) {
                    path.rewind();
                }
            } else if (c == 1) {
                float width = (float) getWidth();
                float height = (float) getHeight();
                ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
                float f6 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                if (reactViewBackgroundDrawable != null) {
                    RectF directionAwareBorderInsets = reactViewBackgroundDrawable.getDirectionAwareBorderInsets();
                    if (directionAwareBorderInsets.top > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || directionAwareBorderInsets.left > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || directionAwareBorderInsets.bottom > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || directionAwareBorderInsets.right > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        f2 = directionAwareBorderInsets.left + BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        f = directionAwareBorderInsets.top + BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        width -= directionAwareBorderInsets.right;
                        height -= directionAwareBorderInsets.bottom;
                    } else {
                        f2 = 0.0f;
                        f = 0.0f;
                    }
                    ReactViewBackgroundDrawable reactViewBackgroundDrawable2 = this.mReactBackgroundDrawable;
                    float f7 = ReactYogaConfigProvider.isUndefined(reactViewBackgroundDrawable2.mBorderRadius) ? 0.0f : reactViewBackgroundDrawable2.mBorderRadius;
                    float borderRadiusOrDefaultTo = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f7, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT);
                    float borderRadiusOrDefaultTo2 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f7, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT);
                    float borderRadiusOrDefaultTo3 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f7, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT);
                    float borderRadiusOrDefaultTo4 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f7, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT);
                    boolean z2 = this.mLayoutDirection == 1;
                    float borderRadiusOrDefaultTo5 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(Float.NaN, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_START);
                    float borderRadiusOrDefaultTo6 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(Float.NaN, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_END);
                    float borderRadiusOrDefaultTo7 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(Float.NaN, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_START);
                    float borderRadiusOrDefaultTo8 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(Float.NaN, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_END);
                    if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(getContext())) {
                        f3 = ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo5) ? borderRadiusOrDefaultTo : borderRadiusOrDefaultTo5;
                        if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo6)) {
                            borderRadiusOrDefaultTo2 = borderRadiusOrDefaultTo6;
                        }
                        if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo7)) {
                            borderRadiusOrDefaultTo3 = borderRadiusOrDefaultTo7;
                        }
                        borderRadiusOrDefaultTo7 = ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo8) ? borderRadiusOrDefaultTo4 : borderRadiusOrDefaultTo8;
                        f5 = z2 ? borderRadiusOrDefaultTo2 : f3;
                        if (!z2) {
                            f3 = borderRadiusOrDefaultTo2;
                        }
                        f4 = z2 ? borderRadiusOrDefaultTo7 : borderRadiusOrDefaultTo3;
                        if (z2) {
                            borderRadiusOrDefaultTo7 = borderRadiusOrDefaultTo3;
                        }
                    } else {
                        float f8 = z2 ? borderRadiusOrDefaultTo6 : borderRadiusOrDefaultTo5;
                        if (!z2) {
                            borderRadiusOrDefaultTo5 = borderRadiusOrDefaultTo6;
                        }
                        float f9 = z2 ? borderRadiusOrDefaultTo8 : borderRadiusOrDefaultTo7;
                        if (!z2) {
                            borderRadiusOrDefaultTo7 = borderRadiusOrDefaultTo8;
                        }
                        if (ReactYogaConfigProvider.isUndefined(f8)) {
                            f8 = borderRadiusOrDefaultTo;
                        }
                        if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo5)) {
                            borderRadiusOrDefaultTo2 = borderRadiusOrDefaultTo5;
                        }
                        if (!ReactYogaConfigProvider.isUndefined(f9)) {
                            borderRadiusOrDefaultTo3 = f9;
                        }
                        if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo7)) {
                            f5 = f8;
                            f3 = borderRadiusOrDefaultTo2;
                            f4 = borderRadiusOrDefaultTo3;
                        } else {
                            f5 = f8;
                            f3 = borderRadiusOrDefaultTo2;
                            f4 = borderRadiusOrDefaultTo3;
                            borderRadiusOrDefaultTo7 = borderRadiusOrDefaultTo4;
                        }
                    }
                    if (f5 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f3 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || borderRadiusOrDefaultTo7 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f4 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        if (this.mPath == null) {
                            this.mPath = new Path();
                        }
                        this.mPath.rewind();
                        this.mPath.addRoundRect(new RectF(f2, f, width, height), new float[]{Math.max(f5 - directionAwareBorderInsets.left, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), Math.max(f5 - directionAwareBorderInsets.top, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), Math.max(f3 - directionAwareBorderInsets.right, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), Math.max(f3 - directionAwareBorderInsets.top, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), Math.max(borderRadiusOrDefaultTo7 - directionAwareBorderInsets.right, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), Math.max(borderRadiusOrDefaultTo7 - directionAwareBorderInsets.bottom, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), Math.max(f4 - directionAwareBorderInsets.left, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), Math.max(f4 - directionAwareBorderInsets.bottom, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)}, Path.Direction.CW);
                        canvas.clipPath(this.mPath);
                        f6 = f2;
                        z = true;
                    } else {
                        f6 = f2;
                        z = false;
                    }
                } else {
                    f = 0.0f;
                    z = false;
                }
                if (!z) {
                    canvas.clipRect(new RectF(f6, f, width, height));
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [int, boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(getContext());
            Drawable background = getBackground();
            updateBackgroundDrawable(null);
            if (background == null) {
                updateBackgroundDrawable(this.mReactBackgroundDrawable);
            } else {
                updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
            ?? isRTL = I18nUtil.getInstance().isRTL(getContext());
            this.mLayoutDirection = isRTL == true ? 1 : 0;
            ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
            if (reactViewBackgroundDrawable.mLayoutDirection != isRTL) {
                reactViewBackgroundDrawable.mLayoutDirection = isRTL;
            }
        }
        return this.mReactBackgroundDrawable;
    }

    private int indexOfChildInAllChildren(View view) {
        int i = this.mAllChildrenCount;
        View[] viewArr = this.mAllChildren;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(viewArr);
        View[] viewArr2 = viewArr;
        for (int i2 = 0; i2 < i; i2++) {
            if (viewArr2[i2] == view) {
                return i2;
            }
        }
        return -1;
    }

    private void removeFromArray(int i) {
        View[] viewArr = this.mAllChildren;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(viewArr);
        View[] viewArr2 = viewArr;
        int i2 = this.mAllChildrenCount;
        if (i == i2 - 1) {
            int i3 = i2 - 1;
            this.mAllChildrenCount = i3;
            viewArr2[i3] = null;
        } else if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr2, i + 1, viewArr2, i, (i2 - i) - 1);
            int i4 = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i4;
            viewArr2[i4] = null;
        }
    }

    private void updateBackgroundDrawable(Drawable drawable) {
        super.setBackground(drawable);
    }

    private void updateClippingToRect(Rect rect) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mAllChildren);
        int i = 0;
        for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
            updateSubviewClipStatus(rect, i2, i);
            if (this.mAllChildren[i2].getParent() == null) {
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        if (r7 != false) goto L_0x0063;
     */
    private void updateSubviewClipStatus(Rect rect, int i, int i2) {
        UiThreadUtil.assertOnUiThread();
        View[] viewArr = this.mAllChildren;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(viewArr);
        View view = viewArr[i];
        sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        Rect rect2 = sHelperRect;
        boolean intersects = rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
        Animation animation = view.getAnimation();
        boolean z = false;
        boolean z2 = animation != null && !animation.hasEnded();
        if (!intersects && view.getParent() != null && !z2) {
            super.removeViewsInLayout(i - i2, 1);
        } else if (intersects && view.getParent() == null) {
            super.addViewInLayout(view, i - i2, sDefaultLayoutParam, true);
            invalidate();
        }
        z = true;
        if (z && (view instanceof ReactClippingViewGroup)) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) view;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                reactClippingViewGroup.updateClippingRect();
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        if (viewGroupDrawingOrderHelper != null) {
            if (ViewGroupManager.getViewZIndex(view) != null) {
                viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex++;
            }
            viewGroupDrawingOrderHelper.mDrawingOrderIndices = null;
            setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
            super.addView(view, i, layoutParams);
            return;
        }
        throw null;
    }

    public void addViewWithSubviewClippingEnabled(View view, int i) {
        addViewWithSubviewClippingEnabled(view, i, sDefaultLayoutParam);
    }

    public void dispatchDraw(Canvas canvas) {
        try {
            dispatchOverflowDraw(canvas);
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            FLog.e("ReactNative", "NullPointerException when executing ViewGroup.dispatchDraw method", e);
        } catch (StackOverflowError e2) {
            RootView rootView = ReactYogaConfigProvider.getRootView(this);
            if (rootView != null) {
                rootView.handleException(e2);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, e2));
            } else {
                throw e2;
            }
        }
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e) {
            FLog.e("ReactNative", "NullPointerException when executing dispatchProvideStructure", e);
        }
    }

    public void dispatchSetPressed(boolean z) {
    }

    public int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    public int getBackgroundColor() {
        if (getBackground() != null) {
            return ((ReactViewBackgroundDrawable) getBackground()).mColor;
        }
        return 0;
    }

    public View getChildAtWithSubviewClippingEnabled(int i) {
        View[] viewArr = this.mAllChildren;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(viewArr);
        return viewArr[i];
    }

    public int getChildDrawingOrder(int i, int i2) {
        return this.mDrawingOrderHelper.getChildDrawingOrder(i, i2);
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    @Override // com.facebook.react.touch.ReactHitSlopView
    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
    }

    public String getOverflow() {
        return this.mOverflow;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    @Override // com.facebook.react.uimanager.ReactZIndexedViewGroup
    public int getZIndexMappedChildIndex(int i) {
        return this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder() ? this.mDrawingOrderHelper.getChildDrawingOrder(getChildCount(), i) : i;
    }

    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        if (onInterceptTouchEventListener != null) {
            int i = ((JSResponderHandler) onInterceptTouchEventListener).mCurrentJSResponder;
            boolean z = false;
            if (!(i == -1 || motionEvent.getAction() == 1 || getId() != i)) {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        PointerEvents pointerEvents = this.mPointerEvents;
        if (pointerEvents == PointerEvents.NONE || pointerEvents == PointerEvents.BOX_ONLY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void onMeasure(int i, int i2) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public void onRtlPropertiesChanged(int i) {
        int i2;
        ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
        if (reactViewBackgroundDrawable != null && reactViewBackgroundDrawable.mLayoutDirection != (i2 = this.mLayoutDirection)) {
            reactViewBackgroundDrawable.mLayoutDirection = i2;
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointerEvents pointerEvents = this.mPointerEvents;
        return (pointerEvents == PointerEvents.NONE || pointerEvents == PointerEvents.BOX_NONE) ? false : true;
    }

    public void removeAllViewsWithSubviewClippingEnabled() {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mRemoveClippedSubviews);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mAllChildren);
        for (int i = 0; i < this.mAllChildrenCount; i++) {
            this.mAllChildren[i].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        }
        removeAllViewsInLayout();
        this.mAllChildrenCount = 0;
    }

    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        if (viewGroupDrawingOrderHelper != null) {
            if (ViewGroupManager.getViewZIndex(view) != null) {
                viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex--;
            }
            viewGroupDrawingOrderHelper.mDrawingOrderIndices = null;
            setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
            super.removeView(view);
            return;
        }
        throw null;
    }

    public void removeViewAt(int i) {
        UiThreadUtil.assertOnUiThread();
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        View childAt = getChildAt(i);
        if (viewGroupDrawingOrderHelper != null) {
            if (ViewGroupManager.getViewZIndex(childAt) != null) {
                viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex--;
            }
            viewGroupDrawingOrderHelper.mDrawingOrderIndices = null;
            setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
            super.removeViewAt(i);
            return;
        }
        throw null;
    }

    public void removeViewWithSubviewClippingEnabled(View view) {
        UiThreadUtil.assertOnUiThread();
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mRemoveClippedSubviews);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mClippingRect);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mAllChildren);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        int indexOfChildInAllChildren = indexOfChildInAllChildren(view);
        if (this.mAllChildren[indexOfChildInAllChildren].getParent() != null) {
            int i = 0;
            for (int i2 = 0; i2 < indexOfChildInAllChildren; i2++) {
                if (this.mAllChildren[i2].getParent() == null) {
                    i++;
                }
            }
            super.removeViewsInLayout(indexOfChildInAllChildren - i, 1);
        }
        removeFromArray(indexOfChildInAllChildren);
    }

    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    public void setBackfaceVisibility(String str) {
        this.mBackfaceVisibility = str;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibilityDependantOpacity() {
        if (this.mBackfaceVisibility.equals("visible")) {
            setAlpha(this.mBackfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX >= -90.0f && rotationX < 90.0f && rotationY >= -90.0f && rotationY < 90.0f) {
            setAlpha(this.mBackfaceOpacity);
        } else {
            setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.mReactBackgroundDrawable != null) {
            ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
            orCreateReactViewBackground.mColor = i;
            orCreateReactViewBackground.invalidateSelf();
        }
    }

    public void setBorderColor(int i, float f, float f2) {
        getOrCreateReactViewBackground().setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        if (!AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(orCreateReactViewBackground.mBorderRadius, f)) {
            orCreateReactViewBackground.mBorderRadius = f;
            orCreateReactViewBackground.mNeedUpdatePathForBorderRadius = true;
            orCreateReactViewBackground.invalidateSelf();
        }
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setBorderWidth(int i, float f) {
        getOrCreateReactViewBackground().setBorderWidth(i, f);
    }

    public void setHitSlopRect(Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.mNeedsOffscreenAlphaCompositing = z;
    }

    @Override // com.facebook.react.touch.ReactInterceptingViewGroup
    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public void setOpacityIfPossible(float f) {
        this.mBackfaceOpacity = f;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z != this.mRemoveClippedSubviews) {
            this.mRemoveClippedSubviews = z;
            if (z) {
                Rect rect = new Rect();
                this.mClippingRect = rect;
                ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
                int childCount = getChildCount();
                this.mAllChildrenCount = childCount;
                this.mAllChildren = new View[Math.max(12, childCount)];
                this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener(this, null);
                for (int i = 0; i < this.mAllChildrenCount; i++) {
                    View childAt = getChildAt(i);
                    this.mAllChildren[i] = childAt;
                    childAt.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                updateClippingRect();
                return;
            }
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mClippingRect);
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mAllChildren);
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mChildrenLayoutChangeListener);
            for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                this.mAllChildren[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            }
            getDrawingRect(this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
            this.mAllChildren = null;
            this.mClippingRect = null;
            this.mAllChildrenCount = 0;
            this.mChildrenLayoutChangeListener = null;
        }
    }

    public void setTranslucentBackgroundDrawable(Drawable drawable) {
        updateBackgroundDrawable(null);
        if (this.mReactBackgroundDrawable != null && drawable != null) {
            updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, drawable}));
        } else if (drawable != null) {
            updateBackgroundDrawable(drawable);
        }
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mClippingRect);
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mAllChildren);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
        }
    }

    @Override // com.facebook.react.uimanager.ReactZIndexedViewGroup
    public void updateDrawingOrder() {
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex = 0;
        for (int i = 0; i < viewGroupDrawingOrderHelper.mViewGroup.getChildCount(); i++) {
            if (ViewGroupManager.getViewZIndex(viewGroupDrawingOrderHelper.mViewGroup.getChildAt(i)) != null) {
                viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex++;
            }
        }
        viewGroupDrawingOrderHelper.mDrawingOrderIndices = null;
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        invalidate();
    }

    public void addViewWithSubviewClippingEnabled(View view, int i, ViewGroup.LayoutParams layoutParams) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mRemoveClippedSubviews);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mClippingRect);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mAllChildren);
        addInArray(view, i);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.mAllChildren[i3].getParent() == null) {
                i2++;
            }
        }
        updateSubviewClipStatus(this.mClippingRect, i, i2);
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    }

    public void setBorderRadius(float f, int i) {
        getOrCreateReactViewBackground().setRadius(f, i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateSubviewClipStatus(View view) {
        if (this.mRemoveClippedSubviews && getParent() != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mClippingRect);
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mAllChildren);
            sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            Rect rect = this.mClippingRect;
            Rect rect2 = sHelperRect;
            if (rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom) != (view.getParent() != null)) {
                int i = 0;
                for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                    View[] viewArr = this.mAllChildren;
                    if (viewArr[i2] == view) {
                        updateSubviewClipStatus(this.mClippingRect, i2, i);
                        return;
                    }
                    if (viewArr[i2].getParent() == null) {
                        i++;
                    }
                }
            }
        }
    }
}
