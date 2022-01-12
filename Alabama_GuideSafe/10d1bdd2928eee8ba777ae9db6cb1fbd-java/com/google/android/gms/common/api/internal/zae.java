package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class zae<T> extends zab {
    public final TaskCompletionSource<T> zab;

    public zae(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zab = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public void zaa(Status status) {
        this.zab.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            zad(zaa);
        } catch (DeadObjectException e) {
            this.zab.trySetException(new ApiException(zac.zaa((RemoteException) e)));
            throw e;
        } catch (RemoteException e2) {
            this.zab.trySetException(new ApiException(zac.zaa(e2)));
        } catch (RuntimeException e3) {
            this.zab.trySetException(e3);
        }
    }

    public abstract void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zac
    public void zaa(Exception exc) {
        this.zab.trySetException(exc);
    }
}
