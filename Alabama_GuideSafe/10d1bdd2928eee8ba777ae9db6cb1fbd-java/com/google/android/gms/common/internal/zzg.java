package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzg extends GmsClientSupervisor {
    public final HashMap<GmsClientSupervisor.zza, zzi> zza = new HashMap<>();
    public final Context zzb;
    public final Handler zzc;
    public final ConnectionTracker zzd;
    public final long zze;
    public final long zzf;

    public zzg(Context context) {
        this.zzb = context.getApplicationContext();
        this.zzc = new zzi(context.getMainLooper(), new zzh(this, null));
        if (ConnectionTracker.zzb == null) {
            synchronized (ConnectionTracker.zza) {
                if (ConnectionTracker.zzb == null) {
                    ConnectionTracker.zzb = new ConnectionTracker();
                }
            }
        }
        ConnectionTracker connectionTracker = ConnectionTracker.zzb;
        ReactYogaConfigProvider.checkNotNull(connectionTracker);
        this.zzd = connectionTracker;
        this.zze = WebsocketJavaScriptExecutor.CONNECT_TIMEOUT_MS;
        this.zzf = 300000;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zza(GmsClientSupervisor.zza zza2, ServiceConnection serviceConnection, String str) {
        boolean z;
        ReactYogaConfigProvider.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zza) {
            zzi zzi = this.zza.get(zza2);
            if (zzi == null) {
                zzi = new zzi(this, zza2);
                zzi.zza.put(serviceConnection, serviceConnection);
                zzi.zza(str);
                this.zza.put(zza2, zzi);
            } else {
                this.zzc.removeMessages(0, zza2);
                if (!zzi.zza.containsKey(serviceConnection)) {
                    zzi.zza.put(serviceConnection, serviceConnection);
                    int i = zzi.zzb;
                    if (i == 1) {
                        serviceConnection.onServiceConnected(zzi.zzf, zzi.zzd);
                    } else if (i == 2) {
                        zzi.zza(str);
                    }
                } else {
                    String valueOf = String.valueOf(zza2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            z = zzi.zzc;
        }
        return z;
    }
}
