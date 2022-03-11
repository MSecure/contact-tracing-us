package f.b.a.a.a.y;

import e.t.g;
import e.t.l;
import e.v.a.f.f;
import java.util.List;

public final class o0 extends n0 {
    public final g a;
    public final e.t.b<p0> b;
    public final l c;

    public class a extends e.t.b<p0> {
        public a(o0 o0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `ExposureEntity` (`dateDaysSinceEpoch`,`exposureScore`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, p0 p0Var) {
            p0 p0Var2 = p0Var;
            fVar.b.bindLong(1, p0Var2.b());
            fVar.b.bindDouble(2, p0Var2.c());
        }
    }

    public class b extends l {
        public b(o0 o0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM ExposureEntity";
        }
    }

    public o0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: e.t.b<f.b.a.a.a.y.p0> */
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(o0 o0Var, List list) {
        o0Var.a.b();
        f a2 = o0Var.c.a();
        o0Var.a.c();
        try {
            a2.d();
            o0Var.a.l();
            o0Var.a.g();
            l lVar = o0Var.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            o0Var.a.b();
            o0Var.a.c();
            try {
                e.t.b<p0> bVar = o0Var.b;
                f a3 = bVar.a();
                try {
                    for (Object obj : list) {
                        bVar.d(a3, obj);
                        a3.c();
                    }
                    bVar.c(a3);
                    o0Var.a.l();
                } catch (Throwable th) {
                    bVar.c(a3);
                    throw th;
                }
            } finally {
                o0Var.a.g();
            }
        } catch (Throwable th2) {
            o0Var.a.g();
            o0Var.c.c(a2);
            throw th2;
        }
    }
}
