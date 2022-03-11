package f.b.a.d.w;

import android.animation.ValueAnimator;
import android.os.Handler;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class i implements ValueAnimator.AnimatorUpdateListener {
    public int a = 0;
    public final /* synthetic */ BaseTransientBottomBar b;

    public i(BaseTransientBottomBar baseTransientBottomBar) {
        this.b = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Handler handler = BaseTransientBottomBar.o;
        this.b.c.setTranslationY((float) intValue);
        this.a = intValue;
    }
}
