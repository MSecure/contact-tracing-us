package f.b.a.c.b;

import java.util.Arrays;

public final class v extends t {
    public final byte[] b;

    public v(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.b = bArr;
    }

    @Override // f.b.a.c.b.t
    public final byte[] m() {
        return this.b;
    }
}
