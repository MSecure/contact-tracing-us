package c.b.c.a.b0;

import c.b.c.a.a;
import c.b.c.a.i0.x0;
import c.b.c.a.y;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class i implements a {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f3437c = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public final x0 f3438a;

    /* renamed from: b  reason: collision with root package name */
    public final a f3439b;

    public i(x0 x0Var, a aVar) {
        this.f3438a = x0Var;
        this.f3439b = aVar;
    }

    @Override // c.b.c.a.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] byteArray = y.f(this.f3438a).toByteArray();
        byte[] a2 = this.f3439b.a(byteArray, f3437c);
        byte[] a3 = ((a) y.c(this.f3438a.typeUrl_, byteArray, a.class)).a(bArr, bArr2);
        return ByteBuffer.allocate(a2.length + 4 + a3.length).putInt(a2.length).put(a2).put(a3).array();
    }

    @Override // c.b.c.a.a
    public byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((a) y.c(this.f3438a.typeUrl_, this.f3439b.b(bArr3, f3437c), a.class)).b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e2) {
            throw new GeneralSecurityException("invalid ciphertext", e2);
        }
    }
}
