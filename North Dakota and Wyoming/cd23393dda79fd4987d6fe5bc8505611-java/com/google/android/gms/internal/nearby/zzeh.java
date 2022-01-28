package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzeh extends zzhq {
    private final BaseImplementation.ResultHolder<Status> zza;

    zzeh(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzhr
    public final void zza(int i) {
        Status zzb = zzdd.zzb(i);
        if (zzb.isSuccess()) {
            this.zza.setResult(zzb);
        } else {
            this.zza.setFailedResult(zzb);
        }
    }
}
