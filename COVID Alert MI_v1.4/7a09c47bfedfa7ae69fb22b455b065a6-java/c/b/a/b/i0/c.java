package c.b.a.b.i0;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f4324a;

    public c(BaseTransientBottomBar baseTransientBottomBar) {
        this.f4324a = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4324a.f6103c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
