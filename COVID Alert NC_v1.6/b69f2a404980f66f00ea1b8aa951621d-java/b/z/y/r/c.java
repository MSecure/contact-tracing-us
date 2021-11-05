package b.z.y.r;

import android.database.Cursor;
import b.r.b;
import b.r.h;
import b.r.j;
import b.u.a.f;
import b.u.a.g.e;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final h f2070a;

    /* renamed from: b  reason: collision with root package name */
    public final b<a> f2071b;

    public class a extends b<a> {
        public a(c cVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.u.a.f, java.lang.Object] */
        @Override // b.r.b
        public void bind(f fVar, a aVar) {
            a aVar2 = aVar;
            String str = aVar2.f2068a;
            if (str == null) {
                ((e) fVar).f1754b.bindNull(1);
            } else {
                ((e) fVar).f1754b.bindString(1, str);
            }
            String str2 = aVar2.f2069b;
            e eVar = (e) fVar;
            if (str2 == null) {
                eVar.f1754b.bindNull(2);
            } else {
                eVar.f1754b.bindString(2, str2);
            }
        }

        @Override // b.r.m
        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }
    }

    public c(h hVar) {
        this.f2070a = hVar;
        this.f2071b = new a(this, hVar);
    }

    public List<String> a(String str) {
        j d2 = j.d("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2070a.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.f2070a, d2, false, null);
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

    public boolean b(String str) {
        boolean z = true;
        j d2 = j.d("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            d2.f(1);
        } else {
            d2.g(1, str);
        }
        this.f2070a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor b2 = b.r.q.b.b(this.f2070a, d2, false, null);
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
            d2.h();
        }
    }
}
