package f.b.c.k.r;

import f.b.a.c.b.o.b;
import f.b.a.c.i.c0;
import f.b.a.c.i.h;
import f.b.c.e.b.a;
import f.b.c.k.x.j;
import f.b.c.k.x.m;
import java.util.Objects;
/* loaded from: classes.dex */
public final class e extends a {
    public final a a;
    public final c b;
    public f c;

    /* renamed from: d */
    public boolean f3515d;

    public e(a aVar) {
        this.a = aVar;
        c cVar = new c(this);
        this.b = cVar;
        String a = aVar.a();
        this.c = a != null ? new f(a) : f.b;
        aVar.b(cVar);
    }

    @Override // f.b.c.k.r.a
    public synchronized h<String> a() {
        boolean z;
        z = this.f3515d;
        this.f3515d = false;
        return this.a.c(z).j(j.b, new f.b.a.c.i.a(this, 0) { // from class: f.b.c.k.r.d
            public final e a;
            public final int b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // f.b.a.c.i.a
            public Object a(h hVar) {
                h<String> t0;
                e eVar = this.a;
                int i2 = this.b;
                synchronized (eVar) {
                    if (i2 != 0) {
                        m.a(m.a.DEBUG, "FirebaseAuthCredentialsProvider", "getToken aborted due to token change", new Object[0]);
                        t0 = eVar.a();
                    } else if (hVar.o()) {
                        Objects.requireNonNull((f.b.c.e.a) hVar.l());
                        t0 = b.t0(null);
                    } else {
                        Exception k2 = hVar.k();
                        c0 c0Var = new c0();
                        c0Var.q(k2);
                        return c0Var;
                    }
                    return t0;
                }
            }
        });
    }

    @Override // f.b.c.k.r.a
    public synchronized void b() {
        this.f3515d = true;
    }

    @Override // f.b.c.k.r.a
    public synchronized void c(f.b.c.k.s.m<f> mVar) {
        mVar.a(this.c);
    }
}
