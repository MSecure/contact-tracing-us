package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdy extends zzeb<Connections.MessageListener> {
    private final /* synthetic */ zzii zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdy(zzdw zzdw, zzii zzii) {
        super();
        this.zza = zzii;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.MessageListener) obj).onDisconnected(this.zza.zza());
    }
}
