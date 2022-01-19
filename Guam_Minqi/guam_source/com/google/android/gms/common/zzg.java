package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzg extends zzd {
    public final byte[] zza;

    public zzg(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    @Override // com.google.android.gms.common.zzd
    public final byte[] zza() {
        return this.zza;
    }
}
