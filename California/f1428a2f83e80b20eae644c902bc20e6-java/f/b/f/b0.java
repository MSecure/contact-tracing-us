package f.b.f;

import f.a.a.a.a;
import f.b.f.c0;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

public final class b0 extends c<Integer> implements c0.g, RandomAccess, c1 {

    /* renamed from: e  reason: collision with root package name */
    public static final b0 f3273e;
    public int[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f3274d;

    static {
        b0 b0Var = new b0(new int[0], 0);
        f3273e = b0Var;
        b0Var.b = false;
    }

    public b0() {
        this.c = new int[10];
        this.f3274d = 0;
    }

    public b0(int[] iArr, int i2) {
        this.c = iArr;
        this.f3274d = i2;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        h();
        if (i2 < 0 || i2 > (i3 = this.f3274d)) {
            throw new IndexOutOfBoundsException(l(i2));
        }
        int[] iArr = this.c;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[a.b(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.c, i2, iArr2, i2 + 1, this.f3274d - i2);
            this.c = iArr2;
        }
        this.c[i2] = intValue;
        this.f3274d++;
        ((AbstractList) this).modCount++;
    }

    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Integer> collection) {
        h();
        Charset charset = c0.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof b0)) {
            return super.addAll(collection);
        }
        b0 b0Var = (b0) collection;
        int i2 = b0Var.f3274d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f3274d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.c;
            if (i4 > iArr.length) {
                this.c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(b0Var.c, 0, this.c, this.f3274d, b0Var.f3274d);
            this.f3274d = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // f.b.f.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return super.equals(obj);
        }
        b0 b0Var = (b0) obj;
        if (this.f3274d != b0Var.f3274d) {
            return false;
        }
        int[] iArr = b0Var.c;
        for (int i2 = 0; i2 < this.f3274d; i2++) {
            if (this.c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i2) {
        j(i2);
        return Integer.valueOf(this.c[i2]);
    }

    @Override // f.b.f.c
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f3274d; i3++) {
            i2 = (i2 * 31) + this.c[i3];
        }
        return i2;
    }

    public void i(int i2) {
        h();
        int i3 = this.f3274d;
        int[] iArr = this.c;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[a.b(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.c = iArr2;
        }
        int[] iArr3 = this.c;
        int i4 = this.f3274d;
        this.f3274d = i4 + 1;
        iArr3[i4] = i2;
    }

    public final void j(int i2) {
        if (i2 < 0 || i2 >= this.f3274d) {
            throw new IndexOutOfBoundsException(l(i2));
        }
    }

    public int k(int i2) {
        j(i2);
        return this.c[i2];
    }

    public final String l(int i2) {
        return "Index:" + i2 + ", Size:" + this.f3274d;
    }

    /* renamed from: m */
    public c0.g d(int i2) {
        if (i2 >= this.f3274d) {
            return new b0(Arrays.copyOf(this.c, i2), this.f3274d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i2) {
        h();
        j(i2);
        int[] iArr = this.c;
        int i3 = iArr[i2];
        int i4 = this.f3274d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f3274d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // f.b.f.c, java.util.List
    public boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f3274d; i2++) {
            if (obj.equals(Integer.valueOf(this.c[i2]))) {
                int[] iArr = this.c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f3274d - i2) - 1);
                this.f3274d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i2, int i3) {
        h();
        if (i3 >= i2) {
            int[] iArr = this.c;
            System.arraycopy(iArr, i3, iArr, i2, this.f3274d - i3);
            this.f3274d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        h();
        j(i2);
        int[] iArr = this.c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public int size() {
        return this.f3274d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Integer num) {
        i(num.intValue());
        return true;
    }
}
