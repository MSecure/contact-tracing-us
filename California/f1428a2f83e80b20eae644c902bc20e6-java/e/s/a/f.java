package e.s.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.b0 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1789d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1790e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ c f1791f;

    public f(c cVar, RecyclerView.b0 b0Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1791f = cVar;
        this.a = b0Var;
        this.b = i2;
        this.c = view;
        this.f1789d = i3;
        this.f1790e = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.b != 0) {
            this.c.setTranslationX(0.0f);
        }
        if (this.f1789d != 0) {
            this.c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.f1790e.setListener(null);
        this.f1791f.g(this.a);
        this.f1791f.p.remove(this.a);
        this.f1791f.q();
    }

    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f1791f);
    }
}
