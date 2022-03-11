package f.b.a.a.a.n0;

import e.b.a.m;
import e.v.g;
import e.v.l;
import e.x.a.f.f;
/* loaded from: classes.dex */
public final class r0 extends q0 {
    public final g a;
    public final e.v.b<u0> b;
    public final l c;

    /* renamed from: d */
    public final l f2371d;

    /* loaded from: classes.dex */
    public class a extends e.v.b<u0> {
        public a(r0 r0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `ExposureCheckEntity` (`checkTime`) VALUES (?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            fVar.b.bindLong(1, m.e.c0(((u0) obj).a()));
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(r0 r0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM ExposureCheckEntity WHERE checkTime < ?";
        }
    }

    /* loaded from: classes.dex */
    public class c extends l {
        public c(r0 r0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM ExposureCheckEntity";
        }
    }

    public r0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2371d = new c(this, gVar);
    }
}
