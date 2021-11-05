package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import b.i.l.m;
import b.x.t;
import c.b.a.b.f;
import c.b.a.b.m.d;
import c.b.a.b.m.g;
import c.b.a.b.m.h;
import c.b.a.b.m.i;
import c.b.a.b.o0.e;
import c.b.a.b.w.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f6196c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f6197d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f6198e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f6199f;

    /* renamed from: g  reason: collision with root package name */
    public float f6200g;
    public float h;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f6201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f6202b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f6203c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f6201a = z;
            this.f6202b = view;
            this.f6203c = view2;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f6201a) {
                this.f6202b.setVisibility(4);
                this.f6203c.setAlpha(1.0f);
                this.f6203c.setVisibility(0);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f6201a) {
                this.f6202b.setVisibility(0);
                this.f6203c.setAlpha(0.0f);
                this.f6203c.setVisibility(4);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public g f6204a;

        /* renamed from: b  reason: collision with root package name */
        public i f6205b;
    }

    public FabTransformationBehavior() {
        this.f6196c = new Rect();
        this.f6197d = new RectF();
        this.f6198e = new RectF();
        this.f6199f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6196c = new Rect();
        this.f6197d = new RectF();
        this.f6198e = new RectF();
        this.f6199f = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet D(View view, View view2, boolean z, boolean z2) {
        b bVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        h hVar;
        Animator animator;
        ObjectAnimator objectAnimator;
        Context context = view2.getContext();
        int i = z ? c.b.a.b.a.mtrl_fab_transformation_sheet_expand_spec : c.b.a.b.a.mtrl_fab_transformation_sheet_collapse_spec;
        b bVar2 = new b();
        bVar2.f6204a = g.b(context, i);
        bVar2.f6205b = new i(17, 0.0f, 0.0f);
        if (z) {
            this.f6200g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        L(view, view2, z, z2, bVar2, arrayList4);
        RectF rectF = this.f6197d;
        M(view, view2, z, z2, bVar2, arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        float F = F(view, view2, bVar2.f6205b);
        float G = G(view, view2, bVar2.f6205b);
        Pair<h, h> E = E(F, G, z, bVar2);
        h hVar2 = (h) E.first;
        h hVar3 = (h) E.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            F = this.f6200g;
        }
        fArr[0] = F;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            G = this.h;
        }
        fArr2[0] = G;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        hVar2.a(ofFloat);
        hVar3.a(ofFloat2);
        arrayList4.add(ofFloat);
        arrayList4.add(ofFloat2);
        boolean z3 = view2 instanceof c;
        if (z3 && (view instanceof ImageView)) {
            c cVar = (c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(BuildConfig.VERSION_CODE);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, d.f4417b, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, d.f4417b, 255);
                }
                objectAnimator.addUpdateListener(new c.b.a.b.o0.a(this, view2));
                bVar2.f6204a.d("iconFade").a(objectAnimator);
                arrayList4.add(objectAnimator);
                arrayList5.add(new c.b.a.b.o0.b(this, cVar, drawable));
            }
        }
        if (!z3) {
            bVar = bVar2;
            arrayList2 = arrayList4;
            arrayList = arrayList5;
        } else {
            c cVar2 = (c) view2;
            i iVar = bVar2.f6205b;
            RectF rectF2 = this.f6197d;
            RectF rectF3 = this.f6198e;
            I(view, rectF2);
            rectF2.offset(this.f6200g, this.h);
            I(view2, rectF3);
            rectF3.offset(-F(view, view2, iVar), 0.0f);
            float centerX = rectF2.centerX() - rectF3.left;
            i iVar2 = bVar2.f6205b;
            RectF rectF4 = this.f6197d;
            RectF rectF5 = this.f6198e;
            I(view, rectF4);
            rectF4.offset(this.f6200g, this.h);
            I(view2, rectF5);
            rectF5.offset(0.0f, -G(view, view2, iVar2));
            float centerY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view).g(this.f6196c);
            float width2 = ((float) this.f6196c.width()) / 2.0f;
            h d2 = bVar2.f6204a.d("expansion");
            if (z) {
                if (!z2) {
                    cVar2.setRevealInfo(new c.e(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = cVar2.getRevealInfo().f4538c;
                }
                float e1 = t.e1(centerX, centerY, 0.0f, 0.0f);
                float e12 = t.e1(centerX, centerY, width, 0.0f);
                float e13 = t.e1(centerX, centerY, width, height);
                float e14 = t.e1(centerX, centerY, 0.0f, height);
                if (e1 <= e12 || e1 <= e13 || e1 <= e14) {
                    e1 = (e12 <= e13 || e12 <= e14) ? e13 > e14 ? e13 : e14 : e12;
                }
                animator = t.T(cVar2, centerX, centerY, e1);
                animator.addListener(new c.b.a.b.o0.c(this, cVar2));
                long j = d2.f4425a;
                int i2 = (int) centerX;
                int i3 = (int) centerY;
                if (j > 0) {
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i2, i3, width2, width2);
                    createCircularReveal.setStartDelay(0);
                    createCircularReveal.setDuration(j);
                    arrayList4.add(createCircularReveal);
                }
                hVar = d2;
                bVar = bVar2;
                arrayList2 = arrayList4;
                arrayList3 = arrayList5;
            } else {
                float f2 = cVar2.getRevealInfo().f4538c;
                Animator T = t.T(cVar2, centerX, centerY, width2);
                long j2 = d2.f4425a;
                int i4 = (int) centerX;
                int i5 = (int) centerY;
                if (j2 > 0) {
                    Animator createCircularReveal2 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, f2, f2);
                    createCircularReveal2.setStartDelay(0);
                    createCircularReveal2.setDuration(j2);
                    arrayList4.add(createCircularReveal2);
                }
                long j3 = d2.f4425a;
                long j4 = d2.f4426b;
                g gVar = bVar2.f6204a;
                int i6 = gVar.f4423a.f1413d;
                bVar = bVar2;
                int i7 = 0;
                long j5 = 0;
                while (i7 < i6) {
                    h k = gVar.f4423a.k(i7);
                    j5 = Math.max(j5, k.f4425a + k.f4426b);
                    i7++;
                    i6 = i6;
                    arrayList4 = arrayList4;
                    arrayList5 = arrayList5;
                    gVar = gVar;
                }
                arrayList3 = arrayList5;
                long j6 = j3 + j4;
                if (j6 < j5) {
                    Animator createCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, width2, width2);
                    createCircularReveal3.setStartDelay(j6);
                    createCircularReveal3.setDuration(j5 - j6);
                    arrayList2 = arrayList4;
                    arrayList2.add(createCircularReveal3);
                } else {
                    arrayList2 = arrayList4;
                }
                animator = T;
                hVar = d2;
            }
            hVar.a(animator);
            arrayList2.add(animator);
            arrayList = arrayList3;
            arrayList.add(new c.b.a.b.w.a(cVar2));
        }
        K(view, view2, z, z2, bVar, arrayList2);
        J(view2, z, z2, bVar, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        t.n2(animatorSet, arrayList2);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList.get(i8));
        }
        return animatorSet;
    }

    public final Pair<h, h> E(float f2, float f3, boolean z, b bVar) {
        String str;
        g gVar;
        h hVar;
        int i;
        if (f2 == 0.0f || f3 == 0.0f) {
            hVar = bVar.f6204a.d("translationXLinear");
            gVar = bVar.f6204a;
            str = "translationYLinear";
        } else if ((!z || f3 >= 0.0f) && (z || i <= 0)) {
            hVar = bVar.f6204a.d("translationXCurveDownwards");
            gVar = bVar.f6204a;
            str = "translationYCurveDownwards";
        } else {
            hVar = bVar.f6204a.d("translationXCurveUpwards");
            gVar = bVar.f6204a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(hVar, gVar.d(str));
    }

    public final float F(View view, View view2, i iVar) {
        float f2;
        float f3;
        RectF rectF = this.f6197d;
        RectF rectF2 = this.f6198e;
        I(view, rectF);
        rectF.offset(this.f6200g, this.h);
        I(view2, rectF2);
        float f4 = 0.0f;
        int i = iVar.f4430a & 7;
        if (i == 1) {
            f3 = rectF2.centerX();
            f2 = rectF.centerX();
        } else if (i != 3) {
            if (i == 5) {
                f3 = rectF2.right;
                f2 = rectF.right;
            }
            return f4 + iVar.f4431b;
        } else {
            f3 = rectF2.left;
            f2 = rectF.left;
        }
        f4 = f3 - f2;
        return f4 + iVar.f4431b;
    }

    public final float G(View view, View view2, i iVar) {
        float f2;
        float f3;
        RectF rectF = this.f6197d;
        RectF rectF2 = this.f6198e;
        I(view, rectF);
        rectF.offset(this.f6200g, this.h);
        I(view2, rectF2);
        float f4 = 0.0f;
        int i = iVar.f4430a & 112;
        if (i == 16) {
            f3 = rectF2.centerY();
            f2 = rectF.centerY();
        } else if (i != 48) {
            if (i == 80) {
                f3 = rectF2.bottom;
                f2 = rectF.bottom;
            }
            return f4 + iVar.f4432c;
        } else {
            f3 = rectF2.top;
            f2 = rectF.top;
        }
        f4 = f3 - f2;
        return f4 + iVar.f4432c;
    }

    public final float H(b bVar, h hVar, float f2, float f3) {
        long j = hVar.f4425a;
        long j2 = hVar.f4426b;
        h d2 = bVar.f6204a.d("expansion");
        return c.b.a.b.m.a.a(f2, f3, hVar.b().getInterpolation(((float) (((d2.f4425a + d2.f4426b) + 17) - j)) / ((float) j2)));
    }

    public final void I(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f6199f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void J(View view, boolean z, boolean z2, b bVar, List list) {
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator;
        if (view instanceof ViewGroup) {
            boolean z3 = view instanceof c;
            View findViewById = view.findViewById(f.mtrl_child_content_container);
            if (findViewById != null) {
                viewGroup = N(findViewById);
            } else {
                if ((view instanceof e) || (view instanceof c.b.a.b.o0.d)) {
                    view = ((ViewGroup) view).getChildAt(0);
                }
                viewGroup = N(view);
            }
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        c.b.a.b.m.c.f4416a.set(viewGroup, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, c.b.a.b.m.c.f4416a, 1.0f);
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, c.b.a.b.m.c.f4416a, 0.0f);
                }
                bVar.f6204a.d("contentFade").a(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void K(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof c) {
            c cVar = (c) view2;
            ColorStateList i = m.i(view);
            int colorForState = i != null ? i.getColorForState(view.getDrawableState(), i.getDefaultColor()) : 0;
            int i2 = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(colorForState);
                }
                objectAnimator = ObjectAnimator.ofInt(cVar, c.d.f4535a, i2);
            } else {
                objectAnimator = ObjectAnimator.ofInt(cVar, c.d.f4535a, colorForState);
            }
            objectAnimator.setEvaluator(c.b.a.b.m.b.f4415a);
            bVar.f6204a.d("color").a(objectAnimator);
            list.add(objectAnimator);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    @TargetApi(21)
    public final void L(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator objectAnimator;
        float l = m.l(view2) - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-l);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -l);
        }
        bVar.f6204a.d("elevation").a(objectAnimator);
        list.add(objectAnimator);
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;Landroid/graphics/RectF;)V */
    public final void M(View view, View view2, boolean z, boolean z2, b bVar, List list, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float F = F(view, view2, bVar.f6205b);
        float G = G(view, view2, bVar.f6205b);
        Pair<h, h> E = E(F, G, z, bVar);
        h hVar = (h) E.first;
        h hVar2 = (h) E.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-F);
                view2.setTranslationY(-G);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            float H = H(bVar, hVar, -F, 0.0f);
            float H2 = H(bVar, hVar2, -G, 0.0f);
            Rect rect = this.f6196c;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.f6197d;
            rectF2.set(rect);
            RectF rectF3 = this.f6198e;
            I(view2, rectF3);
            rectF3.offset(H, H2);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -F);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -G);
        }
        hVar.a(objectAnimator2);
        hVar2.a(objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    public final ViewGroup N(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }
}
