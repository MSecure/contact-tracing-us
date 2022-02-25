package f.b.c.k.w;

import f.b.c.k.u.m;
import f.b.c.k.u.p.e;
import f.b.c.k.u.p.h;
import f.b.c.k.x.c;
import f.b.d.a.k;
import f.b.d.a.t;
import f.b.d.a.u;
import f.b.d.a.v;
import f.b.d.a.w;
import f.b.f.j;
import f.b.f.r;
import h.a.l1.a.b;
import h.a.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class t0 extends b<u, v, a> {
    public static final j s = j.c;
    public final h0 p;
    public boolean q;
    public j r;

    public interface a extends n0 {
        void a(m mVar, List<h> list);

        void b();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public t0(t tVar, c cVar, h0 h0Var, a aVar) {
        super(tVar, r0, cVar, c.d.WRITE_STREAM_CONNECTION_BACKOFF, c.d.WRITE_STREAM_IDLE, aVar);
        o0<u, v> o0Var = k.a;
        if (o0Var == null) {
            synchronized (k.class) {
                o0Var = k.a;
                if (o0Var == null) {
                    o0.c cVar2 = o0.c.BIDI_STREAMING;
                    String a2 = o0.a("google.firestore.v1.Firestore", "Write");
                    u f2 = u.f();
                    r rVar = b.a;
                    o0Var = new o0<>(cVar2, a2, new b.a(f2), new b.a(v.d()), null, false, false, true, null);
                    k.a = o0Var;
                }
            }
        }
        this.q = false;
        this.r = s;
        this.p = h0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.c.k.w.b
    public void f(v vVar) {
        v vVar2 = vVar;
        this.r = vVar2.e();
        if (!this.q) {
            this.q = true;
            ((a) this.f3128k).b();
            return;
        }
        this.f3127j.f3184f = 0;
        m e2 = this.p.e(vVar2.c());
        int g2 = vVar2.g();
        ArrayList arrayList = new ArrayList(g2);
        for (int i2 = 0; i2 < g2; i2++) {
            w f2 = vVar2.f(i2);
            h0 h0Var = this.p;
            Objects.requireNonNull(h0Var);
            m e3 = h0Var.e(f2.e());
            if (m.c.equals(e3)) {
                e3 = e2;
            }
            ArrayList arrayList2 = null;
            int d2 = f2.d();
            if (d2 > 0) {
                arrayList2 = new ArrayList(d2);
                for (int i3 = 0; i3 < d2; i3++) {
                    arrayList2.add(f2.c(i3));
                }
            }
            arrayList.add(new h(e3, arrayList2));
        }
        ((a) this.f3128k).a(e2, arrayList);
    }

    @Override // f.b.c.k.w.b
    public void g() {
        this.q = false;
        super.g();
    }

    @Override // f.b.c.k.w.b
    public void h() {
        if (this.q) {
            j(Collections.emptyList());
        }
    }

    public void j(List<e> list) {
        f.b.a.c.b.o.b.a1(c(), "Writing mutations requires an opened stream", new Object[0]);
        f.b.a.c.b.o.b.a1(this.q, "Handshake must be complete before writing mutations", new Object[0]);
        u.b g2 = u.g();
        for (e eVar : list) {
            t k2 = this.p.k(eVar);
            g2.copyOnWrite();
            u.e((u) g2.instance, k2);
        }
        j jVar = this.r;
        g2.copyOnWrite();
        u.d((u) g2.instance, jVar);
        i((u) g2.build());
    }
}
