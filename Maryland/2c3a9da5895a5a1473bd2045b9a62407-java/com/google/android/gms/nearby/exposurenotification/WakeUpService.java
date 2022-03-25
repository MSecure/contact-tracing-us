package com.google.android.gms.nearby.exposurenotification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import f.b.a.c.f.b.r;

public class WakeUpService extends Service {
    @RecentlyNullable
    public final IBinder onBind(@RecentlyNonNull Intent intent) {
        return new Messenger(new r()).getBinder();
    }
}
