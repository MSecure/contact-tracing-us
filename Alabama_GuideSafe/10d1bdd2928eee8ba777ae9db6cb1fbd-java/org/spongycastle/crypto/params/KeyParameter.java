package org.spongycastle.crypto.params;

public class KeyParameter {
    public byte[] key;

    public KeyParameter(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.key = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }

    public KeyParameter(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.key = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
