package com.google.android.gms.nearby.fastpair;

import b.b.k.i;
import c.b.a.a.c.n.d;
import java.util.Arrays;

public final class FastPairAccountKey {
    public final byte[] zza;

    public FastPairAccountKey(byte[] bArr) {
        i.j.s(bArr);
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FastPairAccountKey.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zza, ((FastPairAccountKey) obj).zza);
    }

    public final byte[] getBytes() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final boolean isEmpty() {
        return this.zza.length == 0;
    }

    public final String toString() {
        return d.a(this.zza);
    }
}
