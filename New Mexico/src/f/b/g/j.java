package f.b.g;

import f.b.g.i1;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class j implements Iterable<Byte>, Serializable {
    public static final j c = new h(c0.b);

    /* renamed from: d */
    public static final e f3884d;
    public int b = 0;

    /* loaded from: classes.dex */
    public class a extends b {
        public int b = 0;
        public final int c;

        public a() {
            j.this = r2;
            this.c = r2.size();
        }

        @Override // f.b.g.j.f
        public byte a() {
            int i2 = this.b;
            if (i2 < this.c) {
                this.b = i2 + 1;
                return j.this.r(i2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.c;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b implements f {
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements e {
        public c(a aVar) {
        }

        @Override // f.b.g.j.e
        public byte[] a(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends h {

        /* renamed from: f */
        public final int f3886f;

        /* renamed from: g */
        public final int f3887g;

        public d(byte[] bArr, int i2, int i3) {
            super(bArr);
            j.k(i2, i2 + i3, bArr.length);
            this.f3886f = i2;
            this.f3887g = i3;
        }

        @Override // f.b.g.j.h
        public int E() {
            return this.f3886f;
        }

        @Override // f.b.g.j.h, f.b.g.j
        public byte i(int i2) {
            j.j(i2, this.f3887g);
            return this.f3888e[this.f3886f + i2];
        }

        @Override // f.b.g.j.h, f.b.g.j
        public void p(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.f3888e, this.f3886f + i2, bArr, i3, i4);
        }

        @Override // f.b.g.j.h, f.b.g.j
        public byte r(int i2) {
            return this.f3888e[this.f3886f + i2];
        }

        @Override // f.b.g.j.h, f.b.g.j
        public int size() {
            return this.f3887g;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        byte[] a(byte[] bArr, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface f extends Iterator<Byte> {
        byte a();
    }

    /* loaded from: classes.dex */
    public static abstract class g extends j {
        public abstract boolean D(j jVar, int i2, int i3);

        @Override // f.b.g.j, java.lang.Iterable
        public Iterator<Byte> iterator() {
            return new a();
        }

        @Override // f.b.g.j
        public final int q() {
            return 0;
        }

        @Override // f.b.g.j
        public final boolean s() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends g {

        /* renamed from: e */
        public final byte[] f3888e;

        public h(byte[] bArr) {
            Objects.requireNonNull(bArr);
            this.f3888e = bArr;
        }

        @Override // f.b.g.j
        public final String A(Charset charset) {
            return new String(this.f3888e, E(), size(), charset);
        }

        @Override // f.b.g.j
        public final void C(i iVar) {
            iVar.a(this.f3888e, E(), size());
        }

        @Override // f.b.g.j.g
        public final boolean D(j jVar, int i2, int i3) {
            if (i3 <= jVar.size()) {
                int i4 = i2 + i3;
                if (i4 > jVar.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i2 + ", " + i3 + ", " + jVar.size());
                } else if (!(jVar instanceof h)) {
                    return jVar.y(i2, i4).equals(y(0, i3));
                } else {
                    h hVar = (h) jVar;
                    byte[] bArr = this.f3888e;
                    byte[] bArr2 = hVar.f3888e;
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

        @Override // f.b.g.j, java.lang.Object
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

        @Override // f.b.g.j
        public byte i(int i2) {
            return this.f3888e[i2];
        }

        @Override // f.b.g.j
        public void p(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.f3888e, i2, bArr, i3, i4);
        }

        @Override // f.b.g.j
        public byte r(int i2) {
            return this.f3888e[i2];
        }

        @Override // f.b.g.j
        public int size() {
            return this.f3888e.length;
        }

        @Override // f.b.g.j
        public final boolean t() {
            int E = E();
            return w1.h(this.f3888e, E, size() + E);
        }

        @Override // f.b.g.j
        public final k v() {
            return k.h(this.f3888e, E(), size(), true);
        }

        @Override // f.b.g.j
        public final int w(int i2, int i3, int i4) {
            byte[] bArr = this.f3888e;
            int E = E() + i3;
            Charset charset = c0.a;
            for (int i5 = E; i5 < E + i4; i5++) {
                i2 = (i2 * 31) + bArr[i5];
            }
            return i2;
        }

        @Override // f.b.g.j
        public final int x(int i2, int i3, int i4) {
            int E = E() + i3;
            return w1.a.e(i2, this.f3888e, E, i4 + E);
        }

        @Override // f.b.g.j
        public final j y(int i2, int i3) {
            int k2 = j.k(i2, i3, size());
            return k2 == 0 ? j.c : new d(this.f3888e, E() + i2, k2);
        }
    }

    /* loaded from: classes.dex */
    public static final class i implements e {
        public i(a aVar) {
        }

        @Override // f.b.g.j.e
        public byte[] a(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
    }

    static {
        f3884d = d.a() ? new i(null) : new c(null);
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
                    if (h3.size() + i1Var2.f3875g.size() < 128) {
                        i1Var = new i1(i1Var2.f3874f, i1.D(i1Var2.f3875g, h3));
                        return i1Var;
                    } else if (i1Var2.f3874f.q() > i1Var2.f3875g.q() && i1Var2.f3877i > h3.q()) {
                        return new i1(i1Var2.f3874f, new i1(i1Var2.f3875g, h3));
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
            throw new ArrayIndexOutOfBoundsException(f.a.a.a.a.u("Index < 0: ", i2));
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
    }

    public static int k(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(f.a.a.a.a.v("Beginning index: ", i2, " < 0"));
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
        return new h(f3884d.a(bArr, i2, i3));
    }

    public static j n(String str) {
        return new h(str.getBytes(c0.a));
    }

    public abstract String A(Charset charset);

    public final String B() {
        return size() == 0 ? "" : A(c0.a);
    }

    public abstract void C(i iVar);

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    @Override // java.lang.Object
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

    @Override // java.lang.Object
    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = f.b.a.c.b.o.b.o0(this);
        } else {
            str = f.b.a.c.b.o.b.o0(y(0, 47)) + "...";
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
