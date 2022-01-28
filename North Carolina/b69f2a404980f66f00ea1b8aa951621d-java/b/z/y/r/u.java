package b.z.y.r;

import android.database.Cursor;
import b.r.b;
import b.r.h;
import b.r.j;
import b.u.a.f;
import b.u.a.g.e;
import java.util.ArrayList;
import java.util.List;

public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    public final h f2105a;

    /* renamed from: b  reason: collision with root package name */
    public final b<s> f2106b;

    public class a extends b<s> {
        public a(u uVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.u.a.f, java.lang.Object] */
        @Override // b.r.b
        public void bind(f fVar, s sVar) {
            s sVar2 = sVar;
            String str = sVar2.f2103a;
            if (str == null) {
                ((e) fVar).f1754b.bindNull(1);
            } else {
                ((e) fVar).f1754b.bindString(1, str);
            }
            String str2 = sVar2.f2104b;
            e eVar = (e) fVar;
            if (str2 == null) {
                eVar.f1754b.bindNull(2);
            } else {
                eVar.f1754b.bindString(2, str2);
            }
        }

        @Override // b.r.m
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public u(h hVar) {
        this.f2105a = hVar;
        this.f2106b = new a(this, hVar);
    }

    public List<String> a(String str) {
        j d2 = j.d("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2105a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2105a, d2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }
}
