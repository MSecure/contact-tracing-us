package e.s.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.b0 a;
    public final /* synthetic */ ViewPropertyAnimator b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1802d;

    public d(c cVar, RecyclerView.b0 b0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1802d = cVar;
        this.a = b0Var;
        this.b = viewPropertyAnimator;
        this.c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.setListener(null);
        this.c.setAlpha(1.0f);
        this.f1802d.g(this.a);
        this.f1802d.q.remove(this.a);
        this.f1802d.q();
    }

    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f1802d);
    }
}
