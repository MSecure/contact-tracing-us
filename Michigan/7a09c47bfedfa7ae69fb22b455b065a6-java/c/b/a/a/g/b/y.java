package c.b.a.a.g.b;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class y implements Serializable, Iterable<Byte> {

    /* renamed from: c  reason: collision with root package name */
    public static final y f3474c = new d0(b1.f3230b);

    /* renamed from: d  reason: collision with root package name */
    public static final b0 f3475d = (t.a() ? new e0(null) : new a0(null));

    /* renamed from: b  reason: collision with root package name */
    public int f3476b = 0;

    public static y a(byte[] bArr, int i, int i2) {
        return new d0(f3475d.a(bArr, i, i2));
    }

    public static y c(String str) {
        return new d0(str.getBytes(b1.f3229a));
    }

    public static c0 g(int i) {
        return new c0(i, null);
    }

    public abstract byte e(int i);

    public abstract boolean equals(Object obj);

    public final String h() {
        Charset charset = b1.f3229a;
        if (size() == 0) {
            return "";
        }
        d0 d0Var = (d0) this;
        return new String(d0Var.f3242e, d0Var.j(), d0Var.size(), charset);
    }

    public final int hashCode() {
        int i = this.f3476b;
        if (i == 0) {
            int size = size();
            d0 d0Var = (d0) this;
            i = b1.c(size, d0Var.f3242e, d0Var.j(), size);
            if (i == 0) {
                i = 1;
            }
            this.f3476b = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new z(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
