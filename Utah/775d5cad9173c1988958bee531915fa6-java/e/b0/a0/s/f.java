package e.b0.a0.s;

import android.database.Cursor;
import e.u.b;
import e.u.g;
import e.u.i;

public final class f implements e {
    public final g a;
    public final b<d> b;

    public class a extends b<d> {
        public a(f fVar, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(e.w.a.f.f fVar, d dVar) {
            d dVar2 = dVar;
            String str = dVar2.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            Long l2 = dVar2.b;
            if (l2 == null) {
                fVar.b.bindNull(2);
                return;
            }
            fVar.b.bindLong(2, l2.longValue());
        }
    }

    public f(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }

    public Long a(String str) {
        i t = i.t("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        Long l2 = null;
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            if (b2.moveToFirst()) {
                if (!b2.isNull(0)) {
                    l2 = Long.valueOf(b2.getLong(0));
                }
            }
            return l2;
        } finally {
            b2.close();
            t.Q();
        }
    }

    public void b(d dVar) {
        this.a.b();
        this.a.c();
        try {
            this.b.e(dVar);
            this.a.l();
        } finally {
            this.a.g();
        }
    }
}
