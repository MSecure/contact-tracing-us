package c.b.a.b.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;

public class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4330a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f4331b;

    public g(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f4331b = baseTransientBottomBar;
        this.f4330a = i;
    }

    public void onAnimationEnd(Animator animator) {
        this.f4331b.c(this.f4330a);
    }

    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.f4331b.f6104d;
        snackbarContentLayout.f6119b.setAlpha(1.0f);
        long j = (long) 180;
        long j2 = (long) 0;
        snackbarContentLayout.f6119b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (snackbarContentLayout.f6120c.getVisibility() == 0) {
            snackbarContentLayout.f6120c.setAlpha(1.0f);
            snackbarContentLayout.f6120c.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
