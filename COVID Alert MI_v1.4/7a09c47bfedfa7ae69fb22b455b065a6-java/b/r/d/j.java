package b.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.a0 f2361a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2362b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2363c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f2364d;

    public j(o oVar, RecyclerView.a0 a0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2364d = oVar;
        this.f2361a = a0Var;
        this.f2362b = viewPropertyAnimator;
        this.f2363c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2362b.setListener(null);
        this.f2363c.setAlpha(1.0f);
        this.f2364d.d(this.f2361a);
        this.f2364d.q.remove(this.f2361a);
        this.f2364d.l();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f2364d == null) {
            throw null;
        }
    }
}
