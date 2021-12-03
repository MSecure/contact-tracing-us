package f.b.a.a.a.b0;

import android.database.Cursor;
import e.b.a.m;
import e.t.g;
import e.t.i;
import e.t.l;
import e.v.a.f.f;
import f.b.a.a.a.b0.h0;
import f.b.b.a.t;

public final class a0 extends w {
    public final g a;
    public final e.t.b<h0> b;
    public final e.t.b<x0> c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2078d;

    public class a extends e.t.b<h0> {
        public a(a0 a0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `DiagnosisEntity` (`id`,`createdTimestampMs`,`sharedStatus`,`verificationCode`,`longTermToken`,`certificate`,`testResult`,`onsetDate`,`isServerOnsetDate`,`hasSymptoms`,`revisionToken`,`travelStatus`,`isCodeFromLink`,`lastUpdatedTimestampMs`,`isPreAuth`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, h0 h0Var) {
            String str;
            String str2;
            String str3;
            h0 h0Var2 = h0Var;
            fVar.b.bindLong(1, h0Var2.e());
            fVar.b.bindLong(2, h0Var2.c());
            String a0 = m.h.a0(h0Var2.m());
            if (a0 == null) {
                fVar.b.bindNull(3);
            } else {
                fVar.b.bindString(3, a0);
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

    public class b extends e.t.b<x0> {
        public b(a0 a0Var, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `RevisionTokenEntity` (`id`,`createdTimestampMs`,`revisionToken`) VALUES (nullif(?, 0),?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
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

        @Override // e.t.l
        public String b() {
            return "DELETE FROM DiagnosisEntity WHERE id = ?";
        }
    }

    public a0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2078d = new c(this, gVar);
    }

    public static Long b(a0 a0Var, long j2, f.b.b.a.g gVar) {
        i iVar;
        Throwable th;
        h0 h0Var;
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        t.x(1, j2);
        a0Var.a.b();
        Cursor b2 = e.t.p.b.b(a0Var.a, t, false, null);
        try {
            int d0 = m.h.d0(b2, "id");
            int d02 = m.h.d0(b2, "createdTimestampMs");
            int d03 = m.h.d0(b2, "sharedStatus");
            int d04 = m.h.d0(b2, "verificationCode");
            int d05 = m.h.d0(b2, "longTermToken");
            int d06 = m.h.d0(b2, "certificate");
            int d07 = m.h.d0(b2, "testResult");
            int d08 = m.h.d0(b2, "onsetDate");
            int d09 = m.h.d0(b2, "isServerOnsetDate");
            int d010 = m.h.d0(b2, "hasSymptoms");
            int d011 = m.h.d0(b2, "revisionToken");
            int d012 = m.h.d0(b2, "travelStatus");
            int d013 = m.h.d0(b2, "isCodeFromLink");
            int d014 = m.h.d0(b2, "lastUpdatedTimestampMs");
            iVar = t;
            try {
                int d015 = m.h.d0(b2, "isPreAuth");
                if (b2.moveToFirst()) {
                    h0Var = h0.a(b2.getLong(d0), b2.getLong(d02), m.h.v1(b2.getString(d03)), b2.getString(d04), b2.getString(d05), b2.getString(d06), m.h.w1(b2.getString(d07)), b2.getInt(d09) != 0, m.h.u1(b2.getString(d08)), m.h.t1(b2.getString(d010)), b2.getString(d011), m.h.x1(b2.getString(d012)), b2.getInt(d013) != 0, b2.getLong(d014), b2.getInt(d015) != 0);
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

    @Override // f.b.a.a.a.b0.w
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
