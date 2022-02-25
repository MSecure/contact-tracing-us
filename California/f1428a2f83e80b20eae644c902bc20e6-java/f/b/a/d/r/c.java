package f.b.a.d.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        e eVar = this.a;
        if (eVar.m) {
            eVar.f2696e.setFloatValues(0.0f, 1.08f);
        }
    }
}
