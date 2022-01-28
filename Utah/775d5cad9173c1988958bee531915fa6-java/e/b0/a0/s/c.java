package e.b0.a0.s;

import android.database.Cursor;
import e.u.b;
import e.u.g;
import e.u.i;
import e.w.a.f.f;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {
    public final g a;
    public final b<a> b;

    public class a extends b<a> {
        public a(c cVar, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, a aVar) {
            a aVar2 = aVar;
            String str = aVar2.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            String str2 = aVar2.b;
            if (str2 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, str2);
            }
        }
    }

    public c(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }

    public List<String> a(String str) {
        i t = i.t("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            t.Q();
        }
    }

    public boolean b(String str) {
        boolean z = true;
        i t = i.t("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        boolean z2 = false;
        Cursor b2 = e.u.p.b.b(this.a, t, false, null);
        try {
            if (b2.moveToFirst()) {
                if (b2.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            b2.close();
            t.Q();
        }
    }
}
