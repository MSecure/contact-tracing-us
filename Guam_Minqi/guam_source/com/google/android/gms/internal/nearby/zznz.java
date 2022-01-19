package com.google.android.gms.internal.nearby;

import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zznz extends zznx<E> {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zznx zzc;

    public zznz(zznx zznx, int i, int i2) {
        this.zzc = zznx;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        ReactYogaConfigProvider.zza(i, this.zzb);
        return (E) this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zznx
    /* renamed from: zza */
    public final zznx<E> subList(int i, int i2) {
        ReactYogaConfigProvider.zza(i, i2, this.zzb);
        zznx zznx = this.zzc;
        int i3 = this.zza;
        return (zznx) zznx.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.nearby.zznw
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.nearby.zznw
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zznw
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zznw
    public final boolean zzf() {
        return true;
    }
}
