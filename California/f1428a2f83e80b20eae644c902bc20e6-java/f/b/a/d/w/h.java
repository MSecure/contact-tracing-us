package f.b.a.d.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;

public class h extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ BaseTransientBottomBar b;

    public h(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.b = baseTransientBottomBar;
        this.a = i2;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.d(this.a);
    }

    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.b.f552d;
        snackbarContentLayout.b.setAlpha(1.0f);
        long j2 = (long) 180;
        long j3 = (long) 0;
        snackbarContentLayout.b.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        if (snackbarContentLayout.c.getVisibility() == 0) {
            snackbarContentLayout.c.setAlpha(1.0f);
            snackbarContentLayout.c.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }
}
