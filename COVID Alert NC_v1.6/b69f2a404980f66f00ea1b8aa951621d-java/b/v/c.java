package b.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import b.i.l.m;

public class c extends d0 {

    public class a extends l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f1776a;

        public a(c cVar, View view) {
            this.f1776a = view;
        }

        @Override // b.v.i.d
        public void e(i iVar) {
            v.f1832a.e(this.f1776a, 1.0f);
            v.f1832a.a(this.f1776a);
            iVar.w(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final View f1777a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1778b = false;

        public b(View view) {
            this.f1777a = view;
        }

        public void onAnimationEnd(Animator animator) {
            v.f1832a.e(this.f1777a, 1.0f);
            if (this.f1778b) {
                this.f1777a.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (m.y(this.f1777a) && this.f1777a.getLayerType() == 0) {
                this.f1778b = true;
                this.f1777a.setLayerType(2, null);
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

    @Override // b.v.d0
    public Animator K(ViewGroup viewGroup, View view, q qVar, q qVar2) {
        v.f1832a.c(view);
        Float f = (Float) qVar.f1823a.get("android:fade:transitionAlpha");
        return L(view, f != null ? f.floatValue() : 1.0f, 0.0f);
    }

    public final Animator L(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        v.f1832a.e(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, v.f1833b, f2);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    @Override // b.v.i
    public void h(q qVar) {
        I(qVar);
        qVar.f1823a.put("android:fade:transitionAlpha", Float.valueOf(v.b(qVar.f1824b)));
    }
}
