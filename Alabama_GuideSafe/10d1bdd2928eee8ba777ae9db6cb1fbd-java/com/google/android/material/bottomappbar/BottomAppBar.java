package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public int animatingModeChangeCounter;
    public Behavior behavior;
    public int fabAlignmentMode;
    public AnimatorListenerAdapter fabAnimationListener;
    public int fabAnimationMode;
    public boolean fabAttached;
    public boolean hideOnScroll;
    public Animator menuAnimator;
    public Animator modeAnimator;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class com.google.android.material.bottomappbar.BottomAppBar.SavedState.AnonymousClass1 */

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
                return new SavedState(parcel, null);
            }
        };
        public int fabAlignmentMode;
        public boolean fabAttached;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }
    }

    public static void access$1000(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        actionMenuView.setTranslationX((float) bottomAppBar.getActionMenuViewTranslationX(actionMenuView, i, z));
    }

    public static void access$700(BottomAppBar bottomAppBar) {
        bottomAppBar.animatingModeChangeCounter--;
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return 0;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().cradleVerticalOffset;
    }

    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        throw null;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Landroid/animation/Animator;>;)V */
    public void createFabDefaultXAnimation(final int i) {
        FloatingActionButton findDependentFab = findDependentFab();
        if (findDependentFab != null && !findDependentFab.isOrWillBeHidden()) {
            this.animatingModeChangeCounter++;
            findDependentFab.hide(new FloatingActionButton.OnVisibilityChangedListener() {
                /* class com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass5 */

                @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                public void onHidden(FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.getFabTranslationX(i));
                    floatingActionButton.show(new FloatingActionButton.OnVisibilityChangedListener() {
                        /* class com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass5.AnonymousClass1 */

                        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                        public void onShown(FloatingActionButton floatingActionButton) {
                            BottomAppBar.access$700(BottomAppBar.this);
                        }
                    }, true);
                }
            }, true);
        }
    }

    public final FloatingActionButton findDependentFab() {
        View findDependentView = findDependentView();
        if (findDependentView instanceof FloatingActionButton) {
            return (FloatingActionButton) findDependentView;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    public final View findDependentView() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
            while (r0.hasNext()) {
            }
        }
        return null;
    }

    public int getActionMenuViewTranslationX(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int measuredWidth = z2 ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                if (z2) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        int right = measuredWidth - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft());
        if (i != 1 || !z) {
            return 0;
        }
        return right;
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().cradleVerticalOffset;
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().roundedCornerRadius;
    }

    public final float getFabTranslationX(int i) {
        int i2 = 1;
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        if (i != 1) {
            return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - 0;
        if (z) {
            i2 = -1;
        }
        return (float) (measuredWidth * i2);
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public final boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton findDependentFab = findDependentFab();
        return findDependentFab != null && findDependentFab.isOrWillBeShown();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.modeAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            setCutoutState();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!isFabVisibleOrWillBeShown()) {
                actionMenuView.setTranslationX((float) getActionMenuViewTranslationX(actionMenuView, 0, false));
            } else {
                actionMenuView.setTranslationX((float) getActionMenuViewTranslationX(actionMenuView, this.fabAlignmentMode, this.fabAttached));
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            getTopEdgeTreatment().cradleVerticalOffset = f;
            throw null;
        }
    }

    public final void setCutoutState() {
        getTopEdgeTreatment().horizontalOffset = getFabTranslationX();
        findDependentView();
        if (this.fabAttached) {
            isFabVisibleOrWillBeShown();
        }
        throw null;
    }

    public void setElevation(float f) {
        throw null;
    }

    public void setFabAlignmentMode(int i) {
        final int i2;
        if (this.fabAlignmentMode != i && ViewCompat.isLaidOut(this)) {
            Animator animator = this.modeAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.fabAnimationMode == 1) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findDependentFab(), "translationX", getFabTranslationX(i));
                ofFloat.setDuration(300L);
                arrayList.add(ofFloat);
            } else {
                createFabDefaultXAnimation(i);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.modeAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                /* class com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass4 */

                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.access$700(BottomAppBar.this);
                }

                public void onAnimationStart(Animator animator) {
                    BottomAppBar.this.animatingModeChangeCounter++;
                }
            });
            this.modeAnimator.start();
        }
        final boolean z = this.fabAttached;
        if (ViewCompat.isLaidOut(this)) {
            Animator animator2 = this.menuAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (!isFabVisibleOrWillBeShown()) {
                z = false;
                i2 = 0;
            } else {
                i2 = i;
            }
            final ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - ((float) getActionMenuViewTranslationX(actionMenuView, i2, z))) > 1.0f) {
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat3.addListener(new AnimatorListenerAdapter() {
                        /* class com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass7 */
                        public boolean cancelled;

                        public void onAnimationCancel(Animator animator) {
                            this.cancelled = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.cancelled) {
                                BottomAppBar.access$1000(BottomAppBar.this, actionMenuView, i2, z);
                            }
                        }
                    });
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.setDuration(150L);
                    animatorSet2.playSequentially(ofFloat3, ofFloat2);
                    arrayList2.add(animatorSet2);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList2.add(ofFloat2);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.menuAnimator = animatorSet3;
            animatorSet3.addListener(new AnimatorListenerAdapter() {
                /* class com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass6 */

                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.access$700(BottomAppBar.this);
                    BottomAppBar.this.menuAnimator = null;
                }

                public void onAnimationStart(Animator animator) {
                    BottomAppBar.this.animatingModeChangeCounter++;
                }
            });
            this.menuAnimator.start();
        }
        this.fabAlignmentMode = i;
    }

    public void setFabAnimationMode(int i) {
        this.fabAnimationMode = i;
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().fabMargin = f;
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().roundedCornerRadius = f;
            throw null;
        }
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect fabContentRect = new Rect();
        public final View.OnLayoutChangeListener fabLayoutListener = new View.OnLayoutChangeListener() {
            /* class com.google.android.material.bottomappbar.BottomAppBar.Behavior.AnonymousClass1 */

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (Behavior.this.viewRef.get() == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Behavior.this.fabContentRect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                throw null;
            }
        };
        public int originalBottomMargin;
        public WeakReference<BottomAppBar> viewRef;

        public Behavior() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int] */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            BottomAppBar bottomAppBar2 = bottomAppBar;
            this.viewRef = new WeakReference<>(bottomAppBar2);
            View findDependentView = bottomAppBar2.findDependentView();
            if (findDependentView == null || ViewCompat.isLaidOut(findDependentView)) {
                coordinatorLayout.onLayoutChild(bottomAppBar2, i);
                this.height = bottomAppBar2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bottomAppBar2.getLayoutParams()).bottomMargin;
                return false;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) findDependentView.getLayoutParams();
            layoutParams.anchorGravity = 49;
            this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (findDependentView instanceof FloatingActionButton) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) findDependentView;
                floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                floatingActionButton.addOnHideAnimationListener(null);
                floatingActionButton.addOnShowAnimationListener(new AnimatorListenerAdapter() {
                    /* class com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass8 */

                    public void onAnimationStart(Animator animator) {
                        BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
                        FloatingActionButton findDependentFab = BottomAppBar.this.findDependentFab();
                        if (findDependentFab != null) {
                            findDependentFab.setTranslationX(BottomAppBar.this.getFabTranslationX());
                        }
                    }
                });
                floatingActionButton.addTransformationCallback(null);
            }
            bottomAppBar2.setCutoutState();
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            if (!bottomAppBar.getHideOnScroll()) {
                return false;
            }
            if (i2 == 0 ? onStartNestedScroll(coordinatorLayout, bottomAppBar, view2, view3, i) : false) {
                return true;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}
