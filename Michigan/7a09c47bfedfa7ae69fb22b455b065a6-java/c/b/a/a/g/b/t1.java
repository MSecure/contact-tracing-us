package c.b.a.a.g.b;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class t1 extends s<Long> implements e1<Long>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public long[] f3416c;

    /* renamed from: d  reason: collision with root package name */
    public int f3417d;

    static {
        new t1().f3405b = false;
    }

    public t1() {
        this.f3416c = new long[10];
        this.f3417d = 0;
    }

    public t1(long[] jArr, int i) {
        this.f3416c = jArr;
        this.f3417d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        h(i, ((Long) obj).longValue());
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.a.a.g.b.s
    public final boolean addAll(Collection<? extends Long> collection) {
        a();
        b1.a(collection);
        if (!(collection instanceof t1)) {
            return super.addAll(collection);
        }
        t1 t1Var = (t1) collection;
        int i = t1Var.f3417d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3417d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f3416c;
            if (i3 > jArr.length) {
                this.f3416c = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(t1Var.f3416c, 0, this.f3416c, this.f3417d, t1Var.f3417d);
            this.f3417d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final long c(int i) {
        e(i);
        return this.f3416c[i];
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3417d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.a.a.g.b.s
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t1)) {
            return super.equals(obj);
        }
        t1 t1Var = (t1) obj;
        if (this.f3417d != t1Var.f3417d) {
            return false;
        }
        long[] jArr = t1Var.f3416c;
        for (int i = 0; i < this.f3417d; i++) {
            if (this.f3416c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3417d);
    }

    @Override // java.util.List, java.util.AbstractList
    public final Object get(int i) {
        e(i);
        return Long.valueOf(this.f3416c[i]);
    }

    public final void h(int i, long j) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f3417d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        long[] jArr = this.f3416c;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[a.b(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f3416c, i, jArr2, i + 1, this.f3417d - i);
            this.f3416c = jArr2;
        }
        this.f3416c[i] = j;
        this.f3417d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.a.a.g.b.s
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3417d; i2++) {
            i = (i * 31) + b1.h(this.f3416c[i2]);
        }
        return i;
    }

    /* Return type fixed from 'c.b.a.a.g.b.e1' to match base method */
    @Override // c.b.a.a.g.b.e1
    public final /* synthetic */ e1<Long> r(int i) {
        if (i >= this.f3417d) {
            return new t1(Arrays.copyOf(this.f3416c, i), this.f3417d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        e(i);
        long[] jArr = this.f3416c;
        long j = jArr[i];
        int i2 = this.f3417d;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, i2 - i);
        }
        this.f3417d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.List, c.b.a.a.g.b.s
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3417d; i++) {
            if (obj.equals(Long.valueOf(this.f3416c[i]))) {
                long[] jArr = this.f3416c;
                System.arraycopy(jArr, i + 1, jArr, i, this.f3417d - i);
                this.f3417d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            long[] jArr = this.f3416c;
            System.arraycopy(jArr, i2, jArr, i, this.f3417d - i2);
            this.f3417d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        a();
        e(i);
        long[] jArr = this.f3416c;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.f3417d;
    }
}
