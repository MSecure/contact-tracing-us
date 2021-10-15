package c.b.a.a.d;

import java.lang.ref.WeakReference;

public abstract class u extends t {

    /* renamed from: c  reason: collision with root package name */
    public static final WeakReference<byte[]> f3185c = new WeakReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<byte[]> f3186b = f3185c;

    public u(byte[] bArr) {
        super(bArr);
    }

    @Override // c.b.a.a.d.t
    public final byte[] f0() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f3186b.get();
            if (bArr == null) {
                bArr = h0();
                this.f3186b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] h0();
}
