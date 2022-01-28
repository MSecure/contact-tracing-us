package com.google.android.gms.tasks;

import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzk implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzl zzb;

    public zzk(zzl zzl, Task task) {
        this.zzb = zzl;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzc != null) {
                OnFailureListener onFailureListener = this.zzb.zzc;
                Exception exception = this.zza.getException();
                ReactYogaConfigProvider.checkNotNull(exception);
                onFailureListener.onFailure(exception);
            }
        }
    }
}
