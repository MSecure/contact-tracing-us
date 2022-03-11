package e.o.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.j.f.a;
import e.o.a.e0;
import e.o.a.m;
import e.o.a.t0;
/* loaded from: classes.dex */
public class u extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ m c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ t0.a f1872d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1873e;

    public u(ViewGroup viewGroup, View view, m mVar, t0.a aVar, a aVar2) {
        this.a = viewGroup;
        this.b = view;
        this.c = mVar;
        this.f1872d = aVar;
        this.f1873e = aVar2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        m mVar = this.c;
        m.d dVar = mVar.I;
        Animator animator2 = dVar == null ? null : dVar.b;
        mVar.z0(null);
        if (animator2 != null && this.a.indexOfChild(this.b) < 0) {
            ((e0.d) this.f1872d).a(this.c, this.f1873e);
        }
    }
}
