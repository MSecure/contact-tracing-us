package f.b.f;

import f.b.f.i1;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class j implements Iterable<Byte>, Serializable {
    public static final j c = new h(c0.b);

    /* renamed from: d  reason: collision with root package name */
    public static final e f3315d = (d.a() ? new i(null) : new c(null));
    public int b = 0;

    public class a extends b {
        public int b = 0;
        public final int c;

        public a() {
            this.c = j.this.size();
        }

        @Override // f.b.f.j.f
        public byte a() {
            int i2 = this.b;
            if (i2 < this.c) {
                this.b = i2 + 1;
                return j.this.r(i2);
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.b < this.c;
        }
    }

    public static abstract class b implements f {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(a());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class c implements e {
        public c(a aVar) {
        }

        @Override // f.b.f.j.e
        public byte[] a(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }
    }

    public static final class d extends h {

        /* renamed from: f  reason: collision with root package name */
        public final int f3317f;

        /* renamed from: g  reason: collision with root package name */
        public final int f3318g;

        public d(byte[] bArr, int i2, int i3) {
            super(bArr);
            j.k(i2, i2 + i3, bArr.length);
            this.f3317f = i2;
            this.f3318g = i3;
        }

        @Override // f.b.f.j.h
        public int E() {
            return this.f3317f;
        }

        @Override // f.b.f.j, f.b.f.j.h
        public byte i(int i2) {
            j.j(i2, this.f3318g);
            return this.f3319e[this.f3317f + i2];
        }

        @Override // f.b.f.j, f.b.f.j.h
        public void p(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.f3319e, this.f3317f + i2, bArr, i3, i4);
        }

        @Override // f.b.f.j, f.b.f.j.h
        public byte r(int i2) {
            return this.f3319e[this.f3317f + i2];
        }

        @Override // f.b.f.j, f.b.f.j.h
        public int size() {
            return this.f3318g;
        }
    }

    public interface e {
        byte[] a(byte[] bArr, int i2, int i3);
    }

    public interface f extends Iterator<Byte> {
        byte a();
    }

    public static abstract class g extends j {
        public abstract boolean D(j jVar, int i2, int i3);

        /* Return type fixed from 'java.util.Iterator' to match base method */
        @Override // f.b.f.j, java.lang.Iterable
        public Iterator<Byte> iterator() {
            return new a();
        }

        @Override // f.b.f.j
        public final int q() {
            return 0;
        }

        @Override // f.b.f.j
        public final boolean s() {
            return true;
        }
    }

    public static class h extends g {

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f3319e;

        public h(byte[] bArr) {
            Objects.requireNonNull(bArr);
            this.f3319e = bArr;
        }

        @Override // f.b.f.j
        public final String A(Charset charset) {
            return new String(this.f3319e, E(), size(), charset);
        }

        @Override // f.b.f.j
        public final void C(i iVar) {
            iVar.a(this.f3319e, E(), size());
        }

        @Override // f.b.f.j.g
        public final boolean D(j jVar, int i2, int i3) {
            if (i3 <= jVar.size()) {
                int i4 = i2 + i3;
                if (i4 > jVar.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i2 + ", " + i3 + ", " + jVar.size());
                } else if (!(jVar instanceof h)) {
                    return jVar.y(i2, i4).equals(y(0, i3));
                } else {
                    h hVar = (h) jVar;
                    byte[] bArr = this.f3319e;
                    byte[] bArr2 = hVar.f3319e;
                    int E = E() + i3;
                    int E2 = E();
                    int E3 = hVar.E() + i2;
                    while (E2 < E) {
                        if (bArr[E2] != bArr2[E3]) {
                            return false;
                        }
                        E2++;
                        E3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i3 + size());
            }
        }

        public int E() {
            return 0;
        }

        @Override // f.b.f.j
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
            if (!(obj instanceof h)) {
                return obj.equals(this);
            }
            h hVar = (h) obj;
            int i2 = this.b;
            int i3 = hVar.b;
            if (i2 == 0 || i3 == 0 || i2 == i3) {
                return D(hVar, 0, size());
            }
            return false;
        }

        @Override // f.b.f.j
        public byte i(int i2) {
            return this.f3319e[i2];
        }

        @Override // f.b.f.j
        public void p(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.f3319e, i2, bArr, i3, i4);
        }

        @Override // f.b.f.j
        public byte r(int i2) {
            return this.f3319e[i2];
        }

        @Override // f.b.f.j
        public int size() {
            return this.f3319e.length;
        }

        @Override // f.b.f.j
        public final boolean t() {
            int E = E();
            return w1.h(this.f3319e, E, size() + E);
        }

        @Override // f.b.f.j
        public final k v() {
            return k.h(this.f3319e, E(), size(), true);
        }

        @Override // f.b.f.j
        public final int w(int i2, int i3, int i4) {
            byte[] bArr = this.f3319e;
            int E = E() + i3;
            Charset charset = c0.a;
            for (int i5 = E; i5 < E + i4; i5++) {
                i2 = (i2 * 31) + bArr[i5];
            }
            return i2;
        }

        @Override // f.b.f.j
        public final int x(int i2, int i3, int i4) {
            int E = E() + i3;
            return w1.a.e(i2, this.f3319e, E, i4 + E);
        }

        @Override // f.b.f.j
        public final j y(int i2, int i3) {
            int k2 = j.k(i2, i3, size());
            return k2 == 0 ? j.c : new d(this.f3319e, E() + i2, k2);
        }
    }

    public static final class i implements e {
        public i(a aVar) {
        }

        @Override // f.b.f.j.e
        public byte[] a(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
    }

    public static j h(Iterator<j> it, int i2) {
        i1 i1Var;
        if (i2 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i2)));
        } else if (i2 == 1) {
            return it.next();
        } else {
            int i3 = i2 >>> 1;
            j h2 = h(it, i3);
            j h3 = h(it, i2 - i3);
            if (Integer.MAX_VALUE - h2.size() < h3.size()) {
                StringBuilder h4 = f.a.a.a.a.h("ByteString would be too long: ");
                h4.append(h2.size());
                h4.append("+");
                h4.append(h3.size());
                throw new IllegalArgumentException(h4.toString());
            } else if (h3.size() == 0) {
                return h2;
            } else {
                if (h2.size() == 0) {
                    return h3;
                }
                int size = h3.size() + h2.size();
                if (size < 128) {
                    return i1.D(h2, h3);
                }
                if (h2 instanceof i1) {
                    i1 i1Var2 = (i1) h2;
                    if (h3.size() + i1Var2.f3306g.size() < 128) {
                        i1Var = new i1(i1Var2.f3305f, i1.D(i1Var2.f3306g, h3));
                        return i1Var;
                    } else if (i1Var2.f3305f.q() > i1Var2.f3306g.q() && i1Var2.f3308i > h3.q()) {
                        return new i1(i1Var2.f3305f, new i1(i1Var2.f3306g, h3));
                    }
                }
                if (size >= i1.E(Math.max(h2.q(), h3.q()) + 1)) {
                    i1Var = new i1(h2, h3);
                    return i1Var;
                }
                i1.b bVar = new i1.b(null);
                bVar.a(h2);
                bVar.a(h3);
                j pop = bVar.a.pop();
                while (!bVar.a.isEmpty()) {
                    pop = new i1(bVar.a.pop(), pop);
                }
                return pop;
            }
        }
    }

    public static void j(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return;
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(f.a.a.a.a.q("Index < 0: ", i2));
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
    }

    public static int k(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(f.a.a.a.a.r("Beginning index: ", i2, " < 0"));
        } else if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
        }
    }

    public static j l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public static j m(byte[] bArr, int i2, int i3) {
        k(i2, i2 + i3, bArr.length);
        return new h(f3315d.a(bArr, i2, i3));
    }

    public static j n(String str) {
        return new h(str.getBytes(c0.a));
    }

    public abstract String A(Charset charset);

    public final String B() {
        return size() == 0 ? "" : A(c0.a);
    }

    public abstract void C(i iVar);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int size = size();
            i2 = w(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.b = i2;
        }
        return i2;
    }

    public abstract byte i(int i2);

    public final boolean isEmpty() {
        return size() == 0;
    }

    @Deprecated
    public final void o(byte[] bArr, int i2, int i3, int i4) {
        k(i2, i2 + i4, size());
        k(i3, i3 + i4, bArr.length);
        if (i4 > 0) {
            p(bArr, i2, i3, i4);
        }
    }

    public abstract void p(byte[] bArr, int i2, int i3, int i4);

    public abstract int q();

    public abstract byte r(int i2);

    public abstract boolean s();

    public abstract int size();

    public abstract boolean t();

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = f.b.a.c.b.o.b.w0(this);
        } else {
            str = f.b.a.c.b.o.b.w0(y(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    /* renamed from: u */
    public f iterator() {
        return new a();
    }

    public abstract k v();

    public abstract int w(int i2, int i3, int i4);

    public abstract int x(int i2, int i3, int i4);

    public abstract j y(int i2, int i3);

    public final byte[] z() {
        int size = size();
        if (size == 0) {
            return c0.b;
        }
        byte[] bArr = new byte[size];
        p(bArr, 0, 0, size);
        return bArr;
    }
}
