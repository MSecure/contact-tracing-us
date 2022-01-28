package c.b.a.a.g.h;

import b.x.t;
import c.a.a.a.a;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

public abstract class q0 implements Serializable, Iterable<Byte> {

    /* renamed from: c  reason: collision with root package name */
    public static final q0 f4006c = new x0(u1.f4043b);

    /* renamed from: d  reason: collision with root package name */
    public static final u0 f4007d = (m0.a() ? new y0(null) : new t0(null));

    /* renamed from: b  reason: collision with root package name */
    public int f4008b = 0;

    public static q0 a(byte[] bArr, int i, int i2) {
        h(i, i + i2, bArr.length);
        return new x0(f4007d.a(bArr, i, i2));
    }

    public static w0 g(int i) {
        return new w0(i, null);
    }

    public static int h(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(a.k(66, "Beginning index larger than ending index: ", i, ", ", i2));
        } else {
            throw new IndexOutOfBoundsException(a.k(37, "End index: ", i2, " >= ", i3));
        }
    }

    public static q0 o(String str) {
        return new x0(str.getBytes(u1.f4042a));
    }

    public abstract byte c(int i);

    public abstract byte e(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f4008b;
        if (i == 0) {
            int size = size();
            x0 x0Var = (x0) this;
            i = u1.c(size, x0Var.f4062e, x0Var.p(), size);
            if (i == 0) {
                i = 1;
            }
            this.f4008b = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new s0(this);
    }

    public final String j() {
        Charset charset = u1.f4042a;
        if (size() == 0) {
            return "";
        }
        x0 x0Var = (x0) this;
        return new String(x0Var.f4062e, x0Var.p(), x0Var.size(), charset);
    }

    public abstract q0 l(int i, int i2);

    public abstract int size();

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? t.H4(this) : String.valueOf(t.H4(l(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
