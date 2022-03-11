package f.b.a.c.b;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class v extends t {
    public final byte[] b;

    public v(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.b = bArr;
    }

    @Override // f.b.a.c.b.t
    public final byte[] z() {
        return this.b;
    }
}
