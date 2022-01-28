package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzfu extends zzgo {
    private final /* synthetic */ long zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfu(zzfq zzfq, GoogleApiClient googleApiClient, long j) {
        super(googleApiClient, null);
        this.zza = j;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzdd zzdd) throws RemoteException {
        zzdd.zza(this, this.zza);
    }
}
