package e.i.i;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

public final class q implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View b;
    public ViewTreeObserver c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f1555d;

    public q(View view, Runnable runnable) {
        this.b = view;
        this.c = view.getViewTreeObserver();
        this.f1555d = runnable;
    }

    public static q a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        q qVar = new q(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(qVar);
        view.addOnAttachStateChangeListener(qVar);
        return qVar;
    }

    public void b() {
        (this.c.isAlive() ? this.c : this.b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f1555d.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.c = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
