package e.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.f.a;
/* loaded from: classes.dex */
public class i extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;
    public final /* synthetic */ h b;

    public i(h hVar, a aVar) {
        this.b = hVar;
        this.a = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.remove(animator);
        this.b.n.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.b.n.add(animator);
    }
}
