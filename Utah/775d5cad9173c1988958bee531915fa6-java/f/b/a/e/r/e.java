package f.b.a.e.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class e extends AnimatorListenerAdapter {
    public final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        g gVar = this.a;
        gVar.f2992h = (gVar.f2992h + 4) % gVar.f2991g.c.length;
    }
}
