package h.a.j1;

import java.io.Closeable;
/* loaded from: classes.dex */
public interface j2 extends Closeable {
    void K(byte[] bArr, int i2, int i3);

    int b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int readUnsignedByte();

    j2 v(int i2);
}
