package c.b.d;

import c.a.a.a.a;
import c.b.d.n0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class h0 extends d<Float> implements n0.e, RandomAccess, x1 {

    /* renamed from: e  reason: collision with root package name */
    public static final h0 f5292e;

    /* renamed from: c  reason: collision with root package name */
    public float[] f5293c;

    /* renamed from: d  reason: collision with root package name */
    public int f5294d;

    static {
        h0 h0Var = new h0(new float[0], 0);
        f5292e = h0Var;
        h0Var.f5244b = false;
    }

    public h0() {
        this.f5293c = new float[10];
        this.f5294d = 0;
    }

    public h0(float[] fArr, int i) {
        this.f5293c = fArr;
        this.f5294d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        a();
        if (i < 0 || i > (i2 = this.f5294d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        float[] fArr = this.f5293c;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[a.b(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f5293c, i, fArr2, i + 1, this.f5294d - i);
            this.f5293c = fArr2;
        }
        this.f5293c[i] = floatValue;
        this.f5294d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Float> collection) {
        a();
        n0.a(collection);
        if (!(collection instanceof h0)) {
            return super.addAll(collection);
        }
        h0 h0Var = (h0) collection;
        int i = h0Var.f5294d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f5294d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f5293c;
            if (i3 > fArr.length) {
                this.f5293c = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(h0Var.f5293c, 0, this.f5293c, this.f5294d, h0Var.f5294d);
            this.f5294d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(float f2) {
        a();
        int i = this.f5294d;
        float[] fArr = this.f5293c;
        if (i == fArr.length) {
            float[] fArr2 = new float[a.b(i, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f5293c = fArr2;
        }
        float[] fArr3 = this.f5293c;
        int i2 = this.f5294d;
        this.f5294d = i2 + 1;
        fArr3[i2] = f2;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f5294d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.d.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return super.equals(obj);
        }
        h0 h0Var = (h0) obj;
        if (this.f5294d != h0Var.f5294d) {
            return false;
        }
        float[] fArr = h0Var.f5293c;
        for (int i = 0; i < this.f5294d; i++) {
            if (Float.floatToIntBits(this.f5293c[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        StringBuilder i2 = a.i("Index:", i, ", Size:");
        i2.append(this.f5294d);
        return i2.toString();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Float.valueOf(this.f5293c[i]);
    }

    /* renamed from: h */
    public n0.e i(int i) {
        if (i >= this.f5294d) {
            return new h0(Arrays.copyOf(this.f5293c, i), this.f5294d);
        }
        throw new IllegalArgumentException();
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f5294d; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f5293c[i2]);
        }
        return i;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        float[] fArr = this.f5293c;
        float f2 = fArr[i];
        int i2 = this.f5294d;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f5294d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f5294d; i++) {
            if (obj.equals(Float.valueOf(this.f5293c[i]))) {
                float[] fArr = this.f5293c;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f5294d - i) - 1);
                this.f5294d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            float[] fArr = this.f5293c;
            System.arraycopy(fArr, i2, fArr, i, this.f5294d - i2);
            this.f5294d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        a();
        e(i);
        float[] fArr = this.f5293c;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    public int size() {
        return this.f5294d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Float f2) {
        c(f2.floatValue());
        return true;
    }
}
