package c.b.d;

import c.a.a.a.a;
import c.b.d.m0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class t extends d<Double> implements m0.b, RandomAccess, w1 {

    /* renamed from: e  reason: collision with root package name */
    public static final t f4325e;

    /* renamed from: c  reason: collision with root package name */
    public double[] f4326c;

    /* renamed from: d  reason: collision with root package name */
    public int f4327d;

    static {
        t tVar = new t(new double[0], 0);
        f4325e = tVar;
        tVar.f3839b = false;
    }

    public t() {
        this.f4326c = new double[10];
        this.f4327d = 0;
    }

    public t(double[] dArr, int i) {
        this.f4326c = dArr;
        this.f4327d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        a();
        if (i < 0 || i > (i2 = this.f4327d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        double[] dArr = this.f4326c;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[a.b(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f4326c, i, dArr2, i + 1, this.f4327d - i);
            this.f4326c = dArr2;
        }
        this.f4326c[i] = doubleValue;
        this.f4327d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Double> collection) {
        a();
        m0.a(collection);
        if (!(collection instanceof t)) {
            return super.addAll(collection);
        }
        t tVar = (t) collection;
        int i = tVar.f4327d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f4327d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f4326c;
            if (i3 > dArr.length) {
                this.f4326c = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(tVar.f4326c, 0, this.f4326c, this.f4327d, tVar.f4327d);
            this.f4327d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(double d2) {
        a();
        int i = this.f4327d;
        double[] dArr = this.f4326c;
        if (i == dArr.length) {
            double[] dArr2 = new double[a.b(i, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f4326c = dArr2;
        }
        double[] dArr3 = this.f4326c;
        int i2 = this.f4327d;
        this.f4327d = i2 + 1;
        dArr3[i2] = d2;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f4327d) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    @Override // c.b.d.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return super.equals(obj);
        }
        t tVar = (t) obj;
        if (this.f4327d != tVar.f4327d) {
            return false;
        }
        double[] dArr = tVar.f4326c;
        for (int i = 0; i < this.f4327d; i++) {
            if (Double.doubleToLongBits(this.f4326c[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Double.valueOf(this.f4326c[i]);
    }

    public final String h(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f4327d);
        return h.toString();
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f4327d; i2++) {
            i = (i * 31) + m0.e(Double.doubleToLongBits(this.f4326c[i2]));
        }
        return i;
    }

    /* renamed from: j */
    public m0.b g(int i) {
        if (i >= this.f4327d) {
            return new t(Arrays.copyOf(this.f4326c, i), this.f4327d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        double[] dArr = this.f4326c;
        double d2 = dArr[i];
        int i2 = this.f4327d;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f4327d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f4327d; i++) {
            if (obj.equals(Double.valueOf(this.f4326c[i]))) {
                double[] dArr = this.f4326c;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f4327d - i) - 1);
                this.f4327d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            double[] dArr = this.f4326c;
            System.arraycopy(dArr, i2, dArr, i, this.f4327d - i2);
            this.f4327d -= i2 - i;
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
        double[] dArr = this.f4326c;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    public int size() {
        return this.f4327d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Double d2) {
        c(d2.doubleValue());
        return true;
    }
}
