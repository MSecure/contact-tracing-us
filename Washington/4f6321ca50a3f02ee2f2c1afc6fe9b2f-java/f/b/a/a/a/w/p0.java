package f.b.a.a.a.w;

import e.t.b;
import e.t.g;
import e.v.a.f.f;

public final class p0 extends o0 {
    public final g a;
    public final b<q0> b;

    public class a extends b<q0> {
        public a(p0 p0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `WorkerStatusEntity` (`workerTaskNameAndStatus`,`lastRunTimestampMillis`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, q0 q0Var) {
            q0 q0Var2 = q0Var;
            if (q0Var2.b() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, q0Var2.b());
            }
            fVar.b.bindLong(2, q0Var2.a());
        }
    }

    public p0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
