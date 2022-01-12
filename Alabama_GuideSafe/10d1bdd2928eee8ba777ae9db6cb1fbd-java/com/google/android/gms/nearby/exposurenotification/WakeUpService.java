package com.google.android.gms.nearby.exposurenotification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.internal.nearby.zzi;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public class WakeUpService extends Service {

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
    public static class zza extends zzi {
        public zza(zzp zzp) {
        }

        public final void handleMessage(Message message) {
        }
    }

    public IBinder onBind(Intent intent) {
        return new Messenger(new zza(null)).getBinder();
    }
}
