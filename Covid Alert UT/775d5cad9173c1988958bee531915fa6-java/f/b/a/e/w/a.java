package f.b.a.e.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class a extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar a;

    public a(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.e();
    }
}
