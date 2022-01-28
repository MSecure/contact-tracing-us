package c.b.a.b.o0;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

public class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f4483a;

    public a(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f4483a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4483a.invalidate();
    }
}
