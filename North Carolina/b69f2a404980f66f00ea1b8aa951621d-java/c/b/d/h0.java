package c.b.d;

import c.a.a.a.a;
import c.b.d.m0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class h0 extends d<Float> implements m0.e, RandomAccess, w1 {

    /* renamed from: e  reason: collision with root package name */
    public static final h0 f3895e;

    /* renamed from: c  reason: collision with root package name */
    public float[] f3896c;

    /* renamed from: d  reason: collision with root package name */
    public int f3897d;

    static {
        h0 h0Var = new h0(new float[0], 0);
        f3895e = h0Var;
        h0Var.f3839b = false;
    }

    public h0() {
        this.f3896c = new float[10];
        this.f3897d = 0;
    }

    public h0(float[] fArr, int i) {
        this.f3896c = fArr;
        this.f3897d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        a();
        if (i < 0 || i > (i2 = this.f3897d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        float[] fArr = this.f3896c;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[a.b(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f3896c, i, fArr2, i + 1, this.f3897d - i);
            this.f3896c = fArr2;
        }
        this.f3896c[i] = floatValue;
        this.f3897d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Float> collection) {
        a();
        m0.a(collection);
        if (!(collection instanceof h0)) {
            return super.addAll(collection);
        }
        h0 h0Var = (h0) collection;
        int i = h0Var.f3897d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3897d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f3896c;
            if (i3 > fArr.length) {
                this.f3896c = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(h0Var.f3896c, 0, this.f3896c, this.f3897d, h0Var.f3897d);
            this.f3897d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(float f) {
        a();
        int i = this.f3897d;
        float[] fArr = this.f3896c;
        if (i == fArr.length) {
            float[] fArr2 = new float[a.b(i, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f3896c = fArr2;
        }
        float[] fArr3 = this.f3896c;
        int i2 = this.f3897d;
        this.f3897d = i2 + 1;
        fArr3[i2] = f;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3897d) {
            throw new IndexOutOfBoundsException(h(i));
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
        if (this.f3897d != h0Var.f3897d) {
            return false;
        }
        float[] fArr = h0Var.f3896c;
        for (int i = 0; i < this.f3897d; i++) {
            if (Float.floatToIntBits(this.f3896c[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Float.valueOf(this.f3896c[i]);
    }

    public final String h(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f3897d);
        return h.toString();
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3897d; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f3896c[i2]);
        }
        return i;
    }

    /* renamed from: j */
    public m0.e g(int i) {
        if (i >= this.f3897d) {
            return new h0(Arrays.copyOf(this.f3896c, i), this.f3897d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        float[] fArr = this.f3896c;
        float f = fArr[i];
        int i2 = this.f3897d;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f3897d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3897d; i++) {
            if (obj.equals(Float.valueOf(this.f3896c[i]))) {
                float[] fArr = this.f3896c;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f3897d - i) - 1);
                this.f3897d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            float[] fArr = this.f3896c;
            System.arraycopy(fArr, i2, fArr, i, this.f3897d - i2);
            this.f3897d -= i2 - i;
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
        float[] fArr = this.f3896c;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public int size() {
        return this.f3897d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Float f) {
        c(f.floatValue());
        return true;
    }
}
