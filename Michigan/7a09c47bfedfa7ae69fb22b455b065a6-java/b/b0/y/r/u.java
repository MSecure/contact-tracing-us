package b.b0.y.r;

import android.database.Cursor;
import b.s.b;
import b.s.h;
import b.s.j;
import b.w.a.f;
import b.w.a.g.e;
import java.util.ArrayList;
import java.util.List;

public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    public final h f1252a;

    /* renamed from: b  reason: collision with root package name */
    public final b<s> f1253b;

    public class a extends b<s> {
        public a(u uVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.w.a.f, java.lang.Object] */
        @Override // b.s.b
        public void bind(f fVar, s sVar) {
            s sVar2 = sVar;
            String str = sVar2.f1250a;
            if (str == null) {
                ((e) fVar).f2630b.bindNull(1);
            } else {
                ((e) fVar).f2630b.bindString(1, str);
            }
            String str2 = sVar2.f1251b;
            e eVar = (e) fVar;
            if (str2 == null) {
                eVar.f2630b.bindNull(2);
            } else {
                eVar.f2630b.bindString(2, str2);
            }
        }

        @Override // b.s.m
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public u(h hVar) {
        this.f1252a = hVar;
        this.f1253b = new a(this, hVar);
    }

    public List<String> a(String str) {
        j c2 = j.c("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1252a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1252a, c2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            c2.g();
        }
    }
}
