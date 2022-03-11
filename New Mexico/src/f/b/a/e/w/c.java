package f.b.a.e.w;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* loaded from: classes.dex */
public class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public c(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
