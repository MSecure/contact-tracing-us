package f.b.a.e.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ BaseTransientBottomBar b;

    public c(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.b = baseTransientBottomBar;
        this.a = i2;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.d(this.a);
    }
}
