package b.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class k extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f2701a;

    public k(i iVar) {
        this.f2701a = iVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2701a.n();
        animator.removeListener(this);
    }
}
