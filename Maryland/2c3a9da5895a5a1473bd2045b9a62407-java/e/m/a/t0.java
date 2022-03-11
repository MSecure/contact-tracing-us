package e.m.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;

public class t0 implements Runnable {
    public final /* synthetic */ l b;
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1689d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1690e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f1691f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ x0 f1692g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Rect f1693h;

    public t0(l lVar, l lVar2, boolean z, a aVar, View view, x0 x0Var, Rect rect) {
        this.b = lVar;
        this.c = lVar2;
        this.f1689d = z;
        this.f1690e = aVar;
        this.f1691f = view;
        this.f1692g = x0Var;
        this.f1693h = rect;
    }

    public void run() {
        v0.c(this.b, this.c, this.f1689d, this.f1690e, false);
        View view = this.f1691f;
        if (view != null) {
            this.f1692g.j(view, this.f1693h);
        }
    }
}
