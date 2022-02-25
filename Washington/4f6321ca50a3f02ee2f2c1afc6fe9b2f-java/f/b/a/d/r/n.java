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
        if (oVar.f2728k) {
            oVar.f2728k = false;
            oVar.f2729l.a(oVar.a);
        } else if (oVar.a.isVisible()) {
            this.a.i();
            this.a.g();
            return;
        }
        this.a.f();
    }
}
