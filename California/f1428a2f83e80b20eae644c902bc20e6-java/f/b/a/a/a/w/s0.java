package f.b.a.a.a.w;

import e.t.b;
import e.t.g;
import e.v.a.f.f;

public final class s0 extends r0 {
    public final g a;
    public final b<t0> b;

    public class a extends b<t0> {
        public a(s0 s0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `WorkerStatusEntity` (`workerTaskNameAndStatus`,`lastRunTimestampMillis`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, t0 t0Var) {
            t0 t0Var2 = t0Var;
            if (t0Var2.b() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, t0Var2.b());
            }
            fVar.b.bindLong(2, t0Var2.a());
        }
    }

    public s0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
