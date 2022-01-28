package com.google.android.apps.exposurenotification.nearby;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.z.a;
import e.z.c;
import e.z.e;
import e.z.m;
import e.z.n;
import e.z.t;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.w;
import f.b.a.a.a.q.k1;
import f.b.a.a.a.v.k;
import f.b.a.a.a.v.l;
import f.b.g.j;
import gov.co.cdphe.exposurenotifications.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ExposureNotificationBroadcastReceiver extends k1 {
    public t c;

    /* renamed from: d  reason: collision with root package name */
    public w f365d;

    /* renamed from: e  reason: collision with root package name */
    public v0 f366e;

    @Override // f.b.a.a.a.q.k1
    public void onReceive(Context context, Intent intent) {
        int i2;
        n.a aVar;
        t tVar;
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (action != null) {
            char c2 = 65535;
            switch (action.hashCode()) {
                case -838677567:
                    if (action.equals("com.google.android.gms.exposurenotification.ACTION_WAKE_UP")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -823519053:
                    if (action.equals("com.google.android.gms.exposurenotification.ACTION_PRE_AUTHORIZE_RELEASE_PHONE_UNLOCKED")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 693141898:
                    if (action.equals("com.google.android.gms.exposurenotification.ACTION_EXPOSURE_STATE_UPDATED")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1041999891:
                    if (action.equals("com.google.android.gms.exposurenotification.ACTION_EXPOSURE_NOT_FOUND")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    v0 v0Var = this.f366e;
                    t tVar2 = this.c;
                    w wVar = this.f365d;
                    if (v0Var.a.getBoolean("ExposureNotificationSharedPreferences.HAS_PENDING_RESTORE_NOTIFICATION", false)) {
                        int i3 = Build.VERSION.SDK_INT;
                        if (i3 >= 28) {
                            if (i3 >= 28) {
                                UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
                                i2 = usageStatsManager != null ? usageStatsManager.getAppStandbyBucket() : 50;
                            } else {
                                i2 = 10;
                            }
                            if (!(i2 == 10 || i2 == 20 || i2 == 30)) {
                                wVar.d(context, R.string.reactivate_exposure_notification_app_subject, R.string.reactivate_exposure_notification_app_body);
                                v0Var.a.edit().remove("ExposureNotificationSharedPreferences.HAS_PENDING_RESTORE_NOTIFICATION").commit();
                                return;
                            }
                        }
                        RestoreNotificationWorker.g(tVar2);
                        v0Var.a.edit().remove("ExposureNotificationSharedPreferences.HAS_PENDING_RESTORE_NOTIFICATION").commit();
                        return;
                    }
                    return;
                case 1:
                    if (intent.hasExtra("com.google.android.gms.exposurenotification.EXTRA_TEMPORARY_EXPOSURE_KEY_LIST")) {
                        t tVar3 = this.c;
                        ArrayList<TemporaryExposureKey> parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.google.android.gms.exposurenotification.EXTRA_TEMPORARY_EXPOSURE_KEY_LIST");
                        HashMap hashMap = new HashMap();
                        l.b newBuilder = l.newBuilder();
                        ArrayList arrayList = new ArrayList();
                        for (TemporaryExposureKey temporaryExposureKey : parcelableArrayListExtra) {
                            k.b newBuilder2 = k.newBuilder();
                            newBuilder2.setKeyData(j.l(temporaryExposureKey.d()));
                            newBuilder2.setTransmissionRiskLevel(temporaryExposureKey.f480d);
                            newBuilder2.setRollingStartIntervalNumber(temporaryExposureKey.c);
                            newBuilder2.setRollingPeriod(temporaryExposureKey.f481e);
                            int i4 = temporaryExposureKey.f482f;
                            if (i4 != 0) {
                                newBuilder2.setReportType(k.c.forNumber(i4));
                            }
                            int i5 = temporaryExposureKey.f483g;
                            if (i5 != Integer.MAX_VALUE) {
                                newBuilder2.setDaysSinceOnsetOfSymptoms(i5);
                            }
                            arrayList.add((k) newBuilder2.build());
                        }
                        hashMap.put("PreAuthTEKsReceivedWorker.KEYS_BYTES", e.a(((l) newBuilder.addAllKeys(arrayList).build()).toByteArray()));
                        e eVar = new e(hashMap);
                        e.c(eVar);
                        n.a aVar2 = new n.a(PreAuthTEKsReceivedWorker.class);
                        aVar2.f1879d.add("PreAuthTEKsReceivedWorker.TEKS_RECEIVED_WORKER_TAG");
                        c.a aVar3 = new c.a();
                        aVar3.a = m.CONNECTED;
                        aVar2.c.f1994j = new c(aVar3);
                        n.a aVar4 = (n.a) aVar2.d(a.EXPONENTIAL, 30, TimeUnit.MINUTES);
                        aVar4.c.f1989e = eVar;
                        tVar3.b(((n.a) aVar4.e(10, TimeUnit.SECONDS)).a());
                        return;
                    }
                    return;
                case 2:
                    tVar = this.c;
                    f.b.a.a.a.i.e0.a aVar5 = StateUpdatedWorker.q;
                    aVar = new n.a(StateUpdatedWorker.class);
                    break;
                case 3:
                    tVar = this.c;
                    f.b.a.a.a.i.e0.a aVar6 = StateUpdatedWorker.q;
                    aVar = new n.a(StateUpdatedWorker.class);
                    break;
                default:
                    return;
            }
            tVar.b(aVar.a());
        }
    }
}
