package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzfl extends RegisterListenerMethod<zzdd, Object> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ ListenerHolder zzc;
    private final /* synthetic */ AdvertisingOptions zzd;
    private final /* synthetic */ zzei zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfl(zzei zzei, ListenerHolder listenerHolder, String str, String str2, ListenerHolder listenerHolder2, AdvertisingOptions advertisingOptions) {
        super(listenerHolder);
        this.zze = zzei;
        this.zza = str;
        this.zzb = str2;
        this.zzc = listenerHolder2;
        this.zzd = advertisingOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzdd zzdd, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzdd.zza(new zzfo(this.zze, taskCompletionSource), this.zza, this.zzb, this.zzc, this.zzd);
    }
}
