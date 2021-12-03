package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import f.b.a.b.i.b;
import f.b.a.b.i.i;
import f.b.a.b.i.m;
import f.b.a.b.i.s.h.g;
import f.b.a.b.i.s.h.l;
import f.b.a.b.i.v.a;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        m.b(context);
        i.a a2 = i.a();
        a2.b(queryParameter);
        a2.c(a.b(intValue));
        if (queryParameter2 != null) {
            ((b.C0076b) a2).b = Base64.decode(queryParameter2, 0);
        }
        l lVar = m.a().f2586d;
        lVar.f2607e.execute(new g(lVar, a2.a(), i2, f.b.a.b.i.s.h.a.b));
    }
}
