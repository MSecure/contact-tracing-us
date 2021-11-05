package b.q.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class l extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.d0 f1523a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f1525c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1526d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1527e;
    public final /* synthetic */ o f;

    public l(o oVar, RecyclerView.d0 d0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = oVar;
        this.f1523a = d0Var;
        this.f1524b = i;
        this.f1525c = view;
        this.f1526d = i2;
        this.f1527e = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.f1524b != 0) {
            this.f1525c.setTranslationX(0.0f);
        }
        if (this.f1526d != 0) {
            this.f1525c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.f1527e.setListener(null);
        this.f.d(this.f1523a);
        this.f.p.remove(this.f1523a);
        this.f.l();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f == null) {
            throw null;
        }
    }
}
