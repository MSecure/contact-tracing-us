package f.b.a.a.a.w;

import e.t.g;
import e.t.l;
import e.v.a.f.f;
import java.util.List;

public final class i0 extends h0 {
    public final g a;
    public final e.t.b<j0> b;
    public final l c;

    public class a extends e.t.b<j0> {
        public a(i0 i0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `ExposureEntity` (`dateDaysSinceEpoch`,`exposureScore`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, j0 j0Var) {
            j0 j0Var2 = j0Var;
            fVar.b.bindLong(1, j0Var2.b());
            fVar.b.bindDouble(2, j0Var2.c());
        }
    }

    public class b extends l {
        public b(i0 i0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM ExposureEntity";
        }
    }

    public i0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: e.t.b<f.b.a.a.a.w.j0> */
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(i0 i0Var, List list) {
        i0Var.a.b();
        f a2 = i0Var.c.a();
        i0Var.a.c();
        try {
            a2.d();
            i0Var.a.l();
            i0Var.a.g();
            l lVar = i0Var.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            i0Var.a.b();
            i0Var.a.c();
            try {
                e.t.b<j0> bVar = i0Var.b;
                f a3 = bVar.a();
                try {
                    for (Object obj : list) {
                        bVar.d(a3, obj);
                        a3.c();
                    }
                    bVar.c(a3);
                    i0Var.a.l();
                } catch (Throwable th) {
                    bVar.c(a3);
                    throw th;
                }
            } finally {
                i0Var.a.g();
            }
        } catch (Throwable th2) {
            i0Var.a.g();
            i0Var.c.c(a2);
            throw th2;
        }
    }
}
