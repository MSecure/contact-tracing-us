package f.b.f;

import f.a.a.a.a;
import f.b.f.c0;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

public final class k0 extends c<Long> implements c0.h, RandomAccess, c1 {

    /* renamed from: e  reason: collision with root package name */
    public static final k0 f3345e;
    public long[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f3346d;

    static {
        k0 k0Var = new k0(new long[0], 0);
        f3345e = k0Var;
        k0Var.b = false;
    }

    public k0() {
        this.c = new long[10];
        this.f3346d = 0;
    }

    public k0(long[] jArr, int i2) {
        this.c = jArr;
        this.f3346d = i2;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        h();
        if (i2 < 0 || i2 > (i3 = this.f3346d)) {
            throw new IndexOutOfBoundsException(l(i2));
        }
        long[] jArr = this.c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[a.b(i3, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.c, i2, jArr2, i2 + 1, this.f3346d - i2);
            this.c = jArr2;
        }
        this.c[i2] = longValue;
        this.f3346d++;
        ((AbstractList) this).modCount++;
    }

    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Long> collection) {
        h();
        Charset charset = c0.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof k0)) {
            return super.addAll(collection);
        }
        k0 k0Var = (k0) collection;
        int i2 = k0Var.f3346d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f3346d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.c;
            if (i4 > jArr.length) {
                this.c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(k0Var.c, 0, this.c, this.f3346d, k0Var.f3346d);
            this.f3346d = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // f.b.f.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return super.equals(obj);
        }
        k0 k0Var = (k0) obj;
        if (this.f3346d != k0Var.f3346d) {
            return false;
        }
        long[] jArr = k0Var.c;
        for (int i2 = 0; i2 < this.f3346d; i2++) {
            if (this.c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i2) {
        j(i2);
        return Long.valueOf(this.c[i2]);
    }

    @Override // f.b.f.c
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f3346d; i3++) {
            i2 = (i2 * 31) + c0.b(this.c[i3]);
        }
        return i2;
    }

    public void i(long j2) {
        h();
        int i2 = this.f3346d;
        long[] jArr = this.c;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[a.b(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.c = jArr2;
        }
        long[] jArr3 = this.c;
        int i3 = this.f3346d;
        this.f3346d = i3 + 1;
        jArr3[i3] = j2;
    }

    public final void j(int i2) {
        if (i2 < 0 || i2 >= this.f3346d) {
            throw new IndexOutOfBoundsException(l(i2));
        }
    }

    public long k(int i2) {
        j(i2);
        return this.c[i2];
    }

    public final String l(int i2) {
        return "Index:" + i2 + ", Size:" + this.f3346d;
    }

    /* renamed from: m */
    public c0.h d(int i2) {
        if (i2 >= this.f3346d) {
            return new k0(Arrays.copyOf(this.c, i2), this.f3346d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i2) {
        h();
        j(i2);
        long[] jArr = this.c;
        long j2 = jArr[i2];
        int i3 = this.f3346d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f3346d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // f.b.f.c, java.util.List
    public boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f3346d; i2++) {
            if (obj.equals(Long.valueOf(this.c[i2]))) {
                long[] jArr = this.c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f3346d - i2) - 1);
                this.f3346d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i2, int i3) {
        h();
        if (i3 >= i2) {
            long[] jArr = this.c;
            System.arraycopy(jArr, i3, jArr, i2, this.f3346d - i3);
            this.f3346d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        h();
        j(i2);
        long[] jArr = this.c;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    public int size() {
        return this.f3346d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Long l2) {
        i(l2.longValue());
        return true;
    }
}
