package c.b.d;

import c.a.a.a.a;
import c.b.d.m0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class g extends d<Boolean> implements m0.a, RandomAccess, w1 {

    /* renamed from: e  reason: collision with root package name */
    public static final g f3870e;

    /* renamed from: c  reason: collision with root package name */
    public boolean[] f3871c;

    /* renamed from: d  reason: collision with root package name */
    public int f3872d;

    static {
        g gVar = new g(new boolean[0], 0);
        f3870e = gVar;
        gVar.f3839b = false;
    }

    public g() {
        this.f3871c = new boolean[10];
        this.f3872d = 0;
    }

    public g(boolean[] zArr, int i) {
        this.f3871c = zArr;
        this.f3872d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        if (i < 0 || i > (i2 = this.f3872d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        boolean[] zArr = this.f3871c;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[a.b(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f3871c, i, zArr2, i + 1, this.f3872d - i);
            this.f3871c = zArr2;
        }
        this.f3871c[i] = booleanValue;
        this.f3872d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Boolean> collection) {
        a();
        m0.a(collection);
        if (!(collection instanceof g)) {
            return super.addAll(collection);
        }
        g gVar = (g) collection;
        int i = gVar.f3872d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3872d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f3871c;
            if (i3 > zArr.length) {
                this.f3871c = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(gVar.f3871c, 0, this.f3871c, this.f3872d, gVar.f3872d);
            this.f3872d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(boolean z) {
        a();
        int i = this.f3872d;
        boolean[] zArr = this.f3871c;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[a.b(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f3871c = zArr2;
        }
        boolean[] zArr3 = this.f3871c;
        int i2 = this.f3872d;
        this.f3872d = i2 + 1;
        zArr3[i2] = z;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3872d) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    @Override // c.b.d.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return super.equals(obj);
        }
        g gVar = (g) obj;
        if (this.f3872d != gVar.f3872d) {
            return false;
        }
        boolean[] zArr = gVar.f3871c;
        for (int i = 0; i < this.f3872d; i++) {
            if (this.f3871c[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Boolean.valueOf(this.f3871c[i]);
    }

    public final String h(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f3872d);
        return h.toString();
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3872d; i2++) {
            i = (i * 31) + m0.c(this.f3871c[i2]);
        }
        return i;
    }

    /* renamed from: j */
    public m0.a g(int i) {
        if (i >= this.f3872d) {
            return new g(Arrays.copyOf(this.f3871c, i), this.f3872d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        boolean[] zArr = this.f3871c;
        boolean z = zArr[i];
        int i2 = this.f3872d;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f3872d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3872d; i++) {
            if (obj.equals(Boolean.valueOf(this.f3871c[i]))) {
                boolean[] zArr = this.f3871c;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f3872d - i) - 1);
                this.f3872d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            boolean[] zArr = this.f3871c;
            System.arraycopy(zArr, i2, zArr, i, this.f3872d - i2);
            this.f3872d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        e(i);
        boolean[] zArr = this.f3871c;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public int size() {
        return this.f3872d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Boolean bool) {
        c(bool.booleanValue());
        return true;
    }
}
