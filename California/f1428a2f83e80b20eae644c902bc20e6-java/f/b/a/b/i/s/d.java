package f.b.a.b.i.s;

import f.b.a.b.i.p.e;
import f.b.a.b.i.s.h.r;
import f.b.a.b.i.s.i.c;
import f.b.a.b.i.t.b;
import i.a.a;
import java.util.concurrent.Executor;

public final class d implements Object<c> {
    public final a<Executor> a;
    public final a<e> b;
    public final a<r> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<c> f2366d;

    /* renamed from: e  reason: collision with root package name */
    public final a<b> f2367e;

    public d(a<Executor> aVar, a<e> aVar2, a<r> aVar3, a<c> aVar4, a<b> aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2366d = aVar4;
        this.f2367e = aVar5;
    }

    public Object get() {
        return new c(this.a.get(), this.b.get(), this.c.get(), this.f2366d.get(), this.f2367e.get());
    }
}
