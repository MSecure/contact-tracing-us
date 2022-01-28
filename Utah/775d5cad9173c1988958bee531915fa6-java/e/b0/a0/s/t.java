package e.b0.a0.s;

import android.database.Cursor;
import e.u.b;
import e.u.g;
import e.u.i;
import e.w.a.f.f;
import java.util.ArrayList;
import java.util.List;

public final class t implements s {
    public final g a;
    public final b<r> b;

    public class a extends b<r> {
        public a(t tVar, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
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
        i t = i.t("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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
}
