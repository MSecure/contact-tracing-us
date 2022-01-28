package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdf extends zzha {
    private final ListenerHolder<ConnectionLifecycleCallback> zza;
    private final Set<String> zzb = new ArraySet();
    private final Set<String> zzc = new ArraySet();

    zzdf(ListenerHolder<ConnectionLifecycleCallback> listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzhb
    public final synchronized void zza(zzia zzia) {
        this.zzb.add(zzia.zza());
        this.zza.notifyListener(new zzde(this, zzia));
    }

    @Override // com.google.android.gms.internal.nearby.zzhb
    public final synchronized void zza(zzig zzig) {
        this.zzb.remove(zzig.zza());
        Status zza2 = zzdd.zza(zzig.zzb());
        if (zza2.isSuccess()) {
            this.zzc.add(zzig.zza());
        }
        this.zza.notifyListener(new zzdh(this, zzig, zza2));
    }

    @Override // com.google.android.gms.internal.nearby.zzhb
    public final synchronized void zza(zzii zzii) {
        this.zzc.remove(zzii.zza());
        this.zza.notifyListener(new zzdg(this, zzii));
    }

    @Override // com.google.android.gms.internal.nearby.zzhb
    public final void zza(zzhy zzhy) {
        this.zza.notifyListener(new zzdj(this, zzhy));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza() {
        for (String str : this.zzb) {
            this.zza.notifyListener(new zzdi(this, str));
        }
        this.zzb.clear();
        for (String str2 : this.zzc) {
            this.zza.notifyListener(new zzdl(this, str2));
        }
        this.zzc.clear();
    }
}
