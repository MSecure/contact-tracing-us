package b.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import b.i.l.m;

public class c extends e0 {

    public class a extends l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2655a;

        public a(c cVar, View view) {
            this.f2655a = view;
        }

        @Override // b.x.i.d
        public void e(i iVar) {
            w.f2726a.e(this.f2655a, 1.0f);
            w.f2726a.a(this.f2655a);
            iVar.y(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final View f2656a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2657b = false;

        public b(View view) {
            this.f2656a = view;
        }

        public void onAnimationEnd(Animator animator) {
            w.f2726a.e(this.f2656a, 1.0f);
            if (this.f2657b) {
                this.f2656a.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (m.z(this.f2656a) && this.f2656a.getLayerType() == 0) {
                this.f2657b = true;
                this.f2656a.setLayerType(2, null);
            }
        }
    }

    public c(int i) {
        if ((i & -4) == 0) {
            this.J = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // b.x.e0
    public Animator M(ViewGroup viewGroup, View view, q qVar, q qVar2) {
        w.f2726a.c(view);
        Float f2 = (Float) qVar.f2712a.get("android:fade:transitionAlpha");
        return N(view, f2 != null ? f2.floatValue() : 1.0f, 0.0f);
    }

    public final Animator N(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        w.f2726a.e(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, w.f2727b, f3);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    @Override // b.x.i
    public void h(q qVar) {
        K(qVar);
        qVar.f2712a.put("android:fade:transitionAlpha", Float.valueOf(w.b(qVar.f2713b)));
    }
}
