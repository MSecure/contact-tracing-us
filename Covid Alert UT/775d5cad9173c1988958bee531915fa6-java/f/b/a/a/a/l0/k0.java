package f.b.a.a.a.l0;

import e.b.a.m;
import e.u.b;
import e.u.g;
import e.w.a.f.f;

public final class k0 extends j0 {
    public final g a;
    public final b<l0> b;

    public class a extends b<l0> {
        public a(k0 k0Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `DownloadServerEntity` (`indexUri`,`mostRecentSuccessfulDownload`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, l0 l0Var) {
            l0 l0Var2 = l0Var;
            String d0 = m.e.d0(l0Var2.a());
            if (d0 == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, d0);
            }
            String d02 = m.e.d0(l0Var2.b());
            if (d02 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, d02);
            }
        }
    }

    public k0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
