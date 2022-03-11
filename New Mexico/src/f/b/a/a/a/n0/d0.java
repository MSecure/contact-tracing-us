package f.b.a.a.a.n0;

import android.database.Cursor;
import e.b.a.m;
import e.v.g;
import e.v.i;
import e.v.l;
import e.x.a.f.f;
import f.b.a.a.a.n0.j0;
import f.b.b.a.t;
/* loaded from: classes.dex */
public final class d0 extends x {
    public final g a;
    public final e.v.b<j0> b;
    public final e.v.b<c1> c;

    /* renamed from: d */
    public final l f2334d;

    /* renamed from: e */
    public final l f2335e;

    /* loaded from: classes.dex */
    public class a extends e.v.b<j0> {
        public a(d0 d0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `DiagnosisEntity` (`id`,`createdTimestampMs`,`sharedStatus`,`verificationCode`,`longTermToken`,`certificate`,`testResult`,`onsetDate`,`isServerOnsetDate`,`hasSymptoms`,`revisionToken`,`travelStatus`,`isCodeFromLink`,`lastUpdatedTimestampMs`,`isPreAuth`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            String str;
            String str2;
            String str3;
            j0 j0Var = (j0) obj;
            fVar.b.bindLong(1, j0Var.e());
            fVar.b.bindLong(2, j0Var.c());
            String d0 = m.e.d0(j0Var.m());
            if (d0 == null) {
                fVar.b.bindNull(3);
            } else {
                fVar.b.bindString(3, d0);
            }
            if (j0Var.p() == null) {
                fVar.b.bindNull(4);
            } else {
                fVar.b.bindString(4, j0Var.p());
            }
            if (j0Var.j() == null) {
                fVar.b.bindNull(5);
            } else {
                fVar.b.bindString(5, j0Var.j());
            }
            if (j0Var.b() == null) {
                fVar.b.bindNull(6);
            } else {
                fVar.b.bindString(6, j0Var.b());
            }
            j0.d n = j0Var.n();
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
            l.b.a.f k2 = j0Var.k();
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
            fVar.b.bindLong(9, j0Var.h() ? 1 : 0);
            j0.b d2 = j0Var.d();
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
            if (j0Var.l() == null) {
                fVar.b.bindNull(11);
            } else {
                fVar.b.bindString(11, j0Var.l());
            }
            j0.e o = j0Var.o();
            if (o != null) {
                str4 = o.name();
            }
            if (str4 == null) {
                fVar.b.bindNull(12);
            } else {
                fVar.b.bindString(12, str4);
            }
            fVar.b.bindLong(13, j0Var.f() ? 1 : 0);
            fVar.b.bindLong(14, j0Var.i());
            fVar.b.bindLong(15, j0Var.g() ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    public class b extends e.v.b<c1> {
        public b(d0 d0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `RevisionTokenEntity` (`id`,`createdTimestampMs`,`revisionToken`) VALUES (nullif(?, 0),?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            c1 c1Var = (c1) obj;
            fVar.b.bindLong(1, c1Var.b());
            fVar.b.bindLong(2, c1Var.a());
            if (c1Var.c() == null) {
                fVar.b.bindNull(3);
                return;
            }
            fVar.b.bindString(3, c1Var.c());
        }
    }

    /* loaded from: classes.dex */
    public class c extends l {
        public c(d0 d0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM DiagnosisEntity WHERE id = ?";
        }
    }

    /* loaded from: classes.dex */
    public class d extends l {
        public d(d0 d0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM RevisionTokenEntity";
        }
    }

    public d0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2334d = new c(this, gVar);
        this.f2335e = new d(this, gVar);
    }

    public static Long b(d0 d0Var, long j2, f.b.b.a.g gVar) {
        i iVar;
        Throwable th;
        j0 j0Var;
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        t.x(1, j2);
        d0Var.a.b();
        Cursor b2 = e.v.p.b.b(d0Var.a, t, false, null);
        try {
            int h0 = m.e.h0(b2, "id");
            int h02 = m.e.h0(b2, "createdTimestampMs");
            int h03 = m.e.h0(b2, "sharedStatus");
            int h04 = m.e.h0(b2, "verificationCode");
            int h05 = m.e.h0(b2, "longTermToken");
            int h06 = m.e.h0(b2, "certificate");
            int h07 = m.e.h0(b2, "testResult");
            int h08 = m.e.h0(b2, "onsetDate");
            int h09 = m.e.h0(b2, "isServerOnsetDate");
            int h010 = m.e.h0(b2, "hasSymptoms");
            int h011 = m.e.h0(b2, "revisionToken");
            int h012 = m.e.h0(b2, "travelStatus");
            int h013 = m.e.h0(b2, "isCodeFromLink");
            int h014 = m.e.h0(b2, "lastUpdatedTimestampMs");
            iVar = t;
            try {
                int h015 = m.e.h0(b2, "isPreAuth");
                if (b2.moveToFirst()) {
                    j0Var = j0.a(b2.getLong(h0), b2.getLong(h02), m.e.P1(b2.getString(h03)), b2.getString(h04), b2.getString(h05), b2.getString(h06), m.e.Q1(b2.getString(h07)), b2.getInt(h09) != 0, m.e.O1(b2.getString(h08)), m.e.N1(b2.getString(h010)), b2.getString(h011), m.e.R1(b2.getString(h012)), b2.getInt(h013) != 0, b2.getLong(h014), b2.getInt(h015) != 0);
                } else {
                    j0Var = null;
                }
                b2.close();
                iVar.Q();
                if (j0Var == null) {
                    j0Var = j0.q().a();
                }
                return d0Var.a((j0) gVar.a(j0Var));
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                iVar.Q();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            iVar = t;
        }
    }

    public static Long c(d0 d0Var, j0 j0Var) {
        if (!t.a(j0Var.l())) {
            o oVar = new o(0, j0Var.c(), j0Var.l());
            d0Var.a.b();
            d0Var.a.c();
            try {
                d0Var.c.f(oVar);
                d0Var.a.l();
                d0Var.a.g();
            } finally {
            }
        }
        d0Var.a.b();
        d0Var.a.c();
        try {
            long f2 = d0Var.b.f(j0Var);
            d0Var.a.l();
            return Long.valueOf(f2);
        } finally {
        }
    }

    @Override // f.b.a.a.a.n0.x
    public Long a(j0 j0Var) {
        this.a.c();
        try {
            Long c2 = c(this, j0Var);
            this.a.l();
            return c2;
        } finally {
            this.a.g();
        }
    }
}
