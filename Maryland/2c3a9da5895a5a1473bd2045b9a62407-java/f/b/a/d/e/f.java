package f.b.a.d.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.Objects;

public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public f(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.a);
        throw null;
    }
}
