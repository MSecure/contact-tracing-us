package e.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import e.t.a.c;
import java.util.Objects;

public class h extends AnimatorListenerAdapter {
    public final /* synthetic */ c.d a;
    public final /* synthetic */ ViewPropertyAnimator b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1899d;

    public h(c cVar, c.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1899d = cVar;
        this.a = dVar;
        this.b = viewPropertyAnimator;
        this.c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.setListener(null);
        this.c.setAlpha(1.0f);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.f1899d.g(this.a.b);
        this.f1899d.r.remove(this.a.b);
        this.f1899d.q();
    }

    public void onAnimationStart(Animator animator) {
        c cVar = this.f1899d;
        RecyclerView.b0 b0Var = this.a.b;
        Objects.requireNonNull(cVar);
    }
}
