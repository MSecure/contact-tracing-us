package c.b.a.a.g.b;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class j0 extends s<Double> implements e1<Double>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public double[] f3328c;

    /* renamed from: d  reason: collision with root package name */
    public int f3329d;

    static {
        new j0().f3405b = false;
    }

    public j0() {
        this.f3328c = new double[10];
        this.f3329d = 0;
    }

    public j0(double[] dArr, int i) {
        this.f3328c = dArr;
        this.f3329d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        c(i, ((Double) obj).doubleValue());
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.a.a.g.b.s
    public final boolean addAll(Collection<? extends Double> collection) {
        a();
        b1.a(collection);
        if (!(collection instanceof j0)) {
            return super.addAll(collection);
        }
        j0 j0Var = (j0) collection;
        int i = j0Var.f3329d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3329d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f3328c;
            if (i3 > dArr.length) {
                this.f3328c = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(j0Var.f3328c, 0, this.f3328c, this.f3329d, j0Var.f3329d);
            this.f3329d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(int i, double d2) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f3329d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        double[] dArr = this.f3328c;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[a.b(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f3328c, i, dArr2, i + 1, this.f3329d - i);
            this.f3328c = dArr2;
        }
        this.f3328c[i] = d2;
        this.f3329d++;
        ((AbstractList) this).modCount++;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3329d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.a.a.g.b.s
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return super.equals(obj);
        }
        j0 j0Var = (j0) obj;
        if (this.f3329d != j0Var.f3329d) {
            return false;
        }
        double[] dArr = j0Var.f3328c;
        for (int i = 0; i < this.f3329d; i++) {
            if (this.f3328c[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3329d);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Double.valueOf(this.f3328c[i]);
    }

    @Override // c.b.a.a.g.b.s
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3329d; i2++) {
            i = (i * 31) + b1.h(Double.doubleToLongBits(this.f3328c[i2]));
        }
        return i;
    }

    /* Return type fixed from 'c.b.a.a.g.b.e1' to match base method */
    @Override // c.b.a.a.g.b.e1
    public final /* synthetic */ e1<Double> r(int i) {
        if (i >= this.f3329d) {
            return new j0(Arrays.copyOf(this.f3328c, i), this.f3329d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        e(i);
        double[] dArr = this.f3328c;
        double d2 = dArr[i];
        int i2 = this.f3329d;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, i2 - i);
        }
        this.f3329d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.List, c.b.a.a.g.b.s
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3329d; i++) {
            if (obj.equals(Double.valueOf(this.f3328c[i]))) {
                double[] dArr = this.f3328c;
                System.arraycopy(dArr, i + 1, dArr, i, this.f3329d - i);
                this.f3329d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            double[] dArr = this.f3328c;
            System.arraycopy(dArr, i2, dArr, i, this.f3329d - i2);
            this.f3329d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        a();
        e(i);
        double[] dArr = this.f3328c;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    public final int size() {
        return this.f3329d;
    }
}
