package f.b.a.e.b;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.AppBarLayout;
import f.b.a.e.u.g;

public class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ g a;

    public a(AppBarLayout appBarLayout, g gVar) {
        this.a = gVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.p(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
