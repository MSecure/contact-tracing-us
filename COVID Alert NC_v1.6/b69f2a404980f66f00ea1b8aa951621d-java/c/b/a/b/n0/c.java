package c.b.a.b.n0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.b.a.b.w.c;
import com.google.android.material.transformation.FabTransformationBehavior;

public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c.b.a.b.w.c f3166a;

    public c(FabTransformationBehavior fabTransformationBehavior, c.b.a.b.w.c cVar) {
        this.f3166a = cVar;
    }

    public void onAnimationEnd(Animator animator) {
        c.e revealInfo = this.f3166a.getRevealInfo();
        revealInfo.f3217c = Float.MAX_VALUE;
        this.f3166a.setRevealInfo(revealInfo);
    }
}
