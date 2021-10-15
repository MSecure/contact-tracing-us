package c.b.d;

import c.a.a.a.a;
import c.b.d.n0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class m0 extends d<Integer> implements n0.f, RandomAccess, x1 {

    /* renamed from: e  reason: collision with root package name */
    public static final m0 f5433e;

    /* renamed from: c  reason: collision with root package name */
    public int[] f5434c;

    /* renamed from: d  reason: collision with root package name */
    public int f5435d;

    static {
        m0 m0Var = new m0(new int[0], 0);
        f5433e = m0Var;
        m0Var.f5244b = false;
    }

    public m0() {
        this.f5434c = new int[10];
        this.f5435d = 0;
    }

    public m0(int[] iArr, int i) {
        this.f5434c = iArr;
        this.f5435d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.f5435d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        int[] iArr = this.f5434c;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f5434c, i, iArr2, i + 1, this.f5435d - i);
            this.f5434c = iArr2;
        }
        this.f5434c[i] = intValue;
        this.f5435d++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        n0.a(collection);
        if (!(collection instanceof m0)) {
            return super.addAll(collection);
        }
        m0 m0Var = (m0) collection;
        int i = m0Var.f5435d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f5435d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f5434c;
            if (i3 > iArr.length) {
                this.f5434c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(m0Var.f5434c, 0, this.f5434c, this.f5435d, m0Var.f5435d);
            this.f5435d = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void c(int i) {
        a();
        int i2 = this.f5435d;
        int[] iArr = this.f5434c;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[a.b(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f5434c = iArr2;
        }
        int[] iArr3 = this.f5434c;
        int i3 = this.f5435d;
        this.f5435d = i3 + 1;
        iArr3[i3] = i;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f5435d) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    @Override // c.b.d.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return super.equals(obj);
        }
        m0 m0Var = (m0) obj;
        if (this.f5435d != m0Var.f5435d) {
            return false;
        }
        int[] iArr = m0Var.f5434c;
        for (int i = 0; i < this.f5435d; i++) {
            if (this.f5434c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int g(int i) {
        e(i);
        return this.f5434c[i];
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        e(i);
        return Integer.valueOf(this.f5434c[i]);
    }

    public final String h(int i) {
        StringBuilder i2 = a.i("Index:", i, ", Size:");
        i2.append(this.f5435d);
        return i2.toString();
    }

    @Override // c.b.d.d
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f5435d; i2++) {
            i = (i * 31) + this.f5434c[i2];
        }
        return i;
    }

    /* renamed from: j */
    public n0.f i(int i) {
        if (i >= this.f5435d) {
            return new m0(Arrays.copyOf(this.f5434c, i), this.f5435d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        e(i);
        int[] iArr = this.f5434c;
        int i2 = iArr[i];
        int i3 = this.f5435d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f5435d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // c.b.d.d, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f5435d; i++) {
            if (obj.equals(Integer.valueOf(this.f5434c[i]))) {
                int[] iArr = this.f5434c;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f5435d - i) - 1);
                this.f5435d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            int[] iArr = this.f5434c;
            System.arraycopy(iArr, i2, iArr, i, this.f5435d - i2);
            this.f5435d -= i2 - i;
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
        int[] iArr = this.f5434c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public int size() {
        return this.f5435d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Integer num) {
        c(num.intValue());
        return true;
    }
}
