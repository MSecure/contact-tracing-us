package f.b.g;

import f.b.g.j;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
/* loaded from: classes.dex */
public final class i1 extends j {

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f3872j = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};

    /* renamed from: e  reason: collision with root package name */
    public final int f3873e;

    /* renamed from: f  reason: collision with root package name */
    public final j f3874f;

    /* renamed from: g  reason: collision with root package name */
    public final j f3875g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3876h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3877i;

    /* loaded from: classes.dex */
    public class a extends j.b {
        public final c b;
        public j.f c = b();

        public a() {
            this.b = new c(i1.this, null);
        }

        @Override // f.b.g.j.f
        public byte a() {
            j.f fVar = this.c;
            if (fVar != null) {
                byte a = fVar.a();
                if (!this.c.hasNext()) {
                    this.c = b();
                }
                return a;
            }
            throw new NoSuchElementException();
        }

        public final j.f b() {
            if (!this.b.hasNext()) {
                return null;
            }
            j.g b = this.b.next();
            Objects.requireNonNull(b);
            return new j.a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public final ArrayDeque<j> a = new ArrayDeque<>();

        public b(a aVar) {
        }

        public final void a(j jVar) {
            if (jVar.s()) {
                int binarySearch = Arrays.binarySearch(i1.f3872j, jVar.size());
                if (binarySearch < 0) {
                    binarySearch = (-(binarySearch + 1)) - 1;
                }
                int E = i1.E(binarySearch + 1);
                if (this.a.isEmpty() || this.a.peek().size() >= E) {
                    this.a.push(jVar);
                    return;
                }
                int E2 = i1.E(binarySearch);
                j pop = this.a.pop();
                while (!this.a.isEmpty() && this.a.peek().size() < E2) {
                    pop = new i1(this.a.pop(), pop);
                }
                i1 i1Var = new i1(pop, jVar);
                while (!this.a.isEmpty()) {
                    int binarySearch2 = Arrays.binarySearch(i1.f3872j, i1Var.f3873e);
                    if (binarySearch2 < 0) {
                        binarySearch2 = (-(binarySearch2 + 1)) - 1;
                    }
                    if (this.a.peek().size() >= i1.E(binarySearch2 + 1)) {
                        break;
                    }
                    i1Var = new i1(this.a.pop(), i1Var);
                }
                this.a.push(i1Var);
            } else if (jVar instanceof i1) {
                i1 i1Var2 = (i1) jVar;
                a(i1Var2.f3874f);
                a(i1Var2.f3875g);
            } else {
                StringBuilder h2 = f.a.a.a.a.h("Has a new type of ByteString been created? Found ");
                h2.append(jVar.getClass());
                throw new IllegalArgumentException(h2.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Iterator<j.g> {
        public final ArrayDeque<i1> b;
        public j.g c;

        public c(j jVar, a aVar) {
            j.g gVar;
            if (jVar instanceof i1) {
                i1 i1Var = (i1) jVar;
                ArrayDeque<i1> arrayDeque = new ArrayDeque<>(i1Var.f3877i);
                this.b = arrayDeque;
                arrayDeque.push(i1Var);
                j jVar2 = i1Var.f3874f;
                while (jVar2 instanceof i1) {
                    i1 i1Var2 = (i1) jVar2;
                    this.b.push(i1Var2);
                    jVar2 = i1Var2.f3874f;
                }
                gVar = (j.g) jVar2;
            } else {
                this.b = null;
                gVar = (j.g) jVar;
            }
            this.c = gVar;
        }

        /* renamed from: b */
        public j.g next() {
            j.g gVar;
            j.g gVar2 = this.c;
            if (gVar2 != null) {
                do {
                    ArrayDeque<i1> arrayDeque = this.b;
                    if (arrayDeque == null || arrayDeque.isEmpty()) {
                        gVar = null;
                        break;
                    }
                    j jVar = this.b.pop().f3875g;
                    while (jVar instanceof i1) {
                        i1 i1Var = (i1) jVar;
                        this.b.push(i1Var);
                        jVar = i1Var.f3874f;
                    }
                    gVar = (j.g) jVar;
                } while (gVar.isEmpty());
                this.c = gVar;
                return gVar2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public class d extends InputStream {
        public c b;
        public j.g c;

        /* renamed from: d  reason: collision with root package name */
        public int f3879d;

        /* renamed from: e  reason: collision with root package name */
        public int f3880e;

        /* renamed from: f  reason: collision with root package name */
        public int f3881f;

        /* renamed from: g  reason: collision with root package name */
        public int f3882g;

        public d() {
            d();
        }

        @Override // java.io.InputStream
        public int available() {
            return i1.this.f3873e - (this.f3881f + this.f3880e);
        }

        public final void c() {
            int i2;
            if (this.c != null && this.f3880e == (i2 = this.f3879d)) {
                this.f3881f += i2;
                int i3 = 0;
                this.f3880e = 0;
                if (this.b.hasNext()) {
                    j.g b = this.b.next();
                    this.c = b;
                    i3 = b.size();
                } else {
                    this.c = null;
                }
                this.f3879d = i3;
            }
        }

        public final void d() {
            c cVar = new c(i1.this, null);
            this.b = cVar;
            j.g b = cVar.next();
            this.c = b;
            this.f3879d = b.size();
            this.f3880e = 0;
            this.f3881f = 0;
        }

        @Override // java.io.InputStream
        public void mark(int i2) {
            this.f3882g = this.f3881f + this.f3880e;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            c();
            j.g gVar = this.c;
            if (gVar == null) {
                return -1;
            }
            int i2 = this.f3880e;
            this.f3880e = i2 + 1;
            return gVar.i(i2) & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            Objects.requireNonNull(bArr);
            if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            }
            int t = t(bArr, i2, i3);
            if (t == 0) {
                return -1;
            }
            return t;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            d();
            t(null, 0, this.f3882g);
        }

        @Override // java.io.InputStream
        public long skip(long j2) {
            if (j2 >= 0) {
                if (j2 > 2147483647L) {
                    j2 = 2147483647L;
                }
                return (long) t(null, 0, (int) j2);
            }
            throw new IndexOutOfBoundsException();
        }

        public final int t(byte[] bArr, int i2, int i3) {
            int i4 = i3;
            while (i4 > 0) {
                c();
                if (this.c == null) {
                    break;
                }
                int min = Math.min(this.f3879d - this.f3880e, i4);
                if (bArr != null) {
                    this.c.o(bArr, this.f3880e, i2, min);
                    i2 += min;
                }
                this.f3880e += min;
                i4 -= min;
            }
            return i3 - i4;
        }
    }

    public i1(j jVar, j jVar2) {
        this.f3874f = jVar;
        this.f3875g = jVar2;
        int size = jVar.size();
        this.f3876h = size;
        this.f3873e = jVar2.size() + size;
        this.f3877i = Math.max(jVar.q(), jVar2.q()) + 1;
    }

    public static j D(j jVar, j jVar2) {
        int size = jVar.size();
        int size2 = jVar2.size();
        byte[] bArr = new byte[size + size2];
        jVar.o(bArr, 0, 0, size);
        jVar2.o(bArr, 0, size, size2);
        return new j.h(bArr);
    }

    public static int E(int i2) {
        int[] iArr = f3872j;
        if (i2 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i2];
    }

    @Override // f.b.g.j
    public String A(Charset charset) {
        return new String(z(), charset);
    }

    @Override // f.b.g.j
    public void C(i iVar) {
        this.f3874f.C(iVar);
        this.f3875g.C(iVar);
    }

    @Override // f.b.g.j, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f3873e != jVar.size()) {
            return false;
        }
        if (this.f3873e == 0) {
            return true;
        }
        int i2 = this.b;
        int i3 = jVar.b;
        if (i2 != 0 && i3 != 0 && i2 != i3) {
            return false;
        }
        c cVar = new c(this, null);
        j.g gVar = (j.g) cVar.next();
        c cVar2 = new c(jVar, null);
        j.g gVar2 = (j.g) cVar2.next();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int size = gVar.size() - i4;
            int size2 = gVar2.size() - i5;
            int min = Math.min(size, size2);
            if (!(i4 == 0 ? gVar.D(gVar2, i5, min) : gVar2.D(gVar, i4, min))) {
                return false;
            }
            i6 += min;
            int i7 = this.f3873e;
            if (i6 < i7) {
                if (min == size) {
                    i4 = 0;
                    gVar = (j.g) cVar.next();
                } else {
                    i4 += min;
                    gVar = gVar;
                }
                if (min == size2) {
                    gVar2 = (j.g) cVar2.next();
                    i5 = 0;
                } else {
                    i5 += min;
                }
            } else if (i6 == i7) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // f.b.g.j
    public byte i(int i2) {
        j.j(i2, this.f3873e);
        return r(i2);
    }

    @Override // f.b.g.j, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new a();
    }

    @Override // f.b.g.j
    public void p(byte[] bArr, int i2, int i3, int i4) {
        j jVar;
        int i5 = i2 + i4;
        int i6 = this.f3876h;
        if (i5 <= i6) {
            jVar = this.f3874f;
        } else if (i2 >= i6) {
            jVar = this.f3875g;
            i2 -= i6;
        } else {
            int i7 = i6 - i2;
            this.f3874f.p(bArr, i2, i3, i7);
            this.f3875g.p(bArr, 0, i3 + i7, i4 - i7);
            return;
        }
        jVar.p(bArr, i2, i3, i4);
    }

    @Override // f.b.g.j
    public int q() {
        return this.f3877i;
    }

    @Override // f.b.g.j
    public byte r(int i2) {
        int i3 = this.f3876h;
        return i2 < i3 ? this.f3874f.r(i2) : this.f3875g.r(i2 - i3);
    }

    @Override // f.b.g.j
    public boolean s() {
        return this.f3873e >= E(this.f3877i);
    }

    @Override // f.b.g.j
    public int size() {
        return this.f3873e;
    }

    @Override // f.b.g.j
    public boolean t() {
        int x = this.f3874f.x(0, 0, this.f3876h);
        j jVar = this.f3875g;
        return jVar.x(x, 0, jVar.size()) == 0;
    }

    @Override // f.b.g.j
    public j.f u() {
        return new a();
    }

    @Override // f.b.g.j
    public k v() {
        return k.f(new d());
    }

    @Override // f.b.g.j
    public int w(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.f3876h;
        if (i5 <= i6) {
            return this.f3874f.w(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.f3875g.w(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.f3875g.w(this.f3874f.w(i2, i3, i7), 0, i4 - i7);
    }

    @Override // f.b.g.j
    public int x(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.f3876h;
        if (i5 <= i6) {
            return this.f3874f.x(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.f3875g.x(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.f3875g.x(this.f3874f.x(i2, i3, i7), 0, i4 - i7);
    }

    @Override // f.b.g.j
    public j y(int i2, int i3) {
        int k2 = j.k(i2, i3, this.f3873e);
        if (k2 == 0) {
            return j.c;
        }
        if (k2 == this.f3873e) {
            return this;
        }
        int i4 = this.f3876h;
        if (i3 <= i4) {
            return this.f3874f.y(i2, i3);
        }
        if (i2 >= i4) {
            return this.f3875g.y(i2 - i4, i3 - i4);
        }
        j jVar = this.f3874f;
        return new i1(jVar.y(i2, jVar.size()), this.f3875g.y(0, i3 - this.f3876h));
    }
}
