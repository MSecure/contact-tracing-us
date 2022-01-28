package com.google.android.apps.exposurenotification.common;

import android.content.Context;
import android.content.Intent;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.f0.a;
import f.b.a.a.a.i.u;

public class ExposureNotificationDismissedReceiver extends u {
    public v0 c;

    /* renamed from: d  reason: collision with root package name */
    public a f329d;

    @Override // f.b.a.a.a.i.u
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        boolean z = ((f.b.a.a.a.x.a) this.c.a()).a != 0 || this.c.f();
        if ("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID".equals(intent.getAction()) && z && !intent.getBooleanExtra("IntentUtil.ACTION_SMS_VERIFICATION", false)) {
            this.c.q(this.f329d.c(), v0.g.DISMISSED, this.c.b());
        }
    }
}
