package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.content.Intent;
import e.c0.n;
import e.c0.t;
import f.b.a.a.a.p.h0;
import l.b.a.c;

public class ExposureNotificationBroadcastReceiver extends h0 {
    public t c;

    @Override // f.b.a.a.a.p.h0
    public void onReceive(Context context, Intent intent) {
        n.a aVar;
        t tVar;
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (action != null) {
            if (action.equals("com.google.android.gms.exposurenotification.ACTION_EXPOSURE_STATE_UPDATED")) {
                tVar = this.c;
                c cVar = StateUpdatedWorker.r;
                aVar = new n.a(StateUpdatedWorker.class);
            } else if (action.equals("com.google.android.gms.exposurenotification.ACTION_EXPOSURE_NOT_FOUND")) {
                tVar = this.c;
                c cVar2 = StateUpdatedWorker.r;
                aVar = new n.a(StateUpdatedWorker.class);
            } else {
                return;
            }
            tVar.a(aVar.a());
        }
    }
}
