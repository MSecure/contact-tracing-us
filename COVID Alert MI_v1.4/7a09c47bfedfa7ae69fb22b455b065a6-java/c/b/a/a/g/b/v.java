package c.b.a.a.g.b;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class v extends s<Boolean> implements e1<Boolean>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public boolean[] f3438c;

    /* renamed from: d  reason: collision with root package name */
    public int f3439d;

    static {
        new v().f3405b = false;
    }

    public v() {
        this.f3438c = new boolean[10];
        this.f3439d = 0;
    }

    public v(boolean[] zArr, int i) {
        this.f3438c = zArr;
        this.f3439d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        c(i, ((Boolean) obj).booleanValue());
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.a.a.g.b.s
    public final boolean addAll(Collection<? extends Boolean> collection) {
        a();
        b1.a(collection);
        if (!(collection instanceof v)) {
            return super.addAll(collection);
        }
        v vVar = (v) collection;
        int i = vVar.f3439d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3439d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f3438c;
            if (i3 > zArr.length) {
                this.f3438c = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(vVar.f3438c, 0, this.f3438c, this.f3439d, vVar.f3439d);
            this.f3439d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(int i, boolean z) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f3439d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        boolean[] zArr = this.f3438c;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[a.b(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f3438c, i, zArr2, i + 1, this.f3439d - i);
            this.f3438c = zArr2;
        }
        this.f3438c[i] = z;
        this.f3439d++;
        ((AbstractList) this).modCount++;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3439d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.a.a.g.b.s
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return super.equals(obj);
        }
        v vVar = (v) obj;
        if (this.f3439d != vVar.f3439d) {
            return false;
        }
        boolean[] zArr = vVar.f3438c;
        for (int i = 0; i < this.f3439d; i++) {
            if (this.f3438c[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3439d);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Boolean.valueOf(this.f3438c[i]);
    }

    @Override // c.b.a.a.g.b.s
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3439d; i2++) {
            i = (i * 31) + b1.f(this.f3438c[i2]);
        }
        return i;
    }

    /* Return type fixed from 'c.b.a.a.g.b.e1' to match base method */
    @Override // c.b.a.a.g.b.e1
    public final /* synthetic */ e1<Boolean> r(int i) {
        if (i >= this.f3439d) {
            return new v(Arrays.copyOf(this.f3438c, i), this.f3439d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        e(i);
        boolean[] zArr = this.f3438c;
        boolean z = zArr[i];
        int i2 = this.f3439d;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, i2 - i);
        }
        this.f3439d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.List, c.b.a.a.g.b.s
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3439d; i++) {
            if (obj.equals(Boolean.valueOf(this.f3438c[i]))) {
                boolean[] zArr = this.f3438c;
                System.arraycopy(zArr, i + 1, zArr, i, this.f3439d - i);
                this.f3439d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            boolean[] zArr = this.f3438c;
            System.arraycopy(zArr, i2, zArr, i, this.f3439d - i2);
            this.f3439d -= i2 - i;
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
        boolean[] zArr = this.f3438c;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.f3439d;
    }
}
