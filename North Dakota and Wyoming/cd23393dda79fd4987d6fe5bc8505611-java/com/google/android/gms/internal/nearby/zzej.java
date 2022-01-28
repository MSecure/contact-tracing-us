package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzej extends zzhv {
    private final BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> zza;

    zzej(BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzhs
    public final void zza(zziu zziu) {
        Status zzb = zzdd.zzb(zziu.zza());
        if (zzb.isSuccess()) {
            this.zza.setResult(new zzeg(zzb, zziu.zzb()));
        } else {
            this.zza.setFailedResult(zzb);
        }
    }
}
