package c.b.a.b.i0;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public int f3034a = this.f3035b;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3035b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3036c;

    public f(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f3036c = baseTransientBottomBar;
        this.f3035b = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f3036c.f4516c.setTranslationY((float) intValue);
        this.f3034a = intValue;
    }
}
