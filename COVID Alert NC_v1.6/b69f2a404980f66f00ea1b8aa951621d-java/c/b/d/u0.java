package c.b.d;

import c.a.a.a.a;
import c.b.d.m0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class u0 extends d<Long> implements m0.g, RandomAccess, w1 {

    /* renamed from: e  reason: collision with root package name */
    public static final u0 f4348e;

    /* renamed from: c  reason: collision with root package name */
    public long[] f4349c;

    /* renamed from: d  reason: collision with root package name */
    public int f4350d;

    static {
        u0 u0Var = new u0(new long[0], 0);
        f4348e = u0Var;
        u0Var.f3839b = false;
    }

    public u0() {
        this.f4349c = new long[10];
        this.f4350d = 0;
    }

    public u0(long[] jArr, int i) {
        this.f4349c = jArr;
        this.f4350d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.f4350d)) {
            throw new IndexOutOfBoundsException(j(i));
        }
        long[] jArr = this.f4349c;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[a.b(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f4349c, i, jArr2, i + 1, this.f4350d - i);
            this.f4349c = jArr2;
        }
        this.f4349c[i] = longValue;
        this.f4350d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Long> collection) {
        a();
        m0.a(collection);
        if (!(collection instanceof u0)) {
            return super.addAll(collection);
        }
        u0 u0Var = (u0) collection;
        int i = u0Var.f4350d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f4350d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f4349c;
            if (i3 > jArr.length) {
                this.f4349c = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(u0Var.f4349c, 0, this.f4349c, this.f4350d, u0Var.f4350d);
            this.f4350d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(long j) {
        a();
        int i = this.f4350d;
        long[] jArr = this.f4349c;
        if (i == jArr.length) {
            long[] jArr2 = new long[a.b(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f4349c = jArr2;
        }
        long[] jArr3 = this.f4349c;
        int i2 = this.f4350d;
        this.f4350d = i2 + 1;
        jArr3[i2] = j;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f4350d) {
            throw new IndexOutOfBoundsException(j(i));
        }
    }

    @Override // c.b.d.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return super.equals(obj);
        }
        u0 u0Var = (u0) obj;
        if (this.f4350d != u0Var.f4350d) {
            return false;
        }
        long[] jArr = u0Var.f4349c;
        for (int i = 0; i < this.f4350d; i++) {
            if (this.f4349c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Long.valueOf(this.f4349c[i]);
    }

    public long h(int i) {
        e(i);
        return this.f4349c[i];
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f4350d; i2++) {
            i = (i * 31) + m0.e(this.f4349c[i2]);
        }
        return i;
    }

    public final String j(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f4350d);
        return h.toString();
    }

    /* renamed from: m */
    public m0.g g(int i) {
        if (i >= this.f4350d) {
            return new u0(Arrays.copyOf(this.f4349c, i), this.f4350d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        long[] jArr = this.f4349c;
        long j = jArr[i];
        int i2 = this.f4350d;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f4350d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f4350d; i++) {
            if (obj.equals(Long.valueOf(this.f4349c[i]))) {
                long[] jArr = this.f4349c;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f4350d - i) - 1);
                this.f4350d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            long[] jArr = this.f4349c;
            System.arraycopy(jArr, i2, jArr, i, this.f4350d - i2);
            this.f4350d -= i2 - i;
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
        long[] jArr = this.f4349c;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public int size() {
        return this.f4350d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Long l) {
        c(l.longValue());
        return true;
    }
}
