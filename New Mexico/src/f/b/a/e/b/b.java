package f.b.a.e.b;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes.dex */
public class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CoordinatorLayout a;
    public final /* synthetic */ AppBarLayout b;
    public final /* synthetic */ AppBarLayout.BaseBehavior c;

    public b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.c = baseBehavior;
        this.a = coordinatorLayout;
        this.b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.G(this.a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
