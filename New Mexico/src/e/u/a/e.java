package e.u.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
/* loaded from: classes.dex */
public class e extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.b0 a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ViewPropertyAnimator c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1979d;

    public e(c cVar, RecyclerView.b0 b0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1979d = cVar;
        this.a = b0Var;
        this.b = view;
        this.c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.c.setListener(null);
        this.f1979d.g(this.a);
        this.f1979d.o.remove(this.a);
        this.f1979d.q();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f1979d);
    }
}
