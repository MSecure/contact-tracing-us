package b.i.l;

import android.view.View;
import android.view.ViewTreeObserver;

public final class k implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final View f1155b;

    /* renamed from: c  reason: collision with root package name */
    public ViewTreeObserver f1156c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f1157d;

    public k(View view, Runnable runnable) {
        this.f1155b = view;
        this.f1156c = view.getViewTreeObserver();
        this.f1157d = runnable;
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
        (this.f1156c.isAlive() ? this.f1156c : this.f1155b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f1155b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f1157d.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f1156c = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
