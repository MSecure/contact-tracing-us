package f.b.a.a.a.y;

import e.t.g;
import e.t.l;
import e.v.a.f.f;
import l.b.a.d;

public final class j0 extends i0 {
    public final g a;
    public final e.t.b<l0> b;
    public final l c;

    public class a extends e.t.b<l0> {
        public a(j0 j0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `ExposureCheckEntity` (`checkTime`) VALUES (?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, l0 l0Var) {
            long j2;
            d a = l0Var.a();
            if (a == null) {
                j2 = 0;
            } else {
                j2 = a.E();
            }
            fVar.b.bindLong(1, j2);
        }
    }

    public class b extends l {
        public b(j0 j0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM ExposureCheckEntity WHERE checkTime < ?";
        }
    }

    public j0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }
}
