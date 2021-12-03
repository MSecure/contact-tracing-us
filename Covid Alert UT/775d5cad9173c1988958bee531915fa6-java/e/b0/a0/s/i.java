package e.b0.a0.s;

import android.database.Cursor;
import e.b.a.m;
import e.u.g;
import e.u.l;
import e.w.a.f.f;

public final class i implements h {
    public final g a;
    public final e.u.b<g> b;
    public final l c;

    public class a extends e.u.b<g> {
        public a(i iVar, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, g gVar) {
            g gVar2 = gVar;
            String str = gVar2.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            fVar.b.bindLong(2, (long) gVar2.b);
        }
    }

    public class b extends l {
        public b(i iVar, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public i(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }

    public g a(String str) {
        e.u.i t = e.u.i.t("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        g gVar = null;
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            int g0 = m.e.g0(b2, "work_spec_id");
            int g02 = m.e.g0(b2, "system_id");
            if (b2.moveToFirst()) {
                gVar = new g(b2.getString(g0), b2.getInt(g02));
            }
            return gVar;
        } finally {
            b2.close();
            t.Q();
        }
    }

    public void b(g gVar) {
        this.a.b();
        this.a.c();
        try {
            this.b.e(gVar);
            this.a.l();
        } finally {
            this.a.g();
        }
    }

    public void c(String str) {
        this.a.b();
        f a2 = this.c.a();
        if (str == null) {
            a2.b.bindNull(1);
        } else {
            a2.b.bindString(1, str);
        }
        this.a.c();
        try {
            a2.d();
            this.a.l();
            this.a.g();
            l lVar = this.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        } catch (Throwable th) {
            this.a.g();
            this.c.c(a2);
            throw th;
        }
    }
}
