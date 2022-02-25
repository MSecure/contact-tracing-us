package f.b.c.k.w;

import f.b.c.k.u.c;
import f.b.c.k.u.f;
import f.b.c.k.w.q0;
import f.b.c.k.x.c;
import f.b.d.a.e;
import f.b.d.a.h;
import f.b.d.a.k;
import f.b.d.a.l;
import f.b.d.a.m;
import f.b.f.j;
import f.b.f.r;
import h.a.c1;
import h.a.l1.a.b;
import h.a.o0;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class s0 extends b<l, m, a> {
    public static final j q = j.c;
    public final h0 p;

    public interface a extends n0 {
        void d(f.b.c.k.u.m mVar, q0 q0Var);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public s0(t tVar, c cVar, h0 h0Var, a aVar) {
        super(tVar, r0, cVar, c.d.LISTEN_STREAM_CONNECTION_BACKOFF, c.d.LISTEN_STREAM_IDLE, aVar);
        o0<l, m> o0Var = k.b;
        if (o0Var == null) {
            synchronized (k.class) {
                o0Var = k.b;
                if (o0Var == null) {
                    o0.c cVar2 = o0.c.BIDI_STREAMING;
                    String a2 = o0.a("google.firestore.v1.Firestore", "Listen");
                    l g2 = l.g();
                    r rVar = b.a;
                    o0Var = new o0<>(cVar2, a2, new b.a(g2), new b.a(m.c()), null, false, false, true, null);
                    k.b = o0Var;
                }
            }
        }
        this.p = h0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.c.k.w.b
    public void f(m mVar) {
        q0 q0Var;
        q0.e eVar;
        q0.b bVar;
        m mVar2 = mVar;
        this.f3127j.f3184f = 0;
        h0 h0Var = this.p;
        Objects.requireNonNull(h0Var);
        int ordinal = mVar2.h().ordinal();
        c1 c1Var = null;
        if (ordinal != 0) {
            if (ordinal == 1) {
                e d2 = mVar2.d();
                List<Integer> f2 = d2.f();
                List<Integer> e2 = d2.e();
                f a2 = h0Var.a(d2.d().h());
                f.b.c.k.u.m e3 = h0Var.e(d2.d().i());
                f.b.a.c.b.o.b.a1(!e3.equals(f.b.c.k.u.m.c), "Got a document change without an update time", new Object[0]);
                bVar = new q0.b(f2, e2, a2, new f.b.c.k.u.c(a2, e3, f.b.c.k.u.k.b(d2.d().g()), c.a.SYNCED));
            } else if (ordinal == 2) {
                f.b.d.a.f e4 = mVar2.e();
                List<Integer> f3 = e4.f();
                f.b.c.k.u.j jVar = new f.b.c.k.u.j(h0Var.a(e4.d()), h0Var.e(e4.e()), false);
                bVar = new q0.b(Collections.emptyList(), f3, jVar.a, jVar);
            } else if (ordinal == 3) {
                h f4 = mVar2.f();
                q0Var = new q0.b(Collections.emptyList(), f4.e(), h0Var.a(f4.d()), null);
            } else if (ordinal == 4) {
                f.b.d.a.j g2 = mVar2.g();
                q0Var = new q0.c(g2.d(), new k(g2.getCount()));
            } else {
                throw new IllegalArgumentException("Unknown change type set");
            }
            q0Var = bVar;
        } else {
            f.b.d.a.r i2 = mVar2.i();
            int ordinal2 = i2.g().ordinal();
            if (ordinal2 == 0) {
                eVar = q0.e.NoChange;
            } else if (ordinal2 == 1) {
                eVar = q0.e.Added;
            } else if (ordinal2 == 2) {
                eVar = q0.e.Removed;
                f.b.g.a c = i2.c();
                c1Var = c1.c(c.c()).g(c.e());
            } else if (ordinal2 == 3) {
                eVar = q0.e.Current;
            } else if (ordinal2 == 4) {
                eVar = q0.e.Reset;
            } else {
                throw new IllegalArgumentException("Unknown target change type");
            }
            q0Var = new q0.d(eVar, i2.i(), i2.f(), c1Var);
        }
        h0 h0Var2 = this.p;
        Objects.requireNonNull(h0Var2);
        ((a) this.f3128k).d((mVar2.h() == m.c.TARGET_CHANGE && mVar2.i().h() == 0) ? h0Var2.e(mVar2.i().e()) : f.b.c.k.u.m.c, q0Var);
    }
}
