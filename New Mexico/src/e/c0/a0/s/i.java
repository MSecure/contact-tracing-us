package e.c0.a0.s;

import android.database.Cursor;
import e.b.a.m;
import e.v.g;
import e.v.l;
import e.x.a.f.f;
/* loaded from: classes.dex */
public final class i implements h {
    public final g a;
    public final e.v.b<g> b;
    public final l c;

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class a extends e.v.b<g> {
        public a(i iVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            g gVar = (g) obj;
            String str = gVar.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            fVar.b.bindLong(2, (long) gVar.b);
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(i iVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
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
        e.v.i t = e.v.i.t("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        g gVar = null;
        Cursor b2 = e.v.p.b.b(this.a, t, false, null);
        try {
            int h0 = m.e.h0(b2, "work_spec_id");
            int h02 = m.e.h0(b2, "system_id");
            if (b2.moveToFirst()) {
                gVar = new g(b2.getString(h0), b2.getInt(h02));
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
