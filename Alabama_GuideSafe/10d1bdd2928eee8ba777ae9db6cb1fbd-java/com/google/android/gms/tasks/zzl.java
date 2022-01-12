package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzl<TResult> implements zzr<TResult> {
    public final Executor zza;
    public final Object zzb = new Object();
    public OnFailureListener zzc;

    public zzl(Executor executor, OnFailureListener onFailureListener) {
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza(Task<TResult> task) {
        if (!task.isSuccessful() && !((zzu) task).zzd) {
            synchronized (this.zzb) {
                if (this.zzc != null) {
                    this.zza.execute(new zzk(this, task));
                }
            }
        }
    }
}
