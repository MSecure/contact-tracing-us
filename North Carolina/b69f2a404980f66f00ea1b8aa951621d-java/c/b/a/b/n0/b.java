package c.b.a.b.n0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import c.b.a.b.w.c;
import com.google.android.material.transformation.FabTransformationBehavior;

public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f3164a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f3165b;

    public b(FabTransformationBehavior fabTransformationBehavior, c cVar, Drawable drawable) {
        this.f3164a = cVar;
        this.f3165b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.f3164a.setCircularRevealOverlayDrawable(null);
    }

    public void onAnimationStart(Animator animator) {
        this.f3164a.setCircularRevealOverlayDrawable(this.f3165b);
    }
}
