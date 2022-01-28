package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzew implements RemoteCall {
    private final zzei zza;
    private final String zzb;
    private final Payload zzc;

    zzew(zzei zzei, String str, Payload payload) {
        this.zza = zzei;
        this.zzb = str;
        this.zzc = payload;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzei zzei = this.zza;
        String str = this.zzb;
        Payload payload = this.zzc;
        ((zzdd) obj).zza((BaseImplementation.ResultHolder<Status>) new zzfo(zzei, (TaskCompletionSource) obj2), new String[]{str}, payload, false);
    }
}
