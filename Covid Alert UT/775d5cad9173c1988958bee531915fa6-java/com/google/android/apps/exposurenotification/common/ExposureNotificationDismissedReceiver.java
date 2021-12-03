package com.google.android.apps.exposurenotification.common;

import android.content.Context;
import android.content.Intent;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.s.e0.a;
import f.b.a.a.a.s.t;

public class ExposureNotificationDismissedReceiver extends t {
    public v0 c;

    /* renamed from: d  reason: collision with root package name */
    public a f334d;

    @Override // f.b.a.a.a.s.t
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        boolean z = ((f.b.a.a.a.h0.a) this.c.a()).a != 0 || this.c.f();
        if ("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID".equals(intent.getAction()) && z && !intent.getBooleanExtra("IntentUtil.ACTION_SMS_VERIFICATION", false)) {
            this.c.q(this.f334d.c(), v0.g.DISMISSED, this.c.b());
        }
    }
}
