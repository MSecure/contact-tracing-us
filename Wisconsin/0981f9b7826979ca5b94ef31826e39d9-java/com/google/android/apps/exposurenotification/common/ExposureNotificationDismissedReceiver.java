package com.google.android.apps.exposurenotification.common;

import android.content.Context;
import android.content.Intent;
import f.b.a.a.a.h.m;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.w.k0;

public class ExposureNotificationDismissedReceiver extends m {
    public k0 c;

    /* renamed from: d  reason: collision with root package name */
    public a f330d;

    @Override // f.b.a.a.a.h.m
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if ("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID".equals(intent.getAction())) {
            this.c.k(this.f330d.b(), k0.g.DISMISSED);
        }
    }
}
