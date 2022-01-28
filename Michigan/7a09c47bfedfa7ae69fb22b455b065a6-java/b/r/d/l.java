package b.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class l extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.a0 f2369a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2370b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2371c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2372d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2373e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ o f2374f;

    public l(o oVar, RecyclerView.a0 a0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2374f = oVar;
        this.f2369a = a0Var;
        this.f2370b = i;
        this.f2371c = view;
        this.f2372d = i2;
        this.f2373e = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.f2370b != 0) {
            this.f2371c.setTranslationX(0.0f);
        }
        if (this.f2372d != 0) {
            this.f2371c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.f2373e.setListener(null);
        this.f2374f.d(this.f2369a);
        this.f2374f.p.remove(this.f2369a);
        this.f2374f.l();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f2374f == null) {
            throw null;
        }
    }
}
