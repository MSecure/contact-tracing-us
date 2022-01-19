package com.google.android.gms.tasks;

import com.google.android.gms.internal.nearby.zzah;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzd<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzr<TResult> {
    public final Executor zza;
    public final zzah<TResult, Task<TContinuationResult>> zzb;
    public final zzu<TContinuationResult> zzc;

    public zzd(Executor executor, zzah<TResult, Task<TContinuationResult>> zzah, zzu<TContinuationResult> zzu) {
        this.zza = executor;
        this.zzb = zzah;
        this.zzc = zzu;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        zzu<TContinuationResult> zzu = this.zzc;
        synchronized (zzu.zza) {
            if (!zzu.zzc) {
                zzu.zzc = true;
                zzu.zzd = true;
                zzu.zzb.zza(zzu);
            }
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzc.zza(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza(Task<TResult> task) {
        this.zza.execute(new zzf(this, task));
    }
}
