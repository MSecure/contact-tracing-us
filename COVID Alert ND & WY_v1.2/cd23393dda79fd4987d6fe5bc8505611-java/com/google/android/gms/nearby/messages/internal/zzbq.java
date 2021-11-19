package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.nearby.zzkt;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzbq extends zzbu {
    zzbq(zzbj zzbj, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzag zzag) throws RemoteException {
        ((zzt) zzag.getService()).zza(new zzg(new zzkt(zza())));
    }
}
