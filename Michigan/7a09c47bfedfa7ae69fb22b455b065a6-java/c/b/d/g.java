package c.b.d;

import c.a.a.a.a;
import c.b.d.n0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class g extends d<Boolean> implements n0.a, RandomAccess, x1 {

    /* renamed from: e  reason: collision with root package name */
    public static final g f5273e;

    /* renamed from: c  reason: collision with root package name */
    public boolean[] f5274c;

    /* renamed from: d  reason: collision with root package name */
    public int f5275d;

    static {
        g gVar = new g(new boolean[0], 0);
        f5273e = gVar;
        gVar.f5244b = false;
    }

    public g() {
        this.f5274c = new boolean[10];
        this.f5275d = 0;
    }

    public g(boolean[] zArr, int i) {
        this.f5274c = zArr;
        this.f5275d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        if (i < 0 || i > (i2 = this.f5275d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        boolean[] zArr = this.f5274c;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[a.b(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f5274c, i, zArr2, i + 1, this.f5275d - i);
            this.f5274c = zArr2;
        }
        this.f5274c[i] = booleanValue;
        this.f5275d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Boolean> collection) {
        a();
        n0.a(collection);
        if (!(collection instanceof g)) {
            return super.addAll(collection);
        }
        g gVar = (g) collection;
        int i = gVar.f5275d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f5275d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f5274c;
            if (i3 > zArr.length) {
                this.f5274c = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(gVar.f5274c, 0, this.f5274c, this.f5275d, gVar.f5275d);
            this.f5275d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(boolean z) {
        a();
        int i = this.f5275d;
        boolean[] zArr = this.f5274c;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[a.b(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f5274c = zArr2;
        }
        boolean[] zArr3 = this.f5274c;
        int i2 = this.f5275d;
        this.f5275d = i2 + 1;
        zArr3[i2] = z;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f5275d) {
            throw new IndexOutOfBoundsException(g(i));
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
        if (this.f5275d != gVar.f5275d) {
            return false;
        }
        boolean[] zArr = gVar.f5274c;
        for (int i = 0; i < this.f5275d; i++) {
            if (this.f5274c[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        StringBuilder i2 = a.i("Index:", i, ", Size:");
        i2.append(this.f5275d);
        return i2.toString();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Boolean.valueOf(this.f5274c[i]);
    }

    /* renamed from: h */
    public n0.a i(int i) {
        if (i >= this.f5275d) {
            return new g(Arrays.copyOf(this.f5274c, i), this.f5275d);
        }
        throw new IllegalArgumentException();
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f5275d; i2++) {
            i = (i * 31) + n0.c(this.f5274c[i2]);
        }
        return i;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        boolean[] zArr = this.f5274c;
        boolean z = zArr[i];
        int i2 = this.f5275d;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f5275d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f5275d; i++) {
            if (obj.equals(Boolean.valueOf(this.f5274c[i]))) {
                boolean[] zArr = this.f5274c;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f5275d - i) - 1);
                this.f5275d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            boolean[] zArr = this.f5274c;
            System.arraycopy(zArr, i2, zArr, i, this.f5275d - i2);
            this.f5275d -= i2 - i;
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
        boolean[] zArr = this.f5274c;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public int size() {
        return this.f5275d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Boolean bool) {
        c(bool.booleanValue());
        return true;
    }
}
