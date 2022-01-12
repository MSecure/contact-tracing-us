package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http1.Http1ExchangeCodec;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int DEF_STYLE_RES = R$style.Widget_Design_BottomSheet_Modal;
    public int activePointerId;
    public final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    public int collapsedOffset;
    public final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass3 */

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return AppCompatDelegateImpl.ConfigurationImplApi17.clamp(i, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                return bottomSheetBehavior.parentHeight;
            }
            return bottomSheetBehavior.collapsedOffset;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            int i2 = 4;
            if (f2 < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.fitToContents) {
                    i = bottomSheetBehavior.fitToContentsOffset;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior2.halfExpandedOffset;
                    if (top > i3) {
                        i = i3;
                        i2 = 6;
                        BottomSheetBehavior.this.startSettlingAnimation(view, i2, i, true);
                    }
                    i = bottomSheetBehavior2.expandedOffset;
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                if (bottomSheetBehavior3.hideable && bottomSheetBehavior3.shouldHide(view, f2) && (view.getTop() > BottomSheetBehavior.this.collapsedOffset || Math.abs(f) < Math.abs(f2))) {
                    i = BottomSheetBehavior.this.parentHeight;
                    i2 = 5;
                    BottomSheetBehavior.this.startSettlingAnimation(view, i2, i, true);
                } else if (f2 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || Math.abs(f) > Math.abs(f2)) {
                    int top2 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior4.fitToContents) {
                        int i4 = bottomSheetBehavior4.halfExpandedOffset;
                        if (top2 < i4) {
                            if (top2 < Math.abs(top2 - bottomSheetBehavior4.collapsedOffset)) {
                                i = BottomSheetBehavior.this.expandedOffset;
                            } else {
                                i = BottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top2 - i4) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                            i = BottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i = BottomSheetBehavior.this.collapsedOffset;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i2, i, true);
                        }
                        i2 = 6;
                        BottomSheetBehavior.this.startSettlingAnimation(view, i2, i, true);
                    } else if (Math.abs(top2 - bottomSheetBehavior4.fitToContentsOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                        i = BottomSheetBehavior.this.fitToContentsOffset;
                    } else {
                        i = BottomSheetBehavior.this.collapsedOffset;
                        BottomSheetBehavior.this.startSettlingAnimation(view, i2, i, true);
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior5.fitToContents) {
                        i = bottomSheetBehavior5.collapsedOffset;
                    } else {
                        int top3 = view.getTop();
                        if (Math.abs(top3 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                            i = BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        } else {
                            i = BottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                    BottomSheetBehavior.this.startSettlingAnimation(view, i2, i, true);
                }
            }
            i2 = 3;
            BottomSheetBehavior.this.startSettlingAnimation(view, i2, i, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.state;
            if (i2 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.activePointerId == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            return weakReference2 != null && weakReference2.get() == view;
        }
    };
    public float elevation = -1.0f;
    public int expandedOffset;
    public boolean fitToContents = true;
    public int fitToContentsOffset;
    public int halfExpandedOffset;
    public float halfExpandedRatio = 0.5f;
    public boolean hideable;
    public boolean ignoreEvents;
    public Map<View, Integer> importantForAccessibilityMap;
    public int initialY;
    public ValueAnimator interpolatorAnimator;
    public boolean isShapeExpanded;
    public int lastNestedScrollDy;
    public MaterialShapeDrawable materialShapeDrawable;
    public float maximumVelocity;
    public boolean nestedScrolled;
    public WeakReference<View> nestedScrollingChildRef;
    public int parentHeight;
    public int parentWidth;
    public int peekHeight;
    public boolean peekHeightAuto;
    public int peekHeightMin;
    public int saveFlags = 0;
    public BottomSheetBehavior<V>.SettleRunnable settleRunnable = null;
    public ShapeAppearanceModel shapeAppearanceModelDefault;
    public boolean shapeThemingEnabled;
    public boolean skipCollapsed;
    public int state = 4;
    public boolean touchingScrollingChild;
    public VelocityTracker velocityTracker;
    public ViewDragHelper viewDragHelper;
    public WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    public class SettleRunnable implements Runnable {
        public boolean isPosted;
        public int targetState;
        public final View view;

        public SettleRunnable(View view2, int i) {
            this.view = view2;
            this.targetState = i;
        }

        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            } else {
                ViewCompat.postOnAnimation(this.view, this);
            }
            this.isPosted = false;
        }
    }

    public BottomSheetBehavior() {
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final void addAccessibilityActionForState(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, final int i) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, new AccessibilityViewCommand() {
            /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4 */
        });
    }

    public final void calculateCollapsedOffset() {
        int i;
        if (this.peekHeightAuto) {
            i = Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16));
        } else {
            i = this.peekHeight;
        }
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - i, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - i;
        }
    }

    public final void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R$attr.bottomSheetStyle, DEF_STYLE_RES).build();
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
            materialShapeDrawable2.updateZ();
            if (!z || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
                return;
            }
            this.materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    public void dispatchOnSlide(int i) {
        float f;
        float f2;
        V v = this.viewRef.get();
        if (!(v == null || this.callbacks.isEmpty())) {
            int i2 = this.collapsedOffset;
            if (i > i2) {
                f = (float) (i2 - i);
                f2 = (float) (this.parentHeight - i2);
            } else {
                f = (float) (i2 - i);
                f2 = (float) (i2 - getExpandedOffset());
            }
            float f3 = f / f2;
            for (int i3 = 0; i3 < this.callbacks.size(); i3++) {
                this.callbacks.get(i3).onSlide(v, f3);
            }
        }
    }

    public View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    public final int getExpandedOffset() {
        return this.fitToContents ? this.fitToContentsOffset : this.expandedOffset;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2;
        if (!v.isShown()) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.activePointerId = -1;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (viewDragHelper2 = this.viewDragHelper) != null && viewDragHelper2.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        return actionMasked == 2 && view != null && !this.ignoreEvents && this.state != 1 && !coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.viewDragHelper != null && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.mTouchSlop);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        MaterialShapeDrawable materialShapeDrawable2;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            this.viewRef = new WeakReference<>(v);
            if (this.shapeThemingEnabled && (materialShapeDrawable2 = this.materialShapeDrawable) != null) {
                v.setBackground(materialShapeDrawable2);
            }
            MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
            if (materialShapeDrawable3 != null) {
                float f = this.elevation;
                if (f == -1.0f) {
                    f = v.getElevation();
                }
                materialShapeDrawable3.setElevation(f);
                boolean z = this.state == 3;
                this.isShapeExpanded = z;
                this.materialShapeDrawable.setInterpolation(z ? BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER : 1.0f);
            }
            updateAccessibilityActions();
            if (v.getImportantForAccessibility() == 0) {
                v.setImportantForAccessibility(1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.parentWidth = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.parentHeight = height;
        this.fitToContentsOffset = Math.max(0, height - v.getHeight());
        this.halfExpandedOffset = (int) ((1.0f - this.halfExpandedRatio) * ((float) this.parentHeight));
        calculateCollapsedOffset();
        int i2 = this.state;
        if (i2 == 3) {
            v.offsetTopAndBottom(getExpandedOffset());
        } else if (i2 == 6) {
            v.offsetTopAndBottom(this.halfExpandedOffset);
        } else if (!this.hideable || i2 != 5) {
            int i3 = this.state;
            if (i3 == 4) {
                v.offsetTopAndBottom(this.collapsedOffset);
            } else if (i3 == 1 || i3 == 2) {
                v.offsetTopAndBottom(top - v.getTop());
            }
        } else {
            v.offsetTopAndBottom(this.parentHeight);
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get() || this.state == 3) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v.getTop();
                int i4 = top - i2;
                if (i2 > 0) {
                    if (i4 < getExpandedOffset()) {
                        iArr[1] = top - getExpandedOffset();
                        ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                        setStateInternal(3);
                    } else {
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        setStateInternal(1);
                    }
                } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                    int i5 = this.collapsedOffset;
                    if (i4 <= i5 || this.hideable) {
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        setStateInternal(1);
                    } else {
                        iArr[1] = top - i5;
                        ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                        setStateInternal(4);
                    }
                }
                dispatchOnSlide(v.getTop());
                this.lastNestedScrollDy = i2;
                this.nestedScrolled = true;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i = this.saveFlags;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            int i2 = this.saveFlags;
            if (i2 == -1 || (i2 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            int i3 = this.saveFlags;
            if (i3 == -1 || (i3 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            int i4 = this.saveFlags;
            if (i4 == -1 || (i4 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
        int i5 = savedState.state;
        if (i5 == 1 || i5 == 2) {
            this.state = 4;
        } else {
            this.state = i5;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        float f;
        int i3 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                i2 = getExpandedOffset();
            } else {
                if (this.hideable) {
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    if (velocityTracker2 == null) {
                        f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    } else {
                        velocityTracker2.computeCurrentVelocity(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, this.maximumVelocity);
                        f = this.velocityTracker.getYVelocity(this.activePointerId);
                    }
                    if (shouldHide(v, f)) {
                        i2 = this.parentHeight;
                        i3 = 5;
                    }
                }
                if (this.lastNestedScrollDy == 0) {
                    int top = v.getTop();
                    if (!this.fitToContents) {
                        int i4 = this.halfExpandedOffset;
                        if (top < i4) {
                            if (top < Math.abs(top - this.collapsedOffset)) {
                                i2 = this.expandedOffset;
                            } else {
                                i2 = this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top - i4) < Math.abs(top - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                        } else {
                            i2 = this.collapsedOffset;
                            i3 = 4;
                        }
                    } else if (Math.abs(top - this.fitToContentsOffset) < Math.abs(top - this.collapsedOffset)) {
                        i2 = this.fitToContentsOffset;
                    } else {
                        i2 = this.collapsedOffset;
                        i3 = 4;
                    }
                } else {
                    if (this.fitToContents) {
                        i2 = this.collapsedOffset;
                    } else {
                        int top2 = v.getTop();
                        if (Math.abs(top2 - this.halfExpandedOffset) < Math.abs(top2 - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                        } else {
                            i2 = this.collapsedOffset;
                        }
                    }
                    i3 = 4;
                }
                i3 = 6;
            }
            startSettlingAnimation(v, i3, i2, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null) {
            viewDragHelper2.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.activePointerId = -1;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents) {
            float abs = Math.abs(((float) this.initialY) - motionEvent.getY());
            ViewDragHelper viewDragHelper3 = this.viewDragHelper;
            if (abs > ((float) viewDragHelper3.mTouchSlop)) {
                viewDragHelper3.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.ignoreEvents;
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void setPeekHeight(int i) {
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
                if (!z && this.viewRef != null) {
                    calculateCollapsedOffset();
                    if (this.state == 4 && (v = this.viewRef.get()) != null) {
                        v.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
        } else if (this.peekHeightAuto || this.peekHeight != i) {
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i);
            if (!z) {
                return;
            }
            return;
        }
        z = false;
        if (!z) {
        }
    }

    public void setState(int i) {
        if (i != this.state) {
            if (this.viewRef != null) {
                settleToStatePendingLayout(i);
            } else if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
                this.state = i;
            }
        }
    }

    public void setStateInternal(int i) {
        V v;
        if (this.state != i) {
            this.state = i;
            WeakReference<V> weakReference = this.viewRef;
            if (!(weakReference == null || (v = weakReference.get()) == null)) {
                if (i == 6 || i == 3) {
                    updateImportantForAccessibility(true);
                } else if (i == 5 || i == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i);
                for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
                    this.callbacks.get(i2).onStateChanged(v, i);
                }
                updateAccessibilityActions();
            }
        }
    }

    public void settleToState(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.collapsedOffset;
        } else if (i == 6) {
            int i4 = this.halfExpandedOffset;
            if (!this.fitToContents || i4 > (i3 = this.fitToContentsOffset)) {
                i2 = i4;
            } else {
                i = 3;
                i2 = i3;
            }
        } else if (i == 3) {
            i2 = getExpandedOffset();
        } else if (!this.hideable || i != 5) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("Illegal state argument: ", i));
        } else {
            i2 = this.parentHeight;
        }
        startSettlingAnimation(view, i, i2, false);
    }

    public final void settleToStatePendingLayout(final int i) {
        final V v = this.viewRef.get();
        if (v != null) {
            ViewParent parent = v.getParent();
            if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(v)) {
                settleToState(v, i);
            } else {
                v.post(new Runnable() {
                    /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass1 */

                    public void run() {
                        BottomSheetBehavior.this.settleToState(v, i);
                    }
                });
            }
        }
    }

    public boolean shouldHide(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.collapsedOffset)) / ((float) this.peekHeight) > 0.5f) {
            return true;
        }
        return false;
    }

    public void startSettlingAnimation(View view, int i, int i2, boolean z) {
        boolean z2;
        if (z) {
            z2 = this.viewDragHelper.settleCapturedViewAt(view.getLeft(), i2);
        } else {
            z2 = this.viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i2);
        }
        if (z2) {
            setStateInternal(2);
            updateDrawableForTargetState(i);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, i);
            }
            BottomSheetBehavior<V>.SettleRunnable settleRunnable2 = this.settleRunnable;
            if (!settleRunnable2.isPosted) {
                settleRunnable2.targetState = i;
                ViewCompat.postOnAnimation(view, settleRunnable2);
                this.settleRunnable.isPosted = true;
                return;
            }
            settleRunnable2.targetState = i;
            return;
        }
        setStateInternal(i);
    }

    public final void updateAccessibilityActions() {
        V v;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && (v = weakReference.get()) != null) {
            ViewCompat.removeAccessibilityAction(v, 524288);
            ViewCompat.removeAccessibilityAction(v, Http1ExchangeCodec.HEADER_LIMIT);
            ViewCompat.removeAccessibilityAction(v, 1048576);
            if (this.hideable && this.state != 5) {
                addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
            }
            int i = this.state;
            int i2 = 6;
            if (i == 3) {
                if (this.fitToContents) {
                    i2 = 4;
                }
                addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i2);
            } else if (i == 4) {
                if (this.fitToContents) {
                    i2 = 3;
                }
                addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i2);
            } else if (i == 6) {
                addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
            }
        }
    }

    public final void updateDrawableForTargetState(int i) {
        ValueAnimator valueAnimator;
        if (i != 2) {
            boolean z = i == 3;
            if (this.isShapeExpanded != z) {
                this.isShapeExpanded = z;
                if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                    if (valueAnimator.isRunning()) {
                        this.interpolatorAnimator.reverse();
                        return;
                    }
                    float f = z ? BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER : 1.0f;
                    this.interpolatorAnimator.setFloatValues(1.0f - f, f);
                    this.interpolatorAnimator.start();
                }
            }
        }
    }

    public final void updateImportantForAccessibility(boolean z) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    if (childAt != this.viewRef.get()) {
                        if (!z) {
                            Map<View, Integer> map = this.importantForAccessibilityMap;
                            if (map != null && map.containsKey(childAt)) {
                                ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                            }
                        } else {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    }
                }
                if (!z) {
                    this.importantForAccessibilityMap = null;
                }
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        public boolean fitToContents;
        public boolean hideable;
        public int peekHeight;
        public boolean skipCollapsed;
        public final int state;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z;
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, ReactYogaConfigProvider.getColorStateList(context, obtainStyledAttributes, R$styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass2 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.this.materialShapeDrawable;
                if (materialShapeDrawable != null) {
                    materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
        this.elevation = obtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || (i = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(i);
        }
        setHideable(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.fitToContents != z) {
            this.fitToContents = z;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            setStateInternal((!this.fitToContents || this.state != 6) ? this.state : 3);
            updateAccessibilityActions();
        }
        this.skipCollapsed = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.saveFlags = obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f = obtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f;
        int i2 = obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
        if (i2 >= 0) {
            this.expandedOffset = i2;
            obtainStyledAttributes.recycle();
            this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }
}
