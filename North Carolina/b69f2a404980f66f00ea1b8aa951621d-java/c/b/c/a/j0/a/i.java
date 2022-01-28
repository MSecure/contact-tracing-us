package c.b.c.a.j0.a;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public abstract class i implements Iterable<Byte>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final i f3564c = new g(a0.f3519b);

    /* renamed from: d  reason: collision with root package name */
    public static final d f3565d = (d.a() ? new h(null) : new b(null));

    /* renamed from: b  reason: collision with root package name */
    public int f3566b = 0;

    public static abstract class a implements Iterator {
        @Override // java.util.Iterator
        public Object next() {
            return Byte.valueOf(((h) this).a());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class b implements d {
        public b(h hVar) {
        }

        @Override // c.b.c.a.j0.a.i.d
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    public static final class c extends g {
        public final int f;
        public final int g;

        public c(byte[] bArr, int i, int i2) {
            super(bArr);
            i.c(i, i + i2, bArr.length);
            this.f = i;
            this.g = i2;
        }

        @Override // c.b.c.a.j0.a.i.g, c.b.c.a.j0.a.i
        public byte a(int i) {
            int i2 = this.g;
            if (((i2 - (i + 1)) | i) >= 0) {
                return this.f3569e[this.f + i];
            }
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(c.a.a.a.a.l("Index < 0: ", i));
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }

        @Override // c.b.c.a.j0.a.i.g, c.b.c.a.j0.a.i
        public void m(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f3569e, this.f + i, bArr, i2, i3);
        }

        @Override // c.b.c.a.j0.a.i.g, c.b.c.a.j0.a.i
        public byte o(int i) {
            return this.f3569e[this.f + i];
        }

        @Override // c.b.c.a.j0.a.i.g, c.b.c.a.j0.a.i
        public int size() {
            return this.g;
        }

        @Override // c.b.c.a.j0.a.i.g
        public int u() {
            return this.f;
        }
    }

    public interface d {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final l f3567a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f3568b;

        public e(int i, h hVar) {
            byte[] bArr = new byte[i];
            this.f3568b = bArr;
            this.f3567a = l.N(bArr);
        }

        public i a() {
            if (this.f3567a.O() == 0) {
                return new g(this.f3568b);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static abstract class f extends i {
    }

    public static class g extends f {

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f3569e;

        public g(byte[] bArr) {
            if (bArr != null) {
                this.f3569e = bArr;
                return;
            }
            throw null;
        }

        @Override // c.b.c.a.j0.a.i
        public byte a(int i) {
            return this.f3569e[i];
        }

        @Override // c.b.c.a.j0.a.i
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof i) || size() != ((i) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof g)) {
                return obj.equals(this);
            }
            g gVar = (g) obj;
            int i = this.f3566b;
            int i2 = gVar.f3566b;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
            int size = size();
            if (size > gVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (0 + size <= gVar.size()) {
                byte[] bArr = this.f3569e;
                byte[] bArr2 = gVar.f3569e;
                int u = u() + size;
                int u2 = u();
                int u3 = gVar.u() + 0;
                while (u2 < u) {
                    if (bArr[u2] != bArr2[u3]) {
                        return false;
                    }
                    u2++;
                    u3++;
                }
                return true;
            } else {
                throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + size + ", " + gVar.size());
            }
        }

        @Override // c.b.c.a.j0.a.i
        public void m(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f3569e, i, bArr, i2, i3);
        }

        @Override // c.b.c.a.j0.a.i
        public byte o(int i) {
            return this.f3569e[i];
        }

        @Override // c.b.c.a.j0.a.i
        public final i q(int i, int i2) {
            int c2 = i.c(i, i2, size());
            return c2 == 0 ? i.f3564c : new c(this.f3569e, u() + i, c2);
        }

        @Override // c.b.c.a.j0.a.i
        public int size() {
            return this.f3569e.length;
        }

        public int u() {
            return 0;
        }
    }

    public static final class h implements d {
        public h(h hVar) {
        }

        @Override // c.b.c.a.j0.a.i.d
        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    public static int c(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(c.a.a.a.a.m("Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    public static i e(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    public static i h(byte[] bArr, int i, int i2) {
        c(i, i + i2, bArr.length);
        return new g(f3565d.a(bArr, i, i2));
    }

    public static i j(String str) {
        return new g(str.getBytes(a0.f3518a));
    }

    public static e p(int i) {
        return new e(i, null);
    }

    public static i t(byte[] bArr) {
        return new g(bArr);
    }

    public abstract byte a(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f3566b;
        if (i == 0) {
            int size = size();
            g gVar = (g) this;
            i = a0.g(size, gVar.f3569e, gVar.u() + 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f3566b = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new h(this);
    }

    public abstract void m(byte[] bArr, int i, int i2, int i3);

    public abstract byte o(int i);

    public abstract i q(int i, int i2);

    public final byte[] r() {
        int size = size();
        if (size == 0) {
            return a0.f3519b;
        }
        byte[] bArr = new byte[size];
        m(bArr, 0, 0, size);
        return bArr;
    }

    public final String s() {
        Charset charset = a0.f3518a;
        if (size() == 0) {
            return "";
        }
        g gVar = (g) this;
        return new String(gVar.f3569e, gVar.u(), gVar.size(), charset);
    }

    public abstract int size();

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = c.b.a.a.c.n.c.M0(this);
        } else {
            str = c.b.a.a.c.n.c.M0(q(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
