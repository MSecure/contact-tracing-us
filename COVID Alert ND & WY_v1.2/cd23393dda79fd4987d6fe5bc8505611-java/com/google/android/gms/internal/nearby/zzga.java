package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzga extends zzgo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ byte[] zzb;
    private final /* synthetic */ ListenerHolder zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzga(zzfq zzfq, GoogleApiClient googleApiClient, String str, byte[] bArr, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = bArr;
        this.zzc = listenerHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzdd zzdd) throws RemoteException {
        zzdd zzdd2 = zzdd;
        String str = this.zza;
        ((zzhk) zzdd2.getService()).zza(new zzcs().zza(new zzeh(this)).zza(str).zza(this.zzb).zza(new zzdw(zzdd2.getContext(), this.zzc)).zza());
    }
}
