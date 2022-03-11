package f.b.a.d.z;

import android.animation.ValueAnimator;

public class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public e(a aVar) {
        this.a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.c.setScaleX(floatValue);
        this.a.c.setScaleY(floatValue);
    }
}
