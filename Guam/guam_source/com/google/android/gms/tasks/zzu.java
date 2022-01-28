package com.google.android.gms.tasks;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzu<TResult> extends Task<TResult> {
    public final Object zza = new Object();
    public final zzq<TResult> zzb = new zzq<>();
    public boolean zzc;
    public volatile boolean zzd;
    public TResult zze;
    public Exception zzf;

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        zzq<TResult> zzq = this.zzb;
        zzv.zza(executor);
        zzq.zza(new zzh(executor, onCanceledListener));
        zze();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        zzq<TResult> zzq = this.zzb;
        zzv.zza(executor);
        zzq.zza(new zzl(executor, onFailureListener));
        zze();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        zzq<TResult> zzq = this.zzb;
        zzv.zza(executor);
        zzq.zza(new zzm(executor, onSuccessListener));
        zze();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.zza) {
            ReactYogaConfigProvider.checkState(this.zzc, "Task is not yet complete");
            if (this.zzd) {
                throw new CancellationException("Task is already canceled.");
            } else if (this.zzf == null) {
                tresult = this.zze;
            } else {
                throw new RuntimeExecutionException(this.zzf);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc && !this.zzd && this.zzf == null;
        }
        return z;
    }

    public final void zza(TResult tresult) {
        synchronized (this.zza) {
            if (!this.zzc) {
                this.zzc = true;
                this.zze = tresult;
            } else {
                throw DuplicateTaskCompletionException.of(this);
            }
        }
        this.zzb.zza(this);
    }

    public final void zze() {
        synchronized (this.zza) {
            if (this.zzc) {
                this.zzb.zza(this);
            }
        }
    }

    public final void zza(Exception exc) {
        ReactYogaConfigProvider.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            if (!this.zzc) {
                this.zzc = true;
                this.zzf = exc;
            } else {
                throw DuplicateTaskCompletionException.of(this);
            }
        }
        this.zzb.zza(this);
    }
}
