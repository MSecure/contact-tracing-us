package c.b.a.b.l0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class l extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f3086a;

    public l(h hVar) {
        this.f3086a = hVar;
    }

    public void onAnimationEnd(Animator animator) {
        h hVar = this.f3086a;
        hVar.f3089c.setChecked(hVar.j);
        this.f3086a.p.start();
    }
}
