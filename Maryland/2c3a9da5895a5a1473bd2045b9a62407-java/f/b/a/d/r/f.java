package f.b.a.d.r;

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
        gVar.f2826k.a(gVar.a);
    }
}
