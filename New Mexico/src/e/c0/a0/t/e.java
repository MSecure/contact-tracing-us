package e.c0.a0.t;

import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import e.c0.a0.c;
import e.c0.a0.g;
import e.c0.a0.l;
import e.c0.a0.s.a;
import e.c0.a0.s.b;
import e.c0.a0.s.j;
import e.c0.a0.s.k;
import e.c0.a0.s.o;
import e.c0.a0.s.p;
import e.c0.a0.s.q;
import e.c0.a0.s.r;
import e.c0.a0.s.s;
import e.c0.a0.s.t;
import e.c0.d;
import e.c0.f;
import e.c0.h;
import e.c0.n;
import e.c0.q;
import e.c0.v;
import e.c0.x;
import e.v.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1209d = n.e("EnqueueRunnable");
    public final g b;
    public final c c = new c();

    public e(g gVar) {
        this.b = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0289, code lost:
        if (r9 != false) goto L_0x028b;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x036f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.util.List] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static boolean a(g gVar) {
        boolean z;
        boolean z2;
        boolean z3;
        g gVar2;
        long j2;
        boolean z4;
        boolean z5;
        boolean z6;
        v vVar;
        boolean z7;
        boolean z8;
        boolean z9;
        long j3;
        q qVar;
        boolean z10;
        ArrayList arrayList;
        boolean z11;
        List<g> list = gVar.f1096g;
        if (list != null) {
            z = false;
            for (g gVar3 : list) {
                if (!gVar3.f1097h) {
                    z |= a(gVar3);
                } else {
                    n.c().f(f1209d, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar3.f1094e)), new Throwable[0]);
                }
            }
        } else {
            z = false;
        }
        Set<String> c = g.c(gVar);
        l lVar = gVar.a;
        List<? extends x> list2 = gVar.f1093d;
        String[] strArr = (String[]) c.toArray(new String[0]);
        String str = gVar.b;
        h hVar = gVar.c;
        v vVar2 = v.ENQUEUED;
        h hVar2 = h.APPEND_OR_REPLACE;
        v vVar3 = v.SUCCEEDED;
        v vVar4 = v.CANCELLED;
        v vVar5 = v.FAILED;
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
                    n.c().b(f1209d, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    break;
                }
                v vVar6 = i3.b;
                z4 &= vVar6 == vVar3;
                if (vVar6 == vVar5) {
                    z5 = true;
                } else if (vVar6 == vVar4) {
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
                if (hVar == h.APPEND || hVar == hVar2) {
                    b m = workDatabase.m();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        o.a aVar = (o.a) it.next();
                        String str3 = aVar.a;
                        e.c0.a0.s.c cVar = (e.c0.a0.s.c) m;
                        Objects.requireNonNull(cVar);
                        i t = i.t("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
                        if (str3 == null) {
                            t.J(1);
                        } else {
                            t.L(1, str3);
                        }
                        cVar.a.b();
                        Cursor b = e.v.p.b.b(cVar.a, t, false, null);
                        try {
                            if (!(b.moveToFirst() && b.getInt(0) != 0)) {
                                v vVar7 = aVar.b;
                                z4 &= vVar7 == vVar3;
                                if (vVar7 == vVar5) {
                                    z5 = true;
                                } else if (vVar7 == vVar4) {
                                    z6 = true;
                                }
                                arrayList3.add(aVar.a);
                            }
                            it = it;
                            z13 = z13;
                            m = m;
                            vVar2 = vVar2;
                        } finally {
                            b.close();
                            t.Q();
                        }
                    }
                    z7 = z13;
                    vVar = vVar2;
                    if (hVar != hVar2 || (!z6 && !z5)) {
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
                    for (x xVar : list2) {
                        o oVar = xVar.b;
                        if (z9 && !z4) {
                            if (z5) {
                                oVar.b = vVar5;
                            } else if (z6) {
                                oVar.b = vVar4;
                            } else {
                                oVar.b = v.BLOCKED;
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
                        try {
                            if (i4 < 23 || i4 > 25) {
                                if (i4 <= 22) {
                                    try {
                                        Class<?> cls = Class.forName("androidx.work.impl.background.gcm.GcmScheduler");
                                        for (e.c0.a0.e eVar : lVar.f1107e) {
                                            if (cls.isAssignableFrom(eVar.getClass())) {
                                                z10 = true;
                                                break;
                                            }
                                        }
                                    } catch (ClassNotFoundException unused) {
                                    }
                                    z10 = false;
                                }
                                if (oVar.b == vVar) {
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
                                        a aVar2 = new a(xVar.a(), strArr[i5]);
                                        e.c0.a0.s.c cVar2 = (e.c0.a0.s.c) workDatabase.m();
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
                                for (String str4 : xVar.c) {
                                    s s = workDatabase.s();
                                    r rVar = new r(str4, xVar.a());
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
                                    j jVar = new j(str, xVar.a());
                                    e.c0.a0.s.l lVar2 = (e.c0.a0.s.l) p;
                                    lVar2.a.b();
                                    lVar2.a.c();
                                    try {
                                        lVar2.b.e(jVar);
                                        lVar2.a.l();
                                    } finally {
                                        lVar2.a.g();
                                    }
                                }
                                vVar = vVar;
                                z9 = z9;
                                strArr = strArr;
                                j2 = j3;
                            }
                            qVar.b.e(oVar);
                            qVar.a.l();
                            if (z9) {
                            }
                            while (r0.hasNext()) {
                            }
                            if (!z7) {
                            }
                            vVar = vVar;
                            z9 = z9;
                            strArr = strArr;
                            j2 = j3;
                        } finally {
                            qVar.a.g();
                        }
                        b(oVar);
                        if (oVar.b == vVar) {
                        }
                        qVar = (q) workDatabase.r();
                        qVar.a.b();
                        qVar.a.c();
                    }
                    z3 = true;
                    gVar2 = gVar;
                    z2 = z8;
                    gVar2.f1097h = z3;
                    return z | z2;
                }
                if (hVar == h.KEEP) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        v vVar8 = ((o.a) it3.next()).b;
                        if (vVar8 != vVar2) {
                            if (vVar8 == v.RUNNING) {
                            }
                        }
                        z3 = true;
                        z2 = false;
                        gVar2 = gVar;
                    }
                }
                new b(lVar, str, false).run();
                p r = workDatabase.r();
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    ((q) r).a(((o.a) it4.next()).a);
                }
                z7 = z13;
                z9 = z12;
                vVar = vVar2;
                z8 = true;
                while (r4.hasNext()) {
                }
                z3 = true;
                gVar2 = gVar;
                z2 = z8;
                gVar2.f1097h = z3;
                return z | z2;
            }
        }
        z7 = z13;
        vVar = vVar2;
        z9 = z12;
        z8 = false;
        while (r4.hasNext()) {
        }
        z3 = true;
        gVar2 = gVar;
        z2 = z8;
        gVar2.f1097h = z3;
        return z | z2;
    }

    public static void b(o oVar) {
        d dVar = oVar.f1197j;
        String str = oVar.c;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (dVar.f1241d || dVar.f1242e) {
            f.a aVar = new f.a();
            aVar.b(oVar.f1192e.a);
            aVar.a.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            oVar.c = ConstraintTrackingWorker.class.getName();
            oVar.f1192e = aVar.a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            g gVar = this.b;
            Objects.requireNonNull(gVar);
            if (!g.b(gVar, new HashSet())) {
                WorkDatabase workDatabase = this.b.a.c;
                workDatabase.c();
                boolean a = a(this.b);
                workDatabase.l();
                workDatabase.g();
                if (a) {
                    g.a(this.b.a.a, RescheduleReceiver.class, true);
                    l lVar = this.b.a;
                    e.c0.a0.f.a(lVar.b, lVar.c, lVar.f1107e);
                }
                this.c.a(e.c0.q.a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.b));
        } catch (Throwable th) {
            this.c.a(new q.b.a(th));
        }
    }
}
