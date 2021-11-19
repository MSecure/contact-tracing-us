package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzbl extends zzbu {
    private final /* synthetic */ ListenerHolder zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbl(zzbj zzbj, GoogleApiClient googleApiClient, ListenerHolder listenerHolder) {
        super(googleApiClient);
        this.zza = listenerHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzag zzag) throws RemoteException {
        zzag.zzc(zza(), this.zza);
    }
}
