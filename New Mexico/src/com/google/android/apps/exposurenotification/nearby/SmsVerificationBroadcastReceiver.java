package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import e.c0.a;
import e.c0.d;
import e.c0.f;
import e.c0.o;
import e.c0.p;
import e.c0.w;
import f.b.a.a.a.c0.t1;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import l.b.a.d;
/* loaded from: classes.dex */
public class SmsVerificationBroadcastReceiver extends t1 {
    public w c;

    @Override // f.b.a.a.a.c0.t1, android.content.BroadcastReceiver
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
            aVar.f1261d.add("SMS_RECEIVED_WORKER_TAG");
            d.a aVar2 = new d.a();
            aVar2.a = o.CONNECTED;
            aVar.c.f1197j = new e.c0.d(aVar2);
            p.a d2 = aVar.d(a.EXPONENTIAL, 30, TimeUnit.MINUTES);
            d2.c.f1192e = fVar;
            wVar.c(d2.a());
        }
    }
}
