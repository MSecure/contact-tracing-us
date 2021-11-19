package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzbn extends zzbu {
    private final /* synthetic */ Message zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbn(zzbj zzbj, GoogleApiClient googleApiClient, Message message) {
        super(googleApiClient);
        this.zza = message;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzag zzag) throws RemoteException {
        zzag.zza(zza(), zzae.zza(this.zza));
    }
}
