package e.s.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

public class e extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.b0 a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ViewPropertyAnimator c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1787d;

    public e(c cVar, RecyclerView.b0 b0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1787d = cVar;
        this.a = b0Var;
        this.b = view;
        this.c = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.c.setListener(null);
        this.f1787d.g(this.a);
        this.f1787d.o.remove(this.a);
        this.f1787d.q();
    }

    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f1787d);
    }
}
