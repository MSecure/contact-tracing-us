package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzay extends RegisterListenerMethod<zzag, T> {
    private final /* synthetic */ zzbc zza;
    private final /* synthetic */ zzal zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzay(zzal zzal, ListenerHolder listenerHolder, zzbc zzbc) {
        super(listenerHolder);
        this.zzb = zzal;
        this.zza = zzbc;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzag zzag, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zza.zza(zzag, this.zzb.zza(taskCompletionSource));
    }
}
