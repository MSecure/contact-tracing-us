package c.b.d;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public abstract class j implements Iterable<Byte>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final j f3914c = new g(m0.f4000c);

    /* renamed from: d  reason: collision with root package name */
    public static final d f3915d = (e.a() ? new h(null) : new b(null));

    /* renamed from: b  reason: collision with root package name */
    public int f3916b = 0;

    public static abstract class a implements Iterator {
        @Override // java.util.Iterator
        public Object next() {
            return Byte.valueOf(((i) this).a());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class b implements d {
        public b(i iVar) {
        }

        @Override // c.b.d.j.d
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    public static final class c extends g {
        public final int f;
        public final int g;

        public c(byte[] bArr, int i, int i2) {
            super(bArr);
            j.c(i, i + i2, bArr.length);
            this.f = i;
            this.g = i2;
        }

        @Override // c.b.d.j.g, c.b.d.j
        public byte a(int i) {
            int i2 = this.g;
            if (((i2 - (i + 1)) | i) >= 0) {
                return this.f3919e[this.f + i];
            }
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(c.a.a.a.a.l("Index < 0: ", i));
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }

        @Override // c.b.d.j.g, c.b.d.j
        public byte m(int i) {
            return this.f3919e[this.f + i];
        }

        @Override // c.b.d.j.g, c.b.d.j
        public int size() {
            return this.g;
        }

        @Override // c.b.d.j.g
        public int x() {
            return this.f;
        }
    }

    public interface d {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final m f3917a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f3918b;

        public e(int i, i iVar) {
            byte[] bArr = new byte[i];
            this.f3918b = bArr;
            this.f3917a = m.V(bArr);
        }

        public j a() {
            this.f3917a.b();
            return new g(this.f3918b);
        }
    }

    public static abstract class f extends j {
        /* Return type fixed from 'java.util.Iterator' to match base method */
        @Override // c.b.d.j, java.lang.Iterable
        public Iterator<Byte> iterator() {
            return new i(this);
        }
    }

    public static class g extends f {

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f3919e;

        public g(byte[] bArr) {
            if (bArr != null) {
                this.f3919e = bArr;
                return;
            }
            throw null;
        }

        @Override // c.b.d.j
        public byte a(int i) {
            return this.f3919e[i];
        }

        @Override // c.b.d.j
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof j) || size() != ((j) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof g)) {
                return obj.equals(this);
            }
            g gVar = (g) obj;
            int i = this.f3916b;
            int i2 = gVar.f3916b;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
            int size = size();
            if (size > gVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (0 + size <= gVar.size()) {
                byte[] bArr = this.f3919e;
                byte[] bArr2 = gVar.f3919e;
                int x = x() + size;
                int x2 = x();
                int x3 = gVar.x() + 0;
                while (x2 < x) {
                    if (bArr[x2] != bArr2[x3]) {
                        return false;
                    }
                    x2++;
                    x3++;
                }
                return true;
            } else {
                throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + size + ", " + gVar.size());
            }
        }

        @Override // c.b.d.j
        public byte m(int i) {
            return this.f3919e[i];
        }

        @Override // c.b.d.j
        public final boolean o() {
            int x = x();
            return v2.h(this.f3919e, x, size() + x);
        }

        @Override // c.b.d.j
        public final k q() {
            return k.j(this.f3919e, x(), size(), true);
        }

        @Override // c.b.d.j
        public final int r(int i, int i2, int i3) {
            return m0.g(i, this.f3919e, x() + i2, i3);
        }

        @Override // c.b.d.j
        public final j s(int i, int i2) {
            int c2 = j.c(i, i2, size());
            return c2 == 0 ? j.f3914c : new c(this.f3919e, x() + i, c2);
        }

        @Override // c.b.d.j
        public int size() {
            return this.f3919e.length;
        }

        @Override // c.b.d.j
        public final String t(Charset charset) {
            return new String(this.f3919e, x(), size(), charset);
        }

        @Override // c.b.d.j
        public final void w(h hVar) {
            hVar.a(this.f3919e, x(), size());
        }

        public int x() {
            return 0;
        }
    }

    public static final class h implements d {
        public h(i iVar) {
        }

        @Override // c.b.d.j.d
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

    public static j e(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    public static j h(byte[] bArr, int i, int i2) {
        c(i, i + i2, bArr.length);
        return new g(f3915d.a(bArr, i, i2));
    }

    public static j j(String str) {
        return new g(str.getBytes(m0.f3998a));
    }

    public static e p(int i) {
        return new e(i, null);
    }

    public static j v(byte[] bArr) {
        return new g(bArr);
    }

    public abstract byte a(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f3916b;
        if (i == 0) {
            int size = size();
            i = r(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f3916b = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new i(this);
    }

    public abstract byte m(int i);

    public abstract boolean o();

    public abstract k q();

    public abstract int r(int i, int i2, int i3);

    public abstract j s(int i, int i2);

    public abstract int size();

    public abstract String t(Charset charset);

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = c.b.a.a.c.n.c.N0(this);
        } else {
            str = c.b.a.a.c.n.c.N0(s(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String u() {
        return size() == 0 ? "" : t(m0.f3998a);
    }

    public abstract void w(h hVar);
}
