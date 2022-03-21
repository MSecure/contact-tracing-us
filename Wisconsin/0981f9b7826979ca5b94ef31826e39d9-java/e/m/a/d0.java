package e.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class d0 extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ l c;

    public d0(c0 c0Var, ViewGroup viewGroup, View view, l lVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = lVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        animator.removeListener(this);
        l lVar = this.c;
        View view = lVar.F;
        if (view != null && lVar.z) {
            view.setVisibility(8);
        }
    }
}
