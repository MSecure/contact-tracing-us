package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
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
import com.google.android.material.R$id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.i.i.m;
import f.b.a.e.a.d;
import f.b.a.e.a.g;
import f.b.a.e.a.h;
import f.b.a.e.a.i;
import f.b.a.e.a0.e;
import f.b.a.e.j.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f636d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f637e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f638f;

    /* renamed from: g  reason: collision with root package name */
    public float f639g;

    /* renamed from: h  reason: collision with root package name */
    public float f640h;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.a = z;
            this.b = view;
            this.c = view2;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                this.b.setVisibility(4);
                this.c.setAlpha(1.0f);
                this.c.setVisibility(0);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.b.setVisibility(0);
                this.c.setAlpha(0.0f);
                this.c.setVisibility(4);
            }
        }
    }

    public static class b {
        public g a;
        public i b;
    }

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.f636d = new RectF();
        this.f637e = new RectF();
        this.f638f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.f636d = new RectF();
        this.f637e = new RectF();
        this.f638f = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet D(View view, View view2, boolean z, boolean z2) {
        b bVar;
        ArrayList arrayList;
        c cVar;
        ArrayList arrayList2;
        Animator animator;
        ObjectAnimator objectAnimator;
        b N = N(view2.getContext(), z);
        if (z) {
            this.f639g = view.getTranslationX();
            this.f640h = view.getTranslationY();
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        L(view, view2, z, z2, N, arrayList3);
        RectF rectF = this.f636d;
        M(view, view2, z, z2, N, arrayList3, rectF);
        float width = rectF.width();
        float height = rectF.height();
        float F = F(view, view2, N.b);
        float G = G(view, view2, N.b);
        Pair<h, h> E = E(F, G, z, N);
        h hVar = (h) E.first;
        h hVar2 = (h) E.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            F = this.f639g;
        }
        fArr[0] = F;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            G = this.f640h;
        }
        fArr2[0] = G;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        hVar.a(ofFloat);
        hVar2.a(ofFloat2);
        arrayList3.add(ofFloat);
        arrayList3.add(ofFloat2);
        boolean z3 = view2 instanceof c;
        if (z3 && (view instanceof ImageView)) {
            c cVar2 = (c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, d.b, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, d.b, 255);
                }
                objectAnimator.addUpdateListener(new f.b.a.e.a0.a(this, view2));
                N.a.d("iconFade").a(objectAnimator);
                arrayList3.add(objectAnimator);
                arrayList4.add(new f.b.a.e.a0.b(this, cVar2, drawable));
            }
        }
        if (!z3) {
            bVar = N;
            arrayList = arrayList4;
        } else {
            c cVar3 = (c) view2;
            i iVar = N.b;
            RectF rectF2 = this.f636d;
            RectF rectF3 = this.f637e;
            I(view, rectF2);
            rectF2.offset(this.f639g, this.f640h);
            I(view2, rectF3);
            rectF3.offset(-F(view, view2, iVar), 0.0f);
            float centerX = rectF2.centerX() - rectF3.left;
            i iVar2 = N.b;
            RectF rectF4 = this.f636d;
            RectF rectF5 = this.f637e;
            I(view, rectF4);
            rectF4.offset(this.f639g, this.f640h);
            I(view2, rectF5);
            rectF5.offset(0.0f, -G(view, view2, iVar2));
            float centerY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view).g(this.c);
            float width2 = ((float) this.c.width()) / 2.0f;
            h d2 = N.a.d("expansion");
            if (z) {
                if (!z2) {
                    cVar3.setRevealInfo(new c.e(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = cVar3.getRevealInfo().c;
                }
                float j0 = f.b.a.c.b.o.b.j0(centerX, centerY, 0.0f, 0.0f);
                float j02 = f.b.a.c.b.o.b.j0(centerX, centerY, width, 0.0f);
                float j03 = f.b.a.c.b.o.b.j0(centerX, centerY, width, height);
                float j04 = f.b.a.c.b.o.b.j0(centerX, centerY, 0.0f, height);
                if (j0 <= j02 || j0 <= j03 || j0 <= j04) {
                    j0 = (j02 <= j03 || j02 <= j04) ? j03 > j04 ? j03 : j04 : j02;
                }
                animator = f.b.a.c.b.o.b.J(cVar3, centerX, centerY, j0);
                animator.addListener(new f.b.a.e.a0.c(this, cVar3));
                long j2 = d2.a;
                int i2 = (int) centerX;
                int i3 = (int) centerY;
                if (j2 > 0) {
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i2, i3, width2, width2);
                    createCircularReveal.setStartDelay(0);
                    createCircularReveal.setDuration(j2);
                    arrayList3.add(createCircularReveal);
                }
                cVar = cVar3;
                arrayList2 = arrayList4;
                bVar = N;
            } else {
                float f2 = cVar3.getRevealInfo().c;
                Animator J = f.b.a.c.b.o.b.J(cVar3, centerX, centerY, width2);
                long j3 = d2.a;
                int i4 = (int) centerX;
                int i5 = (int) centerY;
                if (j3 > 0) {
                    Animator createCircularReveal2 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, f2, f2);
                    createCircularReveal2.setStartDelay(0);
                    createCircularReveal2.setDuration(j3);
                    arrayList3.add(createCircularReveal2);
                }
                long j4 = d2.a;
                long j5 = d2.b;
                g gVar = N.a;
                int i6 = gVar.a.f1022d;
                arrayList2 = arrayList4;
                bVar = N;
                int i7 = 0;
                long j6 = 0;
                while (i7 < i6) {
                    h k2 = gVar.a.k(i7);
                    j6 = Math.max(j6, k2.a + k2.b);
                    i7++;
                    i6 = i6;
                    cVar3 = cVar3;
                    i4 = i4;
                    gVar = gVar;
                }
                cVar = cVar3;
                long j7 = j4 + j5;
                if (j7 < j6) {
                    Animator createCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, width2, width2);
                    createCircularReveal3.setStartDelay(j7);
                    createCircularReveal3.setDuration(j6 - j7);
                    arrayList3.add(createCircularReveal3);
                }
                animator = J;
            }
            d2.a(animator);
            arrayList3.add(animator);
            arrayList = arrayList2;
            arrayList.add(new f.b.a.e.j.a(cVar));
        }
        K(view, view2, z, z2, bVar, arrayList3);
        J(view2, z, z2, bVar, arrayList3);
        AnimatorSet animatorSet = new AnimatorSet();
        f.b.a.c.b.o.b.d1(animatorSet, arrayList3);
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
        int i2;
        if (f2 == 0.0f || f3 == 0.0f) {
            hVar = bVar.a.d("translationXLinear");
            gVar = bVar.a;
            str = "translationYLinear";
        } else if ((!z || f3 >= 0.0f) && (z || i2 <= 0)) {
            hVar = bVar.a.d("translationXCurveDownwards");
            gVar = bVar.a;
            str = "translationYCurveDownwards";
        } else {
            hVar = bVar.a.d("translationXCurveUpwards");
            gVar = bVar.a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(hVar, gVar.d(str));
    }

    public final float F(View view, View view2, i iVar) {
        RectF rectF = this.f636d;
        RectF rectF2 = this.f637e;
        I(view, rectF);
        rectF.offset(this.f639g, this.f640h);
        I(view2, rectF2);
        Objects.requireNonNull(iVar);
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float G(View view, View view2, i iVar) {
        RectF rectF = this.f636d;
        RectF rectF2 = this.f637e;
        I(view, rectF);
        rectF.offset(this.f639g, this.f640h);
        I(view2, rectF2);
        Objects.requireNonNull(iVar);
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final float H(b bVar, h hVar, float f2, float f3) {
        long j2 = hVar.a;
        long j3 = hVar.b;
        h d2 = bVar.a.d("expansion");
        float interpolation = hVar.b().getInterpolation(((float) (((d2.a + d2.b) + 17) - j2)) / ((float) j3));
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
        return f.a.a.a.a.a(f3, f2, interpolation, f2);
    }

    public final void I(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f638f;
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
            View findViewById = view.findViewById(R$id.mtrl_child_content_container);
            if (findViewById != null) {
                viewGroup = O(findViewById);
            } else {
                if ((view instanceof e) || (view instanceof f.b.a.e.a0.d)) {
                    view = ((ViewGroup) view).getChildAt(0);
                }
                viewGroup = O(view);
            }
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        f.b.a.e.a.c.a.set(viewGroup, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, f.b.a.e.a.c.a, 1.0f);
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, f.b.a.e.a.c.a, 0.0f);
                }
                bVar.a.d("contentFade").a(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void K(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof c) {
            c cVar = (c) view2;
            AtomicInteger atomicInteger = m.a;
            ColorStateList backgroundTintList = view.getBackgroundTintList();
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i2 = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(colorForState);
                }
                objectAnimator = ObjectAnimator.ofInt(cVar, c.d.a, i2);
            } else {
                objectAnimator = ObjectAnimator.ofInt(cVar, c.d.a, colorForState);
            }
            objectAnimator.setEvaluator(f.b.a.e.a.b.a);
            bVar.a.d("color").a(objectAnimator);
            list.add(objectAnimator);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void L(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator objectAnimator;
        AtomicInteger atomicInteger = m.a;
        float elevation = view2.getElevation() - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        bVar.a.d("elevation").a(objectAnimator);
        list.add(objectAnimator);
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;Landroid/graphics/RectF;)V */
    public final void M(View view, View view2, boolean z, boolean z2, b bVar, List list, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float F = F(view, view2, bVar.b);
        float G = G(view, view2, bVar.b);
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
            Rect rect = this.c;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.f636d;
            rectF2.set(rect);
            RectF rectF3 = this.f637e;
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

    public abstract b N(Context context, boolean z);

    public final ViewGroup O(View view) {
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
        if (fVar.f146h == 0) {
            fVar.f146h = 80;
        }
    }
}
