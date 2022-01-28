package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.a0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

public final class c1<E> extends c<E> implements RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final c1<Object> f3531e;

    /* renamed from: c  reason: collision with root package name */
    public E[] f3532c;

    /* renamed from: d  reason: collision with root package name */
    public int f3533d;

    static {
        c1<Object> c1Var = new c1<>(new Object[0], 0);
        f3531e = c1Var;
        c1Var.f3526b = false;
    }

    public c1(E[] eArr, int i) {
        this.f3532c = eArr;
        this.f3533d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e2) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f3533d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        E[] eArr = this.f3532c;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[a.b(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.f3532c, i, eArr2, i + 1, this.f3533d - i);
            this.f3532c = eArr2;
        }
        this.f3532c[i] = e2;
        this.f3533d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection, java.util.AbstractList
    public boolean add(E e2) {
        a();
        int i = this.f3533d;
        E[] eArr = this.f3532c;
        if (i == eArr.length) {
            this.f3532c = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f3532c;
        int i2 = this.f3533d;
        this.f3533d = i2 + 1;
        eArr2[i2] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.f3533d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    public final String e(int i) {
        StringBuilder h = a.h("Index:", i, ", Size:");
        h.append(this.f3533d);
        return h.toString();
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c g(int i) {
        if (i >= this.f3533d) {
            return new c1(Arrays.copyOf(this.f3532c, i), this.f3533d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        c(i);
        return this.f3532c[i];
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        a();
        c(i);
        E[] eArr = this.f3532c;
        E e2 = eArr[i];
        int i2 = this.f3533d;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.f3533d--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e2) {
        a();
        c(i);
        E[] eArr = this.f3532c;
        E e3 = eArr[i];
        eArr[i] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    public int size() {
        return this.f3533d;
    }
}
