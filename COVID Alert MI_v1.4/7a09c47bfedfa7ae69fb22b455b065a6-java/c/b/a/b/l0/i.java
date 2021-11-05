package c.b.a.b.l0;

import android.animation.ValueAnimator;

public class i implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f4379a;

    public i(h hVar) {
        this.f4379a = hVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4379a.f4386c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
