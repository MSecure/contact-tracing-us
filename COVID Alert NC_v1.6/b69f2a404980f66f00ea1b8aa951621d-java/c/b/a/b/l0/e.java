package c.b.a.b.l0;

import android.animation.ValueAnimator;

public class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f3071a;

    public e(a aVar) {
        this.f3071a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f3071a.f3089c.setScaleX(floatValue);
        this.f3071a.f3089c.setScaleY(floatValue);
    }
}
