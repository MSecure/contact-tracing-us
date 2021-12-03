package e.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.i.e.a;
import e.m.a.e0;
import e.m.a.m;
import e.m.a.t0;

public class u extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ m c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ t0.a f1514d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1515e;

    public u(ViewGroup viewGroup, View view, m mVar, t0.a aVar, a aVar2) {
        this.a = viewGroup;
        this.b = view;
        this.c = mVar;
        this.f1514d = aVar;
        this.f1515e = aVar2;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        m mVar = this.c;
        m.d dVar = mVar.I;
        Animator animator2 = dVar == null ? null : dVar.b;
        mVar.s0(null);
        if (animator2 != null && this.a.indexOfChild(this.b) < 0) {
            ((e0.d) this.f1514d).a(this.c, this.f1515e);
        }
    }
}
