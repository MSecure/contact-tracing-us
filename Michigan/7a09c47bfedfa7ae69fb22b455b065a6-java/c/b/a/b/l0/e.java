package c.b.a.b.l0;

import android.animation.ValueAnimator;

public class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f4366a;

    public e(a aVar) {
        this.f4366a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f4366a.f4386c.setScaleX(floatValue);
        this.f4366a.f4386c.setScaleY(floatValue);
    }
}
