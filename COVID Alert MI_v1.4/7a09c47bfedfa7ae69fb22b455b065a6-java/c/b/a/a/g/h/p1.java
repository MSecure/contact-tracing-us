package c.b.a.a.g.h;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class p1 extends k0<Float> implements z1<Float>, l3, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public float[] f3990c;

    /* renamed from: d  reason: collision with root package name */
    public int f3991d;

    static {
        new p1(new float[0], 0).f3921b = false;
    }

    public p1() {
        this.f3990c = new float[10];
        this.f3991d = 0;
    }

    public p1(float[] fArr, int i) {
        this.f3990c = fArr;
        this.f3991d = i;
    }

    /* Return type fixed from 'c.b.a.a.g.h.z1' to match base method */
    @Override // c.b.a.a.g.h.z1
    public final /* synthetic */ z1<Float> B(int i) {
        if (i >= this.f3991d) {
            return new p1(Arrays.copyOf(this.f3990c, i), this.f3991d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        a();
        if (i < 0 || i > (i2 = this.f3991d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        float[] fArr = this.f3990c;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[a.b(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f3990c, i, fArr2, i + 1, this.f3991d - i);
            this.f3990c = fArr2;
        }
        this.f3990c[i] = floatValue;
        this.f3991d++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Float f2) {
        g(f2.floatValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection
    public final boolean addAll(Collection<? extends Float> collection) {
        a();
        u1.a(collection);
        if (!(collection instanceof p1)) {
            return super.addAll(collection);
        }
        p1 p1Var = (p1) collection;
        int i = p1Var.f3991d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3991d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f3990c;
            if (i3 > fArr.length) {
                this.f3990c = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(p1Var.f3990c, 0, this.f3990c, this.f3991d, p1Var.f3991d);
            this.f3991d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(int i) {
        if (i < 0 || i >= this.f3991d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final String e(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3991d);
    }

    @Override // c.b.a.a.g.h.k0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return super.equals(obj);
        }
        p1 p1Var = (p1) obj;
        if (this.f3991d != p1Var.f3991d) {
            return false;
        }
        float[] fArr = p1Var.f3990c;
        for (int i = 0; i < this.f3991d; i++) {
            if (Float.floatToIntBits(this.f3990c[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final void g(float f2) {
        a();
        int i = this.f3991d;
        float[] fArr = this.f3990c;
        if (i == fArr.length) {
            float[] fArr2 = new float[a.b(i, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f3990c = fArr2;
        }
        float[] fArr3 = this.f3990c;
        int i2 = this.f3991d;
        this.f3991d = i2 + 1;
        fArr3[i2] = f2;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        c(i);
        return Float.valueOf(this.f3990c[i]);
    }

    @Override // c.b.a.a.g.h.k0
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3991d; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f3990c[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i = this.f3991d;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f3990c[i2] == floatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        c(i);
        float[] fArr = this.f3990c;
        float f2 = fArr[i];
        int i2 = this.f3991d;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f3991d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.List, c.b.a.a.g.h.k0
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3991d; i++) {
            if (obj.equals(Float.valueOf(this.f3990c[i]))) {
                float[] fArr = this.f3990c;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f3991d - i) - 1);
                this.f3991d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            float[] fArr = this.f3990c;
            System.arraycopy(fArr, i2, fArr, i, this.f3991d - i2);
            this.f3991d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        a();
        c(i);
        float[] fArr = this.f3990c;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    public final int size() {
        return this.f3991d;
    }
}
