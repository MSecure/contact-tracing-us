package c.b.a.a.g.b;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class x0 extends s<Float> implements e1<Float>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public float[] f3463c;

    /* renamed from: d  reason: collision with root package name */
    public int f3464d;

    static {
        new x0().f3405b = false;
    }

    public x0() {
        this.f3463c = new float[10];
        this.f3464d = 0;
    }

    public x0(float[] fArr, int i) {
        this.f3463c = fArr;
        this.f3464d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        c(i, ((Float) obj).floatValue());
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.a.a.g.b.s
    public final boolean addAll(Collection<? extends Float> collection) {
        a();
        b1.a(collection);
        if (!(collection instanceof x0)) {
            return super.addAll(collection);
        }
        x0 x0Var = (x0) collection;
        int i = x0Var.f3464d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3464d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f3463c;
            if (i3 > fArr.length) {
                this.f3463c = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(x0Var.f3463c, 0, this.f3463c, this.f3464d, x0Var.f3464d);
            this.f3464d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(int i, float f2) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f3464d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        float[] fArr = this.f3463c;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[a.b(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f3463c, i, fArr2, i + 1, this.f3464d - i);
            this.f3463c = fArr2;
        }
        this.f3463c[i] = f2;
        this.f3464d++;
        ((AbstractList) this).modCount++;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3464d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.a.a.g.b.s
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return super.equals(obj);
        }
        x0 x0Var = (x0) obj;
        if (this.f3464d != x0Var.f3464d) {
            return false;
        }
        float[] fArr = x0Var.f3463c;
        for (int i = 0; i < this.f3464d; i++) {
            if (this.f3463c[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3464d);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Float.valueOf(this.f3463c[i]);
    }

    @Override // c.b.a.a.g.b.s
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3464d; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f3463c[i2]);
        }
        return i;
    }

    /* Return type fixed from 'c.b.a.a.g.b.e1' to match base method */
    @Override // c.b.a.a.g.b.e1
    public final /* synthetic */ e1<Float> r(int i) {
        if (i >= this.f3464d) {
            return new x0(Arrays.copyOf(this.f3463c, i), this.f3464d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        e(i);
        float[] fArr = this.f3463c;
        float f2 = fArr[i];
        int i2 = this.f3464d;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, i2 - i);
        }
        this.f3464d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.List, c.b.a.a.g.b.s
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3464d; i++) {
            if (obj.equals(Float.valueOf(this.f3463c[i]))) {
                float[] fArr = this.f3463c;
                System.arraycopy(fArr, i + 1, fArr, i, this.f3464d - i);
                this.f3464d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            float[] fArr = this.f3463c;
            System.arraycopy(fArr, i2, fArr, i, this.f3464d - i2);
            this.f3464d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        a();
        e(i);
        float[] fArr = this.f3463c;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    public final int size() {
        return this.f3464d;
    }
}
