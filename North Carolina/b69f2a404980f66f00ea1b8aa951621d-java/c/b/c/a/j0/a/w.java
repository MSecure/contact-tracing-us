package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.a0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class w extends c<Float> implements Object, RandomAccess, z0 {

    /* renamed from: e  reason: collision with root package name */
    public static final w f3667e;

    /* renamed from: c  reason: collision with root package name */
    public float[] f3668c;

    /* renamed from: d  reason: collision with root package name */
    public int f3669d;

    static {
        w wVar = new w(new float[0], 0);
        f3667e = wVar;
        wVar.f3526b = false;
    }

    public w() {
        this.f3668c = new float[10];
        this.f3669d = 0;
    }

    public w(float[] fArr, int i) {
        this.f3668c = fArr;
        this.f3669d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        a();
        if (i < 0 || i > (i2 = this.f3669d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        float[] fArr = this.f3668c;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[a.b(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f3668c, i, fArr2, i + 1, this.f3669d - i);
            this.f3668c = fArr2;
        }
        this.f3668c[i] = floatValue;
        this.f3669d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection
    public boolean addAll(Collection<? extends Float> collection) {
        a();
        a0.a(collection);
        if (!(collection instanceof w)) {
            return super.addAll(collection);
        }
        w wVar = (w) collection;
        int i = wVar.f3669d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3669d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f3668c;
            if (i3 > fArr.length) {
                this.f3668c = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(wVar.f3668c, 0, this.f3668c, this.f3669d, wVar.f3669d);
            this.f3669d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(float f) {
        a();
        int i = this.f3669d;
        float[] fArr = this.f3668c;
        if (i == fArr.length) {
            float[] fArr2 = new float[a.b(i, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f3668c = fArr2;
        }
        float[] fArr3 = this.f3668c;
        int i2 = this.f3669d;
        this.f3669d = i2 + 1;
        fArr3[i2] = f;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3669d) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    @Override // c.b.c.a.j0.a.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return super.equals(obj);
        }
        w wVar = (w) obj;
        if (this.f3669d != wVar.f3669d) {
            return false;
        }
        float[] fArr = wVar.f3668c;
        for (int i = 0; i < this.f3669d; i++) {
            if (Float.floatToIntBits(this.f3668c[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c g(int i) {
        if (i >= this.f3669d) {
            return new w(Arrays.copyOf(this.f3668c, i), this.f3669d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Float.valueOf(this.f3668c[i]);
    }

    public final String h(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f3669d);
        return h.toString();
    }

    @Override // c.b.c.a.j0.a.c
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3669d; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f3668c[i2]);
        }
        return i;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        float[] fArr = this.f3668c;
        float f = fArr[i];
        int i2 = this.f3669d;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f3669d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.List, c.b.c.a.j0.a.c
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3669d; i++) {
            if (obj.equals(Float.valueOf(this.f3668c[i]))) {
                float[] fArr = this.f3668c;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f3669d - i) - 1);
                this.f3669d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            float[] fArr = this.f3668c;
            System.arraycopy(fArr, i2, fArr, i, this.f3669d - i2);
            this.f3669d -= i2 - i;
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
        float[] fArr = this.f3668c;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public int size() {
        return this.f3669d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection, java.util.AbstractList
    public boolean add(Float f) {
        c(f.floatValue());
        return true;
    }
}
