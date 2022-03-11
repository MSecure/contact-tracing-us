package f.b.a.e.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.a0.a.a.b;
/* loaded from: classes.dex */
public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.a();
        g gVar = this.a;
        b bVar = gVar.f3037k;
        if (bVar != null) {
            bVar.a(gVar.a);
        }
    }
}
