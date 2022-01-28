package f.b.a.e.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.Objects;

public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public c(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.w(this.a);
        Objects.requireNonNull(this.a);
        this.a.S = null;
    }

    public void onAnimationStart(Animator animator) {
        this.a.W++;
    }
}
