package f.b.g;

import f.a.a.a.a;
import f.b.g.c0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

public final class f1<E> extends c<E> implements RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final f1<Object> f3544e;
    public E[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f3545d;

    static {
        f1<Object> f1Var = new f1<>(new Object[0], 0);
        f3544e = f1Var;
        f1Var.b = false;
    }

    public f1(E[] eArr, int i2) {
        this.c = eArr;
        this.f3545d = i2;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i2, E e2) {
        int i3;
        h();
        if (i2 < 0 || i2 > (i3 = this.f3545d)) {
            throw new IndexOutOfBoundsException(j(i2));
        }
        E[] eArr = this.c;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] eArr2 = (E[]) new Object[a.b(i3, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i2);
            System.arraycopy(this.c, i2, eArr2, i2 + 1, this.f3545d - i2);
            this.c = eArr2;
        }
        this.c[i2] = e2;
        this.f3545d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, f.b.g.c
    public boolean add(E e2) {
        h();
        int i2 = this.f3545d;
        E[] eArr = this.c;
        if (i2 == eArr.length) {
            this.c = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.c;
        int i3 = this.f3545d;
        this.f3545d = i3 + 1;
        eArr2[i3] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // f.b.g.c0.i
    public c0.i d(int i2) {
        if (i2 >= this.f3545d) {
            return new f1(Arrays.copyOf(this.c, i2), this.f3545d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i2) {
        i(i2);
        return this.c[i2];
    }

    public final void i(int i2) {
        if (i2 < 0 || i2 >= this.f3545d) {
            throw new IndexOutOfBoundsException(j(i2));
        }
    }

    public final String j(int i2) {
        return "Index:" + i2 + ", Size:" + this.f3545d;
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i2) {
        h();
        i(i2);
        E[] eArr = this.c;
        E e2 = eArr[i2];
        int i3 = this.f3545d;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f3545d--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i2, E e2) {
        h();
        i(i2);
        E[] eArr = this.c;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    public int size() {
        return this.f3545d;
    }
}
