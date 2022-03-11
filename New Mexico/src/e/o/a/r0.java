package e.o.a;

import android.graphics.Rect;
import android.view.View;
import e.f.a;
/* loaded from: classes.dex */
public class r0 implements Runnable {
    public final /* synthetic */ m b;
    public final /* synthetic */ m c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1854d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1855e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f1856f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ v0 f1857g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Rect f1858h;

    public r0(m mVar, m mVar2, boolean z, a aVar, View view, v0 v0Var, Rect rect) {
        this.b = mVar;
        this.c = mVar2;
        this.f1854d = z;
        this.f1855e = aVar;
        this.f1856f = view;
        this.f1857g = v0Var;
        this.f1858h = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        t0.c(this.b, this.c, this.f1854d, this.f1855e, false);
        View view = this.f1856f;
        if (view != null) {
            this.f1857g.j(view, this.f1858h);
        }
    }
}
