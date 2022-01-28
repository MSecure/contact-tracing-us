package c.b.a.a.g.h;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class v1 extends k0<Integer> implements z1<Integer>, l3, RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final v1 f4048e;

    /* renamed from: c  reason: collision with root package name */
    public int[] f4049c;

    /* renamed from: d  reason: collision with root package name */
    public int f4050d;

    static {
        v1 v1Var = new v1(new int[0], 0);
        f4048e = v1Var;
        v1Var.f3921b = false;
    }

    public v1() {
        this.f4049c = new int[10];
        this.f4050d = 0;
    }

    public v1(int[] iArr, int i) {
        this.f4049c = iArr;
        this.f4050d = i;
    }

    /* Return type fixed from 'c.b.a.a.g.h.z1' to match base method */
    @Override // c.b.a.a.g.h.z1
    public final /* synthetic */ z1<Integer> B(int i) {
        if (i >= this.f4050d) {
            return new v1(Arrays.copyOf(this.f4049c, i), this.f4050d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.f4050d)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        int[] iArr = this.f4049c;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f4049c, i, iArr2, i + 1, this.f4050d - i);
            this.f4049c = iArr2;
        }
        this.f4049c[i] = intValue;
        this.f4050d++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Integer num) {
        h(num.intValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection
    public final boolean addAll(Collection<? extends Integer> collection) {
        a();
        u1.a(collection);
        if (!(collection instanceof v1)) {
            return super.addAll(collection);
        }
        v1 v1Var = (v1) collection;
        int i = v1Var.f4050d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f4050d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f4049c;
            if (i3 > iArr.length) {
                this.f4049c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(v1Var.f4049c, 0, this.f4049c, this.f4050d, v1Var.f4050d);
            this.f4050d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final int c(int i) {
        e(i);
        return this.f4049c[i];
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f4050d) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // c.b.a.a.g.h.k0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return super.equals(obj);
        }
        v1 v1Var = (v1) obj;
        if (this.f4050d != v1Var.f4050d) {
            return false;
        }
        int[] iArr = v1Var.f4049c;
        for (int i = 0; i < this.f4050d; i++) {
            if (this.f4049c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final String g(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f4050d);
    }

    @Override // java.util.List, java.util.AbstractList
    public final Object get(int i) {
        e(i);
        return Integer.valueOf(this.f4049c[i]);
    }

    public final void h(int i) {
        a();
        int i2 = this.f4050d;
        int[] iArr = this.f4049c;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f4049c = iArr2;
        }
        int[] iArr3 = this.f4049c;
        int i3 = this.f4050d;
        this.f4050d = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // c.b.a.a.g.h.k0
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f4050d; i2++) {
            i = (i * 31) + this.f4049c[i2];
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i = this.f4050d;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f4049c[i2] == intValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        e(i);
        int[] iArr = this.f4049c;
        int i2 = iArr[i];
        int i3 = this.f4050d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f4050d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.List, c.b.a.a.g.h.k0
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f4050d; i++) {
            if (obj.equals(Integer.valueOf(this.f4049c[i]))) {
                int[] iArr = this.f4049c;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f4050d - i) - 1);
                this.f4050d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            int[] iArr = this.f4049c;
            System.arraycopy(iArr, i2, iArr, i, this.f4050d - i2);
            this.f4050d -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        a();
        e(i);
        int[] iArr = this.f4049c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.f4050d;
    }
}
