package f.b.a.e.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
/* loaded from: classes.dex */
public class a extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public a(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BottomAppBar.w(this.a);
        this.a.R = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.W++;
    }
}
