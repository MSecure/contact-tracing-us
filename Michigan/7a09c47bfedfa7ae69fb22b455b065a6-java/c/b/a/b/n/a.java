package c.b.a.b.n;

import android.animation.ValueAnimator;
import c.b.a.b.h0.g;
import com.google.android.material.appbar.AppBarLayout;

public class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f4435a;

    public a(AppBarLayout appBarLayout, g gVar) {
        this.f4435a = gVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4435a.q(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
