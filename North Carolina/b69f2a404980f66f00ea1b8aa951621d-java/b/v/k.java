package b.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class k extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f1812a;

    public k(i iVar) {
        this.f1812a = iVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1812a.n();
        animator.removeListener(this);
    }
}
