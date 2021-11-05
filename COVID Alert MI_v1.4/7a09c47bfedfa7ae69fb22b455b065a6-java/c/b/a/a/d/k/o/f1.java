package c.b.a.a.d.k.o;

import b.e.c;
import c.b.a.a.d.d;

public class f1 extends y0 {

    /* renamed from: g  reason: collision with root package name */
    public final c<b<?>> f2975g = new c<>();
    public final g h;

    public f1(j jVar, g gVar) {
        super(jVar, d.f2927d);
        this.h = gVar;
        this.f5986b.a("ConnectionlessLifecycleHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e() {
        if (!this.f2975g.isEmpty()) {
            this.h.c(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void g() {
        this.f3061c = true;
        if (!this.f2975g.isEmpty()) {
            this.h.c(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void h() {
        this.f3061c = false;
        g gVar = this.h;
        if (gVar != null) {
            synchronized (g.q) {
                if (gVar.j == this) {
                    gVar.j = null;
                    gVar.k.clear();
                }
            }
            return;
        }
        throw null;
    }
}
