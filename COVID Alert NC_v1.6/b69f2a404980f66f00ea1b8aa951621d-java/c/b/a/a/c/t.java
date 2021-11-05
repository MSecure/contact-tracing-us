package c.b.a.a.c;

import java.lang.ref.WeakReference;

public abstract class t extends s {

    /* renamed from: c  reason: collision with root package name */
    public static final WeakReference<byte[]> f2504c = new WeakReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<byte[]> f2505b = f2504c;

    public t(byte[] bArr) {
        super(bArr);
    }

    @Override // c.b.a.a.c.s
    public final byte[] d() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f2505b.get();
            if (bArr == null) {
                bArr = h0();
                this.f2505b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] h0();
}
