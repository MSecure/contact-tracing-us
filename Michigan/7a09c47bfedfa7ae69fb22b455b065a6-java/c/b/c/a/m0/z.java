package c.b.c.a.m0;

import b.x.t;
import c.b.c.a.a;
import c.b.c.a.o;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class z implements a {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f5209a;

    /* renamed from: b  reason: collision with root package name */
    public final o f5210b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5211c;

    public z(e0 e0Var, o oVar, int i) {
        this.f5209a = e0Var;
        this.f5210b = oVar;
        this.f5211c = i;
    }

    @Override // c.b.c.a.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] a2 = this.f5209a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return t.N(a2, this.f5210b.b(t.N(bArr2, a2, copyOf)));
    }

    @Override // c.b.c.a.a
    public byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f5211c;
        if (length >= i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.f5211c, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            this.f5210b.a(copyOfRange2, t.N(bArr2, copyOfRange, copyOf));
            return this.f5209a.b(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
