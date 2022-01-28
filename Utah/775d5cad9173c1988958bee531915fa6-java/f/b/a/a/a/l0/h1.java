package f.b.a.a.a.l0;

import e.u.b;
import e.u.g;
import e.w.a.f.f;

public final class h1 extends g1 {
    public final g a;
    public final b<i1> b;

    public class a extends b<i1> {
        public a(h1 h1Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `WorkerStatusEntity` (`workerTaskNameAndStatus`,`lastRunTimestampMillis`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, i1 i1Var) {
            i1 i1Var2 = i1Var;
            if (i1Var2.b() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, i1Var2.b());
            }
            fVar.b.bindLong(2, i1Var2.a());
        }
    }

    public h1(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
