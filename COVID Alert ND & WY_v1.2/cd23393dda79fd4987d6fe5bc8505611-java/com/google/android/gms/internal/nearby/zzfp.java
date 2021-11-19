package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzfp extends ConnectionLifecycleCallback {
    private final ConnectionLifecycleCallback zza;
    private final /* synthetic */ zzei zzb;

    zzfp(zzei zzei, ConnectionLifecycleCallback connectionLifecycleCallback) {
        this.zzb = zzei;
        this.zza = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            zzei.zzb(this.zzb, str);
        }
        this.zza.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().isSuccess()) {
            zzei.zza(this.zzb, str);
        }
        this.zza.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String str) {
        zzei.zza(this.zzb, str);
        this.zza.onDisconnected(str);
    }
}
