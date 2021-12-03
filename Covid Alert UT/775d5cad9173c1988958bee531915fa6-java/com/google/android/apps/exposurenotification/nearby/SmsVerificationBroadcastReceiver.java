package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import e.b0.a;
import e.b0.d;
import e.b0.f;
import e.b0.o;
import e.b0.p;
import e.b0.w;
import f.b.a.a.a.b0.l1;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import l.b.a.d;

public class SmsVerificationBroadcastReceiver extends l1 {
    public w c;

    @Override // f.b.a.a.a.b0.l1
    public void onReceive(Context context, Intent intent) {
        Uri data;
        super.onReceive(context, intent);
        if ("com.google.android.gms.nearby.exposurenotification.ACTION_VERIFICATION_LINK".equals(intent.getAction()) && (data = intent.getData()) != null) {
            w wVar = this.c;
            d dVar = SmsVerificationWorker.r;
            HashMap hashMap = new HashMap();
            hashMap.put("SmsReceivedWorker.DEEP_LINK_URI_STRING", data.toString());
            f fVar = new f(hashMap);
            f.c(fVar);
            p.a aVar = new p.a(SmsVerificationWorker.class);
            aVar.f1182d.add("SMS_RECEIVED_WORKER_TAG");
            d.a aVar2 = new d.a();
            aVar2.a = o.CONNECTED;
            aVar.c.f1118j = new e.b0.d(aVar2);
            p.a aVar3 = (p.a) aVar.d(a.EXPONENTIAL, 30, TimeUnit.MINUTES);
            aVar3.c.f1113e = fVar;
            wVar.c(aVar3.a());
        }
    }
}
