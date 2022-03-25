package e.c0.x.s;

import android.database.Cursor;
import e.t.b;
import e.t.g;
import e.t.i;
import e.v.a.f.f;
import java.util.ArrayList;
import java.util.List;

public final class t implements s {
    public final g a;
    public final b<r> b;

    public class a extends b<r> {
        public a(t tVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, r rVar) {
            r rVar2 = rVar;
            String str = rVar2.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            String str2 = rVar2.b;
            if (str2 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, str2);
            }
        }
    }

    public t(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }

    public List<String> a(String str) {
        i v = i.v("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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
}
