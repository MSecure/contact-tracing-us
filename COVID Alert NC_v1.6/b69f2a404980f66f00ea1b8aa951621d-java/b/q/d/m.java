package b.q.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.q.d.o;

public class m extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o.a f1528a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1529b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f1530c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1531d;

    public m(o oVar, o.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1531d = oVar;
        this.f1528a = aVar;
        this.f1529b = viewPropertyAnimator;
        this.f1530c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1529b.setListener(null);
        this.f1530c.setAlpha(1.0f);
        this.f1530c.setTranslationX(0.0f);
        this.f1530c.setTranslationY(0.0f);
        this.f1531d.d(this.f1528a.f1536a);
        this.f1531d.r.remove(this.f1528a.f1536a);
        this.f1531d.l();
    }

    public void onAnimationStart(Animator animator) {
        o oVar = this.f1531d;
        RecyclerView.d0 d0Var = this.f1528a.f1536a;
        if (oVar == null) {
            throw null;
        }
    }
}
