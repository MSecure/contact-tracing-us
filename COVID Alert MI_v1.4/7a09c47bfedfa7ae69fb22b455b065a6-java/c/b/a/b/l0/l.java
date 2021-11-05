package c.b.a.b.l0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class l extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f4383a;

    public l(h hVar) {
        this.f4383a = hVar;
    }

    public void onAnimationEnd(Animator animator) {
        h hVar = this.f4383a;
        hVar.f4386c.setChecked(hVar.j);
        this.f4383a.p.start();
    }
}
