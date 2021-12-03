package f.b.a.c.h;

import e.b.a.m;
import f.b.a.c.b.l.a;

public final class c {
    public static final a.f<f.b.a.c.h.b.a> a;
    public static final a.f<f.b.a.c.h.b.a> b;
    public static final a.AbstractC0080a<f.b.a.c.h.b.a, a> c;

    /* renamed from: d  reason: collision with root package name */
    public static final a.AbstractC0080a<f.b.a.c.h.b.a, g> f2793d;

    static {
        a.f<f.b.a.c.h.b.a> fVar = new a.f<>();
        a = fVar;
        a.f<f.b.a.c.h.b.a> fVar2 = new a.f<>();
        b = fVar2;
        e eVar = new e();
        c = eVar;
        d dVar = new d();
        f2793d = dVar;
        m.e.p("profile", "scopeUri must not be null or empty");
        m.e.p("email", "scopeUri must not be null or empty");
        m.e.r(eVar, "Cannot construct an Api with a null ClientBuilder");
        m.e.r(fVar, "Cannot construct an Api with a null ClientKey");
        m.e.r(dVar, "Cannot construct an Api with a null ClientBuilder");
        m.e.r(fVar2, "Cannot construct an Api with a null ClientKey");
    }
}
