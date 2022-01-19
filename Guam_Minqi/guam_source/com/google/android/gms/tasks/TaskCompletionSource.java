package com.google.android.gms.tasks;

import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public class TaskCompletionSource<TResult> {
    public final zzu<TResult> zza = new zzu<>();

    public boolean trySetException(Exception exc) {
        zzu<TResult> zzu = this.zza;
        if (zzu != null) {
            ReactYogaConfigProvider.checkNotNull(exc, "Exception must not be null");
            synchronized (zzu.zza) {
                if (zzu.zzc) {
                    return false;
                }
                zzu.zzc = true;
                zzu.zzf = exc;
                zzu.zzb.zza(zzu);
                return true;
            }
        }
        throw null;
    }

    public boolean trySetResult(TResult tresult) {
        zzu<TResult> zzu = this.zza;
        synchronized (zzu.zza) {
            if (zzu.zzc) {
                return false;
            }
            zzu.zzc = true;
            zzu.zze = tresult;
            zzu.zzb.zza(zzu);
            return true;
        }
    }
}
