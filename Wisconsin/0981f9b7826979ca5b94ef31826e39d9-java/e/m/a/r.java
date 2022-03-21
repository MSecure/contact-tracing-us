package e.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.i.e.a;
import e.m.a.c0;
import e.m.a.l;
import e.m.a.s0;

public class r extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ s0.a f1667d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1668e;

    public r(ViewGroup viewGroup, View view, l lVar, s0.a aVar, a aVar2) {
        this.a = viewGroup;
        this.b = view;
        this.c = lVar;
        this.f1667d = aVar;
        this.f1668e = aVar2;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        l lVar = this.c;
        l.b bVar = lVar.I;
        Animator animator2 = bVar == null ? null : bVar.b;
        lVar.r0(null);
        if (animator2 != null && this.a.indexOfChild(this.b) < 0) {
            ((c0.d) this.f1667d).a(this.c, this.f1668e);
        }
    }
}
