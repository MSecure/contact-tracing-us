package f.b.a.a.a.l0;

import e.u.g;
import e.u.l;
import e.w.a.f.f;
import java.util.List;

public final class t0 extends s0 {
    public final g a;
    public final e.u.b<u0> b;
    public final l c;

    public class a extends e.u.b<u0> {
        public a(t0 t0Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `ExposureEntity` (`dateDaysSinceEpoch`,`exposureScore`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, u0 u0Var) {
            u0 u0Var2 = u0Var;
            fVar.b.bindLong(1, u0Var2.b());
            fVar.b.bindDouble(2, u0Var2.c());
        }
    }

    public class b extends l {
        public b(t0 t0Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "DELETE FROM ExposureEntity";
        }
    }

    public t0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: e.u.b<f.b.a.a.a.l0.u0> */
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(t0 t0Var, List list) {
        t0Var.a.b();
        f a2 = t0Var.c.a();
        t0Var.a.c();
        try {
            a2.d();
            t0Var.a.l();
            t0Var.a.g();
            l lVar = t0Var.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            t0Var.a.b();
            t0Var.a.c();
            try {
                e.u.b<u0> bVar = t0Var.b;
                f a3 = bVar.a();
                try {
                    for (Object obj : list) {
                        bVar.d(a3, obj);
                        a3.c();
                    }
                    bVar.c(a3);
                    t0Var.a.l();
                } catch (Throwable th) {
                    bVar.c(a3);
                    throw th;
                }
            } finally {
                t0Var.a.g();
            }
        } catch (Throwable th2) {
            t0Var.a.g();
            t0Var.c.c(a2);
            throw th2;
        }
    }
}
