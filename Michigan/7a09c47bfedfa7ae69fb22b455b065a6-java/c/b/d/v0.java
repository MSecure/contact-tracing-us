package c.b.d;

import c.a.a.a.a;
import c.b.d.n0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class v0 extends d<Long> implements n0.g, RandomAccess, x1 {

    /* renamed from: e  reason: collision with root package name */
    public static final v0 f5889e;

    /* renamed from: c  reason: collision with root package name */
    public long[] f5890c;

    /* renamed from: d  reason: collision with root package name */
    public int f5891d;

    static {
        v0 v0Var = new v0(new long[0], 0);
        f5889e = v0Var;
        v0Var.f5244b = false;
    }

    public v0() {
        this.f5890c = new long[10];
        this.f5891d = 0;
    }

    public v0(long[] jArr, int i) {
        this.f5890c = jArr;
        this.f5891d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.f5891d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        long[] jArr = this.f5890c;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[a.b(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f5890c, i, jArr2, i + 1, this.f5891d - i);
            this.f5890c = jArr2;
        }
        this.f5890c[i] = longValue;
        this.f5891d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Long> collection) {
        a();
        n0.a(collection);
        if (!(collection instanceof v0)) {
            return super.addAll(collection);
        }
        v0 v0Var = (v0) collection;
        int i = v0Var.f5891d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f5891d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f5890c;
            if (i3 > jArr.length) {
                this.f5890c = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(v0Var.f5890c, 0, this.f5890c, this.f5891d, v0Var.f5891d);
            this.f5891d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(long j) {
        a();
        int i = this.f5891d;
        long[] jArr = this.f5890c;
        if (i == jArr.length) {
            long[] jArr2 = new long[a.b(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f5890c = jArr2;
        }
        long[] jArr3 = this.f5890c;
        int i2 = this.f5891d;
        this.f5891d = i2 + 1;
        jArr3[i2] = j;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f5891d) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    @Override // c.b.d.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return super.equals(obj);
        }
        v0 v0Var = (v0) obj;
        if (this.f5891d != v0Var.f5891d) {
            return false;
        }
        long[] jArr = v0Var.f5890c;
        for (int i = 0; i < this.f5891d; i++) {
            if (this.f5890c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public long g(int i) {
        e(i);
        return this.f5890c[i];
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Long.valueOf(this.f5890c[i]);
    }

    public final String h(int i) {
        StringBuilder i2 = a.i("Index:", i, ", Size:");
        i2.append(this.f5891d);
        return i2.toString();
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f5891d; i2++) {
            i = (i * 31) + n0.e(this.f5890c[i2]);
        }
        return i;
    }

    /* renamed from: j */
    public n0.g i(int i) {
        if (i >= this.f5891d) {
            return new v0(Arrays.copyOf(this.f5890c, i), this.f5891d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        long[] jArr = this.f5890c;
        long j = jArr[i];
        int i2 = this.f5891d;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f5891d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f5891d; i++) {
            if (obj.equals(Long.valueOf(this.f5890c[i]))) {
                long[] jArr = this.f5890c;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f5891d - i) - 1);
                this.f5891d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            long[] jArr = this.f5890c;
            System.arraycopy(jArr, i2, jArr, i, this.f5891d - i2);
            this.f5891d -= i2 - i;
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
        long[] jArr = this.f5890c;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public int size() {
        return this.f5891d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Long l) {
        c(l.longValue());
        return true;
    }
}
