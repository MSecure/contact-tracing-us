package b.q.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.q.d.o;

public class n extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o.a f1532a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1533b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f1534c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1535d;

    public n(o oVar, o.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1535d = oVar;
        this.f1532a = aVar;
        this.f1533b = viewPropertyAnimator;
        this.f1534c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1533b.setListener(null);
        this.f1534c.setAlpha(1.0f);
        this.f1534c.setTranslationX(0.0f);
        this.f1534c.setTranslationY(0.0f);
        this.f1535d.d(this.f1532a.f1537b);
        this.f1535d.r.remove(this.f1532a.f1537b);
        this.f1535d.l();
    }

    public void onAnimationStart(Animator animator) {
        o oVar = this.f1535d;
        RecyclerView.d0 d0Var = this.f1532a.f1537b;
        if (oVar == null) {
            throw null;
        }
    }
}
