package f.b.a.d.c0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.transformation.FabTransformationBehavior;
import f.b.a.d.k.c;

public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ f.b.a.d.k.c a;

    public c(FabTransformationBehavior fabTransformationBehavior, f.b.a.d.k.c cVar) {
        this.a = cVar;
    }

    public void onAnimationEnd(Animator animator) {
        c.e revealInfo = this.a.getRevealInfo();
        revealInfo.c = Float.MAX_VALUE;
        this.a.setRevealInfo(revealInfo);
    }
}
