package f.b.a.d.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class n extends AnimatorListenerAdapter {
    public final /* synthetic */ o a;

    public n(o oVar) {
        this.a = oVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        o oVar = this.a;
        if (oVar.f2720k) {
            oVar.f2720k = false;
            oVar.f2721l.a(oVar.a);
        } else if (oVar.a.isVisible()) {
            this.a.i();
            this.a.g();
            return;
        }
        this.a.f();
    }
}
