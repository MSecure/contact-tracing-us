package f.b.f;

import f.a.a.a.a;
import f.b.f.c0;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

public final class o extends c<Double> implements c0.b, RandomAccess, c1 {

    /* renamed from: e  reason: collision with root package name */
    public static final o f3366e;
    public double[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f3367d;

    static {
        o oVar = new o(new double[0], 0);
        f3366e = oVar;
        oVar.b = false;
    }

    public o() {
        this.c = new double[10];
        this.f3367d = 0;
    }

    public o(double[] dArr, int i2) {
        this.c = dArr;
        this.f3367d = i2;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        h();
        if (i2 < 0 || i2 > (i3 = this.f3367d)) {
            throw new IndexOutOfBoundsException(k(i2));
        }
        double[] dArr = this.c;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[a.b(i3, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.c, i2, dArr2, i2 + 1, this.f3367d - i2);
            this.c = dArr2;
        }
        this.c[i2] = doubleValue;
        this.f3367d++;
        ((AbstractList) this).modCount++;
    }

    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Double> collection) {
        h();
        Charset charset = c0.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof o)) {
            return super.addAll(collection);
        }
        o oVar = (o) collection;
        int i2 = oVar.f3367d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f3367d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.c;
            if (i4 > dArr.length) {
                this.c = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(oVar.c, 0, this.c, this.f3367d, oVar.f3367d);
            this.f3367d = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // f.b.f.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        if (this.f3367d != oVar.f3367d) {
            return false;
        }
        double[] dArr = oVar.c;
        for (int i2 = 0; i2 < this.f3367d; i2++) {
            if (Double.doubleToLongBits(this.c[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i2) {
        j(i2);
        return Double.valueOf(this.c[i2]);
    }

    @Override // f.b.f.c
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f3367d; i3++) {
            i2 = (i2 * 31) + c0.b(Double.doubleToLongBits(this.c[i3]));
        }
        return i2;
    }

    public void i(double d2) {
        h();
        int i2 = this.f3367d;
        double[] dArr = this.c;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[a.b(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.c = dArr2;
        }
        double[] dArr3 = this.c;
        int i3 = this.f3367d;
        this.f3367d = i3 + 1;
        dArr3[i3] = d2;
    }

    public final void j(int i2) {
        if (i2 < 0 || i2 >= this.f3367d) {
            throw new IndexOutOfBoundsException(k(i2));
        }
    }

    public final String k(int i2) {
        return "Index:" + i2 + ", Size:" + this.f3367d;
    }

    /* renamed from: l */
    public c0.b d(int i2) {
        if (i2 >= this.f3367d) {
            return new o(Arrays.copyOf(this.c, i2), this.f3367d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i2) {
        h();
        j(i2);
        double[] dArr = this.c;
        double d2 = dArr[i2];
        int i3 = this.f3367d;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f3367d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // f.b.f.c, java.util.List
    public boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f3367d; i2++) {
            if (obj.equals(Double.valueOf(this.c[i2]))) {
                double[] dArr = this.c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f3367d - i2) - 1);
                this.f3367d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i2, int i3) {
        h();
        if (i3 >= i2) {
            double[] dArr = this.c;
            System.arraycopy(dArr, i3, dArr, i2, this.f3367d - i3);
            this.f3367d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        h();
        j(i2);
        double[] dArr = this.c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    public int size() {
        return this.f3367d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Double d2) {
        i(d2.doubleValue());
        return true;
    }
}
