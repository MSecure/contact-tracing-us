package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

@Deprecated
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdk extends zzgu {
    private final ListenerHolder<Connections.ConnectionRequestListener> zza;

    zzdk(ListenerHolder<Connections.ConnectionRequestListener> listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzgv
    public final void zza(zziw zziw) {
    }

    @Override // com.google.android.gms.internal.nearby.zzgv
    public final void zza(zzic zzic) {
        this.zza.notifyListener(new zzdn(this, zzic));
    }
}
