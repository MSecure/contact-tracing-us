package f.b.a.a.a.l0;

import e.b.a.m;
import e.u.g;
import e.u.l;
import e.w.a.f.f;

public final class o0 extends n0 {
    public final g a;
    public final e.u.b<q0> b;
    public final l c;

    public class a extends e.u.b<q0> {
        public a(o0 o0Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `ExposureCheckEntity` (`checkTime`) VALUES (?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, q0 q0Var) {
            fVar.b.bindLong(1, m.e.b0(q0Var.a()));
        }
    }

    public class b extends l {
        public b(o0 o0Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "DELETE FROM ExposureCheckEntity WHERE checkTime < ?";
        }
    }

    public o0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }
}
