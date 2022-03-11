package f.b.a.b.i.s;

import android.content.Context;
import f.b.a.b.i.s.h.d;
import f.b.a.b.i.s.h.f;
import f.b.a.b.i.s.h.r;
import f.b.a.b.i.s.i.c;
import i.a.a;

public final class g implements Object<r> {
    public final a<Context> a;
    public final a<c> b;
    public final a<f> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<f.b.a.b.i.u.a> f2456d;

    public g(a<Context> aVar, a<c> aVar2, a<f> aVar3, a<f.b.a.b.i.u.a> aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2456d = aVar4;
    }

    public Object get() {
        this.f2456d.get();
        return new d(this.a.get(), this.b.get(), this.c.get());
    }
}
