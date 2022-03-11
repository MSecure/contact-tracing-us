package f.b.a.a.a.y;

import e.b.a.m;
import e.t.b;
import e.t.g;
import e.v.a.f.f;

public final class f0 extends e0 {
    public final g a;
    public final b<g0> b;

    public class a extends b<g0> {
        public a(f0 f0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `DownloadServerEntity` (`indexUri`,`mostRecentSuccessfulDownload`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, g0 g0Var) {
            g0 g0Var2 = g0Var;
            String Z = m.h.Z(g0Var2.a());
            if (Z == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, Z);
            }
            String Z2 = m.h.Z(g0Var2.b());
            if (Z2 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, Z2);
            }
        }
    }

    public f0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
