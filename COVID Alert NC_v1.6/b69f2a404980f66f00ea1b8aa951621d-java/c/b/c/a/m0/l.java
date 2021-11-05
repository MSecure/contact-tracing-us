package c.b.c.a.m0;

import c.b.a.a.c.n.c;
import c.b.c.a.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;

public abstract class l implements a {

    /* renamed from: a  reason: collision with root package name */
    public final j f3758a;

    /* renamed from: b  reason: collision with root package name */
    public final j f3759b;

    public l(byte[] bArr) {
        this.f3758a = d(bArr, 1);
        this.f3759b = d(bArr, 0);
    }

    public static byte[] c(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int remaining = byteBuffer.remaining();
        int i = remaining % 16;
        int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
        ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(length);
        order.put(byteBuffer);
        order.position(i2);
        order.putLong((long) bArr.length);
        order.putLong((long) remaining);
        return order.array();
    }

    @Override // c.b.c.a.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= (Integer.MAX_VALUE - this.f3758a.g()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(this.f3758a.g() + bArr.length + 16);
            if (allocate.remaining() >= this.f3758a.g() + bArr.length + 16) {
                int position = allocate.position();
                this.f3758a.f(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.f3758a.g()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                this.f3759b.c(bArr3, 0).get(bArr4);
                byte[] B = c.B(bArr4, c(bArr2, allocate));
                allocate.limit(allocate.limit() + 16);
                allocate.put(B);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // c.b.c.a.a
    public byte[] b(byte[] bArr, byte[] bArr2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.remaining() >= this.f3758a.g() + 16) {
            int position = wrap.position();
            byte[] bArr3 = new byte[16];
            wrap.position(wrap.limit() - 16);
            wrap.get(bArr3);
            wrap.position(position);
            wrap.limit(wrap.limit() - 16);
            byte[] bArr4 = new byte[this.f3758a.g()];
            wrap.get(bArr4);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            try {
                byte[] bArr5 = new byte[32];
                this.f3759b.c(bArr4, 0).get(bArr5);
                if (c.K0(c.B(bArr5, c(bArr2, wrap)), bArr3)) {
                    wrap.position(position);
                    return this.f3758a.e(wrap);
                }
                throw new GeneralSecurityException("invalid MAC");
            } catch (GeneralSecurityException e2) {
                throw new AEADBadTagException(e2.toString());
            }
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }

    public abstract j d(byte[] bArr, int i);
}
