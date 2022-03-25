package e.c0.x.s;

import android.database.Cursor;
import e.b.a.m;
import e.t.g;
import e.t.l;
import e.v.a.f.f;

public final class i implements h {
    public final g a;
    public final e.t.b<g> b;
    public final l c;

    public class a extends e.t.b<g> {
        public a(i iVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
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

        @Override // e.t.l
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
        e.t.i v = e.t.i.v("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            v.N(1);
        } else {
            v.P(1, str);
        }
        this.a.b();
        g gVar = null;
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            int b0 = m.h.b0(b2, "work_spec_id");
            int b02 = m.h.b0(b2, "system_id");
            if (b2.moveToFirst()) {
                gVar = new g(b2.getString(b0), b2.getInt(b02));
            }
            return gVar;
        } finally {
            b2.close();
            v.V();
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
