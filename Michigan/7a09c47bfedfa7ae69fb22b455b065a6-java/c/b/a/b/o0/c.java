package c.b.a.b.o0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.b.a.b.w.c;
import com.google.android.material.transformation.FabTransformationBehavior;

public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c.b.a.b.w.c f4486a;

    public c(FabTransformationBehavior fabTransformationBehavior, c.b.a.b.w.c cVar) {
        this.f4486a = cVar;
    }

    public void onAnimationEnd(Animator animator) {
        c.e revealInfo = this.f4486a.getRevealInfo();
        revealInfo.f4538c = Float.MAX_VALUE;
        this.f4486a.setRevealInfo(revealInfo);
    }
}
