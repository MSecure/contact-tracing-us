package com.google.android.gms.nearby.messages.internal;

import b.x.t;
import java.util.Arrays;

public final class zzf extends zzc {
    public zzf(String str) {
        this(zzc.zza(str));
    }

    public zzf(String str, String str2) {
        this(zzc.zza(str), zzc.zza(str2));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzf(byte[] bArr) {
        super(bArr);
        t.r(bArr.length == 10 || bArr.length == 16, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public zzf(byte[] bArr, byte[] bArr2) {
        this(r9);
        byte[][] bArr3 = new byte[2][];
        boolean z = bArr.length == 10;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(53);
        sb.append("Namespace length(");
        sb.append(length);
        sb.append(" bytes) must be 10 bytes.");
        t.r(z, sb.toString());
        bArr3[0] = bArr;
        boolean z2 = bArr2.length == 6;
        int length2 = bArr2.length;
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("Instance length(");
        sb2.append(length2);
        sb2.append(" bytes) must be 6 bytes.");
        t.r(z2, sb2.toString());
        bArr3[1] = bArr2;
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i += bArr3[i2].length;
        }
        byte[] copyOf = Arrays.copyOf(bArr3[0], i);
        int length3 = bArr3[0].length;
        for (int i3 = 1; i3 < 2; i3++) {
            byte[] bArr4 = bArr3[i3];
            System.arraycopy(bArr4, 0, copyOf, length3, bArr4.length);
            length3 += bArr4.length;
        }
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        String zzb = zzb();
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 26);
        sb.append("EddystoneUidPrefix{bytes=");
        sb.append(zzb);
        sb.append('}');
        return sb.toString();
    }
}
