package f.b.a.a.a.n0;

import e.v.g;
import e.v.l;
import e.x.a.f.f;
/* loaded from: classes.dex */
public final class n1 extends m1 {
    public final g a;
    public final e.v.b<p1> b;
    public final l c;

    /* loaded from: classes.dex */
    public class a extends e.v.b<p1> {
        public a(n1 n1Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `WorkerStatusEntity` (`workerTaskNameAndStatus`,`lastRunTimestampMillis`) VALUES (?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            p1 p1Var = (p1) obj;
            if (p1Var.b() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, p1Var.b());
            }
            fVar.b.bindLong(2, p1Var.a());
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(n1 n1Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM WorkerStatusEntity";
        }
    }

    public n1(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }
}
