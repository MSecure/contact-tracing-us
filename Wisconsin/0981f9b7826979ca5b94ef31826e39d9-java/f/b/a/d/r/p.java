package f.b.a.d.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class p extends AnimatorListenerAdapter {
    public final /* synthetic */ r a;

    public p(r rVar) {
        this.a = rVar;
    }

    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        r rVar = this.a;
        float f2 = rVar.f2735g;
        if (f2 > 0.0f && f2 < 1.0f) {
            rVar.f2733e = (rVar.f2733e + 1) % rVar.a.f2719k.length;
            rVar.i();
        }
    }
}
