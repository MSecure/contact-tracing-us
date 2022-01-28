package c.b.a.a.g.b;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class a1 extends s<Integer> implements e1<Integer>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public int[] f3214c;

    /* renamed from: d  reason: collision with root package name */
    public int f3215d;

    static {
        new a1().f3405b = false;
    }

    public a1() {
        this.f3214c = new int[10];
        this.f3215d = 0;
    }

    public a1(int[] iArr, int i) {
        this.f3214c = iArr;
        this.f3215d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        h(i, ((Integer) obj).intValue());
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.a.a.g.b.s
    public final boolean addAll(Collection<? extends Integer> collection) {
        a();
        b1.a(collection);
        if (!(collection instanceof a1)) {
            return super.addAll(collection);
        }
        a1 a1Var = (a1) collection;
        int i = a1Var.f3215d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3215d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f3214c;
            if (i3 > iArr.length) {
                this.f3214c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(a1Var.f3214c, 0, this.f3214c, this.f3215d, a1Var.f3215d);
            this.f3215d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final int c(int i) {
        e(i);
        return this.f3214c[i];
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3215d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.a.a.g.b.s
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return super.equals(obj);
        }
        a1 a1Var = (a1) obj;
        if (this.f3215d != a1Var.f3215d) {
            return false;
        }
        int[] iArr = a1Var.f3214c;
        for (int i = 0; i < this.f3215d; i++) {
            if (this.f3214c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3215d);
    }

    @Override // java.util.List, java.util.AbstractList
    public final Object get(int i) {
        e(i);
        return Integer.valueOf(this.f3214c[i]);
    }

    public final void h(int i, int i2) {
        int i3;
        a();
        if (i < 0 || i > (i3 = this.f3215d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        int[] iArr = this.f3214c;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[a.b(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f3214c, i, iArr2, i + 1, this.f3215d - i);
            this.f3214c = iArr2;
        }
        this.f3214c[i] = i2;
        this.f3215d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.a.a.g.b.s
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3215d; i2++) {
            i = (i * 31) + this.f3214c[i2];
        }
        return i;
    }

    /* Return type fixed from 'c.b.a.a.g.b.e1' to match base method */
    @Override // c.b.a.a.g.b.e1
    public final /* synthetic */ e1<Integer> r(int i) {
        if (i >= this.f3215d) {
            return new a1(Arrays.copyOf(this.f3214c, i), this.f3215d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        e(i);
        int[] iArr = this.f3214c;
        int i2 = iArr[i];
        int i3 = this.f3215d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, i3 - i);
        }
        this.f3215d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.List, c.b.a.a.g.b.s
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3215d; i++) {
            if (obj.equals(Integer.valueOf(this.f3214c[i]))) {
                int[] iArr = this.f3214c;
                System.arraycopy(iArr, i + 1, iArr, i, this.f3215d - i);
                this.f3215d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            int[] iArr = this.f3214c;
            System.arraycopy(iArr, i2, iArr, i, this.f3215d - i2);
            this.f3215d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        a();
        e(i);
        int[] iArr = this.f3214c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.f3215d;
    }
}
