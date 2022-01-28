package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.a0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class f extends c<Boolean> implements Object, RandomAccess, z0 {

    /* renamed from: e  reason: collision with root package name */
    public static final f f4918e;

    /* renamed from: c  reason: collision with root package name */
    public boolean[] f4919c;

    /* renamed from: d  reason: collision with root package name */
    public int f4920d;

    static {
        f fVar = new f(new boolean[0], 0);
        f4918e = fVar;
        fVar.f4893b = false;
    }

    public f() {
        this.f4919c = new boolean[10];
        this.f4920d = 0;
    }

    public f(boolean[] zArr, int i) {
        this.f4919c = zArr;
        this.f4920d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        if (i < 0 || i > (i2 = this.f4920d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        boolean[] zArr = this.f4919c;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[a.b(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f4919c, i, zArr2, i + 1, this.f4920d - i);
            this.f4919c = zArr2;
        }
        this.f4919c[i] = booleanValue;
        this.f4920d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection
    public boolean addAll(Collection<? extends Boolean> collection) {
        a();
        a0.a(collection);
        if (!(collection instanceof f)) {
            return super.addAll(collection);
        }
        f fVar = (f) collection;
        int i = fVar.f4920d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f4920d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f4919c;
            if (i3 > zArr.length) {
                this.f4919c = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(fVar.f4919c, 0, this.f4919c, this.f4920d, fVar.f4920d);
            this.f4920d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(boolean z) {
        a();
        int i = this.f4920d;
        boolean[] zArr = this.f4919c;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[a.b(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f4919c = zArr2;
        }
        boolean[] zArr3 = this.f4919c;
        int i2 = this.f4920d;
        this.f4920d = i2 + 1;
        zArr3[i2] = z;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f4920d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.c.a.j0.a.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return super.equals(obj);
        }
        f fVar = (f) obj;
        if (this.f4920d != fVar.f4920d) {
            return false;
        }
        boolean[] zArr = fVar.f4919c;
        for (int i = 0; i < this.f4920d; i++) {
            if (this.f4919c[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        StringBuilder i2 = a.i("Index:", i, ", Size:");
        i2.append(this.f4920d);
        return i2.toString();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Boolean.valueOf(this.f4919c[i]);
    }

    @Override // c.b.c.a.j0.a.c
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f4920d; i2++) {
            i = (i * 31) + a0.c(this.f4919c[i2]);
        }
        return i;
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c i(int i) {
        if (i >= this.f4920d) {
            return new f(Arrays.copyOf(this.f4919c, i), this.f4920d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        boolean[] zArr = this.f4919c;
        boolean z = zArr[i];
        int i2 = this.f4920d;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f4920d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.List, c.b.c.a.j0.a.c
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f4920d; i++) {
            if (obj.equals(Boolean.valueOf(this.f4919c[i]))) {
                boolean[] zArr = this.f4919c;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f4920d - i) - 1);
                this.f4920d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            boolean[] zArr = this.f4919c;
            System.arraycopy(zArr, i2, zArr, i, this.f4920d - i2);
            this.f4920d -= i2 - i;
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
        boolean[] zArr = this.f4919c;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public int size() {
        return this.f4920d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection, java.util.AbstractList
    public boolean add(Boolean bool) {
        c(bool.booleanValue());
        return true;
    }
}
