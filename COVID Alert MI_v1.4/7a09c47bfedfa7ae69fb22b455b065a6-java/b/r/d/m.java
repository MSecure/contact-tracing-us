package b.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.o;

public class m extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o.a f2375a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2376b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2377c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f2378d;

    public m(o oVar, o.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2378d = oVar;
        this.f2375a = aVar;
        this.f2376b = viewPropertyAnimator;
        this.f2377c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2376b.setListener(null);
        this.f2377c.setAlpha(1.0f);
        this.f2377c.setTranslationX(0.0f);
        this.f2377c.setTranslationY(0.0f);
        this.f2378d.d(this.f2375a.f2383a);
        this.f2378d.r.remove(this.f2375a.f2383a);
        this.f2378d.l();
    }

    public void onAnimationStart(Animator animator) {
        o oVar = this.f2378d;
        RecyclerView.a0 a0Var = this.f2375a.f2383a;
        if (oVar == null) {
            throw null;
        }
    }
}
