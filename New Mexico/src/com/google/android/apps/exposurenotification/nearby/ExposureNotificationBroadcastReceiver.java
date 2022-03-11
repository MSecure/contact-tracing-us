package com.google.android.apps.exposurenotification.nearby;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.c0.a;
import e.c0.d;
import e.c0.f;
import e.c0.o;
import e.c0.p;
import e.c0.w;
import f.b.a.a.a.c0.s1;
import f.b.a.a.a.h0.k;
import f.b.a.a.a.h0.l;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.t.h0;
import f.b.g.j;
import gov.nm.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class ExposureNotificationBroadcastReceiver extends s1 {
    public w c;

    /* renamed from: d */
    public h0 f375d;

    /* renamed from: e */
    public a1 f376e;

    @Override // f.b.a.a.a.c0.s1, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i2;
        p.a aVar;
        w wVar;
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (action != null) {
            char c = 65535;
            switch (action.hashCode()) {
                case -838677567:
                    if (action.equals("com.google.android.gms.exposurenotification.ACTION_WAKE_UP")) {
                        c = 0;
                        break;
                    }
                    break;
                case -823519053:
                    if (action.equals("com.google.android.gms.exposurenotification.ACTION_PRE_AUTHORIZE_RELEASE_PHONE_UNLOCKED")) {
                        c = 1;
                        break;
                    }
                    break;
                case 693141898:
                    if (action.equals("com.google.android.gms.exposurenotification.ACTION_EXPOSURE_STATE_UPDATED")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1041999891:
                    if (action.equals("com.google.android.gms.exposurenotification.ACTION_EXPOSURE_NOT_FOUND")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a1 a1Var = this.f376e;
                    w wVar2 = this.c;
                    h0 h0Var = this.f375d;
                    if (a1Var.a.getBoolean("ExposureNotificationSharedPreferences.HAS_PENDING_RESTORE_NOTIFICATION", false)) {
                        int i3 = Build.VERSION.SDK_INT;
                        if (i3 >= 28) {
                            if (i3 >= 28) {
                                UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
                                i2 = usageStatsManager != null ? usageStatsManager.getAppStandbyBucket() : 50;
                            } else {
                                i2 = 10;
                            }
                            if (!(i2 == 10 || i2 == 20 || i2 == 30)) {
                                h0Var.d(context, R.string.reactivate_exposure_notification_app_subject, R.string.reactivate_exposure_notification_app_body);
                                a1Var.a.edit().remove("ExposureNotificationSharedPreferences.HAS_PENDING_RESTORE_NOTIFICATION").commit();
                                return;
                            }
                        }
                        RestoreNotificationWorker.g(wVar2);
                        a1Var.a.edit().remove("ExposureNotificationSharedPreferences.HAS_PENDING_RESTORE_NOTIFICATION").commit();
                        return;
                    }
                    return;
                case 1:
                    if (intent.hasExtra("com.google.android.gms.exposurenotification.EXTRA_TEMPORARY_EXPOSURE_KEY_LIST")) {
                        w wVar3 = this.c;
                        ArrayList<TemporaryExposureKey> parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.google.android.gms.exposurenotification.EXTRA_TEMPORARY_EXPOSURE_KEY_LIST");
                        HashMap hashMap = new HashMap();
                        l.b newBuilder = l.newBuilder();
                        ArrayList arrayList = new ArrayList();
                        for (TemporaryExposureKey temporaryExposureKey : parcelableArrayListExtra) {
                            k.b newBuilder2 = k.newBuilder();
                            newBuilder2.setKeyData(j.l(temporaryExposureKey.d()));
                            newBuilder2.setTransmissionRiskLevel(temporaryExposureKey.f486d);
                            newBuilder2.setRollingStartIntervalNumber(temporaryExposureKey.c);
                            newBuilder2.setRollingPeriod(temporaryExposureKey.f487e);
                            int i4 = temporaryExposureKey.f488f;
                            if (i4 != 0) {
                                newBuilder2.setReportType(k.c.forNumber(i4));
                            }
                            int i5 = temporaryExposureKey.f489g;
                            if (i5 != Integer.MAX_VALUE) {
                                newBuilder2.setDaysSinceOnsetOfSymptoms(i5);
                            }
                            arrayList.add(newBuilder2.build());
                        }
                        hashMap.put("PreAuthTEKsReceivedWorker.KEYS_BYTES", f.a(newBuilder.addAllKeys(arrayList).build().toByteArray()));
                        f fVar = new f(hashMap);
                        f.c(fVar);
                        p.a aVar2 = new p.a(PreAuthTEKsReceivedWorker.class);
                        aVar2.f1261d.add("PreAuthTEKsReceivedWorker.TEKS_RECEIVED_WORKER_TAG");
                        d.a aVar3 = new d.a();
                        aVar3.a = o.CONNECTED;
                        aVar2.c.f1197j = new d(aVar3);
                        p.a d2 = aVar2.d(a.EXPONENTIAL, 30, TimeUnit.MINUTES);
                        d2.c.f1192e = fVar;
                        wVar3.c(d2.e(10, TimeUnit.SECONDS).a());
                        return;
                    }
                    return;
                case 2:
                    wVar = this.c;
                    f.b.a.a.a.t.p0.a aVar4 = StateUpdatedWorker.s;
                    aVar = new p.a(StateUpdatedWorker.class);
                    break;
                case 3:
                    wVar = this.c;
                    f.b.a.a.a.t.p0.a aVar5 = StateUpdatedWorker.s;
                    aVar = new p.a(StateUpdatedWorker.class);
                    break;
                default:
                    return;
            }
            wVar.c(aVar.a());
        }
    }
}
