package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public abstract class zzf extends zzd {
    public static final WeakReference<byte[]> zzb = new WeakReference<>(null);
    public WeakReference<byte[]> zza = zzb;

    public zzf(byte[] bArr) {
        super(bArr);
    }

    @Override // com.google.android.gms.common.zzd
    public final byte[] zza() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zza.get();
            if (bArr == null) {
                bArr = zzd();
                this.zza = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] zzd();
}
