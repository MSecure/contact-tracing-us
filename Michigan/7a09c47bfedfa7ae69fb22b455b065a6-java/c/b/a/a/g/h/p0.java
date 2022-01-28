package c.b.a.a.g.h;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class p0 extends k0<Boolean> implements z1<Boolean>, l3, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public boolean[] f3988c;

    /* renamed from: d  reason: collision with root package name */
    public int f3989d;

    static {
        new p0(new boolean[0], 0).f3921b = false;
    }

    public p0() {
        this.f3988c = new boolean[10];
        this.f3989d = 0;
    }

    public p0(boolean[] zArr, int i) {
        this.f3988c = zArr;
        this.f3989d = i;
    }

    /* Return type fixed from 'c.b.a.a.g.h.z1' to match base method */
    @Override // c.b.a.a.g.h.z1
    public final /* synthetic */ z1<Boolean> B(int i) {
        if (i >= this.f3989d) {
            return new p0(Arrays.copyOf(this.f3988c, i), this.f3989d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        if (i < 0 || i > (i2 = this.f3989d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        boolean[] zArr = this.f3988c;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[a.b(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f3988c, i, zArr2, i + 1, this.f3989d - i);
            this.f3988c = zArr2;
        }
        this.f3988c[i] = booleanValue;
        this.f3989d++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Boolean bool) {
        c(bool.booleanValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection
    public final boolean addAll(Collection<? extends Boolean> collection) {
        a();
        u1.a(collection);
        if (!(collection instanceof p0)) {
            return super.addAll(collection);
        }
        p0 p0Var = (p0) collection;
        int i = p0Var.f3989d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3989d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f3988c;
            if (i3 > zArr.length) {
                this.f3988c = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(p0Var.f3988c, 0, this.f3988c, this.f3989d, p0Var.f3989d);
            this.f3989d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(boolean z) {
        a();
        int i = this.f3989d;
        boolean[] zArr = this.f3988c;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[a.b(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f3988c = zArr2;
        }
        boolean[] zArr3 = this.f3988c;
        int i2 = this.f3989d;
        this.f3989d = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3989d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.a.a.g.h.k0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return super.equals(obj);
        }
        p0 p0Var = (p0) obj;
        if (this.f3989d != p0Var.f3989d) {
            return false;
        }
        boolean[] zArr = p0Var.f3988c;
        for (int i = 0; i < this.f3989d; i++) {
            if (this.f3988c[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3989d);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Boolean.valueOf(this.f3988c[i]);
    }

    @Override // c.b.a.a.g.h.k0
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3989d; i2++) {
            i = (i * 31) + u1.h(this.f3988c[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i = this.f3989d;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f3988c[i2] == booleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        e(i);
        boolean[] zArr = this.f3988c;
        boolean z = zArr[i];
        int i2 = this.f3989d;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f3989d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.List, c.b.a.a.g.h.k0
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3989d; i++) {
            if (obj.equals(Boolean.valueOf(this.f3988c[i]))) {
                boolean[] zArr = this.f3988c;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f3989d - i) - 1);
                this.f3989d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            boolean[] zArr = this.f3988c;
            System.arraycopy(zArr, i2, zArr, i, this.f3989d - i2);
            this.f3989d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        e(i);
        boolean[] zArr = this.f3988c;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.f3989d;
    }
}
