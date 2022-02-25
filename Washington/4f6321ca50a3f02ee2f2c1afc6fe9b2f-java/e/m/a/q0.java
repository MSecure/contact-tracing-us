package e.m.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;

public class q0 implements Runnable {
    public final /* synthetic */ l b;
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1662d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1663e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f1664f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ u0 f1665g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Rect f1666h;

    public q0(l lVar, l lVar2, boolean z, a aVar, View view, u0 u0Var, Rect rect) {
        this.b = lVar;
        this.c = lVar2;
        this.f1662d = z;
        this.f1663e = aVar;
        this.f1664f = view;
        this.f1665g = u0Var;
        this.f1666h = rect;
    }

    public void run() {
        s0.c(this.b, this.c, this.f1662d, this.f1663e, false);
        View view = this.f1664f;
        if (view != null) {
            this.f1665g.j(view, this.f1666h);
        }
    }
}
