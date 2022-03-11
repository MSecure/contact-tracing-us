package f.b.a.a.a.n0;

import e.v.g;
import e.v.l;
import e.x.a.f.f;
import java.util.List;
/* loaded from: classes.dex */
public final class x0 extends w0 {
    public final g a;
    public final e.v.b<z0> b;
    public final l c;

    /* loaded from: classes.dex */
    public class a extends e.v.b<z0> {
        public a(x0 x0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `ExposureEntity` (`dateDaysSinceEpoch`,`exposureScore`) VALUES (?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            z0 z0Var = (z0) obj;
            fVar.b.bindLong(1, z0Var.b());
            fVar.b.bindDouble(2, z0Var.c());
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(x0 x0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM ExposureEntity";
        }
    }

    public x0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(x0 x0Var, List list) {
        x0Var.a.b();
        f a2 = x0Var.c.a();
        x0Var.a.c();
        try {
            a2.d();
            x0Var.a.l();
            x0Var.a.g();
            l lVar = x0Var.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            x0Var.a.b();
            x0Var.a.c();
            try {
                e.v.b<z0> bVar = x0Var.b;
                f a3 = bVar.a();
                for (Object obj : list) {
                    bVar.d(a3, obj);
                    a3.c();
                }
                bVar.c(a3);
                x0Var.a.l();
            } finally {
                x0Var.a.g();
            }
        } catch (Throwable th) {
            x0Var.a.g();
            x0Var.c.c(a2);
            throw th;
        }
    }
}
