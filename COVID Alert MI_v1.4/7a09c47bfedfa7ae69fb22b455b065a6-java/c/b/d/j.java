package c.b.d;

import b.x.t;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public abstract class j implements Iterable<Byte>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final j f5320c = new g(n0.f5440c);

    /* renamed from: d  reason: collision with root package name */
    public static final d f5321d = (e.a() ? new h(null) : new b(null));

    /* renamed from: b  reason: collision with root package name */
    public int f5322b = 0;

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

        /* renamed from: f  reason: collision with root package name */
        public final int f5323f;

        /* renamed from: g  reason: collision with root package name */
        public final int f5324g;

        public c(byte[] bArr, int i, int i2) {
            super(bArr);
            j.c(i, i + i2, bArr.length);
            this.f5323f = i;
            this.f5324g = i2;
        }

        @Override // c.b.d.j.g
        public int I() {
            return this.f5323f;
        }

        @Override // c.b.d.j.g, c.b.d.j
        public byte a(int i) {
            int i2 = this.f5324g;
            if (((i2 - (i + 1)) | i) >= 0) {
                return this.f5327e[this.f5323f + i];
            }
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(c.a.a.a.a.n("Index < 0: ", i));
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }

        @Override // c.b.d.j.g, c.b.d.j
        public void j(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f5327e, this.f5323f + i, bArr, i2, i3);
        }

        @Override // c.b.d.j.g, c.b.d.j
        public byte l(int i) {
            return this.f5327e[this.f5323f + i];
        }

        @Override // c.b.d.j.g, c.b.d.j
        public int size() {
            return this.f5324g;
        }
    }

    public interface d {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final m f5325a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f5326b;

        public e(int i, i iVar) {
            byte[] bArr = new byte[i];
            this.f5326b = bArr;
            this.f5325a = m.V(bArr);
        }

        public j a() {
            this.f5325a.b();
            return new g(this.f5326b);
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
        public final byte[] f5327e;

        public g(byte[] bArr) {
            if (bArr != null) {
                this.f5327e = bArr;
                return;
            }
            throw null;
        }

        @Override // c.b.d.j
        public final void E(h hVar) {
            hVar.a(this.f5327e, I(), size());
        }

        public int I() {
            return 0;
        }

        @Override // c.b.d.j
        public byte a(int i) {
            return this.f5327e[i];
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
            int i = this.f5322b;
            int i2 = gVar.f5322b;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
            int size = size();
            if (size > gVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (0 + size <= gVar.size()) {
                byte[] bArr = this.f5327e;
                byte[] bArr2 = gVar.f5327e;
                int I = I() + size;
                int I2 = I();
                int I3 = gVar.I() + 0;
                while (I2 < I) {
                    if (bArr[I2] != bArr2[I3]) {
                        return false;
                    }
                    I2++;
                    I3++;
                }
                return true;
            } else {
                throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + size + ", " + gVar.size());
            }
        }

        @Override // c.b.d.j
        public void j(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f5327e, i, bArr, i2, i3);
        }

        @Override // c.b.d.j
        public byte l(int i) {
            return this.f5327e[i];
        }

        @Override // c.b.d.j
        public final boolean o() {
            int I = I();
            return w2.h(this.f5327e, I, size() + I);
        }

        @Override // c.b.d.j
        public final k q() {
            return k.j(this.f5327e, I(), size(), true);
        }

        @Override // c.b.d.j
        public int size() {
            return this.f5327e.length;
        }

        @Override // c.b.d.j
        public final int u(int i, int i2, int i3) {
            return n0.g(i, this.f5327e, I() + i2, i3);
        }

        @Override // c.b.d.j
        public final j v(int i, int i2) {
            int c2 = j.c(i, i2, size());
            return c2 == 0 ? j.f5320c : new c(this.f5327e, I() + i, c2);
        }

        @Override // c.b.d.j
        public final String x(Charset charset) {
            return new String(this.f5327e, I(), size(), charset);
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

    public static j C(byte[] bArr) {
        return new g(bArr);
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

    public static j e(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public static j g(byte[] bArr, int i, int i2) {
        c(i, i + i2, bArr.length);
        return new g(f5321d.a(bArr, i, i2));
    }

    public static j h(String str) {
        return new g(str.getBytes(n0.f5438a));
    }

    public static e p(int i) {
        return new e(i, null);
    }

    public abstract void E(h hVar);

    public abstract byte a(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f5322b;
        if (i == 0) {
            int size = size();
            i = u(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f5322b = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new i(this);
    }

    public abstract void j(byte[] bArr, int i, int i2, int i3);

    public abstract byte l(int i);

    public abstract boolean o();

    public abstract k q();

    public abstract int size();

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = t.p1(this);
        } else {
            str = t.p1(v(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract int u(int i, int i2, int i3);

    public abstract j v(int i, int i2);

    public final byte[] w() {
        int size = size();
        if (size == 0) {
            return n0.f5440c;
        }
        byte[] bArr = new byte[size];
        j(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String x(Charset charset);

    public final String z() {
        return size() == 0 ? "" : x(n0.f5438a);
    }
}
