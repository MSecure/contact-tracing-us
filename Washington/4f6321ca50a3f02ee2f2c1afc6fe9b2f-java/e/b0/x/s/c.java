package e.b0.x.s;

import android.database.Cursor;
import e.t.b;
import e.t.g;
import e.t.i;
import e.v.a.f.f;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {
    public final g a;
    public final b<a> b;

    public class a extends b<a> {
        public a(c cVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
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
        i v = i.v("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            v.N(1);
        } else {
            v.P(1, str);
        }
        this.a.b();
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            v.V();
        }
    }

    public boolean b(String str) {
        boolean z = true;
        i v = i.v("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            v.N(1);
        } else {
            v.P(1, str);
        }
        this.a.b();
        boolean z2 = false;
        Cursor b2 = e.t.p.b.b(this.a, v, false, null);
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
            v.V();
        }
    }
}
