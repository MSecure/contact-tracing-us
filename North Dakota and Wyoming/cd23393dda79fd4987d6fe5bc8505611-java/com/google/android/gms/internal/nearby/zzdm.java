package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

@Deprecated
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdm extends zzhf {
    private final ListenerHolder<Connections.ConnectionResponseCallback> zza;

    public zzdm(ListenerHolder<Connections.ConnectionResponseCallback> listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzhc
    public final void zza(zzie zzie) {
        this.zza.notifyListener(new zzdp(this, zzie));
    }
}
