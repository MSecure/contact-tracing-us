package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzkw extends zzkv<BaseImplementation.ResultHolder<Status>> {
    private final /* synthetic */ Status zza;

    zzkw(zzkt zzkt, Status status) {
        this.zza = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        BaseImplementation.ResultHolder resultHolder = (BaseImplementation.ResultHolder) obj;
        if (this.zza.isSuccess()) {
            resultHolder.setResult(this.zza);
        } else {
            resultHolder.setFailedResult(this.zza);
        }
    }
}
