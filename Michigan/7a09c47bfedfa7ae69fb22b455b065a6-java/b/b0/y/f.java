package b.b0.y;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import b.b0.m;
import b.b0.y.o.c.b;
import b.b0.y.r.p;
import b.b0.y.r.q;
import b.b0.y.r.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1076a = m.e("Schedulers");

    public static e a(Context context, k kVar) {
        b bVar = new b(context, kVar);
        b.b0.y.s.f.a(context, SystemJobService.class, true);
        m.c().a(f1076a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        return bVar;
    }

    /* JADX INFO: finally extract failed */
    public static void b(b.b0.b bVar, WorkDatabase workDatabase, List<e> list) {
        if (list != null && list.size() != 0) {
            q h = workDatabase.h();
            workDatabase.beginTransaction();
            try {
                r rVar = (r) h;
                List<p> d2 = rVar.d(Build.VERSION.SDK_INT == 23 ? bVar.k / 2 : bVar.k);
                List<p> b2 = rVar.b(200);
                ArrayList arrayList = (ArrayList) d2;
                if (arrayList.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        rVar.l(((p) it.next()).f1234a, currentTimeMillis);
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (arrayList.size() > 0) {
                    p[] pVarArr = (p[]) arrayList.toArray(new p[arrayList.size()]);
                    for (e eVar : list) {
                        if (eVar.f()) {
                            eVar.d(pVarArr);
                        }
                    }
                }
                ArrayList arrayList2 = (ArrayList) b2;
                if (arrayList2.size() > 0) {
                    p[] pVarArr2 = (p[]) arrayList2.toArray(new p[arrayList2.size()]);
                    for (e eVar2 : list) {
                        if (!eVar2.f()) {
                            eVar2.d(pVarArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }
}
