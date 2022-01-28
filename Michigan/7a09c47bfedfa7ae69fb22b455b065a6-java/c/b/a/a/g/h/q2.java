package c.b.a.a.g.h;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class q2 extends k0<Long> implements z1<Long>, l3, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public long[] f4014c;

    /* renamed from: d  reason: collision with root package name */
    public int f4015d;

    static {
        new q2(new long[0], 0).f3921b = false;
    }

    public q2() {
        this.f4014c = new long[10];
        this.f4015d = 0;
    }

    public q2(long[] jArr, int i) {
        this.f4014c = jArr;
        this.f4015d = i;
    }

    /* Return type fixed from 'c.b.a.a.g.h.z1' to match base method */
    @Override // c.b.a.a.g.h.z1
    public final /* synthetic */ z1<Long> B(int i) {
        if (i >= this.f4015d) {
            return new q2(Arrays.copyOf(this.f4014c, i), this.f4015d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.f4015d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        long[] jArr = this.f4014c;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[a.b(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f4014c, i, jArr2, i + 1, this.f4015d - i);
            this.f4014c = jArr2;
        }
        this.f4014c[i] = longValue;
        this.f4015d++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Long l) {
        e(l.longValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection
    public final boolean addAll(Collection<? extends Long> collection) {
        a();
        u1.a(collection);
        if (!(collection instanceof q2)) {
            return super.addAll(collection);
        }
        q2 q2Var = (q2) collection;
        int i = q2Var.f4015d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f4015d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f4014c;
            if (i3 > jArr.length) {
                this.f4014c = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(q2Var.f4014c, 0, this.f4014c, this.f4015d, q2Var.f4015d);
            this.f4015d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final long c(int i) {
        g(i);
        return this.f4014c[i];
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(long j) {
        a();
        int i = this.f4015d;
        long[] jArr = this.f4014c;
        if (i == jArr.length) {
            long[] jArr2 = new long[a.b(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f4014c = jArr2;
        }
        long[] jArr3 = this.f4014c;
        int i2 = this.f4015d;
        this.f4015d = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // c.b.a.a.g.h.k0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q2)) {
            return super.equals(obj);
        }
        q2 q2Var = (q2) obj;
        if (this.f4015d != q2Var.f4015d) {
            return false;
        }
        long[] jArr = q2Var.f4014c;
        for (int i = 0; i < this.f4015d; i++) {
            if (this.f4014c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i) {
        if (i < 0 || i >= this.f4015d) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    @Override // java.util.List, java.util.AbstractList
    public final Object get(int i) {
        g(i);
        return Long.valueOf(this.f4014c[i]);
    }

    public final String h(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f4015d);
    }

    @Override // c.b.a.a.g.h.k0
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f4015d; i2++) {
            i = (i * 31) + u1.e(this.f4014c[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i = this.f4015d;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f4014c[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        g(i);
        long[] jArr = this.f4014c;
        long j = jArr[i];
        int i2 = this.f4015d;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f4015d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.List, c.b.a.a.g.h.k0
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f4015d; i++) {
            if (obj.equals(Long.valueOf(this.f4014c[i]))) {
                long[] jArr = this.f4014c;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f4015d - i) - 1);
                this.f4015d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            long[] jArr = this.f4014c;
            System.arraycopy(jArr, i2, jArr, i, this.f4015d - i2);
            this.f4015d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        a();
        g(i);
        long[] jArr = this.f4014c;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.f4015d;
    }
}
