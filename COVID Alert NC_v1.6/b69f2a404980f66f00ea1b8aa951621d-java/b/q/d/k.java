package b.q.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class k extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.d0 f1519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1520b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1521c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1522d;

    public k(o oVar, RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1522d = oVar;
        this.f1519a = d0Var;
        this.f1520b = view;
        this.f1521c = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1520b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1521c.setListener(null);
        this.f1522d.d(this.f1519a);
        this.f1522d.o.remove(this.f1519a);
        this.f1522d.l();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f1522d == null) {
            throw null;
        }
    }
}
