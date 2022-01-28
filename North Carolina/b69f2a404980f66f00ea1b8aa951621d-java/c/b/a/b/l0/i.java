package c.b.a.b.l0;

import android.animation.ValueAnimator;

public class i implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f3082a;

    public i(h hVar) {
        this.f3082a = hVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3082a.f3089c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
