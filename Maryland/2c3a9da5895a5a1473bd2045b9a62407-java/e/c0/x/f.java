package e.c0.x;

import android.os.Build;
import androidx.work.impl.WorkDatabase;
import e.c0.b;
import e.c0.l;
import e.c0.x.s.o;
import e.c0.x.s.p;
import e.c0.x.s.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f {
    public static final String a = l.e("Schedulers");

    /* JADX INFO: finally extract failed */
    public static void a(b bVar, WorkDatabase workDatabase, List<e> list) {
        if (list != null && list.size() != 0) {
            p r = workDatabase.r();
            workDatabase.c();
            try {
                q qVar = (q) r;
                List<o> d2 = qVar.d(Build.VERSION.SDK_INT == 23 ? bVar.f1004h / 2 : bVar.f1004h);
                List<o> b = qVar.b(200);
                ArrayList arrayList = (ArrayList) d2;
                if (arrayList.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        qVar.l(((o) it.next()).a, currentTimeMillis);
                    }
                }
                workDatabase.l();
                workDatabase.g();
                if (arrayList.size() > 0) {
                    o[] oVarArr = (o[]) arrayList.toArray(new o[arrayList.size()]);
                    for (e eVar : list) {
                        if (eVar.f()) {
                            eVar.d(oVarArr);
                        }
                    }
                }
                ArrayList arrayList2 = (ArrayList) b;
                if (arrayList2.size() > 0) {
                    o[] oVarArr2 = (o[]) arrayList2.toArray(new o[arrayList2.size()]);
                    for (e eVar2 : list) {
                        if (!eVar2.f()) {
                            eVar2.d(oVarArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.g();
                throw th;
            }
        }
    }
}
