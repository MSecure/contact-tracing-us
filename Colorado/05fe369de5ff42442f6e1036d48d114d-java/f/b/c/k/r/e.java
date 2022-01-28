package f.b.c.k.r;

import f.b.a.c.i.h;
import f.b.c.e.b.a;
import f.b.c.k.s.m;
import f.b.c.k.x.j;

public final class e extends a {
    public final a a;
    public final c b;
    public f c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3197d;

    public e(a aVar) {
        this.a = aVar;
        c cVar = new c(this);
        this.b = cVar;
        String a2 = aVar.a();
        this.c = a2 != null ? new f(a2) : f.b;
        aVar.b(cVar);
    }

    @Override // f.b.c.k.r.a
    public synchronized h<String> a() {
        boolean z;
        z = this.f3197d;
        this.f3197d = false;
        return this.a.c(z).j(j.b, new d(this, 0));
    }

    @Override // f.b.c.k.r.a
    public synchronized void b() {
        this.f3197d = true;
    }

    @Override // f.b.c.k.r.a
    public synchronized void c(m<f> mVar) {
        mVar.a(this.c);
    }
}
