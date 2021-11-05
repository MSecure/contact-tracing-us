package c.b.a.a.c.k.o;

import android.os.Handler;
import b.e.c;
import c.b.a.a.c.a;

public class u extends c1 {
    public final c<b<?>> g = new c<>();
    public g h;

    public u(j jVar) {
        super(jVar);
        this.f4436b.a("ConnectionlessLifecycleHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e() {
        if (!this.g.isEmpty()) {
            this.h.b(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void g() {
        this.f2324c = true;
        if (!this.g.isEmpty()) {
            this.h.b(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void h() {
        this.f2324c = false;
        g gVar = this.h;
        if (gVar != null) {
            synchronized (g.p) {
                if (gVar.j == this) {
                    gVar.j = null;
                    gVar.k.clear();
                }
            }
            return;
        }
        throw null;
    }

    @Override // c.b.a.a.c.k.o.c1
    public final void i(a aVar, int i) {
        g gVar = this.h;
        if (!gVar.f(aVar, i)) {
            Handler handler = gVar.m;
            handler.sendMessage(handler.obtainMessage(5, i, 0, aVar));
        }
    }
}
