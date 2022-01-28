package c.b.a.b.l0;

import android.animation.ValueAnimator;

public class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f4365a;

    public d(a aVar) {
        this.f4365a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4365a.f4386c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
