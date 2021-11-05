package c.b.c.a.m0;

import c.b.a.a.c.n.c;
import c.b.c.a.a;
import c.b.c.a.o;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class z implements a {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f3808a;

    /* renamed from: b  reason: collision with root package name */
    public final o f3809b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3810c;

    public z(e0 e0Var, o oVar, int i) {
        this.f3808a = e0Var;
        this.f3809b = oVar;
        this.f3810c = i;
    }

    @Override // c.b.c.a.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] a2 = this.f3808a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return c.C(a2, this.f3809b.b(c.C(bArr2, a2, copyOf)));
    }

    @Override // c.b.c.a.a
    public byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f3810c;
        if (length >= i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.f3810c, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            this.f3809b.a(copyOfRange2, c.C(bArr2, copyOfRange, copyOf));
            return this.f3808a.b(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
