package e.b0.a0;

import android.os.Build;
import androidx.work.impl.WorkDatabase;
import e.b0.a0.s.o;
import e.b0.a0.s.p;
import e.b0.a0.s.q;
import e.b0.c;
import e.b0.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f {
    public static final String a = n.e("Schedulers");

    /* JADX INFO: finally extract failed */
    public static void a(c cVar, WorkDatabase workDatabase, List<e> list) {
        if (list != null && list.size() != 0) {
            p r = workDatabase.r();
            workDatabase.c();
            try {
                q qVar = (q) r;
                List<o> d2 = qVar.d(Build.VERSION.SDK_INT == 23 ? cVar.f1160h / 2 : cVar.f1160h);
                List<o> b = qVar.b(200);
                if (((ArrayList) d2).size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = ((ArrayList) d2).iterator();
                    while (it.hasNext()) {
                        qVar.l(((o) it.next()).a, currentTimeMillis);
                    }
                }
                workDatabase.l();
                workDatabase.g();
                ArrayList arrayList = (ArrayList) d2;
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
