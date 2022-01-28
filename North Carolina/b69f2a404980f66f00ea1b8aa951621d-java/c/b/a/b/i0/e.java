package c.b.a.b.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;

public class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3033a;

    public e(BaseTransientBottomBar baseTransientBottomBar) {
        this.f3033a = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f3033a.d();
    }

    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.f3033a.f4517d;
        snackbarContentLayout.f4528b.setAlpha(0.0f);
        long j = (long) 180;
        long j2 = (long) 70;
        snackbarContentLayout.f4528b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (snackbarContentLayout.f4529c.getVisibility() == 0) {
            snackbarContentLayout.f4529c.setAlpha(0.0f);
            snackbarContentLayout.f4529c.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
