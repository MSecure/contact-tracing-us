package f.b.a.a.a.y;

import android.database.Cursor;
import e.b.a.m;
import e.t.g;
import e.t.i;
import e.t.l;
import e.v.a.f.f;
import f.b.a.a.a.y.c0;
import f.b.b.a.t;
import l.b.a.e;

public final class v extends u {
    public final g a;
    public final e.t.b<c0> b;
    public final e.t.b<s0> c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2369d;

    public class a extends e.t.b<c0> {
        public a(v vVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `DiagnosisEntity` (`id`,`createdTimestampMs`,`sharedStatus`,`verificationCode`,`longTermToken`,`certificate`,`testResult`,`onsetDate`,`isServerOnsetDate`,`hasSymptoms`,`revisionToken`,`travelStatus`,`isCodeFromLink`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, c0 c0Var) {
            String str;
            String str2;
            String str3;
            String str4;
            c0 c0Var2 = c0Var;
            fVar.b.bindLong(1, c0Var2.e());
            fVar.b.bindLong(2, c0Var2.c());
            c0.c k2 = c0Var2.k();
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
            if (c0Var2.n() == null) {
                fVar.b.bindNull(4);
            } else {
                fVar.b.bindString(4, c0Var2.n());
            }
            if (c0Var2.h() == null) {
                fVar.b.bindNull(5);
            } else {
                fVar.b.bindString(5, c0Var2.h());
            }
            if (c0Var2.b() == null) {
                fVar.b.bindNull(6);
            } else {
                fVar.b.bindString(6, c0Var2.b());
            }
            c0.d l2 = c0Var2.l();
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
            e i2 = c0Var2.i();
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
            fVar.b.bindLong(9, c0Var2.g() ? 1 : 0);
            c0.b d2 = c0Var2.d();
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
            if (c0Var2.j() == null) {
                fVar.b.bindNull(11);
            } else {
                fVar.b.bindString(11, c0Var2.j());
            }
            c0.e m = c0Var2.m();
            if (m != null) {
                str5 = m.name();
            }
            if (str5 == null) {
                fVar.b.bindNull(12);
            } else {
                fVar.b.bindString(12, str5);
            }
            fVar.b.bindLong(13, c0Var2.f() ? 1 : 0);
        }
    }

    public class b extends e.t.b<s0> {
        public b(v vVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `RevisionTokenEntity` (`id`,`createdTimestampMs`,`revisionToken`) VALUES (nullif(?, 0),?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, s0 s0Var) {
            s0 s0Var2 = s0Var;
            fVar.b.bindLong(1, s0Var2.b());
            fVar.b.bindLong(2, s0Var2.a());
            if (s0Var2.c() == null) {
                fVar.b.bindNull(3);
                return;
            }
            fVar.b.bindString(3, s0Var2.c());
        }
    }

    public class c extends l {
        public c(v vVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM DiagnosisEntity WHERE id = ?";
        }
    }

    public v(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2369d = new c(this, gVar);
    }

    public static Long b(v vVar, long j2, f.b.b.a.g gVar) {
        c0 c0Var;
        i v = i.v("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        v.A(1, j2);
        vVar.a.b();
        Cursor b2 = e.t.p.b.b(vVar.a, v, false, null);
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
                c0Var = c0.a(b2.getLong(b0), b2.getLong(b02), m.h.p1(b2.getString(b03)), b2.getString(b04), b2.getString(b05), b2.getString(b06), m.h.q1(b2.getString(b07)), b2.getInt(b09) != 0, m.h.o1(b2.getString(b08)), m.h.n1(b2.getString(b010)), b2.getString(b011), m.h.r1(b2.getString(b012)), b2.getInt(b013) != 0);
            } else {
                c0Var = null;
            }
            if (c0Var == null) {
                c0Var = c0.o().a();
            }
            return vVar.a((c0) gVar.a(c0Var));
        } finally {
            b2.close();
            v.V();
        }
    }

    public static Long c(v vVar, c0 c0Var) {
        if (!t.a(c0Var.j())) {
            n nVar = new n(0, c0Var.c(), c0Var.j());
            vVar.a.b();
            vVar.a.c();
            try {
                vVar.c.f(nVar);
                vVar.a.l();
            } finally {
                vVar.a.g();
            }
        }
        vVar.a.b();
        vVar.a.c();
        try {
            long f2 = vVar.b.f(c0Var);
            vVar.a.l();
            return Long.valueOf(f2);
        } finally {
            vVar.a.g();
        }
    }

    @Override // f.b.a.a.a.y.u
    public Long a(c0 c0Var) {
        this.a.c();
        try {
            Long c2 = c(this, c0Var);
            this.a.l();
            return c2;
        } finally {
            this.a.g();
        }
    }
}
