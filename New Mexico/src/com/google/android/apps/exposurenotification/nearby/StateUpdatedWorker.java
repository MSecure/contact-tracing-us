package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import e.b.a.m;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.c0.e1;
import f.b.a.a.a.c0.f1;
import f.b.a.a.a.c0.l1;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.h0.a;
import f.b.a.a.a.h0.p;
import f.b.a.a.a.j0.b;
import f.b.a.a.a.j0.c;
import f.b.a.a.a.j0.e;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.b1;
import f.b.a.a.a.n0.x0;
import f.b.a.a.a.n0.z0;
import f.b.a.a.a.t.g0;
import f.b.a.a.a.t.h0;
import f.b.a.c.i.f;
import f.b.a.c.i.h;
import f.b.b.a.g;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import gov.nm.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.a;
import l.b.a.d;
/* loaded from: classes.dex */
public class StateUpdatedWorker extends ListenableWorker {
    public static final f.b.a.a.a.t.p0.a s = f.b.a.a.a.t.p0.a.e("StateUpdatedWorker");
    public static final d t = d.n(120);
    public static final d u = d.h(24);

    /* renamed from: g */
    public final Context f395g;

    /* renamed from: h */
    public final b1 f396h;

    /* renamed from: i */
    public final q1 f397i;

    /* renamed from: j */
    public final e f398j;

    /* renamed from: k */
    public final DailySummariesConfig f399k;

    /* renamed from: l */
    public final c f400l;
    public final h0 m;
    public final ExecutorService n;
    public final ScheduledExecutorService o;
    public final r p;
    public final f.b.a.a.a.t.q0.a q;
    public a1 r;

    /* loaded from: classes.dex */
    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public StateUpdatedWorker(Context context, WorkerParameters workerParameters, b1 b1Var, q1 q1Var, a1 a1Var, e eVar, DailySummariesConfig dailySummariesConfig, c cVar, h0 h0Var, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, r rVar, f.b.a.a.a.t.q0.a aVar) {
        super(context, workerParameters);
        this.f395g = context;
        this.f396h = b1Var;
        this.f397i = q1Var;
        this.r = a1Var;
        this.f398j = eVar;
        this.f399k = dailySummariesConfig;
        this.f400l = cVar;
        this.m = h0Var;
        this.n = executorService;
        this.o = scheduledExecutorService;
        this.p = rVar;
        this.q = aVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        q1 q1Var = this.f397i;
        l y = l.x(m.e.o0(q1Var.a.d(this.f399k).d(new f.b.a.c.i.e() { // from class: f.b.a.a.a.c0.m
            @Override // f.b.a.c.i.e
            public final void b(Exception exc) {
                q1.this.b.d(a.b.CALL_GET_DAILY_SUMMARIES, exc);
            }
        }).f(new f() { // from class: f.b.a.a.a.c0.g
            @Override // f.b.a.c.i.f
            public final void a(Object obj) {
                List list = (List) obj;
                q1.this.b.f(a.b.CALL_GET_DAILY_SUMMARIES);
            }
        }).h(new f.b.a.c.i.a() { // from class: f.b.a.a.a.c0.k
            @Override // f.b.a.c.i.a
            public final Object a(h hVar) {
                Objects.requireNonNull(q1.this);
                List<DailySummary> list = (List) hVar.l();
                ArrayList arrayList = new ArrayList(list.size());
                for (DailySummary dailySummary : list) {
                    ArrayList arrayList2 = new ArrayList(6);
                    for (int i2 = 0; i2 < 6; i2++) {
                        arrayList2.add(l1.a.d().a());
                    }
                    Integer valueOf = Integer.valueOf(dailySummary.b);
                    DailySummary.ExposureSummaryData exposureSummaryData = dailySummary.f482d;
                    l1.a.AbstractC0071a d2 = l1.a.d();
                    d2.b(exposureSummaryData.b);
                    d2.c(exposureSummaryData.c);
                    d2.d(exposureSummaryData.f484d);
                    l1.a a2 = d2.a();
                    f.b.b.b.a t2 = f.b.b.b.c.y(0, 1, 2, 3, 4, 5).listIterator();
                    while (t2.hasNext()) {
                        int intValue = ((Integer) t2.next()).intValue();
                        DailySummary.ExposureSummaryData exposureSummaryData2 = dailySummary.c.get(intValue);
                        l1.a.AbstractC0071a d3 = l1.a.d();
                        d3.b(exposureSummaryData2.b);
                        d3.c(exposureSummaryData2.c);
                        d3.d(exposureSummaryData2.f484d);
                        arrayList2.set(intValue, d3.a());
                    }
                    String str = valueOf == null ? " daysSinceEpoch" : "";
                    if (str.isEmpty()) {
                        arrayList.add(new j1(valueOf.intValue(), a2, arrayList2, null));
                    } else {
                        throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", str));
                    }
                }
                return f.b.b.b.c.s(arrayList);
            }
        }), t, this.o)).z(new i() { // from class: f.b.a.a.a.c0.h1
            /* JADX WARN: Finally extract failed */
            /* JADX WARN: Removed duplicated region for block: B:116:0x035e  */
            /* JADX WARN: Removed duplicated region for block: B:117:0x0371  */
            /* JADX WARN: Removed duplicated region for block: B:119:0x0374  */
            /* JADX WARN: Removed duplicated region for block: B:121:0x0387 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:125:0x0391  */
            /* JADX WARN: Removed duplicated region for block: B:131:0x0404  */
            /* JADX WARN: Removed duplicated region for block: B:136:0x042c  */
            /* JADX WARN: Removed duplicated region for block: B:137:0x0438  */
            /* JADX WARN: Removed duplicated region for block: B:150:0x00ff A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
            @Override // f.b.b.f.a.i
            /* Code decompiled incorrectly, please refer to instructions dump */
            public final u a(Object obj) {
                f.b.a.a.a.j0.a aVar;
                int i2;
                boolean z;
                int i3;
                int i4;
                boolean z2;
                String str;
                f.b.a.a.a.t.p0.a aVar2;
                x0 x0Var;
                int i5;
                boolean z3;
                Double d2;
                b[] bVarArr;
                boolean z4;
                int i6;
                int i7;
                StateUpdatedWorker stateUpdatedWorker = StateUpdatedWorker.this;
                List<l1> list = (List) obj;
                stateUpdatedWorker.p.i(p.d.TASK_STATE_UPDATED);
                Context context = stateUpdatedWorker.f395g;
                Objects.requireNonNull(stateUpdatedWorker.f398j);
                ArrayList arrayList = new ArrayList();
                for (l1 l1Var : list) {
                    arrayList.add(z0.a((long) l1Var.a(), l1Var.c().b()));
                }
                c cVar = stateUpdatedWorker.f400l;
                Objects.requireNonNull(cVar);
                f.b.a.a.a.t.p0.a aVar3 = c.b;
                StringBuilder h2 = f.a.a.a.a.h("Classifying dailySummaries [");
                h2.append(TextUtils.join(", ", list));
                h2.append("] using classificationThresholds ");
                h2.append(Arrays.toString(cVar.a));
                aVar3.a(h2.toString());
                Iterator it = list.iterator();
                b bVar = null;
                long j2 = 0;
                while (true) {
                    int i8 = 1;
                    if (!it.hasNext()) {
                        break;
                    }
                    l1 l1Var2 = (l1) it.next();
                    b[] bVarArr2 = cVar.a;
                    int length = bVarArr2.length;
                    int i9 = 0;
                    while (i9 < length) {
                        b bVar2 = bVarArr2[i9];
                        if (f.a.a.a.a.q(l1Var2, i8, cVar, bVar2.c) || f.a.a.a.a.q(l1Var2, 2, cVar, bVar2.f2286d) || f.a.a.a.a.q(l1Var2, 3, cVar, bVar2.f2287e) || f.a.a.a.a.q(l1Var2, 4, cVar, bVar2.f2288f)) {
                            bVarArr = bVarArr2;
                        } else {
                            bVarArr = bVarArr2;
                            if (!cVar.a(bVar2.f2289g, l1Var2.c().b()) && !cVar.a(bVar2.f2290h, l1Var2.c().a()) && !cVar.a(bVar2.f2291i, l1Var2.c().c())) {
                                z4 = false;
                                if (z4) {
                                    if (bVar == null || (i6 = bVar2.a) < (i7 = bVar.a)) {
                                        j2 = (long) l1Var2.a();
                                        bVar = bVar2;
                                    } else if (i7 == i6) {
                                        j2 = Math.max(j2, (long) l1Var2.a());
                                    }
                                }
                                i9++;
                                i8 = 1;
                                bVarArr2 = bVarArr;
                            }
                        }
                        z4 = true;
                        if (z4) {
                        }
                        i9++;
                        i8 = 1;
                        bVarArr2 = bVarArr;
                    }
                }
                if (bVar == null) {
                    aVar = new f.b.a.a.a.j0.a(0, "No Exposure", 0);
                } else {
                    aVar = new f.b.a.a.a.j0.a(bVar.a, bVar.b, j2);
                }
                f.b.a.a.a.j0.d b2 = stateUpdatedWorker.r.b();
                f.b.a.a.a.t.p0.a aVar4 = StateUpdatedWorker.s;
                aVar4.a("Current ExposureClassification: " + aVar);
                aVar4.a("Previous ExposureClassification: " + b2);
                boolean z5 = b2.b() != aVar.b() || !b2.c().equals(aVar.c());
                boolean z6 = b2.a() != aVar.a();
                try {
                    if (z5 || z6) {
                        if (b2.b() == 0 || aVar.b() != 0) {
                            int b3 = aVar.b();
                            if (b3 == 1) {
                                i3 = R.string.exposure_notification_title_1;
                            } else if (b3 == 2) {
                                i3 = R.string.exposure_notification_title_2;
                            } else if (b3 == 3) {
                                i3 = R.string.exposure_notification_title_3;
                            } else if (b3 == 4) {
                                i3 = R.string.exposure_notification_title_4;
                            } else {
                                throw new IllegalArgumentException("Classification index must be between 1 and 4");
                            }
                            int b4 = aVar.b();
                            if (b4 == 1) {
                                i5 = R.string.exposure_notification_message_1;
                            } else if (b4 == 2) {
                                i5 = R.string.exposure_notification_message_2;
                            } else if (b4 == 3) {
                                i5 = R.string.exposure_notification_message_3;
                            } else if (b4 == 4) {
                                i5 = R.string.exposure_notification_message_4;
                            } else {
                                throw new IllegalArgumentException("Classification index must be between 1 and 4");
                            }
                            z = false;
                            i2 = i5;
                            stateUpdatedWorker.r.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", aVar.b()).putString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", aVar.c()).putLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", aVar.a()).commit();
                            stateUpdatedWorker.r.a.edit().putBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", z).commit();
                            if (z5) {
                                i4 = 0;
                                stateUpdatedWorker.r.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", 0).apply();
                            } else {
                                i4 = 0;
                            }
                            if (z6) {
                                stateUpdatedWorker.r.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", i4).apply();
                            }
                            z2 = i3 == 0 || i2 != 0;
                            if (z2) {
                                stateUpdatedWorker.m.c(context, i3, i2, g0.a(context), g0.b(context));
                                a1 a1Var = stateUpdatedWorker.r;
                                l.b.a.e c = stateUpdatedWorker.q.c();
                                if (a1Var.j() && aVar.b() > 0) {
                                    a1Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", aVar.b()).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", c.G()).putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_EXPOSURE_TIME", aVar.a()).apply();
                                }
                                aVar2 = StateUpdatedWorker.s;
                                StringBuilder h3 = f.a.a.a.a.h("Notifying user: ");
                                h3.append(context.getResources().getString(i3));
                                h3.append(" - ");
                                h3.append(context.getResources().getString(i2));
                                str = h3.toString();
                            } else {
                                aVar2 = StateUpdatedWorker.s;
                                str = "No new exposure information, not notifying user";
                            }
                            aVar2.a(str);
                            x0Var = (x0) stateUpdatedWorker.f396h.a;
                            x0Var.a.c();
                            x0.a(x0Var, arrayList);
                            x0Var.a.l();
                            x0Var.a.g();
                            stateUpdatedWorker.p.g(p.d.TASK_STATE_UPDATED);
                            if (z2) {
                                return new s.a(new StateUpdatedWorker.b(null));
                            }
                            return m.e.o0(stateUpdatedWorker.f397i.b(), StateUpdatedWorker.t, stateUpdatedWorker.o);
                        }
                        x0 x0Var2 = (x0) stateUpdatedWorker.f396h.a;
                        Objects.requireNonNull(x0Var2);
                        e.v.i t2 = e.v.i.t("SELECT * FROM ExposureEntity", 0);
                        x0Var2.a.b();
                        Cursor b5 = e.v.p.b.b(x0Var2.a, t2, false, null);
                        try {
                            int h0 = m.e.h0(b5, "dateDaysSinceEpoch");
                            int h02 = m.e.h0(b5, "exposureScore");
                            ArrayList arrayList2 = new ArrayList(b5.getCount());
                            while (b5.moveToNext()) {
                                arrayList2.add(z0.a(b5.getLong(h0), b5.getDouble(h02)));
                            }
                            b5.close();
                            t2.Q();
                            e eVar = stateUpdatedWorker.f398j;
                            Objects.requireNonNull(eVar);
                            HashMap hashMap = new HashMap();
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                z0 z0Var = (z0) it2.next();
                                hashMap.put(Long.valueOf(z0Var.b()), Double.valueOf(z0Var.c()));
                            }
                            long j3 = (long) eVar.a.f478f;
                            if (j3 == 0) {
                                j3 = 14;
                            }
                            f.b.a.a.a.t.p0.a aVar5 = e.b;
                            StringBuilder h4 = f.a.a.a.a.h("Checking for possible revocation with previousExposureEntities [");
                            h4.append(TextUtils.join(", ", arrayList2));
                            h4.append("], currentExposureEntities [");
                            h4.append(TextUtils.join(", ", arrayList));
                            h4.append("] and daysSinceExposureThreshold ");
                            h4.append(j3);
                            aVar5.a(h4.toString());
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                z0 z0Var2 = (z0) it3.next();
                                l.b.a.r rVar = l.b.a.r.f4641g;
                                l.b.a.f fVar = l.b.a.f.f4612e;
                                g.b.a.c.c.d.u(rVar, "zone");
                                if (l.b.a.f.O(new a.C0156a(rVar)).M(z0Var2.b()).x() <= j3 && ((d2 = (Double) hashMap.get(Long.valueOf(z0Var2.b()))) == null || d2.doubleValue() < z0Var2.c())) {
                                    f.b.a.a.a.t.p0.a aVar6 = e.b;
                                    StringBuilder h5 = f.a.a.a.a.h("Revocation detected on day ");
                                    h5.append(z0Var2.b());
                                    aVar6.a(h5.toString());
                                    z3 = true;
                                    break;
                                }
                            }
                            e.b.a("No revocation detected");
                            z3 = false;
                            if (z3) {
                                i3 = R.string.exposure_notification_title_revoked;
                                z = true;
                                i2 = R.string.exposure_notification_message_revoked;
                                stateUpdatedWorker.r.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", aVar.b()).putString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", aVar.c()).putLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", aVar.a()).commit();
                                stateUpdatedWorker.r.a.edit().putBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", z).commit();
                                if (z5) {
                                }
                                if (z6) {
                                }
                                if (i3 == 0) {
                                }
                                if (z2) {
                                }
                                aVar2.a(str);
                                x0Var = (x0) stateUpdatedWorker.f396h.a;
                                x0Var.a.c();
                                x0.a(x0Var, arrayList);
                                x0Var.a.l();
                                x0Var.a.g();
                                stateUpdatedWorker.p.g(p.d.TASK_STATE_UPDATED);
                                if (z2) {
                                }
                            }
                        } catch (Throwable th) {
                            b5.close();
                            t2.Q();
                            throw th;
                        }
                    }
                    x0.a(x0Var, arrayList);
                    x0Var.a.l();
                    x0Var.a.g();
                    stateUpdatedWorker.p.g(p.d.TASK_STATE_UPDATED);
                    if (z2) {
                    }
                } catch (Throwable th2) {
                    x0Var.a.g();
                    throw th2;
                }
                i3 = 0;
                i5 = 0;
                z = false;
                i2 = i5;
                stateUpdatedWorker.r.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", aVar.b()).putString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", aVar.c()).putLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", aVar.a()).commit();
                stateUpdatedWorker.r.a.edit().putBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", z).commit();
                if (z5) {
                }
                if (z6) {
                }
                if (i3 == 0) {
                }
                if (z2) {
                }
                aVar2.a(str);
                x0Var = (x0) stateUpdatedWorker.f396h.a;
                x0Var.a.c();
            }
        }, this.n).y(new g() { // from class: f.b.a.a.a.c0.g1
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                StateUpdatedWorker stateUpdatedWorker = StateUpdatedWorker.this;
                Set<f.b.a.c.f.b.d> set = (Set) obj;
                if (!stateUpdatedWorker.r.a.getBoolean("ExposureNotificationSharedPreferences.BLE_LOC_OFF_NOTIFICATION_SEEN", false) && ((f.b.a.a.a.j0.a) stateUpdatedWorker.r.b()).a == 0 && !stateUpdatedWorker.r.g()) {
                    long j2 = stateUpdatedWorker.r.a.getLong("ExposureNotificationSharedPreferences.BEGIN_TIMESTAMP_BLE_LOC_OFF", -1);
                    f.b.b.a.l c = j2 != -1 ? f.b.b.a.l.c(l.b.a.e.z(j2)) : f.b.b.a.a.b;
                    if (!set.contains(f.b.a.c.f.b.d.LOCATION_DISABLED) && !set.contains(f.b.a.c.f.b.d.BLUETOOTH_DISABLED) && !set.contains(f.b.a.c.f.b.d.BLUETOOTH_SUPPORT_UNKNOWN)) {
                        c = f.b.b.a.a.b;
                    } else if (!c.b()) {
                        c = f.b.b.a.l.c(stateUpdatedWorker.q.c());
                    }
                    if (c.b()) {
                        d c2 = d.c((l.b.a.x.d) c.a(), stateUpdatedWorker.q.c());
                        d dVar = StateUpdatedWorker.u;
                        int e2 = g.b.a.c.c.d.e(c2.b, dVar.b);
                        if (e2 == 0) {
                            e2 = c2.c - dVar.c;
                        }
                        if (e2 >= 0) {
                            if (stateUpdatedWorker.g(set) != 0) {
                                stateUpdatedWorker.m.c(stateUpdatedWorker.f395g, R.string.updated_permission_disabled_notification_title, stateUpdatedWorker.g(set), g0.a(stateUpdatedWorker.f395g), g0.b(stateUpdatedWorker.f395g));
                            }
                            a1 a1Var = stateUpdatedWorker.r;
                            f.a.a.a.a.o(a1Var.a, "ExposureNotificationSharedPreferences.BLE_LOC_OFF_NOTIFICATION_SEEN", true);
                            a1Var.a.edit().remove("ExposureNotificationSharedPreferences.BEGIN_TIMESTAMP_BLE_LOC_OFF").apply();
                        }
                    }
                    a1 a1Var2 = stateUpdatedWorker.r;
                    Objects.requireNonNull(a1Var2);
                    boolean b2 = c.b();
                    SharedPreferences.Editor edit = a1Var2.a.edit();
                    (b2 ? edit.putLong("ExposureNotificationSharedPreferences.BEGIN_TIMESTAMP_BLE_LOC_OFF", ((l.b.a.e) c.a()).G()) : edit.remove("ExposureNotificationSharedPreferences.BEGIN_TIMESTAMP_BLE_LOC_OFF")).apply();
                }
                return new ListenableWorker.a.c();
            }
        }, this.n);
        e1 e1Var = e1.a;
        ExecutorService executorService = this.n;
        a.b bVar = new a.b(y, b.class, e1Var);
        y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
        f1 f1Var = new g() { // from class: f.b.a.a.a.c0.f1
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                StateUpdatedWorker stateUpdatedWorker = StateUpdatedWorker.this;
                Exception exc = (Exception) obj;
                Objects.requireNonNull(stateUpdatedWorker);
                StateUpdatedWorker.s.d("Failure to update app state (tokens, etc) from exposure summary.", exc);
                stateUpdatedWorker.p.k(p.d.TASK_STATE_UPDATED, exc);
                return new ListenableWorker.a.C0003a();
            }
        };
        ExecutorService executorService2 = this.n;
        a.b bVar2 = new a.b(bVar, Exception.class, f1Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.k1(executorService2, bVar2));
        return bVar2;
    }

    public final int g(Set<f.b.a.c.f.b.d> set) {
        f.b.a.c.f.b.d dVar = f.b.a.c.f.b.d.BLUETOOTH_SUPPORT_UNKNOWN;
        f.b.a.c.f.b.d dVar2 = f.b.a.c.f.b.d.BLUETOOTH_DISABLED;
        f.b.a.c.f.b.d dVar3 = f.b.a.c.f.b.d.LOCATION_DISABLED;
        if (set.contains(dVar3) && (set.contains(dVar2) || set.contains(dVar))) {
            return R.string.updated_bluetooth_location_state_notification;
        }
        if (set.contains(dVar2) || set.contains(dVar)) {
            return R.string.updated_bluetooth_state_notification;
        }
        if (set.contains(dVar3)) {
            return R.string.updated_location_state_notification;
        }
        return 0;
    }
}
