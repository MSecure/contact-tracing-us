package c.b.c.a.m0;

import c.b.c.a.t;

public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5197a;

    public u(byte[] bArr) {
        if (bArr.length == 32) {
            byte[] d2 = s.d(bArr);
            this.f5197a = d2;
            s.e(d2);
            return;
        }
        throw new IllegalArgumentException(String.format("Given private key's length is not %s", 32));
    }
}
