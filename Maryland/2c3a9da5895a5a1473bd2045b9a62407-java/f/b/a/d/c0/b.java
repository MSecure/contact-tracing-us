package f.b.a.d.c0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;
import f.b.a.d.k.c;

public class b extends AnimatorListenerAdapter {
    public final /* synthetic */ c a;
    public final /* synthetic */ Drawable b;

    public b(FabTransformationBehavior fabTransformationBehavior, c cVar, Drawable drawable) {
        this.a = cVar;
        this.b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setCircularRevealOverlayDrawable(null);
    }

    public void onAnimationStart(Animator animator) {
        this.a.setCircularRevealOverlayDrawable(this.b);
    }
}
