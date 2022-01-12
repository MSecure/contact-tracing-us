package com.google.android.gms.internal.nearby;

import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzog<E> extends zznx<E> {
    public static final zznx<Object> zza = new zzog(new Object[0], 0);
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzog(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        ReactYogaConfigProvider.zza(i, this.zzc);
        return (E) this.zzb[i];
    }

    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zznx, com.google.android.gms.internal.nearby.zznw
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc + 0;
    }

    @Override // com.google.android.gms.internal.nearby.zznw
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zznw
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.nearby.zznw
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zznw
    public final boolean zzf() {
        return false;
    }
}
