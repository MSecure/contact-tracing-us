package f.b.a.d.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class l extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public l(h hVar) {
        this.a = hVar;
    }

    public void onAnimationEnd(Animator animator) {
        h hVar = this.a;
        hVar.c.setChecked(hVar.f2940j);
        this.a.p.start();
    }
}
