package b.b0.y.r;

import android.database.Cursor;
import b.s.b;
import b.s.h;
import b.s.j;
import b.w.a.f;
import b.w.a.g.e;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final h f1213a;

    /* renamed from: b  reason: collision with root package name */
    public final b<a> f1214b;

    public class a extends b<a> {
        public a(c cVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.w.a.f, java.lang.Object] */
        @Override // b.s.b
        public void bind(f fVar, a aVar) {
            a aVar2 = aVar;
            String str = aVar2.f1211a;
            if (str == null) {
                ((e) fVar).f2630b.bindNull(1);
            } else {
                ((e) fVar).f2630b.bindString(1, str);
            }
            String str2 = aVar2.f1212b;
            e eVar = (e) fVar;
            if (str2 == null) {
                eVar.f2630b.bindNull(2);
            } else {
                eVar.f2630b.bindString(2, str2);
            }
        }

        @Override // b.s.m
        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }
    }

    public c(h hVar) {
        this.f1213a = hVar;
        this.f1214b = new a(this, hVar);
    }

    public List<String> a(String str) {
        j c2 = j.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1213a.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.f1213a, c2, false, null);
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

    public boolean b(String str) {
        boolean z = true;
        j c2 = j.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            c2.e(1);
        } else {
            c2.f(1, str);
        }
        this.f1213a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor b2 = b.s.q.b.b(this.f1213a, c2, false, null);
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
            c2.g();
        }
    }
}
