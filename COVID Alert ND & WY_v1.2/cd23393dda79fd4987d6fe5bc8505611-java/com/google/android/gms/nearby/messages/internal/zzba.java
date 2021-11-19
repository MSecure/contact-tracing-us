package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzba extends TaskApiCall<zzag, Void> {
    private final /* synthetic */ zzbc zza;
    private final /* synthetic */ zzal zzb;

    zzba(zzal zzal, zzbc zzbc) {
        this.zzb = zzal;
        this.zza = zzbc;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzag zzag, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.zza.zza(zzag, this.zzb.zza((TaskCompletionSource) taskCompletionSource));
    }
}
