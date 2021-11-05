package b.z.y.r;

import android.database.Cursor;
import b.r.b;
import b.r.h;
import b.r.j;
import b.u.a.g.e;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final h f2074a;

    /* renamed from: b  reason: collision with root package name */
    public final b<d> f2075b;

    public class a extends b<d> {
        public a(f fVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.u.a.f, java.lang.Object] */
        @Override // b.r.b
        public void bind(b.u.a.f fVar, d dVar) {
            d dVar2 = dVar;
            String str = dVar2.f2072a;
            if (str == null) {
                ((e) fVar).f1754b.bindNull(1);
            } else {
                ((e) fVar).f1754b.bindString(1, str);
            }
            Long l = dVar2.f2073b;
            if (l == null) {
                ((e) fVar).f1754b.bindNull(2);
                return;
            }
            ((e) fVar).f1754b.bindLong(2, l.longValue());
        }

        @Override // b.r.m
        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }
    }

    public f(h hVar) {
        this.f2074a = hVar;
        this.f2075b = new a(this, hVar);
    }

    public Long a(String str) {
        j d2 = j.d("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2074a.assertNotSuspendingTransaction();
        Long l = null;
        Cursor b2 = b.r.q.b.b(this.f2074a, d2, false, null);
        try {
            if (b2.moveToFirst()) {
                if (!b2.isNull(0)) {
                    l = Long.valueOf(b2.getLong(0));
                }
            }
            return l;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public void b(d dVar) {
        this.f2074a.assertNotSuspendingTransaction();
        this.f2074a.beginTransaction();
        try {
            this.f2075b.insert(dVar);
            this.f2074a.setTransactionSuccessful();
        } finally {
            this.f2074a.endTransaction();
        }
    }
}
