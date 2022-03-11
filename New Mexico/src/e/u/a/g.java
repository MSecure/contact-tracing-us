package e.u.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import e.u.a.c;
import java.util.Objects;
/* loaded from: classes.dex */
public class g extends AnimatorListenerAdapter {
    public final /* synthetic */ c.d a;
    public final /* synthetic */ ViewPropertyAnimator b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1983d;

    public g(c cVar, c.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1983d = cVar;
        this.a = dVar;
        this.b = viewPropertyAnimator;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.b.setListener(null);
        this.c.setAlpha(1.0f);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.f1983d.g(this.a.a);
        this.f1983d.r.remove(this.a.a);
        this.f1983d.q();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        c cVar = this.f1983d;
        RecyclerView.b0 b0Var = this.a.a;
        Objects.requireNonNull(cVar);
    }
}
