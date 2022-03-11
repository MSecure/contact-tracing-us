package f.b.a.e.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes.dex */
public class l extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public l(h hVar) {
        this.a = hVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        h hVar = this.a;
        hVar.c.setChecked(hVar.f3139k);
        this.a.q.start();
    }
}
