package c.b.a.b.i0;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public int f4327a = this.f4328b;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4328b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f4329c;

    public f(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f4329c = baseTransientBottomBar;
        this.f4328b = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f4329c.f6103c.setTranslationY((float) intValue);
        this.f4327a = intValue;
    }
}
