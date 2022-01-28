package c.b.a.a.g.h;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class c1 extends k0<Double> implements z1<Double>, l3, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public double[] f3849c;

    /* renamed from: d  reason: collision with root package name */
    public int f3850d;

    static {
        new c1(new double[0], 0).f3921b = false;
    }

    public c1() {
        this.f3849c = new double[10];
        this.f3850d = 0;
    }

    public c1(double[] dArr, int i) {
        this.f3849c = dArr;
        this.f3850d = i;
    }

    /* Return type fixed from 'c.b.a.a.g.h.z1' to match base method */
    @Override // c.b.a.a.g.h.z1
    public final /* synthetic */ z1<Double> B(int i) {
        if (i >= this.f3850d) {
            return new c1(Arrays.copyOf(this.f3849c, i), this.f3850d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        a();
        if (i < 0 || i > (i2 = this.f3850d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        double[] dArr = this.f3849c;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[a.b(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f3849c, i, dArr2, i + 1, this.f3850d - i);
            this.f3849c = dArr2;
        }
        this.f3849c[i] = doubleValue;
        this.f3850d++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Double d2) {
        g(d2.doubleValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection
    public final boolean addAll(Collection<? extends Double> collection) {
        a();
        u1.a(collection);
        if (!(collection instanceof c1)) {
            return super.addAll(collection);
        }
        c1 c1Var = (c1) collection;
        int i = c1Var.f3850d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3850d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f3849c;
            if (i3 > dArr.length) {
                this.f3849c = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(c1Var.f3849c, 0, this.f3849c, this.f3850d, c1Var.f3850d);
            this.f3850d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(int i) {
        if (i < 0 || i >= this.f3850d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final String e(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3850d);
    }

    @Override // c.b.a.a.g.h.k0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return super.equals(obj);
        }
        c1 c1Var = (c1) obj;
        if (this.f3850d != c1Var.f3850d) {
            return false;
        }
        double[] dArr = c1Var.f3849c;
        for (int i = 0; i < this.f3850d; i++) {
            if (Double.doubleToLongBits(this.f3849c[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final void g(double d2) {
        a();
        int i = this.f3850d;
        double[] dArr = this.f3849c;
        if (i == dArr.length) {
            double[] dArr2 = new double[a.b(i, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f3849c = dArr2;
        }
        double[] dArr3 = this.f3849c;
        int i2 = this.f3850d;
        this.f3850d = i2 + 1;
        dArr3[i2] = d2;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        c(i);
        return Double.valueOf(this.f3849c[i]);
    }

    @Override // c.b.a.a.g.h.k0
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3850d; i2++) {
            i = (i * 31) + u1.e(Double.doubleToLongBits(this.f3849c[i2]));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i = this.f3850d;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f3849c[i2] == doubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        c(i);
        double[] dArr = this.f3849c;
        double d2 = dArr[i];
        int i2 = this.f3850d;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f3850d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.List, c.b.a.a.g.h.k0
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3850d; i++) {
            if (obj.equals(Double.valueOf(this.f3849c[i]))) {
                double[] dArr = this.f3849c;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f3850d - i) - 1);
                this.f3850d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            double[] dArr = this.f3849c;
            System.arraycopy(dArr, i2, dArr, i, this.f3850d - i2);
            this.f3850d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        a();
        c(i);
        double[] dArr = this.f3849c;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    public final int size() {
        return this.f3850d;
    }
}
