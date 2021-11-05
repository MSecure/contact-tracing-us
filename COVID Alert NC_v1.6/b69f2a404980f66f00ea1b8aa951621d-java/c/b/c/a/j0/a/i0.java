package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.a0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class i0 extends c<Long> implements Object, RandomAccess, z0 {

    /* renamed from: e  reason: collision with root package name */
    public static final i0 f3570e;

    /* renamed from: c  reason: collision with root package name */
    public long[] f3571c;

    /* renamed from: d  reason: collision with root package name */
    public int f3572d;

    static {
        i0 i0Var = new i0(new long[0], 0);
        f3570e = i0Var;
        i0Var.f3526b = false;
    }

    public i0() {
        this.f3571c = new long[10];
        this.f3572d = 0;
    }

    public i0(long[] jArr, int i) {
        this.f3571c = jArr;
        this.f3572d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.f3572d)) {
            throw new IndexOutOfBoundsException(j(i));
        }
        long[] jArr = this.f3571c;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[a.b(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f3571c, i, jArr2, i + 1, this.f3572d - i);
            this.f3571c = jArr2;
        }
        this.f3571c[i] = longValue;
        this.f3572d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection
    public boolean addAll(Collection<? extends Long> collection) {
        a();
        a0.a(collection);
        if (!(collection instanceof i0)) {
            return super.addAll(collection);
        }
        i0 i0Var = (i0) collection;
        int i = i0Var.f3572d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3572d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f3571c;
            if (i3 > jArr.length) {
                this.f3571c = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(i0Var.f3571c, 0, this.f3571c, this.f3572d, i0Var.f3572d);
            this.f3572d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(long j) {
        a();
        int i = this.f3572d;
        long[] jArr = this.f3571c;
        if (i == jArr.length) {
            long[] jArr2 = new long[a.b(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f3571c = jArr2;
        }
        long[] jArr3 = this.f3571c;
        int i2 = this.f3572d;
        this.f3572d = i2 + 1;
        jArr3[i2] = j;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3572d) {
            throw new IndexOutOfBoundsException(j(i));
        }
    }

    @Override // c.b.c.a.j0.a.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return super.equals(obj);
        }
        i0 i0Var = (i0) obj;
        if (this.f3572d != i0Var.f3572d) {
            return false;
        }
        long[] jArr = i0Var.f3571c;
        for (int i = 0; i < this.f3572d; i++) {
            if (this.f3571c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c g(int i) {
        if (i >= this.f3572d) {
            return new i0(Arrays.copyOf(this.f3571c, i), this.f3572d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Long.valueOf(this.f3571c[i]);
    }

    public long h(int i) {
        e(i);
        return this.f3571c[i];
    }

    @Override // c.b.c.a.j0.a.c
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3572d; i2++) {
            i = (i * 31) + a0.e(this.f3571c[i2]);
        }
        return i;
    }

    public final String j(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f3572d);
        return h.toString();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        long[] jArr = this.f3571c;
        long j = jArr[i];
        int i2 = this.f3572d;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f3572d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.List, c.b.c.a.j0.a.c
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3572d; i++) {
            if (obj.equals(Long.valueOf(this.f3571c[i]))) {
                long[] jArr = this.f3571c;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f3572d - i) - 1);
                this.f3572d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            long[] jArr = this.f3571c;
            System.arraycopy(jArr, i2, jArr, i, this.f3572d - i2);
            this.f3572d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        a();
        e(i);
        long[] jArr = this.f3571c;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public int size() {
        return this.f3572d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection, java.util.AbstractList
    public boolean add(Long l) {
        c(l.longValue());
        return true;
    }
}
