package b.z.y.r;

import android.database.Cursor;
import b.b.k.i;
import b.r.h;
import b.r.j;
import b.r.m;
import b.u.a.f;
import b.u.a.g.e;

public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    public final h f2078a;

    /* renamed from: b  reason: collision with root package name */
    public final b.r.b<g> f2079b;

    /* renamed from: c  reason: collision with root package name */
    public final m f2080c;

    public class a extends b.r.b<g> {
        public a(i iVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.u.a.f, java.lang.Object] */
        @Override // b.r.b
        public void bind(f fVar, g gVar) {
            g gVar2 = gVar;
            String str = gVar2.f2076a;
            if (str == null) {
                ((e) fVar).f1754b.bindNull(1);
            } else {
                ((e) fVar).f1754b.bindString(1, str);
            }
            ((e) fVar).f1754b.bindLong(2, (long) gVar2.f2077b);
        }

        @Override // b.r.m
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }
    }

    public class b extends m {
        public b(i iVar, h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public i(h hVar) {
        this.f2078a = hVar;
        this.f2079b = new a(this, hVar);
        this.f2080c = new b(this, hVar);
    }

    public g a(String str) {
        j d2 = j.d("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2078a.assertNotSuspendingTransaction();
        g gVar = null;
        Cursor b2 = b.r.q.b.b(this.f2078a, d2, false, null);
        try {
            int a0 = i.j.a0(b2, "work_spec_id");
            int a02 = i.j.a0(b2, "system_id");
            if (b2.moveToFirst()) {
                gVar = new g(b2.getString(a0), b2.getInt(a02));
            }
            return gVar;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public void b(g gVar) {
        this.f2078a.assertNotSuspendingTransaction();
        this.f2078a.beginTransaction();
        try {
            this.f2079b.insert(gVar);
            this.f2078a.setTransactionSuccessful();
        } finally {
            this.f2078a.endTransaction();
        }
    }

    public void c(String str) {
        this.f2078a.assertNotSuspendingTransaction();
        b.u.a.g.f acquire = this.f2080c.acquire();
        if (str == null) {
            ((e) acquire).f1754b.bindNull(1);
        } else {
            ((e) acquire).f1754b.bindString(1, str);
        }
        this.f2078a.beginTransaction();
        acquire = (b.u.a.g.f) acquire;
        try {
            acquire.b();
            this.f2078a.setTransactionSuccessful();
        } finally {
            this.f2078a.endTransaction();
            this.f2080c.release(acquire);
        }
    }
}
