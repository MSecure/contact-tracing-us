package f.b.a.a.a.w;

import android.database.Cursor;
import e.b.a.m;
import e.t.g;
import e.t.i;
import e.t.l;
import e.v.a.f.f;
import f.b.a.a.a.w.b0;
import l.b.a.e;

public final class u extends t {
    public final g a;
    public final e.t.b<b0> b;
    public final e.t.b<p0> c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2284d;

    public class a extends e.t.b<b0> {
        public a(u uVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `DiagnosisEntity` (`id`,`createdTimestampMs`,`sharedStatus`,`verificationCode`,`longTermToken`,`certificate`,`testResult`,`onsetDate`,`isServerOnsetDate`,`hasSymptoms`,`revisionToken`,`travelStatus`,`isCodeFromLink`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, b0 b0Var) {
            String str;
            String str2;
            String str3;
            String str4;
            b0 b0Var2 = b0Var;
            fVar.b.bindLong(1, b0Var2.e());
            fVar.b.bindLong(2, b0Var2.c());
            b0.c k2 = b0Var2.k();
            String str5 = null;
            if (k2 == null) {
                str = null;
            } else {
                str = k2.name();
            }
            if (str == null) {
                fVar.b.bindNull(3);
            } else {
                fVar.b.bindString(3, str);
            }
            if (b0Var2.n() == null) {
                fVar.b.bindNull(4);
            } else {
                fVar.b.bindString(4, b0Var2.n());
            }
            if (b0Var2.h() == null) {
                fVar.b.bindNull(5);
            } else {
                fVar.b.bindString(5, b0Var2.h());
            }
            if (b0Var2.b() == null) {
                fVar.b.bindNull(6);
            } else {
                fVar.b.bindString(6, b0Var2.b());
            }
            b0.d l2 = b0Var2.l();
            if (l2 == null) {
                str2 = null;
            } else {
                str2 = l2.name();
            }
            if (str2 == null) {
                fVar.b.bindNull(7);
            } else {
                fVar.b.bindString(7, str2);
            }
            e i2 = b0Var2.i();
            if (i2 == null) {
                str3 = null;
            } else {
                str3 = i2.toString();
            }
            if (str3 == null) {
                fVar.b.bindNull(8);
            } else {
                fVar.b.bindString(8, str3);
            }
            fVar.b.bindLong(9, b0Var2.g() ? 1 : 0);
            b0.b d2 = b0Var2.d();
            if (d2 == null) {
                str4 = null;
            } else {
                str4 = d2.name();
            }
            if (str4 == null) {
                fVar.b.bindNull(10);
            } else {
                fVar.b.bindString(10, str4);
            }
            if (b0Var2.j() == null) {
                fVar.b.bindNull(11);
            } else {
                fVar.b.bindString(11, b0Var2.j());
            }
            b0.e m = b0Var2.m();
            if (m != null) {
                str5 = m.name();
            }
            if (str5 == null) {
                fVar.b.bindNull(12);
            } else {
                fVar.b.bindString(12, str5);
            }
            fVar.b.bindLong(13, b0Var2.f() ? 1 : 0);
        }
    }

    public class b extends e.t.b<p0> {
        public b(u uVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `RevisionTokenEntity` (`id`,`createdTimestampMs`,`revisionToken`) VALUES (nullif(?, 0),?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, p0 p0Var) {
            p0 p0Var2 = p0Var;
            fVar.b.bindLong(1, p0Var2.b());
            fVar.b.bindLong(2, p0Var2.a());
            if (p0Var2.c() == null) {
                fVar.b.bindNull(3);
                return;
            }
            fVar.b.bindString(3, p0Var2.c());
        }
    }

    public class c extends l {
        public c(u uVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM DiagnosisEntity WHERE id = ?";
        }
    }

    public u(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2284d = new c(this, gVar);
    }

    public static Long b(u uVar, long j2, f.b.b.a.g gVar) {
        b0 b0Var;
        i v = i.v("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        v.A(1, j2);
        uVar.a.b();
        Cursor b2 = e.t.p.b.b(uVar.a, v, false, null);
        try {
            int b0 = m.h.b0(b2, "id");
            int b02 = m.h.b0(b2, "createdTimestampMs");
            int b03 = m.h.b0(b2, "sharedStatus");
            int b04 = m.h.b0(b2, "verificationCode");
            int b05 = m.h.b0(b2, "longTermToken");
            int b06 = m.h.b0(b2, "certificate");
            int b07 = m.h.b0(b2, "testResult");
            int b08 = m.h.b0(b2, "onsetDate");
            int b09 = m.h.b0(b2, "isServerOnsetDate");
            int b010 = m.h.b0(b2, "hasSymptoms");
            int b011 = m.h.b0(b2, "revisionToken");
            int b012 = m.h.b0(b2, "travelStatus");
            int b013 = m.h.b0(b2, "isCodeFromLink");
            if (b2.moveToFirst()) {
                b0Var = b0.a(b2.getLong(b0), b2.getLong(b02), m.h.o1(b2.getString(b03)), b2.getString(b04), b2.getString(b05), b2.getString(b06), m.h.p1(b2.getString(b07)), b2.getInt(b09) != 0, m.h.n1(b2.getString(b08)), m.h.m1(b2.getString(b010)), b2.getString(b011), m.h.q1(b2.getString(b012)), b2.getInt(b013) != 0);
            } else {
                b0Var = null;
            }
            if (b0Var == null) {
                b0Var = b0.o().a();
            }
            return uVar.a((b0) gVar.a(b0Var));
        } finally {
            b2.close();
            v.V();
        }
    }

    public static Long c(u uVar, b0 b0Var) {
        if (!f.b.a.c.b.o.b.i1(b0Var.j())) {
            m mVar = new m(0, b0Var.c(), b0Var.j());
            uVar.a.b();
            uVar.a.c();
            try {
                uVar.c.f(mVar);
                uVar.a.l();
            } finally {
                uVar.a.g();
            }
        }
        uVar.a.b();
        uVar.a.c();
        try {
            long f2 = uVar.b.f(b0Var);
            uVar.a.l();
            return Long.valueOf(f2);
        } finally {
            uVar.a.g();
        }
    }

    @Override // f.b.a.a.a.w.t
    public Long a(b0 b0Var) {
        this.a.c();
        try {
            Long c2 = c(this, b0Var);
            this.a.l();
            return c2;
        } finally {
            this.a.g();
        }
    }
}
