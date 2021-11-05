package c.b.c.a.m0;

public class i extends j {
    public i(byte[] bArr, int i) {
        super(bArr, i);
    }

    @Override // c.b.c.a.m0.j
    public int[] d(int[] iArr, int i) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            j.k(iArr2, this.f3751a);
            iArr2[12] = i;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
    }

    @Override // c.b.c.a.m0.j
    public int g() {
        return 12;
    }
}
