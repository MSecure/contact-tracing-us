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
import c.b.a.b.f;
import c.b.a.b.m.d;
import c.b.a.b.m.g;
import c.b.a.b.m.h;
import c.b.a.b.m.i;
import c.b.a.b.n0.e;
import c.b.a.b.w.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f4582c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f4583d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f4584e;
    public final int[] f;
    public float g;
    public float h;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f4585a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f4586b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f4587c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f4585a = z;
            this.f4586b = view;
            this.f4587c = view2;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f4585a) {
                this.f4586b.setVisibility(4);
                this.f4587c.setAlpha(1.0f);
                this.f4587c.setVisibility(0);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f4585a) {
                this.f4586b.setVisibility(0);
                this.f4587c.setAlpha(0.0f);
                this.f4587c.setVisibility(4);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public g f4588a;

        /* renamed from: b  reason: collision with root package name */
        public i f4589b;
    }

    public FabTransformationBehavior() {
        this.f4582c = new Rect();
        this.f4583d = new RectF();
        this.f4584e = new RectF();
        this.f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4582c = new Rect();
        this.f4583d = new RectF();
        this.f4584e = new RectF();
        this.f = new int[2];
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
        bVar2.f4588a = g.b(context, i);
        bVar2.f4589b = new i(17, 0.0f, 0.0f);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        L(view, view2, z, z2, bVar2, arrayList4);
        RectF rectF = this.f4583d;
        M(view, view2, z, z2, bVar2, arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        float F = F(view, view2, bVar2.f4589b);
        float G = G(view, view2, bVar2.f4589b);
        Pair<h, h> E = E(F, G, z, bVar2);
        h hVar2 = (h) E.first;
        h hVar3 = (h) E.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            F = this.g;
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
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, d.f3115b, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, d.f3115b, 255);
                }
                objectAnimator.addUpdateListener(new c.b.a.b.n0.a(this, view2));
                bVar2.f4588a.d("iconFade").a(objectAnimator);
                arrayList4.add(objectAnimator);
                arrayList5.add(new c.b.a.b.n0.b(this, cVar, drawable));
            }
        }
        if (!z3) {
            bVar = bVar2;
            arrayList2 = arrayList4;
            arrayList = arrayList5;
        } else {
            c cVar2 = (c) view2;
            i iVar = bVar2.f4589b;
            RectF rectF2 = this.f4583d;
            RectF rectF3 = this.f4584e;
            I(view, rectF2);
            rectF2.offset(this.g, this.h);
            I(view2, rectF3);
            rectF3.offset(-F(view, view2, iVar), 0.0f);
            float centerX = rectF2.centerX() - rectF3.left;
            i iVar2 = bVar2.f4589b;
            RectF rectF4 = this.f4583d;
            RectF rectF5 = this.f4584e;
            I(view, rectF4);
            rectF4.offset(this.g, this.h);
            I(view2, rectF5);
            rectF5.offset(0.0f, -G(view, view2, iVar2));
            float centerY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view).g(this.f4582c);
            float width2 = ((float) this.f4582c.width()) / 2.0f;
            h d2 = bVar2.f4588a.d("expansion");
            if (z) {
                if (!z2) {
                    cVar2.setRevealInfo(new c.e(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = cVar2.getRevealInfo().f3217c;
                }
                float G0 = c.b.a.a.c.n.c.G0(centerX, centerY, 0.0f, 0.0f);
                float G02 = c.b.a.a.c.n.c.G0(centerX, centerY, width, 0.0f);
                float G03 = c.b.a.a.c.n.c.G0(centerX, centerY, width, height);
                float G04 = c.b.a.a.c.n.c.G0(centerX, centerY, 0.0f, height);
                if (G0 <= G02 || G0 <= G03 || G0 <= G04) {
                    G0 = (G02 <= G03 || G02 <= G04) ? G03 > G04 ? G03 : G04 : G02;
                }
                animator = c.b.a.a.c.n.c.F(cVar2, centerX, centerY, G0);
                animator.addListener(new c.b.a.b.n0.c(this, cVar2));
                long j = d2.f3123a;
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
                float f2 = cVar2.getRevealInfo().f3217c;
                Animator F2 = c.b.a.a.c.n.c.F(cVar2, centerX, centerY, width2);
                long j2 = d2.f3123a;
                int i4 = (int) centerX;
                int i5 = (int) centerY;
                if (j2 > 0) {
                    Animator createCircularReveal2 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, f2, f2);
                    createCircularReveal2.setStartDelay(0);
                    createCircularReveal2.setDuration(j2);
                    arrayList4.add(createCircularReveal2);
                }
                long j3 = d2.f3123a;
                long j4 = d2.f3124b;
                g gVar = bVar2.f4588a;
                int i6 = gVar.f3121a.f829d;
                bVar = bVar2;
                int i7 = 0;
                long j5 = 0;
                while (i7 < i6) {
                    h k = gVar.f3121a.k(i7);
                    j5 = Math.max(j5, k.f3123a + k.f3124b);
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
                animator = F2;
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
        c.b.a.a.c.n.c.O1(animatorSet, arrayList2);
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
            hVar = bVar.f4588a.d("translationXLinear");
            gVar = bVar.f4588a;
            str = "translationYLinear";
        } else if ((!z || f3 >= 0.0f) && (z || i <= 0)) {
            hVar = bVar.f4588a.d("translationXCurveDownwards");
            gVar = bVar.f4588a;
            str = "translationYCurveDownwards";
        } else {
            hVar = bVar.f4588a.d("translationXCurveUpwards");
            gVar = bVar.f4588a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(hVar, gVar.d(str));
    }

    public final float F(View view, View view2, i iVar) {
        float f2;
        float f3;
        RectF rectF = this.f4583d;
        RectF rectF2 = this.f4584e;
        I(view, rectF);
        rectF.offset(this.g, this.h);
        I(view2, rectF2);
        float f4 = 0.0f;
        int i = iVar.f3128a & 7;
        if (i == 1) {
            f3 = rectF2.centerX();
            f2 = rectF.centerX();
        } else if (i != 3) {
            if (i == 5) {
                f3 = rectF2.right;
                f2 = rectF.right;
            }
            return f4 + iVar.f3129b;
        } else {
            f3 = rectF2.left;
            f2 = rectF.left;
        }
        f4 = f3 - f2;
        return f4 + iVar.f3129b;
    }

    public final float G(View view, View view2, i iVar) {
        float f2;
        float f3;
        RectF rectF = this.f4583d;
        RectF rectF2 = this.f4584e;
        I(view, rectF);
        rectF.offset(this.g, this.h);
        I(view2, rectF2);
        float f4 = 0.0f;
        int i = iVar.f3128a & 112;
        if (i == 16) {
            f3 = rectF2.centerY();
            f2 = rectF.centerY();
        } else if (i != 48) {
            if (i == 80) {
                f3 = rectF2.bottom;
                f2 = rectF.bottom;
            }
            return f4 + iVar.f3130c;
        } else {
            f3 = rectF2.top;
            f2 = rectF.top;
        }
        f4 = f3 - f2;
        return f4 + iVar.f3130c;
    }

    public final float H(b bVar, h hVar, float f2, float f3) {
        long j = hVar.f3123a;
        long j2 = hVar.f3124b;
        h d2 = bVar.f4588a.d("expansion");
        return c.b.a.b.m.a.a(f2, f3, hVar.b().getInterpolation(((float) (((d2.f3123a + d2.f3124b) + 17) - j)) / ((float) j2)));
    }

    public final void I(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f;
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
                if ((view instanceof e) || (view instanceof c.b.a.b.n0.d)) {
                    view = ((ViewGroup) view).getChildAt(0);
                }
                viewGroup = N(view);
            }
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        c.b.a.b.m.c.f3114a.set(viewGroup, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, c.b.a.b.m.c.f3114a, 1.0f);
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, c.b.a.b.m.c.f3114a, 0.0f);
                }
                bVar.f4588a.d("contentFade").a(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void K(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof c) {
            c cVar = (c) view2;
            ColorStateList h2 = m.h(view);
            int colorForState = h2 != null ? h2.getColorForState(view.getDrawableState(), h2.getDefaultColor()) : 0;
            int i = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(colorForState);
                }
                objectAnimator = ObjectAnimator.ofInt(cVar, c.d.f3214a, i);
            } else {
                objectAnimator = ObjectAnimator.ofInt(cVar, c.d.f3214a, colorForState);
            }
            objectAnimator.setEvaluator(c.b.a.b.m.b.f3113a);
            bVar.f4588a.d("color").a(objectAnimator);
            list.add(objectAnimator);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    @TargetApi(21)
    public final void L(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator objectAnimator;
        float k = m.k(view2) - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-k);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -k);
        }
        bVar.f4588a.d("elevation").a(objectAnimator);
        list.add(objectAnimator);
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;Landroid/graphics/RectF;)V */
    public final void M(View view, View view2, boolean z, boolean z2, b bVar, List list, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float F = F(view, view2, bVar.f4589b);
        float G = G(view, view2, bVar.f4589b);
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
            Rect rect = this.f4582c;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.f4583d;
            rectF2.set(rect);
            RectF rectF3 = this.f4584e;
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
