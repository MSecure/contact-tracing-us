package c.b.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4492a;

    public c(BottomAppBar bottomAppBar) {
        this.f4492a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.w(this.f4492a);
        BottomAppBar bottomAppBar = this.f4492a;
        bottomAppBar.a0 = false;
        bottomAppBar.R = null;
    }

    public void onAnimationStart(Animator animator) {
        this.f4492a.V++;
    }
}
