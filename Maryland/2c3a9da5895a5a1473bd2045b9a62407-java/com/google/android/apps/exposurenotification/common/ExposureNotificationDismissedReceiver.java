package com.google.android.apps.exposurenotification.common;

import android.content.Context;
import android.content.Intent;
import f.b.a.a.a.h.m;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.y.q0;

public class ExposureNotificationDismissedReceiver extends m {
    public q0 c;

    /* renamed from: d  reason: collision with root package name */
    public a f338d;

    @Override // f.b.a.a.a.h.m
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if ("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID".equals(intent.getAction())) {
            this.c.l(this.f338d.b(), q0.g.DISMISSED, this.c.b());
        }
    }
}
