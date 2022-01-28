package c.b.c.a.m0;

import c.b.c.a.u;

public final class v implements u {
    public v(byte[] bArr) {
        if (bArr.length == 32) {
            int length = bArr.length;
            System.arraycopy(bArr, 0, new byte[length], 0, length);
            return;
        }
        throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
    }
}
