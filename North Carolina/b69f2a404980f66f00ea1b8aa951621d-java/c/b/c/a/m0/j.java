package c.b.c.a.m0;

import c.b.a.a.c.n.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

public abstract class j implements e0 {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f3750c = m(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* renamed from: a  reason: collision with root package name */
    public int[] f3751a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3752b;

    public j(byte[] bArr, int i) {
        if (bArr.length == 32) {
            this.f3751a = m(bArr);
            this.f3752b = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public static void i(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = j(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = j(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = j(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = j(iArr[i2] ^ iArr[i3], 7);
    }

    public static int j(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public static void k(int[] iArr, int[] iArr2) {
        int[] iArr3 = f3750c;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, f3750c.length, 8);
    }

    public static void l(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            i(iArr, 0, 4, 8, 12);
            i(iArr, 1, 5, 9, 13);
            i(iArr, 2, 6, 10, 14);
            i(iArr, 3, 7, 11, 15);
            i(iArr, 0, 5, 10, 15);
            i(iArr, 1, 6, 11, 12);
            i(iArr, 2, 7, 8, 13);
            i(iArr, 3, 4, 9, 14);
        }
    }

    public static int[] m(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    @Override // c.b.c.a.m0.e0
    public byte[] a(byte[] bArr) {
        if (bArr.length <= Integer.MAX_VALUE - g()) {
            ByteBuffer allocate = ByteBuffer.allocate(g() + bArr.length);
            f(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // c.b.c.a.m0.e0
    public byte[] b(byte[] bArr) {
        return e(ByteBuffer.wrap(bArr));
    }

    public ByteBuffer c(byte[] bArr, int i) {
        int[] d2 = d(m(bArr), i);
        int[] iArr = (int[]) d2.clone();
        l(iArr);
        for (int i2 = 0; i2 < d2.length; i2++) {
            d2[i2] = d2[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(d2, 0, 16);
        return order;
    }

    public abstract int[] d(int[] iArr, int i);

    public byte[] e(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= g()) {
            byte[] bArr = new byte[g()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            h(bArr, allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public void f(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() - g() >= bArr.length) {
            byte[] a2 = i0.a(g());
            byteBuffer.put(a2);
            h(a2, byteBuffer, ByteBuffer.wrap(bArr));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    public abstract int g();

    public final void h(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer2.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer c2 = c(bArr, this.f3752b + i2);
            if (i2 == i - 1) {
                c.B2(byteBuffer, byteBuffer2, c2, remaining % 64);
            } else {
                c.B2(byteBuffer, byteBuffer2, c2, 64);
            }
        }
    }
}
