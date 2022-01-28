package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzh<TResult> implements zzr<TResult> {
    public final Executor zza;
    public final Object zzb = new Object();
    public OnCanceledListener zzc;

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.zza = executor;
        this.zzc = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza(Task<TResult> task) {
        if (((zzu) task).zzd) {
            synchronized (this.zzb) {
                if (this.zzc != null) {
                    this.zza.execute(new zzg(this));
                }
            }
        }
    }
}
