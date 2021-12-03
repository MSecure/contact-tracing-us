package f.b.a.e.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import f.b.a.e.p.d;

public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ d.g b;
    public final /* synthetic */ d c;

    public c(d dVar, boolean z, d.g gVar) {
        this.c = dVar;
        this.a = z;
        this.b = gVar;
    }

    public void onAnimationEnd(Animator animator) {
        d dVar = this.c;
        dVar.m = 0;
        dVar.f2931h = null;
        d.g gVar = this.b;
        if (gVar != null) {
            a aVar = (a) gVar;
            aVar.a.b(aVar.b);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.c.q.b(0, this.a);
        d dVar = this.c;
        dVar.m = 2;
        dVar.f2931h = animator;
    }
}
