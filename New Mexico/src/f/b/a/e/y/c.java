package f.b.a.e.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.a.setEndIconVisible(false);
    }
}
