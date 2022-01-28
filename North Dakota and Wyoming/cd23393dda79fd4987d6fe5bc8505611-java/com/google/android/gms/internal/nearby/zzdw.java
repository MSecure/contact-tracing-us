package com.google.android.gms.internal.nearby;

import android.content.Context;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

public final class zzdw extends zzgz {
    private final Context zza;
    private final ListenerHolder<Connections.MessageListener> zzb;

    zzdw(Context context, ListenerHolder<Connections.MessageListener> listenerHolder) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzgw
    public final void zza(zzis zzis) {
    }

    @Override // com.google.android.gms.internal.nearby.zzgw
    public final void zza(zziq zziq) {
        this.zzb.notifyListener(new zzdz(this, zziq));
    }

    @Override // com.google.android.gms.internal.nearby.zzgw
    public final void zza(zzii zzii) {
        this.zzb.notifyListener(new zzdy(this, zzii));
    }
}
