package f.b.a.d.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;

public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar a;

    public f(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.e();
    }

    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.a.f551d;
        snackbarContentLayout.b.setAlpha(0.0f);
        long j2 = (long) 180;
        long j3 = (long) 70;
        snackbarContentLayout.b.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        if (snackbarContentLayout.c.getVisibility() == 0) {
            snackbarContentLayout.c.setAlpha(0.0f);
            snackbarContentLayout.c.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }
}
