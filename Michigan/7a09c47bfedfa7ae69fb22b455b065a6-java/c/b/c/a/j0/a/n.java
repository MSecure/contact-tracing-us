package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.a0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class n extends c<Double> implements Object, RandomAccess, z0 {

    /* renamed from: e  reason: collision with root package name */
    public static final n f4989e;

    /* renamed from: c  reason: collision with root package name */
    public double[] f4990c;

    /* renamed from: d  reason: collision with root package name */
    public int f4991d;

    static {
        n nVar = new n(new double[0], 0);
        f4989e = nVar;
        nVar.f4893b = false;
    }

    public n() {
        this.f4990c = new double[10];
        this.f4991d = 0;
    }

    public n(double[] dArr, int i) {
        this.f4990c = dArr;
        this.f4991d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        a();
        if (i < 0 || i > (i2 = this.f4991d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        double[] dArr = this.f4990c;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[a.b(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f4990c, i, dArr2, i + 1, this.f4991d - i);
            this.f4990c = dArr2;
        }
        this.f4990c[i] = doubleValue;
        this.f4991d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection
    public boolean addAll(Collection<? extends Double> collection) {
        a();
        a0.a(collection);
        if (!(collection instanceof n)) {
            return super.addAll(collection);
        }
        n nVar = (n) collection;
        int i = nVar.f4991d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f4991d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f4990c;
            if (i3 > dArr.length) {
                this.f4990c = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(nVar.f4990c, 0, this.f4990c, this.f4991d, nVar.f4991d);
            this.f4991d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(double d2) {
        a();
        int i = this.f4991d;
        double[] dArr = this.f4990c;
        if (i == dArr.length) {
            double[] dArr2 = new double[a.b(i, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f4990c = dArr2;
        }
        double[] dArr3 = this.f4990c;
        int i2 = this.f4991d;
        this.f4991d = i2 + 1;
        dArr3[i2] = d2;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f4991d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.c.a.j0.a.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return super.equals(obj);
        }
        n nVar = (n) obj;
        if (this.f4991d != nVar.f4991d) {
            return false;
        }
        double[] dArr = nVar.f4990c;
        for (int i = 0; i < this.f4991d; i++) {
            if (Double.doubleToLongBits(this.f4990c[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        StringBuilder i2 = a.i("Index:", i, ", Size:");
        i2.append(this.f4991d);
        return i2.toString();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Double.valueOf(this.f4990c[i]);
    }

    @Override // c.b.c.a.j0.a.c
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f4991d; i2++) {
            i = (i * 31) + a0.e(Double.doubleToLongBits(this.f4990c[i2]));
        }
        return i;
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c i(int i) {
        if (i >= this.f4991d) {
            return new n(Arrays.copyOf(this.f4990c, i), this.f4991d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        double[] dArr = this.f4990c;
        double d2 = dArr[i];
        int i2 = this.f4991d;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f4991d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.List, c.b.c.a.j0.a.c
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f4991d; i++) {
            if (obj.equals(Double.valueOf(this.f4990c[i]))) {
                double[] dArr = this.f4990c;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f4991d - i) - 1);
                this.f4991d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            double[] dArr = this.f4990c;
            System.arraycopy(dArr, i2, dArr, i, this.f4991d - i2);
            this.f4991d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        a();
        e(i);
        double[] dArr = this.f4990c;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    public int size() {
        return this.f4991d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection, java.util.AbstractList
    public boolean add(Double d2) {
        c(d2.doubleValue());
        return true;
    }
}
