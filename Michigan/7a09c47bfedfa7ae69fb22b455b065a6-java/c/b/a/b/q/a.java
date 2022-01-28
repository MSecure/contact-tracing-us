package c.b.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

public class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4488a;

    public a(BottomAppBar bottomAppBar) {
        this.f4488a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.w(this.f4488a);
        this.f4488a.Q = null;
    }

    public void onAnimationStart(Animator animator) {
        this.f4488a.V++;
    }
}
