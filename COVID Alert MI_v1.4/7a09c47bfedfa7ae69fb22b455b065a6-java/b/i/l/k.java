package b.i.l;

import android.view.View;
import android.view.ViewTreeObserver;

public final class k implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final View f1863b;

    /* renamed from: c  reason: collision with root package name */
    public ViewTreeObserver f1864c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f1865d;

    public k(View view, Runnable runnable) {
        this.f1863b = view;
        this.f1864c = view.getViewTreeObserver();
        this.f1865d = runnable;
    }

    public static k a(View view, Runnable runnable) {
        if (view != null) {
            k kVar = new k(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(kVar);
            view.addOnAttachStateChangeListener(kVar);
            return kVar;
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        (this.f1864c.isAlive() ? this.f1864c : this.f1863b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f1863b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f1865d.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f1864c = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
