package com.google.android.gms.internal.nearby;

import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzlj extends zzlh<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzlh zzc;

    zzlj(zzlh zzlh, int i, int i2) {
        this.zzc = zzlh;
        this.zza = i;
        this.zzb = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public final boolean zzg() {
        return true;
    }

    public final int size() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public final Object[] zzd() {
        return this.zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public final int zze() {
        return this.zzc.zze() + this.zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public final int zzf() {
        return this.zzc.zze() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzld.zza(i, this.zzb);
        return (E) this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzlh
    public final zzlh<E> zza(int i, int i2) {
        zzld.zza(i, i2, this.zzb);
        zzlh zzlh = this.zzc;
        int i3 = this.zza;
        return (zzlh) zzlh.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.nearby.zzlh, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
