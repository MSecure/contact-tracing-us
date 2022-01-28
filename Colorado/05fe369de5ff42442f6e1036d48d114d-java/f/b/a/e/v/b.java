package f.b.a.e.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class b extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar a;

    public b(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.e();
    }
}
