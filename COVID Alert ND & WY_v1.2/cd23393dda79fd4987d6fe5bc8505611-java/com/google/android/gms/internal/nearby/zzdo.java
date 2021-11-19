package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdo extends zzhi {
    private final ListenerHolder<EndpointDiscoveryCallback> zza;
    private final Set<String> zzb = new ArraySet();

    zzdo(ListenerHolder<EndpointDiscoveryCallback> listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final void zza(zziy zziy) {
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final synchronized void zza(zzik zzik) {
        this.zza.notifyListener(new zzdr(this, zzik));
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final synchronized void zza(zzim zzim) {
        if (!zzc(zzim)) {
            this.zzb.add(zzim.zza());
        }
        this.zza.notifyListener(new zzdq(this, zzim));
    }

    /* access modifiers changed from: private */
    public static boolean zzc(zzim zzim) {
        if (zzim.zzd() != null) {
            return zzim.zza() == null || "__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(zzim.zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final synchronized void zza(zzio zzio) {
        this.zzb.remove(zzio.zza());
        this.zza.notifyListener(new zzdt(this, zzio));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza() {
        for (String str : this.zzb) {
            this.zza.notifyListener(new zzds(this, str));
        }
        this.zzb.clear();
    }
}
