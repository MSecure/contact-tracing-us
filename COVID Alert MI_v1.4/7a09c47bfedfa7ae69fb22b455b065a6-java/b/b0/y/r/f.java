package b.b0.y.r;

import android.database.Cursor;
import b.s.b;
import b.s.h;
import b.s.j;
import b.w.a.g.e;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final h f1217a;

    /* renamed from: b  reason: collision with root package name */
    public final b<d> f1218b;

    public class a extends b<d> {
        public a(f fVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.w.a.f, java.lang.Object] */
        @Override // b.s.b
        public void bind(b.w.a.f fVar, d dVar) {
            d dVar2 = dVar;
            String str = dVar2.f1215a;
            if (str == null) {
                ((e) fVar).f2630b.bindNull(1);
            } else {
                ((e) fVar).f2630b.bindString(1, str);
            }
            Long l = dVar2.f1216b;
            if (l == null) {
                ((e) fVar).f2630b.bindNull(2);
                return;
            }
            ((e) fVar).f2630b.bindLong(2, l.longValue());
        }

        @Override // b.s.m
        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }
    }

    public f(h hVar) {
        this.f1217a = hVar;
        this.f1218b = new a(this, hVar);
    }

    public Long a(String str) {
        j c2 = j.c("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1217a.assertNotSuspendingTransaction();
        Long l = null;
        Cursor b2 = b.s.q.b.b(this.f1217a, c2, false, null);
        try {
            if (b2.moveToFirst()) {
                if (!b2.isNull(0)) {
                    l = Long.valueOf(b2.getLong(0));
                }
            }
            return l;
        } finally {
            b2.close();
            c2.g();
        }
    }

    public void b(d dVar) {
        this.f1217a.assertNotSuspendingTransaction();
        this.f1217a.beginTransaction();
        try {
            this.f1218b.insert(dVar);
            this.f1217a.setTransactionSuccessful();
        } finally {
            this.f1217a.endTransaction();
        }
    }
}
