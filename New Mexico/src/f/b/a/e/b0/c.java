package f.b.a.e.b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.transformation.FabTransformationBehavior;
import f.b.a.e.j.c;
/* loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ f.b.a.e.j.c a;

    public c(FabTransformationBehavior fabTransformationBehavior, f.b.a.e.j.c cVar) {
        this.a = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        c.e revealInfo = this.a.getRevealInfo();
        revealInfo.c = Float.MAX_VALUE;
        this.a.setRevealInfo(revealInfo);
    }
}
