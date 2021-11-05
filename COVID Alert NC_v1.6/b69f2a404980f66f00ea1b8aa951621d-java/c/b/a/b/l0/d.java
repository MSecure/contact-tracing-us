package c.b.a.b.l0;

import android.animation.ValueAnimator;

public class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f3070a;

    public d(a aVar) {
        this.f3070a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3070a.f3089c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
