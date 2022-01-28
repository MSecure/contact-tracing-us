package c.b.a.b.o0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import c.b.a.b.w.c;
import com.google.android.material.transformation.FabTransformationBehavior;

public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f4484a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f4485b;

    public b(FabTransformationBehavior fabTransformationBehavior, c cVar, Drawable drawable) {
        this.f4484a = cVar;
        this.f4485b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.f4484a.setCircularRevealOverlayDrawable(null);
    }

    public void onAnimationStart(Animator animator) {
        this.f4484a.setCircularRevealOverlayDrawable(this.f4485b);
    }
}
