package f.b.a.e.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.a();
        g gVar = this.a;
        gVar.f2931k.a(gVar.a);
    }
}
