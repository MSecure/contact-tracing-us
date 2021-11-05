package c.b.a.b.i0;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3031a;

    public c(BaseTransientBottomBar baseTransientBottomBar) {
        this.f3031a = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3031a.f4516c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
