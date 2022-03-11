package com.google.android.apps.exposurenotification.common;

import android.content.Context;
import android.content.Intent;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.t.f0;
import f.b.a.a.a.t.q0.a;
/* loaded from: classes.dex */
public class ExposureNotificationDismissedReceiver extends f0 {
    public a1 c;

    /* renamed from: d */
    public a f334d;

    @Override // f.b.a.a.a.t.f0, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        boolean z = ((f.b.a.a.a.j0.a) this.c.b()).a != 0 || this.c.g();
        if ("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID".equals(intent.getAction()) && z && !intent.getBooleanExtra("IntentUtil.ACTION_SMS_VERIFICATION", false)) {
            this.c.u(this.f334d.c(), a1.g.DISMISSED, this.c.c());
        }
    }
}
