package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdv extends zzhi {
    private final ListenerHolder<Connections.EndpointDiscoveryListener> zza;

    zzdv(ListenerHolder<Connections.EndpointDiscoveryListener> listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final void zza(zziy zziy) {
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final void zza(zzim zzim) {
        this.zza.notifyListener(new zzdu(this, zzim));
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final void zza(zzio zzio) {
        this.zza.notifyListener(new zzdx(this, zzio));
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final synchronized void zza(zzik zzik) {
    }
}
