package e.i.i;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

public final class l implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View b;
    public ViewTreeObserver c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f1291d;

    public l(View view, Runnable runnable) {
        this.b = view;
        this.c = view.getViewTreeObserver();
        this.f1291d = runnable;
    }

    public static l a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        l lVar = new l(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(lVar);
        view.addOnAttachStateChangeListener(lVar);
        return lVar;
    }

    public void b() {
        (this.c.isAlive() ? this.c : this.b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f1291d.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.c = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
