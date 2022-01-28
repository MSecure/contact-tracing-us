package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzh extends zzb {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzh(byte[] bArr) {
        super(bArr);
        Preconditions.checkArgument(bArr.length == 10 || bArr.length == 16, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
    }

    public zzh(String str) {
        this(zza(str));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    private zzh(byte[] bArr, byte[] bArr2) {
        this(ArrayUtils.concatByteArrays(r0));
        byte[][] bArr3 = new byte[2][];
        boolean z = false;
        boolean z2 = bArr.length == 10;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(53);
        sb.append("Namespace length(");
        sb.append(length);
        sb.append(" bytes) must be 10 bytes.");
        Preconditions.checkArgument(z2, sb.toString());
        bArr3[0] = bArr;
        z = bArr2.length == 6 ? true : z;
        int length2 = bArr2.length;
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("Instance length(");
        sb2.append(length2);
        sb2.append(" bytes) must be 6 bytes.");
        Preconditions.checkArgument(z, sb2.toString());
        bArr3[1] = bArr2;
    }

    public zzh(String str, String str2) {
        this(zza(str), zza(str2));
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzb
    public final String toString() {
        String zzb = zzb();
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 26);
        sb.append("EddystoneUidPrefix{bytes=");
        sb.append(zzb);
        sb.append('}');
        return sb.toString();
    }
}
