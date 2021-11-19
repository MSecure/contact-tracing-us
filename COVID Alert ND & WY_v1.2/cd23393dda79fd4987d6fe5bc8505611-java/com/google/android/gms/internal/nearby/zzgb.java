package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzgb extends zzgo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ byte[] zzc;
    private final /* synthetic */ ListenerHolder zzd;
    private final /* synthetic */ ListenerHolder zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgb(zzfq zzfq, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = listenerHolder;
        this.zze = listenerHolder2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzdd zzdd) throws RemoteException {
        zzdd zzdd2 = zzdd;
        String str = this.zza;
        String str2 = this.zzb;
        byte[] bArr = this.zzc;
        ListenerHolder listenerHolder = this.zzd;
        ((zzhk) zzdd2.getService()).zza(new zzjp().zza(new zzeh(this)).zza(str).zzb(str2).zza(bArr).zza(new zzdw(zzdd2.getContext(), this.zze)).zza(new zzdm(listenerHolder)).zza());
    }
}
