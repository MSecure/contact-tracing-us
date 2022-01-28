package e.n.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.i.e.a;
import e.n.a.e0;
import e.n.a.m;
import e.n.a.t0;

public class u extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ m c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ t0.a f1787d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1788e;

    public u(ViewGroup viewGroup, View view, m mVar, t0.a aVar, a aVar2) {
        this.a = viewGroup;
        this.b = view;
        this.c = mVar;
        this.f1787d = aVar;
        this.f1788e = aVar2;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        m mVar = this.c;
        m.d dVar = mVar.I;
        Animator animator2 = dVar == null ? null : dVar.b;
        mVar.x0(null);
        if (animator2 != null && this.a.indexOfChild(this.b) < 0) {
            ((e0.d) this.f1787d).a(this.c, this.f1788e);
        }
    }
}
