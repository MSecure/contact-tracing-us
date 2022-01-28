package c.b.c.a.b0;

import c.b.c.a.i;
import c.b.c.a.i0.d;
import c.b.c.a.i0.e;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.e0;
import c.b.c.a.m0.n0;
import c.b.c.a.m0.z;
import c.b.c.a.o;

public final class c extends i<d> {

    public class a extends i.b<c.b.c.a.a, d> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c.b.c.a.a a(d dVar) {
            d dVar2 = dVar;
            d dVar3 = new d();
            c.b.c.a.i0.i iVar = dVar2.aesCtrKey_;
            if (iVar == null) {
                iVar = c.b.c.a.i0.i.DEFAULT_INSTANCE;
            }
            return new z((e0) dVar3.b(iVar, e0.class), (o) new c.b.c.a.g0.b().b(dVar2.p(), o.class), dVar2.p().p().tagSize_);
        }
    }

    public class b extends i.a<e, d> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public d a(e eVar) {
            e eVar2 = eVar;
            d.b bVar = (d.b) d.DEFAULT_INSTANCE.e();
            bVar.d();
            d.n((d) bVar.f5063c, new d().c().a(eVar2.n()));
            bVar.d();
            d.o((d) bVar.f5063c, new c.b.c.a.g0.b().c().a(eVar2.o()));
            if (c.this != null) {
                bVar.d();
                ((d) bVar.f5063c).version_ = 0;
                return (d) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public e b(c.b.c.a.j0.a.i iVar) {
            return (e) y.k(e.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(e eVar) {
            e eVar2 = eVar;
            new d().c().c(eVar2.n());
            new c.b.c.a.g0.b().c().c(eVar2.o());
            n0.a(eVar2.n().keySize_);
        }
    }

    public c() {
        super(d.class, new a(c.b.c.a.a.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.e, c.b.c.a.i0.d>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, d> c() {
        return new b(e.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public d e(c.b.c.a.j0.a.i iVar) {
        return (d) y.k(d.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(d dVar) {
        d dVar2 = dVar;
        n0.e(dVar2.version_, 0);
        d dVar3 = new d();
        c.b.c.a.i0.i iVar = dVar2.aesCtrKey_;
        if (iVar == null) {
            iVar = c.b.c.a.i0.i.DEFAULT_INSTANCE;
        }
        dVar3.g(iVar);
        new c.b.c.a.g0.b().g(dVar2.p());
    }
}
