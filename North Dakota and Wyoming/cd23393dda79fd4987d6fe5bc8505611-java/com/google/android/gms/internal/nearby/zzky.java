package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.internal.zzz;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzky extends zzz {
    private final ListenerHolder<StatusCallback> zza;

    public zzky(ListenerHolder<StatusCallback> listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzw
    public final void zza(boolean z) {
        this.zza.notifyListener(new zzkx(this, z));
    }
}
