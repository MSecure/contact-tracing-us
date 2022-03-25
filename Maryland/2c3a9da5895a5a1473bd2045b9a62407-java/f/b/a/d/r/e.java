package f.b.a.d.r;

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
        gVar.f2823h = (gVar.f2823h + 4) % gVar.f2822g.c.length;
    }
}
