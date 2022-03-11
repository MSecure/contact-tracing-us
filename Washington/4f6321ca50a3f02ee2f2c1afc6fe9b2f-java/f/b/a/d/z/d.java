package f.b.a.d.z;

import android.animation.ValueAnimator;

public class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
