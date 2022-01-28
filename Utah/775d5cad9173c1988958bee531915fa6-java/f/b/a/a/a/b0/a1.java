package f.b.a.a.a.b0;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import e.b.a.m;
import f.b.a.a.a.g0.p;
import f.b.a.a.a.h0.a;
import f.b.a.a.a.h0.b;
import f.b.a.a.a.h0.c;
import f.b.a.a.a.h0.d;
import f.b.a.a.a.l0.t0;
import f.b.a.a.a.l0.u0;
import f.b.a.a.a.l0.v0;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import gov.ut.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l.b.a.a;
import l.b.a.e;
import l.b.a.f;
import l.b.a.r;

public final /* synthetic */ class a1 implements i {
    public final /* synthetic */ StateUpdatedWorker a;

    public /* synthetic */ a1(StateUpdatedWorker stateUpdatedWorker) {
        this.a = stateUpdatedWorker;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0387 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0438  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x00ff A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e4  */
    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        a aVar;
        int i2;
        boolean z;
        int i3;
        int i4;
        boolean z2;
        String str;
        f.b.a.a.a.s.d0.a aVar2;
        t0 t0Var;
        int i5;
        boolean z3;
        u0 u0Var;
        Double d2;
        b[] bVarArr;
        boolean z4;
        int i6;
        int i7;
        StateUpdatedWorker stateUpdatedWorker = this.a;
        List<e1> list = (List) obj;
        stateUpdatedWorker.p.i(p.d.TASK_STATE_UPDATED);
        Context context = stateUpdatedWorker.f388g;
        Objects.requireNonNull(stateUpdatedWorker.f391j);
        ArrayList arrayList = new ArrayList();
        for (e1 e1Var : list) {
            arrayList.add(u0.a((long) e1Var.a(), e1Var.c().b()));
        }
        c cVar = stateUpdatedWorker.f393l;
        Objects.requireNonNull(cVar);
        f.b.a.a.a.s.d0.a aVar3 = c.b;
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
            e1 e1Var2 = (e1) it.next();
            b[] bVarArr2 = cVar.a;
            int length = bVarArr2.length;
            int i9 = 0;
            while (i9 < length) {
                b bVar2 = bVarArr2[i9];
                if (f.a.a.a.a.p(e1Var2, i8, cVar, bVar2.c) || f.a.a.a.a.p(e1Var2, 2, cVar, bVar2.f2249d) || f.a.a.a.a.p(e1Var2, 3, cVar, bVar2.f2250e) || f.a.a.a.a.p(e1Var2, 4, cVar, bVar2.f2251f)) {
                    bVarArr = bVarArr2;
                } else {
                    bVarArr = bVarArr2;
                    if (!cVar.a(bVar2.f2252g, e1Var2.c().b()) && !cVar.a(bVar2.f2253h, e1Var2.c().a()) && !cVar.a(bVar2.f2254i, e1Var2.c().c())) {
                        z4 = false;
                        if (z4) {
                            if (bVar == null || (i6 = bVar2.a) < (i7 = bVar.a)) {
                                j2 = (long) e1Var2.a();
                                bVar = bVar2;
                            } else if (i7 == i6) {
                                j2 = Math.max(j2, (long) e1Var2.a());
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
            aVar = new a(0, "No Exposure", 0);
        } else {
            aVar = new a(bVar.a, bVar.b, j2);
        }
        d a2 = stateUpdatedWorker.r.a();
        f.b.a.a.a.s.d0.a aVar4 = StateUpdatedWorker.s;
        aVar4.a("Current ExposureClassification: " + aVar);
        aVar4.a("Previous ExposureClassification: " + a2);
        boolean z5 = a2.b() != aVar.b() || !a2.c().equals(aVar.c());
        boolean z6 = a2.a() != aVar.a();
        if (z5 || z6) {
            if (a2.b() == 0 || aVar.b() != 0) {
                int b = aVar.b();
                if (b == 1) {
                    i3 = R.string.exposure_notification_title_1;
                } else if (b == 2) {
                    i3 = R.string.exposure_notification_title_2;
                } else if (b == 3) {
                    i3 = R.string.exposure_notification_title_3;
                } else if (b == 4) {
                    i3 = R.string.exposure_notification_title_4;
                } else {
                    throw new IllegalArgumentException("Classification index must be between 1 and 4");
                }
                int b2 = aVar.b();
                if (b2 == 1) {
                    i5 = R.string.exposure_notification_message_1;
                } else if (b2 == 2) {
                    i5 = R.string.exposure_notification_message_2;
                } else if (b2 == 3) {
                    i5 = R.string.exposure_notification_message_3;
                } else if (b2 == 4) {
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
                    stateUpdatedWorker.m.c(context, i3, i2, f.b.a.a.a.s.u.a(context), f.b.a.a.a.s.u.b(context));
                    v0 v0Var = stateUpdatedWorker.r;
                    e c = stateUpdatedWorker.q.c();
                    if (v0Var.g() && aVar.b() > 0) {
                        v0Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", aVar.b()).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", c.G()).putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_EXPOSURE_TIME", aVar.a()).apply();
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
                t0Var = (t0) stateUpdatedWorker.f389h.a;
                t0Var.a.c();
                t0.a(t0Var, arrayList);
                t0Var.a.l();
                t0Var.a.g();
                stateUpdatedWorker.p.g(p.d.TASK_STATE_UPDATED);
                if (z2) {
                    return new s.a(new StateUpdatedWorker.b(null));
                }
                return m.e.m0(stateUpdatedWorker.f390i.a.getStatus(), StateUpdatedWorker.t, stateUpdatedWorker.o);
            }
            t0 t0Var2 = (t0) stateUpdatedWorker.f389h.a;
            Objects.requireNonNull(t0Var2);
            e.u.i t = e.u.i.t("SELECT * FROM ExposureEntity", 0);
            t0Var2.a.b();
            Cursor b3 = e.u.p.b.b(t0Var2.a, t, false, null);
            try {
                int g0 = m.e.g0(b3, "dateDaysSinceEpoch");
                int g02 = m.e.g0(b3, "exposureScore");
                ArrayList arrayList2 = new ArrayList(b3.getCount());
                while (b3.moveToNext()) {
                    arrayList2.add(u0.a(b3.getLong(g0), b3.getDouble(g02)));
                }
                b3.close();
                t.Q();
                f.b.a.a.a.h0.e eVar = stateUpdatedWorker.f391j;
                Objects.requireNonNull(eVar);
                HashMap hashMap = new HashMap();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    u0 u0Var2 = (u0) it2.next();
                    hashMap.put(Long.valueOf(u0Var2.b()), Double.valueOf(u0Var2.c()));
                }
                long j3 = (long) eVar.a.f468f;
                if (j3 == 0) {
                    j3 = 14;
                }
                f.b.a.a.a.s.d0.a aVar5 = f.b.a.a.a.h0.e.b;
                StringBuilder h4 = f.a.a.a.a.h("Checking for possible revocation with previousExposureEntities [");
                h4.append(TextUtils.join(", ", arrayList2));
                h4.append("], currentExposureEntities [");
                h4.append(TextUtils.join(", ", arrayList));
                h4.append("] and daysSinceExposureThreshold ");
                h4.append(j3);
                aVar5.a(h4.toString());
                Iterator it3 = arrayList2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        f.b.a.a.a.h0.e.b.a("No revocation detected");
                        z3 = false;
                        break;
                    }
                    u0Var = (u0) it3.next();
                    r rVar = r.f4386g;
                    f fVar = f.f4357e;
                    g.b.a.c.c.d.u(rVar, "zone");
                    if (f.O(new a.C0154a(rVar)).M(u0Var.b()).x() > j3 || ((d2 = (Double) hashMap.get(Long.valueOf(u0Var.b()))) != null && d2.doubleValue() >= u0Var.c())) {
                    }
                }
                f.b.a.a.a.s.d0.a aVar6 = f.b.a.a.a.h0.e.b;
                StringBuilder h5 = f.a.a.a.a.h("Revocation detected on day ");
                h5.append(u0Var.b());
                aVar6.a(h5.toString());
                z3 = true;
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
                    t0Var = (t0) stateUpdatedWorker.f389h.a;
                    t0Var.a.c();
                    t0.a(t0Var, arrayList);
                    t0Var.a.l();
                    t0Var.a.g();
                    stateUpdatedWorker.p.g(p.d.TASK_STATE_UPDATED);
                    if (z2) {
                    }
                }
            } catch (Throwable th) {
                b3.close();
                t.Q();
                throw th;
            }
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
        t0Var = (t0) stateUpdatedWorker.f389h.a;
        t0Var.a.c();
        try {
            t0.a(t0Var, arrayList);
            t0Var.a.l();
            t0Var.a.g();
            stateUpdatedWorker.p.g(p.d.TASK_STATE_UPDATED);
            if (z2) {
            }
        } catch (Throwable th2) {
            t0Var.a.g();
            throw th2;
        }
    }
}
