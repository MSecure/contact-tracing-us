package b.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.o;

public class n extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o.a f2379a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2380b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2381c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f2382d;

    public n(o oVar, o.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2382d = oVar;
        this.f2379a = aVar;
        this.f2380b = viewPropertyAnimator;
        this.f2381c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2380b.setListener(null);
        this.f2381c.setAlpha(1.0f);
        this.f2381c.setTranslationX(0.0f);
        this.f2381c.setTranslationY(0.0f);
        this.f2382d.d(this.f2379a.f2384b);
        this.f2382d.r.remove(this.f2379a.f2384b);
        this.f2382d.l();
    }

    public void onAnimationStart(Animator animator) {
        o oVar = this.f2382d;
        RecyclerView.a0 a0Var = this.f2379a.f2384b;
        if (oVar == null) {
            throw null;
        }
    }
}
