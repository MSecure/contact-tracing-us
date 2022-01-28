package c.b.a.b.n;

import android.animation.ValueAnimator;
import c.b.a.b.h0.g;
import com.google.android.material.appbar.AppBarLayout;

public class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f3134a;

    public b(AppBarLayout appBarLayout, g gVar) {
        this.f3134a = gVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3134a.q(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
