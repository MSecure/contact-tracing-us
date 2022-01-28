package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.internal.zzr;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzkt extends zzr {
    private final ListenerHolder<BaseImplementation.ResultHolder<Status>> zza;
    private boolean zzb = false;

    public zzkt(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzo
    public final synchronized void zza(Status status) throws RemoteException {
        if (!this.zzb) {
            this.zza.notifyListener(new zzkw(this, status));
            this.zzb = true;
            return;
        }
        String valueOf = String.valueOf(status);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
        sb.append("Received multiple statuses: ");
        sb.append(valueOf);
        Log.wtf("NearbyMessagesCallbackWrapper", sb.toString(), new Exception());
    }
}
