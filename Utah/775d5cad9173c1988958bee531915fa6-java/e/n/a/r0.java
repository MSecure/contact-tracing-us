package e.n.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;

public class r0 implements Runnable {
    public final /* synthetic */ m b;
    public final /* synthetic */ m c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1769d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1770e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f1771f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ v0 f1772g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Rect f1773h;

    public r0(m mVar, m mVar2, boolean z, a aVar, View view, v0 v0Var, Rect rect) {
        this.b = mVar;
        this.c = mVar2;
        this.f1769d = z;
        this.f1770e = aVar;
        this.f1771f = view;
        this.f1772g = v0Var;
        this.f1773h = rect;
    }

    public void run() {
        t0.c(this.b, this.c, this.f1769d, this.f1770e, false);
        View view = this.f1771f;
        if (view != null) {
            this.f1772g.j(view, this.f1773h);
        }
    }
}
