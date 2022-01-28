package f.b.a.a.a.b0;

import e.b.a.m;
import e.t.b;
import e.t.g;
import e.v.a.f.f;

public final class k0 extends j0 {
    public final g a;
    public final b<l0> b;

    public class a extends b<l0> {
        public a(k0 k0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `DownloadServerEntity` (`indexUri`,`mostRecentSuccessfulDownload`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, l0 l0Var) {
            l0 l0Var2 = l0Var;
            String b0 = m.h.b0(l0Var2.a());
            if (b0 == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, b0);
            }
            String b02 = m.h.b0(l0Var2.b());
            if (b02 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, b02);
            }
        }
    }

    public k0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
