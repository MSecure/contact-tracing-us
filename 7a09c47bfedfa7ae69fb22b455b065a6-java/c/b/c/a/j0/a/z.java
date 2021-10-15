package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.a0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class z extends c<Integer> implements Object, RandomAccess, z0 {

    /* renamed from: e  reason: collision with root package name */
    public static final z f5074e;

    /* renamed from: c  reason: collision with root package name */
    public int[] f5075c;

    /* renamed from: d  reason: collision with root package name */
    public int f5076d;

    static {
        z zVar = new z(new int[0], 0);
        f5074e = zVar;
        zVar.f4893b = false;
    }

    public z() {
        this.f5075c = new int[10];
        this.f5076d = 0;
    }

    public z(int[] iArr, int i) {
        this.f5075c = iArr;
        this.f5076d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.f5076d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        int[] iArr = this.f5075c;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f5075c, i, iArr2, i + 1, this.f5076d - i);
            this.f5075c = iArr2;
        }
        this.f5075c[i] = intValue;
        this.f5076d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection
    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        a0.a(collection);
        if (!(collection instanceof z)) {
            return super.addAll(collection);
        }
        z zVar = (z) collection;
        int i = zVar.f5076d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f5076d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f5075c;
            if (i3 > iArr.length) {
                this.f5075c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zVar.f5075c, 0, this.f5075c, this.f5076d, zVar.f5076d);
            this.f5076d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(int i) {
        a();
        int i2 = this.f5076d;
        int[] iArr = this.f5075c;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f5075c = iArr2;
        }
        int[] iArr3 = this.f5075c;
        int i3 = this.f5076d;
        this.f5076d = i3 + 1;
        iArr3[i3] = i;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f5076d) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    @Override // c.b.c.a.j0.a.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return super.equals(obj);
        }
        z zVar = (z) obj;
        if (this.f5076d != zVar.f5076d) {
            return false;
        }
        int[] iArr = zVar.f5075c;
        for (int i = 0; i < this.f5076d; i++) {
            if (this.f5075c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int g(int i) {
        e(i);
        return this.f5075c[i];
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Integer.valueOf(this.f5075c[i]);
    }

    public final String h(int i) {
        StringBuilder i2 = a.i("Index:", i, ", Size:");
        i2.append(this.f5076d);
        return i2.toString();
    }

    @Override // c.b.c.a.j0.a.c
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f5076d; i2++) {
            i = (i * 31) + this.f5075c[i2];
        }
        return i;
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c i(int i) {
        if (i >= this.f5076d) {
            return new z(Arrays.copyOf(this.f5075c, i), this.f5076d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        int[] iArr = this.f5075c;
        int i2 = iArr[i];
        int i3 = this.f5076d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f5076d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.List, c.b.c.a.j0.a.c
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f5076d; i++) {
            if (obj.equals(Integer.valueOf(this.f5075c[i]))) {
                int[] iArr = this.f5075c;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f5076d - i) - 1);
                this.f5076d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            int[] iArr = this.f5075c;
            System.arraycopy(iArr, i2, iArr, i, this.f5076d - i2);
            this.f5076d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        a();
        e(i);
        int[] iArr = this.f5075c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public int size() {
        return this.f5076d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection, java.util.AbstractList
    public boolean add(Integer num) {
        c(num.intValue());
        return true;
    }
}
