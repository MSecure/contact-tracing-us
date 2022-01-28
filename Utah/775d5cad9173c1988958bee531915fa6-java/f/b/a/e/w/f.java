package f.b.a.e.w;

import android.animation.ValueAnimator;
import android.os.Handler;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class f implements ValueAnimator.AnimatorUpdateListener {
    public int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BaseTransientBottomBar c;

    public f(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.c = baseTransientBottomBar;
        this.b = i2;
        this.a = i2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Handler handler = BaseTransientBottomBar.n;
        this.c.c.setTranslationY((float) intValue);
        this.a = intValue;
    }
}
