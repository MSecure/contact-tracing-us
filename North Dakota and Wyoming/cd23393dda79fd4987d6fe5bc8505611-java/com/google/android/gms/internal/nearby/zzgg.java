package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzgg extends zzgo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ ListenerHolder zzb;
    private final /* synthetic */ DiscoveryOptions zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgg(zzfq zzfq, GoogleApiClient googleApiClient, String str, ListenerHolder listenerHolder, DiscoveryOptions discoveryOptions) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = listenerHolder;
        this.zzc = discoveryOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzdd zzdd) throws RemoteException {
        zzdd.zza(this, this.zza, this.zzb, this.zzc);
    }
}
