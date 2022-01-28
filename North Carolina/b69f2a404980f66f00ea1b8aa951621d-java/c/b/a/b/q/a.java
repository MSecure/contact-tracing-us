package c.b.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

public class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3176a;

    public a(BottomAppBar bottomAppBar) {
        this.f3176a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.v(this.f3176a);
    }

    public void onAnimationStart(Animator animator) {
        this.f3176a.V++;
    }
}
