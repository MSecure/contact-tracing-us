package c.b.a.a.g.h;

import c.a.a.a.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

public final class m3<E> extends k0<E> implements RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final m3<Object> f3947e;

    /* renamed from: c  reason: collision with root package name */
    public E[] f3948c;

    /* renamed from: d  reason: collision with root package name */
    public int f3949d;

    static {
        m3<Object> m3Var = new m3<>(new Object[0], 0);
        f3947e = m3Var;
        m3Var.f3921b = false;
    }

    public m3(E[] eArr, int i) {
        this.f3948c = eArr;
        this.f3949d = i;
    }

    @Override // c.b.a.a.g.h.z1
    public final /* synthetic */ z1 B(int i) {
        if (i >= this.f3949d) {
            return new m3(Arrays.copyOf(this.f3948c, i), this.f3949d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final void add(int i, E e2) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f3949d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        E[] eArr = this.f3948c;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[a.b(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.f3948c, i, eArr2, i + 1, this.f3949d - i);
            this.f3948c = eArr2;
        }
        this.f3948c[i] = e2;
        this.f3949d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection, java.util.AbstractList
    public final boolean add(E e2) {
        a();
        int i = this.f3949d;
        E[] eArr = this.f3948c;
        if (i == eArr.length) {
            this.f3948c = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f3948c;
        int i2 = this.f3949d;
        this.f3949d = i2 + 1;
        eArr2[i2] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.f3949d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    public final String e(int i) {
        return a.k(35, "Index:", i, ", Size:", this.f3949d);
    }

    @Override // java.util.List, java.util.AbstractList
    public final E get(int i) {
        c(i);
        return this.f3948c[i];
    }

    @Override // java.util.List, java.util.AbstractList
    public final E remove(int i) {
        a();
        c(i);
        E[] eArr = this.f3948c;
        E e2 = eArr[i];
        int i2 = this.f3949d;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.f3949d--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E set(int i, E e2) {
        a();
        c(i);
        E[] eArr = this.f3948c;
        E e3 = eArr[i];
        eArr[i] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    public final int size() {
        return this.f3949d;
    }
}
