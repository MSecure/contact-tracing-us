package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.a0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class z extends c<Integer> implements Object, RandomAccess, z0 {

    /* renamed from: e  reason: collision with root package name */
    public static final z f3683e;

    /* renamed from: c  reason: collision with root package name */
    public int[] f3684c;

    /* renamed from: d  reason: collision with root package name */
    public int f3685d;

    static {
        z zVar = new z(new int[0], 0);
        f3683e = zVar;
        zVar.f3526b = false;
    }

    public z() {
        this.f3684c = new int[10];
        this.f3685d = 0;
    }

    public z(int[] iArr, int i) {
        this.f3684c = iArr;
        this.f3685d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.f3685d)) {
            throw new IndexOutOfBoundsException(j(i));
        }
        int[] iArr = this.f3684c;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f3684c, i, iArr2, i + 1, this.f3685d - i);
            this.f3684c = iArr2;
        }
        this.f3684c[i] = intValue;
        this.f3685d++;
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
        int i = zVar.f3685d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3685d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f3684c;
            if (i3 > iArr.length) {
                this.f3684c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zVar.f3684c, 0, this.f3684c, this.f3685d, zVar.f3685d);
            this.f3685d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(int i) {
        a();
        int i2 = this.f3685d;
        int[] iArr = this.f3684c;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f3684c = iArr2;
        }
        int[] iArr3 = this.f3684c;
        int i3 = this.f3685d;
        this.f3685d = i3 + 1;
        iArr3[i3] = i;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3685d) {
            throw new IndexOutOfBoundsException(j(i));
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
        if (this.f3685d != zVar.f3685d) {
            return false;
        }
        int[] iArr = zVar.f3684c;
        for (int i = 0; i < this.f3685d; i++) {
            if (this.f3684c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c g(int i) {
        if (i >= this.f3685d) {
            return new z(Arrays.copyOf(this.f3684c, i), this.f3685d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Integer.valueOf(this.f3684c[i]);
    }

    public int h(int i) {
        e(i);
        return this.f3684c[i];
    }

    @Override // c.b.c.a.j0.a.c
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3685d; i2++) {
            i = (i * 31) + this.f3684c[i2];
        }
        return i;
    }

    public final String j(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f3685d);
        return h.toString();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        int[] iArr = this.f3684c;
        int i2 = iArr[i];
        int i3 = this.f3685d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f3685d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.List, c.b.c.a.j0.a.c
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3685d; i++) {
            if (obj.equals(Integer.valueOf(this.f3684c[i]))) {
                int[] iArr = this.f3684c;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f3685d - i) - 1);
                this.f3685d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            int[] iArr = this.f3684c;
            System.arraycopy(iArr, i2, iArr, i, this.f3685d - i2);
            this.f3685d -= i2 - i;
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
        int[] iArr = this.f3684c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public int size() {
        return this.f3685d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection, java.util.AbstractList
    public boolean add(Integer num) {
        c(num.intValue());
        return true;
    }
}
