package c.b.a.b.i0;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f4325a;

    public d(BaseTransientBottomBar baseTransientBottomBar) {
        this.f4325a = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f4325a.f6103c.setScaleX(floatValue);
        this.f4325a.f6103c.setScaleY(floatValue);
    }
}
