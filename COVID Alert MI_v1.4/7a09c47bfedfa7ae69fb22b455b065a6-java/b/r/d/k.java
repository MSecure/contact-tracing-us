package b.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class k extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.a0 f2365a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2367c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f2368d;

    public k(o oVar, RecyclerView.a0 a0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2368d = oVar;
        this.f2365a = a0Var;
        this.f2366b = view;
        this.f2367c = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2366b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.f2367c.setListener(null);
        this.f2368d.d(this.f2365a);
        this.f2368d.o.remove(this.f2365a);
        this.f2368d.l();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f2368d == null) {
            throw null;
        }
    }
}
