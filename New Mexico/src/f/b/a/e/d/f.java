package f.b.a.e.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.Objects;
/* loaded from: classes.dex */
public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public f(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.a);
        throw null;
    }
}
