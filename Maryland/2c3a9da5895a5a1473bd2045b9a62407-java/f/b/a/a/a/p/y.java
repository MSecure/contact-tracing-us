package f.b.a.a.a.p;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import com.google.android.apps.exposurenotification.home.ExposureNotificationActivity;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import e.b.a.m;
import e.i.a.j;
import e.i.a.k;
import e.i.a.o;
import e.t.i;
import f.b.a.a.a.u.u;
import f.b.a.a.a.v.a;
import f.b.a.a.a.v.b;
import f.b.a.a.a.v.c;
import f.b.a.a.a.v.d;
import f.b.a.a.a.v.e;
import f.b.a.a.a.y.o0;
import f.b.a.a.a.y.p0;
import f.b.a.a.a.y.q0;
import f.b.b.a.g;
import gov.md.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l.b.a.q;

public final /* synthetic */ class y implements g {
    public final /* synthetic */ StateUpdatedWorker a;

    public /* synthetic */ y(StateUpdatedWorker stateUpdatedWorker) {
        this.a = stateUpdatedWorker;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x00e5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca  */
    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        a aVar;
        boolean z;
        int i2;
        int i3;
        int i4;
        o0 o0Var;
        Bundle bundle;
        q0 q0Var;
        int b;
        boolean z2;
        p0 p0Var;
        Double d2;
        Iterator it;
        b[] bVarArr;
        boolean z3;
        int i5;
        int i6;
        StateUpdatedWorker stateUpdatedWorker = this.a;
        List<b0> list = (List) obj;
        stateUpdatedWorker.o.i(u.d.TASK_STATE_UPDATED);
        Context context = stateUpdatedWorker.f373e;
        Objects.requireNonNull(stateUpdatedWorker.f376h);
        ArrayList arrayList = new ArrayList();
        for (b0 b0Var : list) {
            arrayList.add(p0.a((long) b0Var.a(), b0Var.c().b()));
        }
        c cVar = stateUpdatedWorker.f378j;
        Objects.requireNonNull(cVar);
        TextUtils.join(", ", list);
        Arrays.toString(cVar.a);
        Iterator it2 = list.iterator();
        b bVar = null;
        long j2 = 0;
        while (true) {
            int i7 = 1;
            if (!it2.hasNext()) {
                break;
            }
            b0 b0Var2 = (b0) it2.next();
            b[] bVarArr2 = cVar.a;
            int length = bVarArr2.length;
            int i8 = 0;
            while (i8 < length) {
                b bVar2 = bVarArr2[i8];
                if (f.a.a.a.a.l(b0Var2, i7, cVar, bVar2.c) || f.a.a.a.a.l(b0Var2, 2, cVar, bVar2.f2320d) || f.a.a.a.a.l(b0Var2, 3, cVar, bVar2.f2321e) || f.a.a.a.a.l(b0Var2, 4, cVar, bVar2.f2322f)) {
                    it = it2;
                } else {
                    it = it2;
                    if (!cVar.a(bVar2.f2323g, b0Var2.c().b())) {
                        bVarArr = bVarArr2;
                        if (!cVar.a(bVar2.f2324h, b0Var2.c().a()) && !cVar.a(bVar2.f2325i, b0Var2.c().c())) {
                            z3 = false;
                            if (z3) {
                                if (bVar == null || (i5 = bVar2.a) < (i6 = bVar.a)) {
                                    j2 = (long) b0Var2.a();
                                    bVar = bVar2;
                                } else if (i6 == i5) {
                                    j2 = Math.max(j2, (long) b0Var2.a());
                                }
                            }
                            i8++;
                            i7 = 1;
                            it2 = it;
                            bVarArr2 = bVarArr;
                        }
                        z3 = true;
                        if (z3) {
                        }
                        i8++;
                        i7 = 1;
                        it2 = it;
                        bVarArr2 = bVarArr;
                    }
                }
                bVarArr = bVarArr2;
                z3 = true;
                if (z3) {
                }
                i8++;
                i7 = 1;
                it2 = it;
                bVarArr2 = bVarArr;
            }
        }
        if (bVar == null) {
            aVar = new a(0, "No Exposure", 0);
        } else {
            aVar = new a(bVar.a, bVar.b, j2);
        }
        d a2 = stateUpdatedWorker.q.a();
        String str = "Current ExposureClassification: " + aVar;
        String str2 = "Previous ExposureClassification: " + a2;
        boolean z4 = a2.b() != aVar.b() || !a2.c().equals(aVar.c());
        boolean z5 = a2.a() != aVar.a();
        if (z4 || z5) {
            if (a2.b() == 0 || aVar.b() != 0) {
                int b2 = aVar.b();
                if (b2 == 1) {
                    i2 = R.string.exposure_notification_title_1;
                } else if (b2 == 2) {
                    i2 = R.string.exposure_notification_title_2;
                } else if (b2 == 3) {
                    i2 = R.string.exposure_notification_title_3;
                } else if (b2 == 4) {
                    i2 = R.string.exposure_notification_title_4;
                } else {
                    throw new IllegalArgumentException("Classification index must be between 1 and 4");
                }
                int b3 = aVar.b();
                if (b3 == 1) {
                    i3 = R.string.exposure_notification_message_1;
                } else if (b3 == 2) {
                    i3 = R.string.exposure_notification_message_2;
                } else if (b3 == 3) {
                    i3 = R.string.exposure_notification_message_3;
                } else if (b3 == 4) {
                    i3 = R.string.exposure_notification_message_4;
                } else {
                    throw new IllegalArgumentException("Classification index must be between 1 and 4");
                }
                z = false;
                stateUpdatedWorker.q.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", aVar.b()).putString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", aVar.c()).putLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", aVar.a()).commit();
                stateUpdatedWorker.q.a.edit().putBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", z).commit();
                if (z4) {
                    i4 = 0;
                    stateUpdatedWorker.q.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", 0).apply();
                } else {
                    i4 = 0;
                }
                if (z5) {
                    stateUpdatedWorker.q.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", i4).apply();
                }
                if (!(i2 == 0 && i3 == 0)) {
                    Objects.requireNonNull(stateUpdatedWorker.f379k);
                    if (Build.VERSION.SDK_INT >= 26) {
                        NotificationChannel notificationChannel = new NotificationChannel("ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID", context.getString(R.string.notification_channel_name), 4);
                        notificationChannel.setDescription(context.getString(R.string.notification_channel_description));
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                        Objects.requireNonNull(notificationManager);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                    Intent intent = new Intent(context, ExposureNotificationActivity.class);
                    intent.setAction("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION");
                    intent.setFlags(268468224);
                    PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
                    Intent intent2 = new Intent(context, ExposureNotificationDismissedReceiver.class);
                    intent2.setAction("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID");
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 268435456);
                    k kVar = new k(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
                    kVar.q.icon = R.drawable.ic_exposure_notification;
                    kVar.m = e.i.b.a.a(context, R.color.notification_color);
                    kVar.f1414e = k.b(context.getString(i2));
                    kVar.f1415f = k.b(context.getString(i3));
                    j jVar = new j();
                    jVar.b = k.b(context.getString(i3));
                    kVar.d(jVar);
                    kVar.f1417h = 2;
                    kVar.f1416g = activity;
                    kVar.c(8, true);
                    kVar.c(16, true);
                    kVar.q.deleteIntent = broadcast;
                    kVar.n = -1;
                    o oVar = new o(context);
                    Notification a3 = kVar.a();
                    bundle = a3.extras;
                    if (bundle == null && bundle.getBoolean("android.support.useSideChannel")) {
                        o.a aVar2 = new o.a(oVar.a.getPackageName(), 0, null, a3);
                        synchronized (o.f1425f) {
                            if (o.f1426g == null) {
                                o.f1426g = new o.c(oVar.a.getApplicationContext());
                            }
                            o.f1426g.c.obtainMessage(0, aVar2).sendToTarget();
                        }
                        oVar.b.cancel(null, 0);
                    } else {
                        oVar.b.notify(null, 0, a3);
                    }
                    q0Var = stateUpdatedWorker.q;
                    l.b.a.d b4 = stateUpdatedWorker.p.b();
                    b = aVar.b();
                    if (q0Var.f() && b > 0) {
                        q0Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", b).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", b4.E()).apply();
                    }
                    context.getResources().getString(i2);
                    context.getResources().getString(i3);
                }
                o0Var = (o0) stateUpdatedWorker.f374f.a;
                o0Var.a.c();
                o0.a(o0Var, arrayList);
                o0Var.a.l();
                o0Var.a.g();
                stateUpdatedWorker.o.g(u.d.TASK_STATE_UPDATED);
                return new ListenableWorker.a.c();
            }
            o0 o0Var2 = (o0) stateUpdatedWorker.f374f.a;
            Objects.requireNonNull(o0Var2);
            i v = i.v("SELECT * FROM ExposureEntity", 0);
            o0Var2.a.b();
            Cursor b5 = e.t.p.b.b(o0Var2.a, v, false, null);
            try {
                int b0 = m.h.b0(b5, "dateDaysSinceEpoch");
                int b02 = m.h.b0(b5, "exposureScore");
                ArrayList arrayList2 = new ArrayList(b5.getCount());
                while (b5.moveToNext()) {
                    arrayList2.add(p0.a(b5.getLong(b0), b5.getDouble(b02)));
                }
                b5.close();
                v.V();
                e eVar = stateUpdatedWorker.f376h;
                Objects.requireNonNull(eVar);
                HashMap hashMap = new HashMap();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    p0 p0Var2 = (p0) it3.next();
                    hashMap.put(Long.valueOf(p0Var2.b()), Double.valueOf(p0Var2.c()));
                }
                long j3 = (long) eVar.a.f444f;
                if (j3 == 0) {
                    j3 = 14;
                }
                TextUtils.join(", ", arrayList2);
                TextUtils.join(", ", arrayList);
                Iterator it4 = arrayList2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z2 = false;
                        break;
                    }
                    p0Var = (p0) it4.next();
                    if (l.b.a.e.O(q.f4166g).M(p0Var.b()).x() > j3 || ((d2 = (Double) hashMap.get(Long.valueOf(p0Var.b()))) != null && d2.doubleValue() >= p0Var.c())) {
                    }
                }
                p0Var.b();
                z2 = true;
                if (z2) {
                    i3 = R.string.exposure_notification_message_revoked;
                    i2 = R.string.exposure_notification_title_revoked;
                    z = true;
                    stateUpdatedWorker.q.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", aVar.b()).putString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", aVar.c()).putLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", aVar.a()).commit();
                    stateUpdatedWorker.q.a.edit().putBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", z).commit();
                    if (z4) {
                    }
                    if (z5) {
                    }
                    Objects.requireNonNull(stateUpdatedWorker.f379k);
                    if (Build.VERSION.SDK_INT >= 26) {
                    }
                    Intent intent3 = new Intent(context, ExposureNotificationActivity.class);
                    intent3.setAction("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION");
                    intent3.setFlags(268468224);
                    PendingIntent activity2 = PendingIntent.getActivity(context, 0, intent3, 0);
                    Intent intent22 = new Intent(context, ExposureNotificationDismissedReceiver.class);
                    intent22.setAction("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID");
                    PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 0, intent22, 268435456);
                    k kVar2 = new k(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
                    kVar2.q.icon = R.drawable.ic_exposure_notification;
                    kVar2.m = e.i.b.a.a(context, R.color.notification_color);
                    kVar2.f1414e = k.b(context.getString(i2));
                    kVar2.f1415f = k.b(context.getString(i3));
                    j jVar2 = new j();
                    jVar2.b = k.b(context.getString(i3));
                    kVar2.d(jVar2);
                    kVar2.f1417h = 2;
                    kVar2.f1416g = activity2;
                    kVar2.c(8, true);
                    kVar2.c(16, true);
                    kVar2.q.deleteIntent = broadcast2;
                    kVar2.n = -1;
                    o oVar2 = new o(context);
                    Notification a32 = kVar2.a();
                    bundle = a32.extras;
                    if (bundle == null && bundle.getBoolean("android.support.useSideChannel")) {
                    }
                    q0Var = stateUpdatedWorker.q;
                    l.b.a.d b42 = stateUpdatedWorker.p.b();
                    b = aVar.b();
                    q0Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", b).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", b42.E()).apply();
                    context.getResources().getString(i2);
                    context.getResources().getString(i3);
                    o0Var = (o0) stateUpdatedWorker.f374f.a;
                    o0Var.a.c();
                    o0.a(o0Var, arrayList);
                    o0Var.a.l();
                    o0Var.a.g();
                    stateUpdatedWorker.o.g(u.d.TASK_STATE_UPDATED);
                    return new ListenableWorker.a.c();
                }
            } catch (Throwable th) {
                b5.close();
                v.V();
                throw th;
            }
        }
        i3 = 0;
        i2 = 0;
        z = false;
        stateUpdatedWorker.q.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", aVar.b()).putString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", aVar.c()).putLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", aVar.a()).commit();
        stateUpdatedWorker.q.a.edit().putBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", z).commit();
        if (z4) {
        }
        if (z5) {
        }
        Objects.requireNonNull(stateUpdatedWorker.f379k);
        if (Build.VERSION.SDK_INT >= 26) {
        }
        Intent intent32 = new Intent(context, ExposureNotificationActivity.class);
        intent32.setAction("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION");
        intent32.setFlags(268468224);
        PendingIntent activity22 = PendingIntent.getActivity(context, 0, intent32, 0);
        Intent intent222 = new Intent(context, ExposureNotificationDismissedReceiver.class);
        intent222.setAction("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID");
        PendingIntent broadcast22 = PendingIntent.getBroadcast(context, 0, intent222, 268435456);
        k kVar22 = new k(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
        kVar22.q.icon = R.drawable.ic_exposure_notification;
        kVar22.m = e.i.b.a.a(context, R.color.notification_color);
        kVar22.f1414e = k.b(context.getString(i2));
        kVar22.f1415f = k.b(context.getString(i3));
        j jVar22 = new j();
        jVar22.b = k.b(context.getString(i3));
        kVar22.d(jVar22);
        kVar22.f1417h = 2;
        kVar22.f1416g = activity22;
        kVar22.c(8, true);
        kVar22.c(16, true);
        kVar22.q.deleteIntent = broadcast22;
        kVar22.n = -1;
        o oVar22 = new o(context);
        Notification a322 = kVar22.a();
        bundle = a322.extras;
        if (bundle == null && bundle.getBoolean("android.support.useSideChannel")) {
        }
        q0Var = stateUpdatedWorker.q;
        l.b.a.d b422 = stateUpdatedWorker.p.b();
        b = aVar.b();
        q0Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", b).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", b422.E()).apply();
        context.getResources().getString(i2);
        context.getResources().getString(i3);
        o0Var = (o0) stateUpdatedWorker.f374f.a;
        o0Var.a.c();
        try {
            o0.a(o0Var, arrayList);
            o0Var.a.l();
            o0Var.a.g();
            stateUpdatedWorker.o.g(u.d.TASK_STATE_UPDATED);
            return new ListenableWorker.a.c();
        } catch (Throwable th2) {
            o0Var.a.g();
            throw th2;
        }
    }
}
