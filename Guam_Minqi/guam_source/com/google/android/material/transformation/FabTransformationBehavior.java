package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$animator;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat$1;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public float dependencyOriginalTranslationX;
    public float dependencyOriginalTranslationY;
    public final int[] tmpArray;
    public final Rect tmpRect;
    public final RectF tmpRectF1;
    public final RectF tmpRectF2;

    public static class FabTransformationSpec {
        public Positioning positioning;
        public MotionSpec timings;
    }

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    public final Pair<MotionTiming, MotionTiming> calculateMotionTiming(float f, float f2, boolean z, FabTransformationSpec fabTransformationSpec) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        int i;
        if (f == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f2 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXLinear");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYLinear");
        } else if ((!z || f2 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) && (z || i <= 0)) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
        } else {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
        }
        return new Pair<>(motionTiming2, motionTiming);
    }

    public final float calculateTranslationX(View view, View view2, Positioning positioning) {
        float f;
        float f2;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        calculateWindowBounds(view2, rectF2);
        float f3 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        int i = positioning.gravity & 7;
        if (i == 1) {
            f2 = rectF2.centerX();
            f = rectF.centerX();
        } else if (i != 3) {
            if (i == 5) {
                f2 = rectF2.right;
                f = rectF.right;
            }
            return f3 + positioning.xAdjustment;
        } else {
            f2 = rectF2.left;
            f = rectF.left;
        }
        f3 = f2 - f;
        return f3 + positioning.xAdjustment;
    }

    public final float calculateTranslationY(View view, View view2, Positioning positioning) {
        float f;
        float f2;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        calculateWindowBounds(view2, rectF2);
        float f3 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        int i = positioning.gravity & 112;
        if (i == 16) {
            f2 = rectF2.centerY();
            f = rectF.centerY();
        } else if (i != 48) {
            if (i == 80) {
                f2 = rectF2.bottom;
                f = rectF.bottom;
            }
            return f3 + positioning.yAdjustment;
        } else {
            f2 = rectF2.top;
            f = rectF.top;
        }
        f3 = f2 - f;
        return f3 + positioning.yAdjustment;
    }

    public final float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f, float f2) {
        long j = motionTiming.delay;
        long j2 = motionTiming.duration;
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        return AnimationUtils.lerp(f, f2, motionTiming.getInterpolator().getInterpolation(((float) (((timing.delay + timing.duration) + 17) - j)) / ((float) j2)));
    }

    public final void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.tmpArray;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$FabTransformationSpec;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void createChildrenFadeAnimation(View view, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator;
        if (view instanceof ViewGroup) {
            boolean z3 = view instanceof CircularRevealWidget;
            View findViewById = view.findViewById(R$id.mtrl_child_content_container);
            if (findViewById != null) {
                viewGroup = toViewGroupOrNull(findViewById);
            } else if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
                viewGroup = toViewGroupOrNull(((ViewGroup) view).getChildAt(0));
            } else {
                viewGroup = toViewGroupOrNull(view);
            }
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        ChildrenAlphaProperty.CHILDREN_ALPHA.set(viewGroup, Float.valueOf((float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, 1.0f);
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, 0.0f);
                }
                fabTransformationSpec.timings.getTiming("contentFade").apply(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$FabTransformationSpec;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void createColorAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(colorForState);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, i);
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, colorForState);
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.instance);
            fabTransformationSpec.timings.getTiming("color").apply(objectAnimator);
            list.add(objectAnimator);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$FabTransformationSpec;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    @TargetApi(21)
    public final void createElevationAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ObjectAnimator objectAnimator;
        float elevation = ViewCompat.getElevation(view2) - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(objectAnimator);
        list.add(objectAnimator);
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$FabTransformationSpec;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;Landroid/graphics/RectF;)V */
    public final void createTranslationAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-calculateTranslationX);
                view2.setTranslationY(-calculateTranslationY);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, -calculateTranslationX, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, -calculateTranslationY, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            Rect rect = this.tmpRect;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.tmpRectF1;
            rectF2.set(rect);
            RectF rectF3 = this.tmpRectF2;
            calculateWindowBounds(view2, rectF3);
            rectF3.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -calculateTranslationX);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -calculateTranslationY);
        }
        motionTiming.apply(objectAnimator2);
        motionTiming2.apply(objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet onCreateExpandedStateChangeAnimation(final View view, final View view2, final boolean z, boolean z2) {
        int i;
        FabTransformationSpec fabTransformationSpec;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        MotionTiming motionTiming;
        Animator animator;
        ObjectAnimator objectAnimator;
        Context context = view2.getContext();
        if (z) {
            i = R$animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i = R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationSpec fabTransformationSpec2 = new FabTransformationSpec();
        fabTransformationSpec2.timings = MotionSpec.createFromResource(context, i);
        fabTransformationSpec2.positioning = new Positioning(17, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        if (z) {
            this.dependencyOriginalTranslationX = view.getTranslationX();
            this.dependencyOriginalTranslationY = view.getTranslationY();
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        createElevationAnimation(view, view2, z, z2, fabTransformationSpec2, arrayList4);
        RectF rectF = this.tmpRectF1;
        createTranslationAnimation(view, view2, z, z2, fabTransformationSpec2, arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec2.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec2.positioning);
        Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, fabTransformationSpec2);
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming3 = (MotionTiming) calculateMotionTiming.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            calculateTranslationX = this.dependencyOriginalTranslationX;
        }
        fArr[0] = calculateTranslationX;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            calculateTranslationY = this.dependencyOriginalTranslationY;
        }
        fArr2[0] = calculateTranslationY;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        motionTiming2.apply(ofFloat);
        motionTiming3.apply(ofFloat2);
        arrayList4.add(ofFloat);
        arrayList4.add(ofFloat2);
        boolean z3 = view2 instanceof CircularRevealWidget;
        if (z3 && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 255);
                }
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                    /* class com.google.android.material.transformation.FabTransformationBehavior.AnonymousClass2 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                fabTransformationSpec2.timings.getTiming("iconFade").apply(objectAnimator);
                arrayList4.add(objectAnimator);
                arrayList5.add(new AnimatorListenerAdapter(this) {
                    /* class com.google.android.material.transformation.FabTransformationBehavior.AnonymousClass3 */

                    public void onAnimationEnd(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(null);
                    }

                    public void onAnimationStart(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                    }
                });
            }
        }
        if (!z3) {
            fabTransformationSpec = fabTransformationSpec2;
            arrayList2 = arrayList4;
            arrayList = arrayList5;
        } else {
            final CircularRevealWidget circularRevealWidget2 = (CircularRevealWidget) view2;
            Positioning positioning = fabTransformationSpec2.positioning;
            RectF rectF2 = this.tmpRectF1;
            RectF rectF3 = this.tmpRectF2;
            calculateWindowBounds(view, rectF2);
            rectF2.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
            calculateWindowBounds(view2, rectF3);
            rectF3.offset(-calculateTranslationX(view, view2, positioning), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float centerX = rectF2.centerX() - rectF3.left;
            Positioning positioning2 = fabTransformationSpec2.positioning;
            RectF rectF4 = this.tmpRectF1;
            RectF rectF5 = this.tmpRectF2;
            calculateWindowBounds(view, rectF4);
            rectF4.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
            calculateWindowBounds(view2, rectF5);
            rectF5.offset(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, -calculateTranslationY(view, view2, positioning2));
            float centerY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view).getContentRect(this.tmpRect);
            float width2 = ((float) this.tmpRect.width()) / 2.0f;
            MotionTiming timing = fabTransformationSpec2.timings.getTiming("expansion");
            if (z) {
                if (!z2) {
                    circularRevealWidget2.setRevealInfo(new CircularRevealWidget.RevealInfo(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = circularRevealWidget2.getRevealInfo().radius;
                }
                float dist = ReactYogaConfigProvider.dist(centerX, centerY, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                float dist2 = ReactYogaConfigProvider.dist(centerX, centerY, width, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                float dist3 = ReactYogaConfigProvider.dist(centerX, centerY, width, height);
                float dist4 = ReactYogaConfigProvider.dist(centerX, centerY, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, height);
                if (dist <= dist2 || dist <= dist3 || dist <= dist4) {
                    dist = (dist2 <= dist3 || dist2 <= dist4) ? dist3 > dist4 ? dist3 : dist4 : dist2;
                }
                animator = ReactYogaConfigProvider.createCircularReveal(circularRevealWidget2, centerX, centerY, dist);
                animator.addListener(new AnimatorListenerAdapter(this) {
                    /* class com.google.android.material.transformation.FabTransformationBehavior.AnonymousClass4 */

                    public void onAnimationEnd(Animator animator) {
                        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget2.getRevealInfo();
                        revealInfo.radius = Float.MAX_VALUE;
                        circularRevealWidget2.setRevealInfo(revealInfo);
                    }
                });
                long j = timing.delay;
                int i2 = (int) centerX;
                int i3 = (int) centerY;
                if (j > 0) {
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i2, i3, width2, width2);
                    createCircularReveal.setStartDelay(0);
                    createCircularReveal.setDuration(j);
                    arrayList4.add(createCircularReveal);
                }
                motionTiming = timing;
                fabTransformationSpec = fabTransformationSpec2;
                arrayList2 = arrayList4;
                arrayList3 = arrayList5;
            } else {
                float f = circularRevealWidget2.getRevealInfo().radius;
                Animator createCircularReveal2 = ReactYogaConfigProvider.createCircularReveal(circularRevealWidget2, centerX, centerY, width2);
                long j2 = timing.delay;
                int i4 = (int) centerX;
                int i5 = (int) centerY;
                if (j2 > 0) {
                    Animator createCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, f, f);
                    createCircularReveal3.setStartDelay(0);
                    createCircularReveal3.setDuration(j2);
                    arrayList4.add(createCircularReveal3);
                }
                long j3 = timing.delay;
                long j4 = timing.duration;
                MotionSpec motionSpec = fabTransformationSpec2.timings;
                int i6 = motionSpec.timings.mSize;
                fabTransformationSpec = fabTransformationSpec2;
                int i7 = 0;
                long j5 = 0;
                while (i7 < i6) {
                    MotionTiming valueAt = motionSpec.timings.valueAt(i7);
                    j5 = Math.max(j5, valueAt.delay + valueAt.duration);
                    i7++;
                    i6 = i6;
                    arrayList4 = arrayList4;
                    arrayList5 = arrayList5;
                    motionSpec = motionSpec;
                }
                arrayList3 = arrayList5;
                long j6 = j3 + j4;
                if (j6 < j5) {
                    Animator createCircularReveal4 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, width2, width2);
                    createCircularReveal4.setStartDelay(j6);
                    createCircularReveal4.setDuration(j5 - j6);
                    arrayList2 = arrayList4;
                    arrayList2.add(createCircularReveal4);
                } else {
                    arrayList2 = arrayList4;
                }
                animator = createCircularReveal2;
                motionTiming = timing;
            }
            motionTiming.apply(animator);
            arrayList2.add(animator);
            arrayList = arrayList3;
            arrayList.add(new CircularRevealCompat$1(circularRevealWidget2));
        }
        createColorAnimation(view, view2, z, z2, fabTransformationSpec, arrayList2);
        createChildrenFadeAnimation(view2, z, z2, fabTransformationSpec, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        ReactYogaConfigProvider.playTogether(animatorSet, arrayList2);
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            /* class com.google.android.material.transformation.FabTransformationBehavior.AnonymousClass1 */

            public void onAnimationEnd(Animator animator) {
                if (!z) {
                    view2.setVisibility(4);
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                    view.setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    view.setVisibility(4);
                }
            }
        });
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList.get(i8));
        }
        return animatorSet;
    }

    public final ViewGroup toViewGroupOrNull(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }
}
