package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.a0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

public final class c1<E> extends c<E> implements RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final c1<Object> f4900e;

    /* renamed from: c  reason: collision with root package name */
    public E[] f4901c;

    /* renamed from: d  reason: collision with root package name */
    public int f4902d;

    static {
        c1<Object> c1Var = new c1<>(new Object[0], 0);
        f4900e = c1Var;
        c1Var.f4893b = false;
    }

    public c1(E[] eArr, int i) {
        this.f4901c = eArr;
        this.f4902d = i;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e2) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f4902d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        E[] eArr = this.f4901c;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[a.b(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.f4901c, i, eArr2, i + 1, this.f4902d - i);
            this.f4901c = eArr2;
        }
        this.f4901c[i] = e2;
        this.f4902d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection, java.util.AbstractList
    public boolean add(E e2) {
        a();
        int i = this.f4902d;
        E[] eArr = this.f4901c;
        if (i == eArr.length) {
            this.f4901c = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f4901c;
        int i2 = this.f4902d;
        this.f4902d = i2 + 1;
        eArr2[i2] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.f4902d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    public final String e(int i) {
        StringBuilder i2 = a.i("Index:", i, ", Size:");
        i2.append(this.f4902d);
        return i2.toString();
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        c(i);
        return this.f4901c[i];
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c i(int i) {
        if (i >= this.f4902d) {
            return new c1(Arrays.copyOf(this.f4901c, i), this.f4902d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        a();
        c(i);
        E[] eArr = this.f4901c;
        E e2 = eArr[i];
        int i2 = this.f4902d;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.f4902d--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e2) {
        a();
        c(i);
        E[] eArr = this.f4901c;
        E e3 = eArr[i];
        eArr[i] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    public int size() {
        return this.f4902d;
    }
}
