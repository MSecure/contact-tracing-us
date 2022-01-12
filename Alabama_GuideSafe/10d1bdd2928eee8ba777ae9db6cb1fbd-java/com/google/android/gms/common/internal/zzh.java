package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.GmsClientSupervisor;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzh implements Handler.Callback {
    public final /* synthetic */ zzg zza;

    public zzh(zzg zzg, zzf zzf) {
        this.zza = zzg;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zza.zza) {
                GmsClientSupervisor.zza zza2 = (GmsClientSupervisor.zza) message.obj;
                zzi zzi = this.zza.zza.get(zza2);
                if (zzi != null && zzi.zza.isEmpty()) {
                    if (zzi.zzc) {
                        zzi.zzg.zzc.removeMessages(1, zzi.zze);
                        zzg zzg = zzi.zzg;
                        zzg.zzd.unbindService(zzg.zzb, zzi);
                        zzi.zzc = false;
                        zzi.zzb = 2;
                    }
                    this.zza.zza.remove(zza2);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zza.zza) {
                GmsClientSupervisor.zza zza3 = (GmsClientSupervisor.zza) message.obj;
                zzi zzi2 = this.zza.zza.get(zza3);
                if (zzi2 != null && zzi2.zzb == 3) {
                    String valueOf = String.valueOf(zza3);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentName = zzi2.zzf;
                    if (componentName == null) {
                        componentName = zza3.zzc;
                    }
                    if (componentName == null) {
                        String str = zza3.zzb;
                        ReactYogaConfigProvider.checkNotNull(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    zzi2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
