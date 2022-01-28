package c.b.c.a.j0.a;

import b.x.t;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public abstract class i implements Iterable<Byte>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final i f4933c = new g(a0.f4886b);

    /* renamed from: d  reason: collision with root package name */
    public static final d f4934d = (d.a() ? new h(null) : new b(null));

    /* renamed from: b  reason: collision with root package name */
    public int f4935b = 0;

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

        /* renamed from: f  reason: collision with root package name */
        public final int f4936f;

        /* renamed from: g  reason: collision with root package name */
        public final int f4937g;

        public c(byte[] bArr, int i, int i2) {
            super(bArr);
            i.c(i, i + i2, bArr.length);
            this.f4936f = i;
            this.f4937g = i2;
        }

        @Override // c.b.c.a.j0.a.i.g, c.b.c.a.j0.a.i
        public byte a(int i) {
            int i2 = this.f4937g;
            if (((i2 - (i + 1)) | i) >= 0) {
                return this.f4940e[this.f4936f + i];
            }
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(c.a.a.a.a.n("Index < 0: ", i));
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }

        @Override // c.b.c.a.j0.a.i.g, c.b.c.a.j0.a.i
        public void j(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f4940e, this.f4936f + i, bArr, i2, i3);
        }

        @Override // c.b.c.a.j0.a.i.g, c.b.c.a.j0.a.i
        public byte l(int i) {
            return this.f4940e[this.f4936f + i];
        }

        @Override // c.b.c.a.j0.a.i.g, c.b.c.a.j0.a.i
        public int size() {
            return this.f4937g;
        }

        @Override // c.b.c.a.j0.a.i.g
        public int w() {
            return this.f4936f;
        }
    }

    public interface d {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final l f4938a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f4939b;

        public e(int i, h hVar) {
            byte[] bArr = new byte[i];
            this.f4939b = bArr;
            this.f4938a = l.N(bArr);
        }

        public i a() {
            if (this.f4938a.O() == 0) {
                return new g(this.f4939b);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static abstract class f extends i {
    }

    public static class g extends f {

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f4940e;

        public g(byte[] bArr) {
            if (bArr != null) {
                this.f4940e = bArr;
                return;
            }
            throw null;
        }

        @Override // c.b.c.a.j0.a.i
        public byte a(int i) {
            return this.f4940e[i];
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
            int i = this.f4935b;
            int i2 = gVar.f4935b;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
            int size = size();
            if (size > gVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (0 + size <= gVar.size()) {
                byte[] bArr = this.f4940e;
                byte[] bArr2 = gVar.f4940e;
                int w = w() + size;
                int w2 = w();
                int w3 = gVar.w() + 0;
                while (w2 < w) {
                    if (bArr[w2] != bArr2[w3]) {
                        return false;
                    }
                    w2++;
                    w3++;
                }
                return true;
            } else {
                throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + size + ", " + gVar.size());
            }
        }

        @Override // c.b.c.a.j0.a.i
        public void j(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f4940e, i, bArr, i2, i3);
        }

        @Override // c.b.c.a.j0.a.i
        public byte l(int i) {
            return this.f4940e[i];
        }

        @Override // c.b.c.a.j0.a.i
        public final i p(int i, int i2) {
            int c2 = i.c(i, i2, size());
            return c2 == 0 ? i.f4933c : new c(this.f4940e, w() + i, c2);
        }

        @Override // c.b.c.a.j0.a.i
        public int size() {
            return this.f4940e.length;
        }

        public int w() {
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
            throw new IndexOutOfBoundsException(c.a.a.a.a.o("Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    public static i e(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public static i g(byte[] bArr, int i, int i2) {
        c(i, i + i2, bArr.length);
        return new g(f4934d.a(bArr, i, i2));
    }

    public static i h(String str) {
        return new g(str.getBytes(a0.f4885a));
    }

    public static e o(int i) {
        return new e(i, null);
    }

    public static i v(byte[] bArr) {
        return new g(bArr);
    }

    public abstract byte a(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f4935b;
        if (i == 0) {
            int size = size();
            g gVar = (g) this;
            i = a0.g(size, gVar.f4940e, gVar.w() + 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f4935b = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new h(this);
    }

    public abstract void j(byte[] bArr, int i, int i2, int i3);

    public abstract byte l(int i);

    public abstract i p(int i, int i2);

    public final byte[] q() {
        int size = size();
        if (size == 0) {
            return a0.f4886b;
        }
        byte[] bArr = new byte[size];
        j(bArr, 0, 0, size);
        return bArr;
    }

    public abstract int size();

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = t.o1(this);
        } else {
            str = t.o1(p(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String u() {
        Charset charset = a0.f4885a;
        if (size() == 0) {
            return "";
        }
        g gVar = (g) this;
        return new String(gVar.f4940e, gVar.w(), gVar.size(), charset);
    }
}
