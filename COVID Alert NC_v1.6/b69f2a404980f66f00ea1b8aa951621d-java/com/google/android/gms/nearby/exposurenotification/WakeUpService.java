package com.google.android.gms.nearby.exposurenotification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import c.b.a.a.e.c.b6;

public class WakeUpService extends Service {

    public static class zza extends b6 {
        public zza() {
        }

        public final void handleMessage(Message message) {
        }
    }

    public IBinder onBind(Intent intent) {
        return new Messenger(new zza()).getBinder();
    }
}
