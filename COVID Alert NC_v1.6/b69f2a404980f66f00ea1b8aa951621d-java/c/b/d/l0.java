package c.b.d;

import c.a.a.a.a;
import c.b.d.m0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class l0 extends d<Integer> implements m0.f, RandomAccess, w1 {

    /* renamed from: e  reason: collision with root package name */
    public static final l0 f3987e;

    /* renamed from: c  reason: collision with root package name */
    public int[] f3988c;

    /* renamed from: d  reason: collision with root package name */
    public int f3989d;

    static {
        l0 l0Var = new l0(new int[0], 0);
        f3987e = l0Var;
        l0Var.f3839b = false;
    }

    public l0() {
        this.f3988c = new int[10];
        this.f3989d = 0;
    }

    public l0(int[] iArr, int i) {
        this.f3988c = iArr;
        this.f3989d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.f3989d)) {
            throw new IndexOutOfBoundsException(j(i));
        }
        int[] iArr = this.f3988c;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f3988c, i, iArr2, i + 1, this.f3989d - i);
            this.f3988c = iArr2;
        }
        this.f3988c[i] = intValue;
        this.f3989d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        m0.a(collection);
        if (!(collection instanceof l0)) {
            return super.addAll(collection);
        }
        l0 l0Var = (l0) collection;
        int i = l0Var.f3989d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3989d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f3988c;
            if (i3 > iArr.length) {
                this.f3988c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(l0Var.f3988c, 0, this.f3988c, this.f3989d, l0Var.f3989d);
            this.f3989d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(int i) {
        a();
        int i2 = this.f3989d;
        int[] iArr = this.f3988c;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f3988c = iArr2;
        }
        int[] iArr3 = this.f3988c;
        int i3 = this.f3989d;
        this.f3989d = i3 + 1;
        iArr3[i3] = i;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f3989d) {
            throw new IndexOutOfBoundsException(j(i));
        }
    }

    @Override // c.b.d.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return super.equals(obj);
        }
        l0 l0Var = (l0) obj;
        if (this.f3989d != l0Var.f3989d) {
            return false;
        }
        int[] iArr = l0Var.f3988c;
        for (int i = 0; i < this.f3989d; i++) {
            if (this.f3988c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Integer.valueOf(this.f3988c[i]);
    }

    public int h(int i) {
        e(i);
        return this.f3988c[i];
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3989d; i2++) {
            i = (i * 31) + this.f3988c[i2];
        }
        return i;
    }

    public final String j(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f3989d);
        return h.toString();
    }

    /* renamed from: m */
    public m0.f g(int i) {
        if (i >= this.f3989d) {
            return new l0(Arrays.copyOf(this.f3988c, i), this.f3989d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        int[] iArr = this.f3988c;
        int i2 = iArr[i];
        int i3 = this.f3989d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f3989d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f3989d; i++) {
            if (obj.equals(Integer.valueOf(this.f3988c[i]))) {
                int[] iArr = this.f3988c;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f3989d - i) - 1);
                this.f3989d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            int[] iArr = this.f3988c;
            System.arraycopy(iArr, i2, iArr, i, this.f3989d - i2);
            this.f3989d -= i2 - i;
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
        int[] iArr = this.f3988c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public int size() {
        return this.f3989d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Integer num) {
        c(num.intValue());
        return true;
    }
}
