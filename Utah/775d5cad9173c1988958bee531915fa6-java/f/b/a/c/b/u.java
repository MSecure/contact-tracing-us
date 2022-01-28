package f.b.a.c.b;

import java.lang.ref.WeakReference;

public abstract class u extends t {
    public static final WeakReference<byte[]> c = new WeakReference<>(null);
    public WeakReference<byte[]> b = c;

    public u(byte[] bArr) {
        super(bArr);
    }

    public abstract byte[] H();

    @Override // f.b.a.c.b.t
    public final byte[] q() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.b.get();
            if (bArr == null) {
                bArr = H();
                this.b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
