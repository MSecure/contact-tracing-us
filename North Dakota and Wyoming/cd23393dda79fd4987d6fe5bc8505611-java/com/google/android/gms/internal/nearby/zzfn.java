package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzfn extends RegisterListenerMethod<zzdd, EndpointDiscoveryCallback> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ ListenerHolder zzb;
    private final /* synthetic */ DiscoveryOptions zzc;
    private final /* synthetic */ zzei zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfn(zzei zzei, ListenerHolder listenerHolder, String str, ListenerHolder listenerHolder2, DiscoveryOptions discoveryOptions) {
        super(listenerHolder);
        this.zzd = zzei;
        this.zza = str;
        this.zzb = listenerHolder2;
        this.zzc = discoveryOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzdd zzdd, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzdd.zza(new zzfo(this.zzd, taskCompletionSource), this.zza, this.zzb, this.zzc);
    }
}
