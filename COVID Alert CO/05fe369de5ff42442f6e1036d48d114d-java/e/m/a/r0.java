package e.m.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;

public class r0 implements Runnable {
    public final /* synthetic */ m b;
    public final /* synthetic */ m c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1496d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1497e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f1498f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ v0 f1499g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Rect f1500h;

    public r0(m mVar, m mVar2, boolean z, a aVar, View view, v0 v0Var, Rect rect) {
        this.b = mVar;
        this.c = mVar2;
        this.f1496d = z;
        this.f1497e = aVar;
        this.f1498f = view;
        this.f1499g = v0Var;
        this.f1500h = rect;
    }

    public void run() {
        t0.c(this.b, this.c, this.f1496d, this.f1497e, false);
        View view = this.f1498f;
        if (view != null) {
            this.f1499g.j(view, this.f1500h);
        }
    }
}
