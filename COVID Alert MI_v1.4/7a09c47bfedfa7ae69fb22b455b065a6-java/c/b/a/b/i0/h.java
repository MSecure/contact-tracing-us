package c.b.a.b.i0;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public int f4332a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f4333b;

    public h(BaseTransientBottomBar baseTransientBottomBar) {
        this.f4333b = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f4333b.f6103c.setTranslationY((float) intValue);
        this.f4332a = intValue;
    }
}
