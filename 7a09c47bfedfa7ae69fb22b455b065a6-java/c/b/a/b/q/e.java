package c.b.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4498a;

    public e(BottomAppBar bottomAppBar) {
        this.f4498a = bottomAppBar;
    }

    public void onAnimationStart(Animator animator) {
        this.f4498a.d0.onAnimationStart(animator);
        FloatingActionButton C = this.f4498a.C();
        if (C != null) {
            C.setTranslationX(this.f4498a.getFabTranslationX());
        }
    }
}
