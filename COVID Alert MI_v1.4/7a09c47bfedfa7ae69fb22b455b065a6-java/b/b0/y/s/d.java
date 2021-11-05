package b.b0.y.s;

import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import b.b0.e;
import b.b0.f;
import b.b0.m;
import b.b0.p;
import b.b0.u;
import b.b0.w;
import b.b0.y.c;
import b.b0.y.g;
import b.b0.y.k;
import b.b0.y.r.a;
import b.b0.y.r.b;
import b.b0.y.r.l;
import b.b0.y.r.p;
import b.b0.y.r.q;
import b.b0.y.r.r;
import b.b0.y.r.s;
import b.b0.y.r.t;
import b.s.j;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class d implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1260d = m.e("EnqueueRunnable");

    /* renamed from: b  reason: collision with root package name */
    public final g f1261b;

    /* renamed from: c  reason: collision with root package name */
    public final c f1262c = new c();

    public d(g gVar) {
        this.f1261b = gVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v17, types: [boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x021a  */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static boolean a(g gVar) {
        int i;
        int i2;
        boolean z;
        long j;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        int i4;
        long j2;
        List<g> list = gVar.f1083g;
        if (list != null) {
            i = 0;
            for (g gVar2 : list) {
                if (!gVar2.h) {
                    i |= a(gVar2);
                } else {
                    m.c().f(f1260d, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar2.f1081e)), new Throwable[0]);
                }
            }
        } else {
            i = 0;
        }
        Set<String> c2 = g.c(gVar);
        k kVar = gVar.f1077a;
        List<? extends w> list2 = gVar.f1080d;
        String[] strArr = (String[]) ((AbstractCollection) c2).toArray(new String[0]);
        String str = gVar.f1078b;
        f fVar = gVar.f1079c;
        u uVar = u.ENQUEUED;
        f fVar2 = f.APPEND_OR_REPLACE;
        u uVar2 = u.SUCCEEDED;
        u uVar3 = u.CANCELLED;
        u uVar4 = u.FAILED;
        long currentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase = kVar.f1096c;
        boolean z6 = strArr != null && strArr.length > 0;
        if (z6) {
            int length = strArr.length;
            int i5 = 0;
            z4 = false;
            z3 = false;
            z2 = true;
            while (i5 < length) {
                String str2 = strArr[i5];
                p i6 = ((r) workDatabase.h()).i(str2);
                if (i6 == null) {
                    m.c().b(f1260d, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    break;
                }
                u uVar5 = i6.f1235b;
                z2 &= uVar5 == uVar2;
                if (uVar5 == uVar4) {
                    z3 = true;
                } else if (uVar5 == uVar3) {
                    z4 = true;
                }
                i5++;
                length = length;
                currentTimeMillis = currentTimeMillis;
            }
            j = currentTimeMillis;
        } else {
            j = currentTimeMillis;
            z4 = false;
            z3 = false;
            z2 = true;
        }
        boolean z7 = !TextUtils.isEmpty(str);
        if (z7 && !z6) {
            ArrayList arrayList = (ArrayList) ((r) workDatabase.h()).j(str);
            if (!arrayList.isEmpty()) {
                if (fVar == f.APPEND || fVar == fVar2) {
                    b b2 = workDatabase.b();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        p.a aVar = (p.a) it.next();
                        String str3 = aVar.f1241a;
                        b.b0.y.r.c cVar = (b.b0.y.r.c) b2;
                        if (cVar != null) {
                            j c3 = j.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
                            if (str3 == null) {
                                c3.e(1);
                            } else {
                                c3.f(1, str3);
                            }
                            cVar.f1213a.assertNotSuspendingTransaction();
                            Cursor b3 = b.s.q.b.b(cVar.f1213a, c3, false, null);
                            try {
                                if (!(b3.moveToFirst() && b3.getInt(0) != 0)) {
                                    boolean z8 = z2 & (aVar.f1242b == uVar2);
                                    u uVar6 = aVar.f1242b;
                                    if (uVar6 == uVar4) {
                                        z3 = true;
                                    } else if (uVar6 == uVar3) {
                                        z4 = true;
                                    }
                                    arrayList2.add(aVar.f1241a);
                                    z2 = z8;
                                }
                                it = it;
                                b2 = b2;
                                z7 = z7;
                            } finally {
                                b3.close();
                                c3.g();
                            }
                        } else {
                            throw null;
                        }
                    }
                    z5 = z7;
                    i3 = 0;
                    ArrayList arrayList3 = arrayList2;
                    arrayList3 = arrayList2;
                    if (fVar == fVar2 && (z4 || z3)) {
                        r rVar = (r) workDatabase.h();
                        Iterator it2 = ((ArrayList) rVar.j(str)).iterator();
                        while (it2.hasNext()) {
                            rVar.a(((p.a) it2.next()).f1241a);
                        }
                        z4 = false;
                        z3 = false;
                        arrayList3 = Collections.emptyList();
                    }
                    strArr = (String[]) arrayList3.toArray(strArr);
                    z6 = strArr.length > 0;
                    i4 = i3;
                    for (w wVar : list2) {
                        p pVar = wVar.f1057b;
                        if (z6 && !z2) {
                            if (z3) {
                                pVar.f1235b = uVar4;
                            } else if (z4) {
                                pVar.f1235b = uVar3;
                            } else {
                                pVar.f1235b = u.BLOCKED;
                            }
                            j2 = j;
                        } else if (!pVar.c()) {
                            j2 = j;
                            pVar.n = j2;
                        } else {
                            j2 = j;
                            pVar.n = 0;
                        }
                        if (Build.VERSION.SDK_INT <= 25) {
                            b(pVar);
                        }
                        if (pVar.f1235b == uVar) {
                            i4 = 1;
                        }
                        r rVar2 = (r) workDatabase.h();
                        rVar2.f1243a.assertNotSuspendingTransaction();
                        rVar2.f1243a.beginTransaction();
                        try {
                            rVar2.f1244b.insert(pVar);
                            rVar2.f1243a.setTransactionSuccessful();
                            if (z6) {
                                int length2 = strArr.length;
                                int i7 = i3;
                                while (i7 < length2) {
                                    a aVar2 = new a(wVar.a(), strArr[i7]);
                                    b.b0.y.r.c cVar2 = (b.b0.y.r.c) workDatabase.b();
                                    cVar2.f1213a.assertNotSuspendingTransaction();
                                    cVar2.f1213a.beginTransaction();
                                    try {
                                        cVar2.f1214b.insert(aVar2);
                                        cVar2.f1213a.setTransactionSuccessful();
                                        cVar2.f1213a.endTransaction();
                                        i7++;
                                        i4 = i4;
                                    } catch (Throwable th) {
                                        cVar2.f1213a.endTransaction();
                                        throw th;
                                    }
                                }
                            }
                            for (String str4 : wVar.f1058c) {
                                t i8 = workDatabase.i();
                                s sVar = new s(str4, wVar.a());
                                b.b0.y.r.u uVar7 = (b.b0.y.r.u) i8;
                                uVar7.f1252a.assertNotSuspendingTransaction();
                                uVar7.f1252a.beginTransaction();
                                try {
                                    uVar7.f1253b.insert(sVar);
                                    uVar7.f1252a.setTransactionSuccessful();
                                } finally {
                                    uVar7.f1252a.endTransaction();
                                }
                            }
                            if (z5) {
                                b.b0.y.r.k f2 = workDatabase.f();
                                b.b0.y.r.j jVar = new b.b0.y.r.j(str, wVar.a());
                                l lVar = (l) f2;
                                lVar.f1226a.assertNotSuspendingTransaction();
                                lVar.f1226a.beginTransaction();
                                try {
                                    lVar.f1227b.insert(jVar);
                                    lVar.f1226a.setTransactionSuccessful();
                                } finally {
                                    lVar.f1226a.endTransaction();
                                }
                            }
                            j = j2;
                            i4 = i4;
                            i3 = 0;
                        } finally {
                            rVar2.f1243a.endTransaction();
                        }
                    }
                    z = true;
                    i2 = i4;
                    gVar.h = z;
                    return i | i2;
                }
                if (fVar == f.KEEP) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        u uVar8 = ((p.a) it3.next()).f1242b;
                        if (uVar8 != uVar) {
                            if (uVar8 == u.RUNNING) {
                            }
                        }
                        z = true;
                        i2 = 0;
                    }
                }
                new b(kVar, str, false).run();
                q h = workDatabase.h();
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    ((r) h).a(((p.a) it4.next()).f1241a);
                }
                z5 = z7;
                i4 = 1;
                i3 = 0;
                while (r5.hasNext()) {
                }
                z = true;
                i2 = i4;
                gVar.h = z;
                return i | i2;
            }
        }
        z5 = z7;
        i3 = 0;
        i4 = i3;
        while (r5.hasNext()) {
        }
        z = true;
        i2 = i4;
        gVar.h = z;
        return i | i2;
    }

    public static void b(p pVar) {
        b.b0.c cVar = pVar.j;
        if (cVar.f1012d || cVar.f1013e) {
            String str = pVar.f1236c;
            e.a aVar = new e.a();
            aVar.b(pVar.f1238e.f1028a);
            aVar.f1029a.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f1236c = ConstraintTrackingWorker.class.getName();
            pVar.f1238e = aVar.a();
        }
    }

    public void run() {
        try {
            g gVar = this.f1261b;
            if (gVar == null) {
                throw null;
            } else if (!g.b(gVar, new HashSet())) {
                WorkDatabase workDatabase = this.f1261b.f1077a.f1096c;
                workDatabase.beginTransaction();
                try {
                    boolean a2 = a(this.f1261b);
                    workDatabase.setTransactionSuccessful();
                    if (a2) {
                        f.a(this.f1261b.f1077a.f1094a, RescheduleReceiver.class, true);
                        k kVar = this.f1261b.f1077a;
                        b.b0.y.f.b(kVar.f1095b, kVar.f1096c, kVar.f1098e);
                    }
                    this.f1262c.a(b.b0.p.f1047a);
                } finally {
                    workDatabase.endTransaction();
                }
            } else {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f1261b));
            }
        } catch (Throwable th) {
            this.f1262c.a(new p.b.a(th));
        }
    }
}
