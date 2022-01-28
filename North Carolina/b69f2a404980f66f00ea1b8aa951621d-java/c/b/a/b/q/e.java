package c.b.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3186a;

    public e(BottomAppBar bottomAppBar) {
        this.f3186a = bottomAppBar;
    }

    public void onAnimationStart(Animator animator) {
        this.f3186a.b0.onAnimationStart(animator);
        FloatingActionButton B = this.f3186a.B();
        if (B != null) {
            B.setTranslationX(this.f3186a.getFabTranslationX());
        }
    }
}
