package e.i.i;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

public final class k implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View b;
    public ViewTreeObserver c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f1466d;

    public k(View view, Runnable runnable) {
        this.b = view;
        this.c = view.getViewTreeObserver();
        this.f1466d = runnable;
    }

    public static k a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        k kVar = new k(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(kVar);
        view.addOnAttachStateChangeListener(kVar);
        return kVar;
    }

    public void b() {
        (this.c.isAlive() ? this.c : this.b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f1466d.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.c = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
