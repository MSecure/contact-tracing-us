package com.google.android.gms.internal.nearby;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzlm<E> extends zzlh<E> {
    static final zzlh<Object> zza = new zzlm(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzlm(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public final int zze() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public final boolean zzg() {
        return false;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public final Object[] zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public final int zzf() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzlh, com.google.android.gms.internal.nearby.zzli
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc + 0;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzld.zza(i, this.zzc);
        return (E) this.zzb[i];
    }
}
