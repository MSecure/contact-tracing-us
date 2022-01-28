package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.nearby.connection.Payload;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzgc extends zzgo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ byte[] zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgc(zzfq zzfq, GoogleApiClient googleApiClient, String str, byte[] bArr) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = bArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzdd zzdd) throws RemoteException {
        zzdd.zza((BaseImplementation.ResultHolder<Status>) this, new String[]{this.zza}, Payload.fromBytes(this.zzb), true);
    }
}
