package f.b.a.e.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import f.b.a.e.p.d;
/* loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ d.g b;
    public final /* synthetic */ d c;

    public c(d dVar, boolean z, d.g gVar) {
        this.c = dVar;
        this.a = z;
        this.b = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d dVar = this.c;
        dVar.n = 0;
        dVar.f2973h = null;
        d.g gVar = this.b;
        if (gVar != null) {
            a aVar = (a) gVar;
            aVar.a.b(aVar.b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.c.r.b(0, this.a);
        d dVar = this.c;
        dVar.n = 2;
        dVar.f2973h = animator;
    }
}
