package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzen implements RemoteCall {
    private final zzei zza;
    private final List zzb;
    private final Payload zzc;

    zzen(zzei zzei, List list, Payload payload) {
        this.zza = zzei;
        this.zzb = list;
        this.zzc = payload;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzei zzei = this.zza;
        List list = this.zzb;
        ((zzdd) obj).zza((BaseImplementation.ResultHolder<Status>) new zzfo(zzei, (TaskCompletionSource) obj2), (String[]) list.toArray(new String[0]), this.zzc, false);
    }
}
