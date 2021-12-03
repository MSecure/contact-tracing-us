package f.b.a.a.a.l0;

import android.database.Cursor;
import e.b.a.m;
import e.u.g;
import e.u.i;
import e.u.l;
import e.w.a.f.f;
import f.b.a.a.a.l0.h0;
import f.b.b.a.t;

public final class a0 extends w {
    public final g a;
    public final e.u.b<h0> b;
    public final e.u.b<x0> c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2275d;

    public class a extends e.u.b<h0> {
        public a(a0 a0Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `DiagnosisEntity` (`id`,`createdTimestampMs`,`sharedStatus`,`verificationCode`,`longTermToken`,`certificate`,`testResult`,`onsetDate`,`isServerOnsetDate`,`hasSymptoms`,`revisionToken`,`travelStatus`,`isCodeFromLink`,`lastUpdatedTimestampMs`,`isPreAuth`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, h0 h0Var) {
            String str;
            String str2;
            String str3;
            h0 h0Var2 = h0Var;
            fVar.b.bindLong(1, h0Var2.e());
            fVar.b.bindLong(2, h0Var2.c());
            String c0 = m.e.c0(h0Var2.m());
            if (c0 == null) {
                fVar.b.bindNull(3);
            } else {
                fVar.b.bindString(3, c0);
            }
            if (h0Var2.p() == null) {
                fVar.b.bindNull(4);
            } else {
                fVar.b.bindString(4, h0Var2.p());
            }
            if (h0Var2.j() == null) {
                fVar.b.bindNull(5);
            } else {
                fVar.b.bindString(5, h0Var2.j());
            }
            if (h0Var2.b() == null) {
                fVar.b.bindNull(6);
            } else {
                fVar.b.bindString(6, h0Var2.b());
            }
            h0.d n = h0Var2.n();
            String str4 = null;
            if (n == null) {
                str = null;
            } else {
                str = n.name();
            }
            if (str == null) {
                fVar.b.bindNull(7);
            } else {
                fVar.b.bindString(7, str);
            }
            l.b.a.f k2 = h0Var2.k();
            if (k2 == null) {
                str2 = null;
            } else {
                str2 = k2.toString();
            }
            if (str2 == null) {
                fVar.b.bindNull(8);
            } else {
                fVar.b.bindString(8, str2);
            }
            fVar.b.bindLong(9, h0Var2.h() ? 1 : 0);
            h0.b d2 = h0Var2.d();
            if (d2 == null) {
                str3 = null;
            } else {
                str3 = d2.name();
            }
            if (str3 == null) {
                fVar.b.bindNull(10);
            } else {
                fVar.b.bindString(10, str3);
            }
            if (h0Var2.l() == null) {
                fVar.b.bindNull(11);
            } else {
                fVar.b.bindString(11, h0Var2.l());
            }
            h0.e o = h0Var2.o();
            if (o != null) {
                str4 = o.name();
            }
            if (str4 == null) {
                fVar.b.bindNull(12);
            } else {
                fVar.b.bindString(12, str4);
            }
            fVar.b.bindLong(13, h0Var2.f() ? 1 : 0);
            fVar.b.bindLong(14, h0Var2.i());
            fVar.b.bindLong(15, h0Var2.g() ? 1 : 0);
        }
    }

    public class b extends e.u.b<x0> {
        public b(a0 a0Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `RevisionTokenEntity` (`id`,`createdTimestampMs`,`revisionToken`) VALUES (nullif(?, 0),?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, x0 x0Var) {
            x0 x0Var2 = x0Var;
            fVar.b.bindLong(1, x0Var2.b());
            fVar.b.bindLong(2, x0Var2.a());
            if (x0Var2.c() == null) {
                fVar.b.bindNull(3);
                return;
            }
            fVar.b.bindString(3, x0Var2.c());
        }
    }

    public class c extends l {
        public c(a0 a0Var, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "DELETE FROM DiagnosisEntity WHERE id = ?";
        }
    }

    public a0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2275d = new c(this, gVar);
    }

    public static Long b(a0 a0Var, long j2, f.b.b.a.g gVar) {
        i iVar;
        Throwable th;
        h0 h0Var;
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        t.x(1, j2);
        a0Var.a.b();
        Cursor b2 = e.u.p.b.b(a0Var.a, t, false, null);
        try {
            int g0 = m.e.g0(b2, "id");
            int g02 = m.e.g0(b2, "createdTimestampMs");
            int g03 = m.e.g0(b2, "sharedStatus");
            int g04 = m.e.g0(b2, "verificationCode");
            int g05 = m.e.g0(b2, "longTermToken");
            int g06 = m.e.g0(b2, "certificate");
            int g07 = m.e.g0(b2, "testResult");
            int g08 = m.e.g0(b2, "onsetDate");
            int g09 = m.e.g0(b2, "isServerOnsetDate");
            int g010 = m.e.g0(b2, "hasSymptoms");
            int g011 = m.e.g0(b2, "revisionToken");
            int g012 = m.e.g0(b2, "travelStatus");
            int g013 = m.e.g0(b2, "isCodeFromLink");
            int g014 = m.e.g0(b2, "lastUpdatedTimestampMs");
            iVar = t;
            try {
                int g015 = m.e.g0(b2, "isPreAuth");
                if (b2.moveToFirst()) {
                    h0Var = h0.a(b2.getLong(g0), b2.getLong(g02), m.e.H1(b2.getString(g03)), b2.getString(g04), b2.getString(g05), b2.getString(g06), m.e.I1(b2.getString(g07)), b2.getInt(g09) != 0, m.e.G1(b2.getString(g08)), m.e.F1(b2.getString(g010)), b2.getString(g011), m.e.J1(b2.getString(g012)), b2.getInt(g013) != 0, b2.getLong(g014), b2.getInt(g015) != 0);
                } else {
                    h0Var = null;
                }
                b2.close();
                iVar.Q();
                if (h0Var == null) {
                    h0Var = h0.q().a();
                }
                return a0Var.a((h0) gVar.a(h0Var));
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.Q();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = t;
            b2.close();
            iVar.Q();
            throw th;
        }
    }

    public static Long c(a0 a0Var, h0 h0Var) {
        if (!t.a(h0Var.l())) {
            o oVar = new o(0, h0Var.c(), h0Var.l());
            a0Var.a.b();
            a0Var.a.c();
            try {
                a0Var.c.f(oVar);
                a0Var.a.l();
            } finally {
                a0Var.a.g();
            }
        }
        a0Var.a.b();
        a0Var.a.c();
        try {
            long f2 = a0Var.b.f(h0Var);
            a0Var.a.l();
            return Long.valueOf(f2);
        } finally {
            a0Var.a.g();
        }
    }

    @Override // f.b.a.a.a.l0.w
    public Long a(h0 h0Var) {
        this.a.c();
        try {
            Long c2 = c(this, h0Var);
            this.a.l();
            return c2;
        } finally {
            this.a.g();
        }
    }
}
