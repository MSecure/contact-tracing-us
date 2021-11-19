package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzv implements RemoteCall {
    static final RemoteCall zza = new zzv();

    private zzv() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        ((zzbq) ((zzr) obj).getService()).zza((zzr) new zzcn().zza(zzt.zza((TaskCompletionSource) obj2)).zza());
    }
}
