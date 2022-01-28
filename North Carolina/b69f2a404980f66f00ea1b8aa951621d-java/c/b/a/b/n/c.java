package c.b.a.b.n;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f3135a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f3136b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f3137c;

    public c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f3137c = baseBehavior;
        this.f3135a = coordinatorLayout;
        this.f3136b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3137c.F(this.f3135a, this.f3136b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
