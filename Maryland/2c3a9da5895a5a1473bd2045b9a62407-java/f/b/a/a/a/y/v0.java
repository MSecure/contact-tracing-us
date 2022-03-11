package f.b.a.a.a.y;

import e.t.b;
import e.t.g;
import e.v.a.f.f;

public final class v0 extends u0 {
    public final g a;
    public final b<w0> b;

    public class a extends b<w0> {
        public a(v0 v0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `WorkerStatusEntity` (`workerTaskNameAndStatus`,`lastRunTimestampMillis`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, w0 w0Var) {
            w0 w0Var2 = w0Var;
            if (w0Var2.b() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, w0Var2.b());
            }
            fVar.b.bindLong(2, w0Var2.a());
        }
    }

    public v0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
