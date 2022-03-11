package f.b.a.b.i;

import f.b.a.b.i.s.e;
import f.b.a.b.i.s.h.l;
import f.b.a.b.i.s.h.p;
import i.a.a;
/* loaded from: classes.dex */
public final class o implements Object<m> {
    public final a<f.b.a.b.i.u.a> a;
    public final a<f.b.a.b.i.u.a> b;
    public final a<e> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<l> f2628d;

    /* renamed from: e  reason: collision with root package name */
    public final a<p> f2629e;

    public o(a<f.b.a.b.i.u.a> aVar, a<f.b.a.b.i.u.a> aVar2, a<e> aVar3, a<l> aVar4, a<p> aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2628d = aVar4;
        this.f2629e = aVar5;
    }

    public Object get() {
        return new m(this.a.get(), this.b.get(), this.c.get(), this.f2628d.get(), this.f2629e.get());
    }
}
