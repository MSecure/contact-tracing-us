package e.c0.a0.s;

import android.database.Cursor;
import e.v.b;
import e.v.g;
import e.v.i;
/* loaded from: classes.dex */
public final class f implements e {
    public final g a;
    public final b<d> b;

    /* loaded from: classes.dex */
    public class a extends b<d> {
        public a(f fVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // e.v.b
        public void d(e.x.a.f.f fVar, Object obj) {
            d dVar = (d) obj;
            String str = dVar.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            Long l2 = dVar.b;
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
        Cursor b = e.v.p.b.b(this.a, t, false, null);
        try {
            if (b.moveToFirst() && !b.isNull(0)) {
                l2 = Long.valueOf(b.getLong(0));
            }
            return l2;
        } finally {
            b.close();
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
