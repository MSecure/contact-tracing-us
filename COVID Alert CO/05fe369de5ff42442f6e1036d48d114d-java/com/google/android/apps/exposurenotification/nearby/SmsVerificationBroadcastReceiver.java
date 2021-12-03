package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import e.z.a;
import e.z.c;
import e.z.e;
import e.z.m;
import e.z.n;
import e.z.t;
import f.b.a.a.a.q.l1;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import l.b.a.d;

public class SmsVerificationBroadcastReceiver extends l1 {
    public t c;

    @Override // f.b.a.a.a.q.l1
    public void onReceive(Context context, Intent intent) {
        Uri data;
        super.onReceive(context, intent);
        if ("com.google.android.gms.nearby.exposurenotification.ACTION_VERIFICATION_LINK".equals(intent.getAction()) && (data = intent.getData()) != null) {
            t tVar = this.c;
            d dVar = SmsVerificationWorker.p;
            HashMap hashMap = new HashMap();
            hashMap.put("SmsReceivedWorker.DEEP_LINK_URI_STRING", data.toString());
            e eVar = new e(hashMap);
            e.c(eVar);
            n.a aVar = new n.a(SmsVerificationWorker.class);
            aVar.f1879d.add("SMS_RECEIVED_WORKER_TAG");
            c.a aVar2 = new c.a();
            aVar2.a = m.CONNECTED;
            aVar.c.f1994j = new c(aVar2);
            n.a aVar3 = (n.a) aVar.d(a.EXPONENTIAL, 30, TimeUnit.MINUTES);
            aVar3.c.f1989e = eVar;
            tVar.b(aVar3.a());
        }
    }
}
