package b.b0.y.r;

import android.database.Cursor;
import b.b.k.i;
import b.s.h;
import b.s.j;
import b.s.m;
import b.w.a.f;
import b.w.a.g.e;

public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    public final h f1221a;

    /* renamed from: b  reason: collision with root package name */
    public final b.s.b<g> f1222b;

    /* renamed from: c  reason: collision with root package name */
    public final m f1223c;

    public class a extends b.s.b<g> {
        public a(i iVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.w.a.f, java.lang.Object] */
        @Override // b.s.b
        public void bind(f fVar, g gVar) {
            g gVar2 = gVar;
            String str = gVar2.f1219a;
            if (str == null) {
                ((e) fVar).f2630b.bindNull(1);
            } else {
                ((e) fVar).f2630b.bindString(1, str);
            }
            ((e) fVar).f2630b.bindLong(2, (long) gVar2.f1220b);
        }

        @Override // b.s.m
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }
    }

    public class b extends m {
        public b(i iVar, h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public i(h hVar) {
        this.f1221a = hVar;
        this.f1222b = new a(this, hVar);
        this.f1223c = new b(this, hVar);
    }

    public g a(String str) {
        j c2 = j.c("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1221a.assertNotSuspendingTransaction();
        g gVar = null;
        Cursor b2 = b.s.q.b.b(this.f1221a, c2, false, null);
        try {
            int y = i.j.y(b2, "work_spec_id");
            int y2 = i.j.y(b2, "system_id");
            if (b2.moveToFirst()) {
                gVar = new g(b2.getString(y), b2.getInt(y2));
            }
            return gVar;
        } finally {
            b2.close();
            c2.g();
        }
    }

    public void b(g gVar) {
        this.f1221a.assertNotSuspendingTransaction();
        this.f1221a.beginTransaction();
        try {
            this.f1222b.insert(gVar);
            this.f1221a.setTransactionSuccessful();
        } finally {
            this.f1221a.endTransaction();
        }
    }

    public void c(String str) {
        this.f1221a.assertNotSuspendingTransaction();
        b.w.a.g.f acquire = this.f1223c.acquire();
        if (str == null) {
            ((e) acquire).f2630b.bindNull(1);
        } else {
            ((e) acquire).f2630b.bindString(1, str);
        }
        this.f1221a.beginTransaction();
        acquire = (b.w.a.g.f) acquire;
        try {
            acquire.b();
            this.f1221a.setTransactionSuccessful();
        } finally {
            this.f1221a.endTransaction();
            this.f1223c.release(acquire);
        }
    }
}
