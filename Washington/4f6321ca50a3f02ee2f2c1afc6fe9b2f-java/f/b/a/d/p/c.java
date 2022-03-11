package f.b.a.d.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import f.b.a.d.p.d;

public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ d.f b;
    public final /* synthetic */ d c;

    public c(d dVar, boolean z, d.f fVar) {
        this.c = dVar;
        this.a = z;
        this.b = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        d dVar = this.c;
        dVar.o = 0;
        dVar.f2670j = null;
        d.f fVar = this.b;
        if (fVar != null) {
            a aVar = (a) fVar;
            aVar.a.b(aVar.b);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.c.s.b(0, this.a);
        d dVar = this.c;
        dVar.o = 2;
        dVar.f2670j = animator;
    }
}
