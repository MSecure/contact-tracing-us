package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzf implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzd zzb;

    public zzf(zzd zzd, Task task) {
        this.zzb = zzd;
        this.zza = task;
    }

    public final void run() {
        try {
            Task task = (Task) this.zzb.zzb.then(this.zza);
            if (task == null) {
                zzd zzd = this.zzb;
                zzd.zzc.zza(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.zza;
            zzd zzd2 = this.zzb;
            zzu zzu = (zzu) task;
            zzq<TResult> zzq = zzu.zzb;
            zzv.zza(executor);
            zzq.zza(new zzm(executor, zzd2));
            zzu.zze();
            zzu.zzb.zza(new zzl(TaskExecutors.zza, this.zzb));
            zzu.zze();
            zzu.zzb.zza(new zzh(TaskExecutors.zza, this.zzb));
            zzu.zze();
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzb.zzc.zza((Exception) e.getCause());
            } else {
                this.zzb.zzc.zza(e);
            }
        } catch (Exception e2) {
            this.zzb.zzc.zza(e2);
        }
    }
}
