package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.Strategy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzfz extends zzgm {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ ListenerHolder zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfz(zzfq zzfq, GoogleApiClient googleApiClient, String str, long j, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = j;
        this.zzc = listenerHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzdd zzdd) throws RemoteException {
        String str = this.zza;
        long j = this.zzb;
        ListenerHolder listenerHolder = this.zzc;
        ((zzhk) zzdd.getService()).zza(new zzjx().zza(new zzej(this)).zza(str).zzb("__LEGACY_SERVICE_ID__").zza(j).zza(new zzdk(listenerHolder)).zza(new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_CLUSTER).build()).zza());
    }
}
