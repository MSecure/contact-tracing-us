package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzfc extends TaskApiCall<zzdd, Void> {
    private final /* synthetic */ zzfm zza;
    private final /* synthetic */ zzei zzb;

    zzfc(zzei zzei, zzfm zzfm) {
        this.zzb = zzei;
        this.zza = zzfm;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzdd zzdd, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.zza.zza(zzdd, new zzfo(this.zzb, taskCompletionSource));
    }
}
