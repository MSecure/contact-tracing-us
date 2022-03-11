package f.b.a.e.y;

import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public e(a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.c.setScaleX(floatValue);
        this.a.c.setScaleY(floatValue);
    }
}
