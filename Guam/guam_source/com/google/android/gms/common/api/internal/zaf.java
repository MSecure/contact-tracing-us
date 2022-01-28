package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzq;
import com.google.android.gms.tasks.zzu;
import com.google.android.gms.tasks.zzv;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaf<ResultT> extends zab {
    public final TaskApiCall<Object, ResultT> zab;
    public final TaskCompletionSource<ResultT> zac;
    public final ApiExceptionMapper zad;

    public zaf(int i, TaskApiCall<Object, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, ApiExceptionMapper apiExceptionMapper) {
        super(i);
        this.zac = taskCompletionSource;
        this.zab = taskApiCall;
        this.zad = apiExceptionMapper;
        if (i == 2 && taskApiCall.zab) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaa(Status status) {
        Exception exc;
        TaskCompletionSource<ResultT> taskCompletionSource = this.zac;
        if (this.zad != null) {
            if (status.zze != null) {
                exc = new ResolvableApiException(status);
            } else {
                exc = new ApiException(status);
            }
            taskCompletionSource.trySetException(exc);
            return;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final boolean zab(GoogleApiManager.zaa<?> zaa) {
        return this.zab.zab;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            TaskApiCall<Object, ResultT> taskApiCall = this.zab;
            ((zacg) taskApiCall).zaa.zaa.accept(zaa.zac, this.zac);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zaa(zac.zaa(e2));
        } catch (RuntimeException e3) {
            this.zac.trySetException(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaa(Exception exc) {
        this.zac.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaa(zaw zaw, boolean z) {
        TaskCompletionSource<ResultT> taskCompletionSource = this.zac;
        zaw.zab.put(taskCompletionSource, Boolean.valueOf(z));
        zzu<TResult> zzu = taskCompletionSource.zza;
        zay zay = new zay(zaw, taskCompletionSource);
        if (zzu != null) {
            Executor executor = TaskExecutors.MAIN_THREAD;
            zzq<TResult> zzq = zzu.zzb;
            zzv.zza(executor);
            zzq.zza(new zzi(executor, zay));
            zzu.zze();
            return;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final Feature[] zaa(GoogleApiManager.zaa<?> zaa) {
        return this.zab.zaa;
    }
}
