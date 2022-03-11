package f.b.a.e.y;

import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ h a;

    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
