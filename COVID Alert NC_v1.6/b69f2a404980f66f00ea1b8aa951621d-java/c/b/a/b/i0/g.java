package c.b.a.b.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;

public class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3037a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3038b;

    public g(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f3038b = baseTransientBottomBar;
        this.f3037a = i;
    }

    public void onAnimationEnd(Animator animator) {
        this.f3038b.c(this.f3037a);
    }

    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.f3038b.f4517d;
        snackbarContentLayout.f4528b.setAlpha(1.0f);
        long j = (long) 180;
        long j2 = (long) 0;
        snackbarContentLayout.f4528b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (snackbarContentLayout.f4529c.getVisibility() == 0) {
            snackbarContentLayout.f4529c.setAlpha(1.0f);
            snackbarContentLayout.f4529c.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
