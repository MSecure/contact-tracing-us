package f.b.f;

import f.a.a.a.a;
import f.b.f.c0;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

public final class x extends c<Float> implements c0.f, RandomAccess, c1 {

    /* renamed from: e  reason: collision with root package name */
    public static final x f3404e;
    public float[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f3405d;

    static {
        x xVar = new x(new float[0], 0);
        f3404e = xVar;
        xVar.b = false;
    }

    public x() {
        this.c = new float[10];
        this.f3405d = 0;
    }

    public x(float[] fArr, int i2) {
        this.c = fArr;
        this.f3405d = i2;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i2, Object obj) {
        int i3;
        float floatValue = ((Float) obj).floatValue();
        h();
        if (i2 < 0 || i2 > (i3 = this.f3405d)) {
            throw new IndexOutOfBoundsException(k(i2));
        }
        float[] fArr = this.c;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[a.b(i3, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.c, i2, fArr2, i2 + 1, this.f3405d - i2);
            this.c = fArr2;
        }
        this.c[i2] = floatValue;
        this.f3405d++;
        ((AbstractList) this).modCount++;
    }

    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Float> collection) {
        h();
        Charset charset = c0.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof x)) {
            return super.addAll(collection);
        }
        x xVar = (x) collection;
        int i2 = xVar.f3405d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f3405d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.c;
            if (i4 > fArr.length) {
                this.c = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(xVar.c, 0, this.c, this.f3405d, xVar.f3405d);
            this.f3405d = i4;
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
        if (!(obj instanceof x)) {
            return super.equals(obj);
        }
        x xVar = (x) obj;
        if (this.f3405d != xVar.f3405d) {
            return false;
        }
        float[] fArr = xVar.c;
        for (int i2 = 0; i2 < this.f3405d; i2++) {
            if (Float.floatToIntBits(this.c[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i2) {
        j(i2);
        return Float.valueOf(this.c[i2]);
    }

    @Override // f.b.f.c
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f3405d; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.c[i3]);
        }
        return i2;
    }

    public void i(float f2) {
        h();
        int i2 = this.f3405d;
        float[] fArr = this.c;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[a.b(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.c = fArr2;
        }
        float[] fArr3 = this.c;
        int i3 = this.f3405d;
        this.f3405d = i3 + 1;
        fArr3[i3] = f2;
    }

    public final void j(int i2) {
        if (i2 < 0 || i2 >= this.f3405d) {
            throw new IndexOutOfBoundsException(k(i2));
        }
    }

    public final String k(int i2) {
        return "Index:" + i2 + ", Size:" + this.f3405d;
    }

    /* renamed from: l */
    public c0.f d(int i2) {
        if (i2 >= this.f3405d) {
            return new x(Arrays.copyOf(this.c, i2), this.f3405d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i2) {
        h();
        j(i2);
        float[] fArr = this.c;
        float f2 = fArr[i2];
        int i3 = this.f3405d;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f3405d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // f.b.f.c, java.util.List
    public boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f3405d; i2++) {
            if (obj.equals(Float.valueOf(this.c[i2]))) {
                float[] fArr = this.c;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f3405d - i2) - 1);
                this.f3405d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i2, int i3) {
        h();
        if (i3 >= i2) {
            float[] fArr = this.c;
            System.arraycopy(fArr, i3, fArr, i2, this.f3405d - i3);
            this.f3405d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        h();
        j(i2);
        float[] fArr = this.c;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    public int size() {
        return this.f3405d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Float f2) {
        i(f2.floatValue());
        return true;
    }
}
