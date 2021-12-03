package e.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import e.t.a.c;
import java.util.Objects;

public class g extends AnimatorListenerAdapter {
    public final /* synthetic */ c.d a;
    public final /* synthetic */ ViewPropertyAnimator b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1898d;

    public g(c cVar, c.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1898d = cVar;
        this.a = dVar;
        this.b = viewPropertyAnimator;
        this.c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.setListener(null);
        this.c.setAlpha(1.0f);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.f1898d.g(this.a.a);
        this.f1898d.r.remove(this.a.a);
        this.f1898d.q();
    }

    public void onAnimationStart(Animator animator) {
        c cVar = this.f1898d;
        RecyclerView.b0 b0Var = this.a.a;
        Objects.requireNonNull(cVar);
    }
}
