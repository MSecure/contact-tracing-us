package f.b.a.a.a.n;

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
import e.i.a.h;
import e.i.a.i;
import e.i.a.m;
import f.b.a.a.a.s.u;
import f.b.a.a.a.t.a;
import f.b.a.a.a.t.b;
import f.b.a.a.a.t.c;
import f.b.a.a.a.t.d;
import f.b.a.a.a.t.e;
import f.b.a.a.a.w.i0;
import f.b.a.a.a.w.j0;
import f.b.a.a.a.w.k0;
import f.b.b.a.g;
import gov.wa.doh.exposurenotifications.R;
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
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x00e5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca  */
    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        a aVar;
        boolean z;
        int i2;
        int i3;
        int i4;
        i0 i0Var;
        Bundle bundle;
        k0 k0Var;
        boolean z2;
        j0 j0Var;
        Double d2;
        Iterator it;
        b[] bVarArr;
        boolean z3;
        int i5;
        int i6;
        StateUpdatedWorker stateUpdatedWorker = this.a;
        List<b0> list = (List) obj;
        stateUpdatedWorker.o.i(u.d.TASK_STATE_UPDATED);
        Context context = stateUpdatedWorker.f363e;
        Objects.requireNonNull(stateUpdatedWorker.f366h);
        ArrayList arrayList = new ArrayList();
        for (b0 b0Var : list) {
            arrayList.add(j0.a((long) b0Var.a(), b0Var.c().b()));
        }
        c cVar = stateUpdatedWorker.f368j;
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
                if (f.a.a.a.a.l(b0Var2, i7, cVar, bVar2.c) || f.a.a.a.a.l(b0Var2, 2, cVar, bVar2.f2243d) || f.a.a.a.a.l(b0Var2, 3, cVar, bVar2.f2244e) || f.a.a.a.a.l(b0Var2, 4, cVar, bVar2.f2245f)) {
                    it = it2;
                } else {
                    it = it2;
                    if (!cVar.a(bVar2.f2246g, b0Var2.c().b())) {
                        bVarArr = bVarArr2;
                        if (!cVar.a(bVar2.f2247h, b0Var2.c().a()) && !cVar.a(bVar2.f2248i, b0Var2.c().c())) {
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
        d c = stateUpdatedWorker.q.c();
        String str = "Current ExposureClassification: " + aVar;
        String str2 = "Previous ExposureClassification: " + c;
        boolean z4 = c.b() != aVar.b() || !c.c().equals(aVar.c());
        boolean z5 = c.a() != aVar.a();
        if (z4 || z5) {
            if (c.b() == 0 || aVar.b() != 0) {
                int b = aVar.b();
                if (b == 1) {
                    i2 = R.string.exposure_notification_title_1;
                } else if (b == 2) {
                    i2 = R.string.exposure_notification_title_2;
                } else if (b == 3) {
                    i2 = R.string.exposure_notification_title_3;
                } else if (b == 4) {
                    i2 = R.string.exposure_notification_title_4;
                } else {
                    throw new IllegalArgumentException("Classification index must be between 1 and 4");
                }
                int b2 = aVar.b();
                if (b2 == 1) {
                    i3 = R.string.exposure_notification_message_1;
                } else if (b2 == 2) {
                    i3 = R.string.exposure_notification_message_2;
                } else if (b2 == 3) {
                    i3 = R.string.exposure_notification_message_3;
                } else if (b2 == 4) {
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
                    Objects.requireNonNull(stateUpdatedWorker.f369k);
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
                    i iVar = new i(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
                    iVar.q.icon = R.drawable.ic_exposure_notification;
                    iVar.m = e.i.b.a.a(context, R.color.notification_color);
                    iVar.f1400e = i.b(context.getString(i2));
                    iVar.f1401f = i.b(context.getString(i3));
                    h hVar = new h();
                    hVar.b = i.b(context.getString(i3));
                    iVar.d(hVar);
                    iVar.f1403h = 2;
                    iVar.f1402g = activity;
                    iVar.c(8, true);
                    iVar.c(16, true);
                    iVar.q.deleteIntent = broadcast;
                    iVar.n = -1;
                    m mVar = new m(context);
                    Notification a2 = iVar.a();
                    bundle = a2.extras;
                    if (bundle == null && bundle.getBoolean("android.support.useSideChannel")) {
                        m.a aVar2 = new m.a(mVar.a.getPackageName(), 0, null, a2);
                        synchronized (m.f1411f) {
                            if (m.f1412g == null) {
                                m.f1412g = new m.c(mVar.a.getApplicationContext());
                            }
                            m.f1412g.c.obtainMessage(0, aVar2).sendToTarget();
                        }
                        mVar.b.cancel(null, 0);
                    } else {
                        mVar.b.notify(null, 0, a2);
                    }
                    k0Var = stateUpdatedWorker.q;
                    l.b.a.d b3 = stateUpdatedWorker.p.b();
                    int b4 = aVar.b();
                    if (k0Var.f()) {
                        k0Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", b4).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", b3.D()).apply();
                    }
                    context.getResources().getString(i2);
                    context.getResources().getString(i3);
                }
                i0Var = (i0) stateUpdatedWorker.f364f.a;
                i0Var.a.c();
                i0.a(i0Var, arrayList);
                i0Var.a.l();
                i0Var.a.g();
                stateUpdatedWorker.o.g(u.d.TASK_STATE_UPDATED);
                return new ListenableWorker.a.c();
            }
            i0 i0Var2 = (i0) stateUpdatedWorker.f364f.a;
            Objects.requireNonNull(i0Var2);
            e.t.i v = e.t.i.v("SELECT * FROM ExposureEntity", 0);
            i0Var2.a.b();
            Cursor b5 = e.t.p.b.b(i0Var2.a, v, false, null);
            try {
                int b0 = m.h.b0(b5, "dateDaysSinceEpoch");
                int b02 = m.h.b0(b5, "exposureScore");
                ArrayList arrayList2 = new ArrayList(b5.getCount());
                while (b5.moveToNext()) {
                    arrayList2.add(j0.a(b5.getLong(b0), b5.getDouble(b02)));
                }
                b5.close();
                v.V();
                e eVar = stateUpdatedWorker.f366h;
                Objects.requireNonNull(eVar);
                HashMap hashMap = new HashMap();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    j0 j0Var2 = (j0) it3.next();
                    hashMap.put(Long.valueOf(j0Var2.b()), Double.valueOf(j0Var2.c()));
                }
                long j3 = (long) eVar.a.f428f;
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
                    j0Var = (j0) it4.next();
                    if (l.b.a.e.O(q.f4070g).M(j0Var.b()).x() > j3 || ((d2 = (Double) hashMap.get(Long.valueOf(j0Var.b()))) != null && d2.doubleValue() >= j0Var.c())) {
                    }
                }
                j0Var.b();
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
                    Objects.requireNonNull(stateUpdatedWorker.f369k);
                    if (Build.VERSION.SDK_INT >= 26) {
                    }
                    Intent intent3 = new Intent(context, ExposureNotificationActivity.class);
                    intent3.setAction("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION");
                    intent3.setFlags(268468224);
                    PendingIntent activity2 = PendingIntent.getActivity(context, 0, intent3, 0);
                    Intent intent22 = new Intent(context, ExposureNotificationDismissedReceiver.class);
                    intent22.setAction("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID");
                    PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 0, intent22, 268435456);
                    i iVar2 = new i(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
                    iVar2.q.icon = R.drawable.ic_exposure_notification;
                    iVar2.m = e.i.b.a.a(context, R.color.notification_color);
                    iVar2.f1400e = i.b(context.getString(i2));
                    iVar2.f1401f = i.b(context.getString(i3));
                    h hVar2 = new h();
                    hVar2.b = i.b(context.getString(i3));
                    iVar2.d(hVar2);
                    iVar2.f1403h = 2;
                    iVar2.f1402g = activity2;
                    iVar2.c(8, true);
                    iVar2.c(16, true);
                    iVar2.q.deleteIntent = broadcast2;
                    iVar2.n = -1;
                    e.i.a.m mVar2 = new e.i.a.m(context);
                    Notification a22 = iVar2.a();
                    bundle = a22.extras;
                    if (bundle == null && bundle.getBoolean("android.support.useSideChannel")) {
                    }
                    k0Var = stateUpdatedWorker.q;
                    l.b.a.d b32 = stateUpdatedWorker.p.b();
                    int b42 = aVar.b();
                    if (k0Var.f()) {
                    }
                    context.getResources().getString(i2);
                    context.getResources().getString(i3);
                    i0Var = (i0) stateUpdatedWorker.f364f.a;
                    i0Var.a.c();
                    i0.a(i0Var, arrayList);
                    i0Var.a.l();
                    i0Var.a.g();
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
        Objects.requireNonNull(stateUpdatedWorker.f369k);
        if (Build.VERSION.SDK_INT >= 26) {
        }
        Intent intent32 = new Intent(context, ExposureNotificationActivity.class);
        intent32.setAction("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION");
        intent32.setFlags(268468224);
        PendingIntent activity22 = PendingIntent.getActivity(context, 0, intent32, 0);
        Intent intent222 = new Intent(context, ExposureNotificationDismissedReceiver.class);
        intent222.setAction("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID");
        PendingIntent broadcast22 = PendingIntent.getBroadcast(context, 0, intent222, 268435456);
        i iVar22 = new i(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
        iVar22.q.icon = R.drawable.ic_exposure_notification;
        iVar22.m = e.i.b.a.a(context, R.color.notification_color);
        iVar22.f1400e = i.b(context.getString(i2));
        iVar22.f1401f = i.b(context.getString(i3));
        h hVar22 = new h();
        hVar22.b = i.b(context.getString(i3));
        iVar22.d(hVar22);
        iVar22.f1403h = 2;
        iVar22.f1402g = activity22;
        iVar22.c(8, true);
        iVar22.c(16, true);
        iVar22.q.deleteIntent = broadcast22;
        iVar22.n = -1;
        e.i.a.m mVar22 = new e.i.a.m(context);
        Notification a222 = iVar22.a();
        bundle = a222.extras;
        if (bundle == null && bundle.getBoolean("android.support.useSideChannel")) {
        }
        k0Var = stateUpdatedWorker.q;
        l.b.a.d b322 = stateUpdatedWorker.p.b();
        int b422 = aVar.b();
        if (k0Var.f()) {
        }
        context.getResources().getString(i2);
        context.getResources().getString(i3);
        i0Var = (i0) stateUpdatedWorker.f364f.a;
        i0Var.a.c();
        try {
            i0.a(i0Var, arrayList);
            i0Var.a.l();
            i0Var.a.g();
            stateUpdatedWorker.o.g(u.d.TASK_STATE_UPDATED);
            return new ListenableWorker.a.c();
        } catch (Throwable th2) {
            i0Var.a.g();
            throw th2;
        }
    }
}
