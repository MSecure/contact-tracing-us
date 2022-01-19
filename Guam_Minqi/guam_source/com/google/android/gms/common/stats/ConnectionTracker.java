package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class ConnectionTracker {
    public static final Object zza = new Object();
    public static volatile ConnectionTracker zzb;
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> zzd = new ConcurrentHashMap<>();

    @SuppressLint({"UntrackedBindService"})
    public void unbindService(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
    }
}
