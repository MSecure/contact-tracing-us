package c.b.a.b.n;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CollapsingToolbarLayout f3146a;

    public g(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f3146a = collapsingToolbarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3146a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
