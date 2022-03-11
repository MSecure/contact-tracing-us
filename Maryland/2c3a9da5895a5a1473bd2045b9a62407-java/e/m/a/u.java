package e.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.i.e.a;
import e.m.a.f0;
import e.m.a.l;
import e.m.a.v0;

public class u extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ v0.a f1694d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1695e;

    public u(ViewGroup viewGroup, View view, l lVar, v0.a aVar, a aVar2) {
        this.a = viewGroup;
        this.b = view;
        this.c = lVar;
        this.f1694d = aVar;
        this.f1695e = aVar2;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        l lVar = this.c;
        l.c cVar = lVar.I;
        Animator animator2 = cVar == null ? null : cVar.b;
        lVar.r0(null);
        if (animator2 != null && this.a.indexOfChild(this.b) < 0) {
            ((f0.d) this.f1694d).a(this.c, this.f1695e);
        }
    }
}
