package f.b.a.a.a.n0;

import e.b.a.m;
import e.v.g;
import e.v.l;
import e.x.a.f.f;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class f1 extends e1 {
    public final g a;
    public final e.v.b<k1> b;
    public final l c;

    /* renamed from: d */
    public final l f2336d;

    /* renamed from: e */
    public final l f2337e;

    /* loaded from: classes.dex */
    public class a extends e.v.b<k1> {
        public a(f1 f1Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `VerificationCodeRequestEntity` (`id`,`requestTime`,`expiresAtTime`,`nonce`) VALUES (nullif(?, 0),?,?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            k1 k1Var = (k1) obj;
            fVar.b.bindLong(1, k1Var.c());
            fVar.b.bindLong(2, m.e.c0(k1Var.e()));
            fVar.b.bindLong(3, m.e.c0(k1Var.b()));
            if (k1Var.d() == null) {
                fVar.b.bindNull(4);
                return;
            }
            fVar.b.bindString(4, k1Var.d());
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(f1 f1Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM VerificationCodeRequestEntity WHERE requestTime < ?";
        }
    }

    /* loaded from: classes.dex */
    public class c extends l {
        public c(f1 f1Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "UPDATE VerificationCodeRequestEntity SET nonce = '' WHERE expiresAtTime <= ?";
        }
    }

    /* loaded from: classes.dex */
    public class d extends l {
        public d(f1 f1Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM VerificationCodeRequestEntity";
        }
    }

    public f1(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        new AtomicBoolean(false);
        this.c = new b(this, gVar);
        this.f2336d = new c(this, gVar);
        this.f2337e = new d(this, gVar);
    }
}
