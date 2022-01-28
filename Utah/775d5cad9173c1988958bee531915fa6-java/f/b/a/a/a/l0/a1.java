package f.b.a.a.a.l0;

import e.b.a.m;
import e.u.g;
import e.u.l;
import e.w.a.f.f;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a1 extends z0 {
    public final g a;
    public final e.u.b<e1> b;
    public final l c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2276d;

    public class a extends e.u.b<e1> {
        public a(a1 a1Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `VerificationCodeRequestEntity` (`id`,`requestTime`,`expiresAtTime`,`nonce`) VALUES (nullif(?, 0),?,?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, e1 e1Var) {
            e1 e1Var2 = e1Var;
            fVar.b.bindLong(1, e1Var2.c());
            fVar.b.bindLong(2, m.e.b0(e1Var2.e()));
            fVar.b.bindLong(3, m.e.b0(e1Var2.b()));
            if (e1Var2.d() == null) {
                fVar.b.bindNull(4);
                return;
            }
            fVar.b.bindString(4, e1Var2.d());
        }
    }

    public class b extends l {
        public b(a1 a1Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "DELETE FROM VerificationCodeRequestEntity WHERE requestTime < ?";
        }
    }

    public class c extends l {
        public c(a1 a1Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "UPDATE VerificationCodeRequestEntity SET nonce = '' WHERE expiresAtTime <= ?";
        }
    }

    public a1(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        new AtomicBoolean(false);
        this.c = new b(this, gVar);
        this.f2276d = new c(this, gVar);
    }
}
