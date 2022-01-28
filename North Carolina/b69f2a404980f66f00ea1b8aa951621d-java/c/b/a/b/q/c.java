package c.b.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3180a;

    public c(BottomAppBar bottomAppBar) {
        this.f3180a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.v(this.f3180a);
        this.f3180a.R = null;
    }

    public void onAnimationStart(Animator animator) {
        this.f3180a.V++;
    }
}
