package e.m.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;

public class q0 implements Runnable {
    public final /* synthetic */ l b;
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1663d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1664e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f1665f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ u0 f1666g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Rect f1667h;

    public q0(l lVar, l lVar2, boolean z, a aVar, View view, u0 u0Var, Rect rect) {
        this.b = lVar;
        this.c = lVar2;
        this.f1663d = z;
        this.f1664e = aVar;
        this.f1665f = view;
        this.f1666g = u0Var;
        this.f1667h = rect;
    }

    public void run() {
        s0.c(this.b, this.c, this.f1663d, this.f1664e, false);
        View view = this.f1665f;
        if (view != null) {
            this.f1666g.j(view, this.f1667h);
        }
    }
}
