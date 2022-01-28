package b.q.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.d0 f1515a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1516b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f1517c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1518d;

    public j(o oVar, RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1518d = oVar;
        this.f1515a = d0Var;
        this.f1516b = viewPropertyAnimator;
        this.f1517c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1516b.setListener(null);
        this.f1517c.setAlpha(1.0f);
        this.f1518d.d(this.f1515a);
        this.f1518d.q.remove(this.f1515a);
        this.f1518d.l();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f1518d == null) {
            throw null;
        }
    }
}
