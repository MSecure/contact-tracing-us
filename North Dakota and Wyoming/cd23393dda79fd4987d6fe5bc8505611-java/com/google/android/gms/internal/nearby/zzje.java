package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzje {
    private final zzjc zza = new zzjc();

    public final zzje zza(long j) {
        this.zza.zza = j;
        return this;
    }

    public final zzje zza(int i) {
        this.zza.zzb = i;
        return this;
    }

    public final zzje zza(byte[] bArr) {
        this.zza.zzc = bArr;
        return this;
    }

    public final zzje zza(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzd = parcelFileDescriptor;
        return this;
    }

    public final zzje zza(String str) {
        this.zza.zze = str;
        return this;
    }

    public final zzje zzb(long j) {
        this.zza.zzf = j;
        return this;
    }

    public final zzje zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzg = parcelFileDescriptor;
        return this;
    }

    public final zzjc zza() {
        return this.zza;
    }
}
