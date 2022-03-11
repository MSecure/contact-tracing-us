package f.b.a.e.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;
/* loaded from: classes.dex */
public class g extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ BaseTransientBottomBar b;

    public g(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.b = baseTransientBottomBar;
        this.a = i2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.b.d(this.a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.b.f593d;
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
