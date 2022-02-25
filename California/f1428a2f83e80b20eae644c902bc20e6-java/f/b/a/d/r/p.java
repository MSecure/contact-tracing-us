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
        float f2 = rVar.f2727g;
        if (f2 > 0.0f && f2 < 1.0f) {
            rVar.f2725e = (rVar.f2725e + 1) % rVar.a.f2711k.length;
            rVar.i();
        }
    }
}
