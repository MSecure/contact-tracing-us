package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    public final MotionStrategy extendStrategy;
    public final MotionStrategy hideStrategy;
    public boolean isExtended;
    public final Rect shadowPadding;
    public final MotionStrategy showStrategy;
    public final MotionStrategy shrinkStrategy;

    public static abstract class OnChangedCallback {
    }

    static {
        new Property<View, Float>(Float.class, RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH) {
            /* class com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.util.Property
            public Float get(View view) {
                return Float.valueOf((float) view.getLayoutParams().width);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // android.util.Property
            public void set(View view, Float f) {
                View view2 = view;
                view2.getLayoutParams().width = f.intValue();
                view2.requestLayout();
            }
        };
        new Property<View, Float>(Float.class, RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT) {
            /* class com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.util.Property
            public Float get(View view) {
                return Float.valueOf((float) view.getLayoutParams().height);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // android.util.Property
            public void set(View view, Float f) {
                View view2 = view;
                view2.getLayoutParams().height = f.intValue();
                view2.requestLayout();
            }
        };
    }

    public static void access$200(ExtendedFloatingActionButton extendedFloatingActionButton, final MotionStrategy motionStrategy) {
        if (extendedFloatingActionButton == null) {
            throw null;
        } else if (!motionStrategy.shouldCancel()) {
            if (!(ViewCompat.isLaidOut(extendedFloatingActionButton) && !extendedFloatingActionButton.isInEditMode())) {
                motionStrategy.performNow();
                motionStrategy.onChange(null);
                return;
            }
            extendedFloatingActionButton.measure(0, 0);
            AnimatorSet createAnimator = motionStrategy.createAnimator();
            createAnimator.addListener(new AnimatorListenerAdapter() {
                /* class com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass3 */
                public boolean cancelled;
                public final /* synthetic */ OnChangedCallback val$callback = null;

                public void onAnimationCancel(Animator animator) {
                    this.cancelled = true;
                    motionStrategy.onAnimationCancel();
                }

                public void onAnimationEnd(Animator animator) {
                    motionStrategy.onAnimationEnd();
                    if (!this.cancelled) {
                        motionStrategy.onChange(null);
                    }
                }

                public void onAnimationStart(Animator animator) {
                    motionStrategy.onAnimationStart(animator);
                    this.cancelled = false;
                }
            });
            for (Animator.AnimatorListener animatorListener : motionStrategy.getListeners()) {
                createAnimator.addListener(animatorListener);
            }
            createAnimator.start();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return null;
    }

    public int getCollapsedSize() {
        return getIconSize() + (Math.min(ViewCompat.getPaddingStart(this), getPaddingEnd()) * 2);
    }

    public MotionSpec getExtendMotionSpec() {
        throw null;
    }

    public MotionSpec getHideMotionSpec() {
        throw null;
    }

    public MotionSpec getShowMotionSpec() {
        throw null;
    }

    public MotionSpec getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            throw null;
        }
    }

    public void setExtendMotionSpec(MotionSpec motionSpec) {
        throw null;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.isExtended != z) {
            MotionStrategy motionStrategy = null;
            if (!motionStrategy.shouldCancel()) {
                motionStrategy.performNow();
            }
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        throw null;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        throw null;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setShrinkMotionSpec(MotionSpec motionSpec) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public boolean autoHideEnabled;
        public boolean autoShrinkEnabled;
        public Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public boolean getInsetDodgeRect(ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            Rect rect2 = extendedFloatingActionButton.shadowPadding;
            rect.set(extendedFloatingActionButton.getLeft() + rect2.left, extendedFloatingActionButton.getTop() + rect2.top, extendedFloatingActionButton.getRight() - rect2.right, extendedFloatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior : false) {
                    updateFabVisibilityForBottomSheet(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = dependencies.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior : false) && updateFabVisibilityForBottomSheet(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            return true;
        }

        public final boolean shouldUpdateVisibility(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((this.autoHideEnabled || this.autoShrinkEnabled) && layoutParams.mAnchorId == view.getId()) {
                return true;
            }
            return false;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            MotionStrategy motionStrategy;
            MotionStrategy motionStrategy2;
            if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if (this.autoShrinkEnabled) {
                    motionStrategy2 = extendedFloatingActionButton.shrinkStrategy;
                } else {
                    motionStrategy2 = extendedFloatingActionButton.hideStrategy;
                }
                ExtendedFloatingActionButton.access$200(extendedFloatingActionButton, motionStrategy2);
                return true;
            }
            if (this.autoShrinkEnabled) {
                motionStrategy = extendedFloatingActionButton.extendStrategy;
            } else {
                motionStrategy = extendedFloatingActionButton.showStrategy;
            }
            ExtendedFloatingActionButton.access$200(extendedFloatingActionButton, motionStrategy);
            return true;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            MotionStrategy motionStrategy;
            MotionStrategy motionStrategy2;
            if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                if (this.autoShrinkEnabled) {
                    motionStrategy2 = extendedFloatingActionButton.shrinkStrategy;
                } else {
                    motionStrategy2 = extendedFloatingActionButton.hideStrategy;
                }
                ExtendedFloatingActionButton.access$200(extendedFloatingActionButton, motionStrategy2);
                return true;
            }
            if (this.autoShrinkEnabled) {
                motionStrategy = extendedFloatingActionButton.extendStrategy;
            } else {
                motionStrategy = extendedFloatingActionButton.showStrategy;
            }
            ExtendedFloatingActionButton.access$200(extendedFloatingActionButton, motionStrategy);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return getInsetDodgeRect((ExtendedFloatingActionButton) view, rect);
        }
    }
}
