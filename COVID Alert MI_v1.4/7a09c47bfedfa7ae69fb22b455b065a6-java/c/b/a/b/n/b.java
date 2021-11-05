package c.b.a.b.n;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f4436a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f4437b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f4438c;

    public b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f4438c = baseBehavior;
        this.f4436a = coordinatorLayout;
        this.f4437b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4438c.G(this.f4436a, this.f4437b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
