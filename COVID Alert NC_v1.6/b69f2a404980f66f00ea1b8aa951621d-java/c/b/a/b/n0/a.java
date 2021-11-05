package c.b.a.b.n0;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

public class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f3163a;

    public a(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f3163a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3163a.invalidate();
    }
}
