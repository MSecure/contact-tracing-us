package e.b0.x.t;

import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import e.b0.e;
import e.b0.l;
import e.b0.o;
import e.b0.s;
import e.b0.u;
import e.b0.x.c;
import e.b0.x.e;
import e.b0.x.f;
import e.b0.x.g;
import e.b0.x.s.a;
import e.b0.x.s.b;
import e.b0.x.s.j;
import e.b0.x.s.k;
import e.b0.x.s.o;
import e.b0.x.s.p;
import e.b0.x.s.q;
import e.b0.x.s.r;
import e.b0.x.s.t;
import e.t.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class d implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1132d = l.e("EnqueueRunnable");
    public final g b;
    public final c c = new c();

    public d(g gVar) {
        this.b = gVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.util.List] */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0289, code lost:
        if (r9 != false) goto L_0x028b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x036f A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static boolean a(g gVar) {
        boolean z;
        boolean z2;
        boolean z3;
        g gVar2;
        long j2;
        boolean z4;
        boolean z5;
        boolean z6;
        s sVar;
        boolean z7;
        boolean z8;
        boolean z9;
        long j3;
        q qVar;
        boolean z10;
        ArrayList arrayList;
        boolean z11;
        List<g> list = gVar.f1021g;
        if (list != null) {
            z = false;
            for (g gVar3 : list) {
                if (!gVar3.f1022h) {
                    z |= a(gVar3);
                } else {
                    l.c().f(f1132d, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar3.f1019e)), new Throwable[0]);
                }
            }
        } else {
            z = false;
        }
        Set<String> c2 = g.c(gVar);
        e.b0.x.l lVar = gVar.a;
        List<? extends u> list2 = gVar.f1018d;
        String[] strArr = (String[]) c2.toArray(new String[0]);
        String str = gVar.b;
        e.b0.g gVar4 = gVar.c;
        s sVar2 = s.ENQUEUED;
        e.b0.g gVar5 = e.b0.g.APPEND_OR_REPLACE;
        s sVar3 = s.SUCCEEDED;
        s sVar4 = s.CANCELLED;
        s sVar5 = s.FAILED;
        long currentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase = lVar.c;
        boolean z12 = strArr != null && strArr.length > 0;
        if (z12) {
            int length = strArr.length;
            int i2 = 0;
            z6 = false;
            z5 = false;
            z4 = true;
            while (i2 < length) {
                String str2 = strArr[i2];
                o i3 = ((q) workDatabase.r()).i(str2);
                if (i3 == null) {
                    l.c().b(f1132d, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    break;
                }
                s sVar6 = i3.b;
                z4 &= sVar6 == sVar3;
                if (sVar6 == sVar5) {
                    z5 = true;
                } else if (sVar6 == sVar4) {
                    z6 = true;
                }
                i2++;
                length = length;
                currentTimeMillis = currentTimeMillis;
            }
            j2 = currentTimeMillis;
        } else {
            j2 = currentTimeMillis;
            z6 = false;
            z5 = false;
            z4 = true;
        }
        boolean z13 = !TextUtils.isEmpty(str);
        if (z13 && !z12) {
            ArrayList arrayList2 = (ArrayList) ((q) workDatabase.r()).j(str);
            if (!arrayList2.isEmpty()) {
                if (gVar4 == e.b0.g.APPEND || gVar4 == gVar5) {
                    b m = workDatabase.m();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        o.a aVar = (o.a) it.next();
                        String str3 = aVar.a;
                        e.b0.x.s.c cVar = (e.b0.x.s.c) m;
                        Objects.requireNonNull(cVar);
                        i v = i.v("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
                        if (str3 == null) {
                            v.N(1);
                        } else {
                            v.P(1, str3);
                        }
                        cVar.a.b();
                        Cursor b2 = e.t.p.b.b(cVar.a, v, false, null);
                        try {
                            if (!(b2.moveToFirst() && b2.getInt(0) != 0)) {
                                s sVar7 = aVar.b;
                                boolean z14 = z4 & (sVar7 == sVar3);
                                if (sVar7 == sVar5) {
                                    z5 = true;
                                } else if (sVar7 == sVar4) {
                                    z6 = true;
                                }
                                arrayList3.add(aVar.a);
                                z4 = z14;
                            }
                            it = it;
                            z13 = z13;
                            m = m;
                            sVar2 = sVar2;
                        } finally {
                            b2.close();
                            v.V();
                        }
                    }
                    z7 = z13;
                    sVar = sVar2;
                    if (gVar4 != gVar5 || (!z6 && !z5)) {
                        z11 = z6;
                        arrayList = arrayList3;
                    } else {
                        q qVar2 = (q) workDatabase.r();
                        Iterator it2 = ((ArrayList) qVar2.j(str)).iterator();
                        while (it2.hasNext()) {
                            qVar2.a(((o.a) it2.next()).a);
                        }
                        z11 = false;
                        z5 = false;
                        arrayList = Collections.emptyList();
                    }
                    strArr = (String[]) arrayList.toArray(strArr);
                    z6 = z11;
                    z12 = strArr.length > 0;
                    z9 = z12;
                    z8 = false;
                    for (u uVar : list2) {
                        o oVar = uVar.b;
                        if (z9 && !z4) {
                            if (z5) {
                                oVar.b = sVar5;
                            } else if (z6) {
                                oVar.b = sVar4;
                            } else {
                                oVar.b = s.BLOCKED;
                            }
                            j3 = j2;
                        } else if (!oVar.c()) {
                            j3 = j2;
                            oVar.n = j3;
                        } else {
                            j3 = j2;
                            oVar.n = 0;
                        }
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 < 23 || i4 > 25) {
                            if (i4 <= 22) {
                                try {
                                    Class<?> cls = Class.forName("androidx.work.impl.background.gcm.GcmScheduler");
                                    Iterator<e> it3 = lVar.f1030e.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            break;
                                        } else if (cls.isAssignableFrom(it3.next().getClass())) {
                                            z10 = true;
                                            break;
                                        }
                                    }
                                } catch (ClassNotFoundException unused) {
                                }
                                z10 = false;
                            }
                            if (oVar.b == sVar) {
                                z8 = true;
                            }
                            qVar = (q) workDatabase.r();
                            qVar.a.b();
                            qVar.a.c();
                            qVar.b.e(oVar);
                            qVar.a.l();
                            if (z9) {
                                int length2 = strArr.length;
                                int i5 = 0;
                                while (i5 < length2) {
                                    a aVar2 = new a(uVar.a(), strArr[i5]);
                                    e.b0.x.s.c cVar2 = (e.b0.x.s.c) workDatabase.m();
                                    cVar2.a.b();
                                    cVar2.a.c();
                                    try {
                                        cVar2.b.e(aVar2);
                                        cVar2.a.l();
                                        cVar2.a.g();
                                        i5++;
                                        z9 = z9;
                                        strArr = strArr;
                                    } catch (Throwable th) {
                                        cVar2.a.g();
                                        throw th;
                                    }
                                }
                            }
                            for (String str4 : uVar.c) {
                                e.b0.x.s.s s = workDatabase.s();
                                r rVar = new r(str4, uVar.a());
                                t tVar = (t) s;
                                tVar.a.b();
                                tVar.a.c();
                                try {
                                    tVar.b.e(rVar);
                                    tVar.a.l();
                                } finally {
                                    tVar.a.g();
                                }
                            }
                            if (!z7) {
                                k p = workDatabase.p();
                                j jVar = new j(str, uVar.a());
                                e.b0.x.s.l lVar2 = (e.b0.x.s.l) p;
                                lVar2.a.b();
                                lVar2.a.c();
                                try {
                                    lVar2.b.e(jVar);
                                    lVar2.a.l();
                                } finally {
                                    lVar2.a.g();
                                }
                            }
                            sVar = sVar;
                            z9 = z9;
                            strArr = strArr;
                            j2 = j3;
                        }
                        b(oVar);
                        if (oVar.b == sVar) {
                        }
                        qVar = (q) workDatabase.r();
                        qVar.a.b();
                        qVar.a.c();
                        try {
                            qVar.b.e(oVar);
                            qVar.a.l();
                            if (z9) {
                            }
                            while (r0.hasNext()) {
                            }
                            if (!z7) {
                            }
                            sVar = sVar;
                            z9 = z9;
                            strArr = strArr;
                            j2 = j3;
                        } finally {
                            qVar.a.g();
                        }
                    }
                    z3 = true;
                    gVar2 = gVar;
                    z2 = z8;
                    gVar2.f1022h = z3;
                    return z | z2;
                }
                if (gVar4 == e.b0.g.KEEP) {
                    Iterator it4 = arrayList2.iterator();
                    while (it4.hasNext()) {
                        s sVar8 = ((o.a) it4.next()).b;
                        if (sVar8 != sVar2) {
                            if (sVar8 == s.RUNNING) {
                            }
                        }
                        z3 = true;
                        z2 = false;
                        gVar2 = gVar;
                    }
                }
                new b(lVar, str, false).run();
                p r = workDatabase.r();
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    ((q) r).a(((o.a) it5.next()).a);
                }
                z7 = z13;
                z9 = z12;
                sVar = sVar2;
                z8 = true;
                while (r4.hasNext()) {
                }
                z3 = true;
                gVar2 = gVar;
                z2 = z8;
                gVar2.f1022h = z3;
                return z | z2;
            }
        }
        z7 = z13;
        sVar = sVar2;
        z9 = z12;
        z8 = false;
        while (r4.hasNext()) {
        }
        z3 = true;
        gVar2 = gVar;
        z2 = z8;
        gVar2.f1022h = z3;
        return z | z2;
    }

    public static void b(o oVar) {
        e.b0.c cVar = oVar.f1120j;
        if (cVar.f987d || cVar.f988e) {
            String str = oVar.c;
            e.a aVar = new e.a();
            aVar.b(oVar.f1115e.a);
            aVar.a.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            oVar.c = ConstraintTrackingWorker.class.getName();
            oVar.f1115e = aVar.a();
        }
    }

    public void run() {
        try {
            g gVar = this.b;
            Objects.requireNonNull(gVar);
            if (!g.b(gVar, new HashSet())) {
                WorkDatabase workDatabase = this.b.a.c;
                workDatabase.c();
                try {
                    boolean a = a(this.b);
                    workDatabase.l();
                    if (a) {
                        f.a(this.b.a.a, RescheduleReceiver.class, true);
                        e.b0.x.l lVar = this.b.a;
                        f.a(lVar.b, lVar.c, lVar.f1030e);
                    }
                    this.c.a(e.b0.o.a);
                } finally {
                    workDatabase.g();
                }
            } else {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.b));
            }
        } catch (Throwable th) {
            this.c.a(new o.b.a(th));
        }
    }
}
