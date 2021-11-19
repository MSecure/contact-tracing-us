package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbm extends zzbu {
    private final /* synthetic */ ListenerHolder zza;
    private final /* synthetic */ zzbx zzb;
    private final /* synthetic */ SubscribeOptions zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbm(zzbj zzbj, GoogleApiClient googleApiClient, ListenerHolder listenerHolder, zzbx zzbx, SubscribeOptions subscribeOptions) {
        super(googleApiClient);
        this.zza = listenerHolder;
        this.zzb = zzbx;
        this.zzc = subscribeOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzag zzag) throws RemoteException {
        zzag.zza(zza(), this.zza, this.zzb, this.zzc, (byte[]) null);
    }
}
