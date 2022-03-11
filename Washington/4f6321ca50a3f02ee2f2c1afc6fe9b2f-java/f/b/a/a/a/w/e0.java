package f.b.a.a.a.w;

import e.b.a.m;
import e.t.b;
import e.t.g;
import e.v.a.f.f;

public final class e0 extends d0 {
    public final g a;
    public final b<f0> b;

    public class a extends b<f0> {
        public a(e0 e0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `DownloadServerEntity` (`indexUri`,`mostRecentSuccessfulDownload`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, f0 f0Var) {
            f0 f0Var2 = f0Var;
            String Z = m.h.Z(f0Var2.a());
            if (Z == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, Z);
            }
            String Z2 = m.h.Z(f0Var2.b());
            if (Z2 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, Z2);
            }
        }
    }

    public e0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
