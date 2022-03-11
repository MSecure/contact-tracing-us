package com.google.android.gms.nearby.exposurenotification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import f.b.a.c.e.c.g2;
import f.b.a.c.f.b.q;

public class WakeUpService extends Service {

    public static class a extends g2 {
        public a(q qVar) {
        }

        public final void handleMessage(Message message) {
        }
    }

    public IBinder onBind(Intent intent) {
        return new Messenger(new a(null)).getBinder();
    }
}
