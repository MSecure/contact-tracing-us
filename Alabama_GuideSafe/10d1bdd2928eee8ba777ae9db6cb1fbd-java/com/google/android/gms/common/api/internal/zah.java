package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zah extends zae<Boolean> {
    public final ListenerHolder$ListenerKey<?> zac;

    public zah(ListenerHolder$ListenerKey<?> listenerHolder$ListenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zac = listenerHolder$ListenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final /* bridge */ /* synthetic */ void zaa(zaw zaw, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final Feature[] zaa(GoogleApiManager.zaa<?> zaa) {
        if (zaa.zag.get(this.zac) == null) {
            return null;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final boolean zab(GoogleApiManager.zaa<?> zaa) {
        if (zaa.zag.get(this.zac) == null) {
            return false;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zae
    public final void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException {
        if (zaa.zag.remove(this.zac) == null) {
            this.zab.trySetResult((T) Boolean.FALSE);
            return;
        }
        throw null;
    }
}
