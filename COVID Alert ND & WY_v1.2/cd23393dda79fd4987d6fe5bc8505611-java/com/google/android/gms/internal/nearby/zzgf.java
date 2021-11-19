package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzgf extends zzgo {
    private final /* synthetic */ List zza;
    private final /* synthetic */ byte[] zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgf(zzfq zzfq, GoogleApiClient googleApiClient, List list, byte[] bArr) {
        super(googleApiClient, null);
        this.zza = list;
        this.zzb = bArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzdd zzdd) throws RemoteException {
        zzdd.zza((BaseImplementation.ResultHolder<Status>) this, (String[]) this.zza.toArray(new String[0]), Payload.fromBytes(this.zzb), true);
    }
}
