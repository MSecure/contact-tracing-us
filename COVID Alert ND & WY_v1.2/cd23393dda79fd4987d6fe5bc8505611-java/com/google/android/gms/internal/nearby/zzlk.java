package com.google.android.gms.internal.nearby;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzlk<E> extends zzlf<E> {
    private final zzlh<E> zza;

    zzlk(zzlh<E> zzlh, int i) {
        super(zzlh.size(), i);
        this.zza = zzlh;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.nearby.zzlf
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
