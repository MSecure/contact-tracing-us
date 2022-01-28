package c.b.a.a.e.c;

import c.b.a.a.c.n.c;
import java.util.NoSuchElementException;

/* JADX WARN: Incorrect class signature, class is equals to this class: <E:Ljava/lang/Object;>Lc/b/a/a/e/c/pa<TE;>; */
public final class pa<E> extends wa {

    /* renamed from: b  reason: collision with root package name */
    public final int f2694b;

    /* renamed from: c  reason: collision with root package name */
    public int f2695c;

    /* renamed from: d  reason: collision with root package name */
    public final na<E> f2696d;

    public pa(na<E> naVar, int i) {
        int size = naVar.size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(c.J2(i, size, "index"));
        }
        this.f2694b = size;
        this.f2695c = i;
        this.f2696d = naVar;
    }

    public final boolean hasNext() {
        return this.f2695c < this.f2694b;
    }

    public final boolean hasPrevious() {
        return this.f2695c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (this.f2695c < this.f2694b) {
            int i = this.f2695c;
            this.f2695c = i + 1;
            return this.f2696d.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f2695c;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (this.f2695c > 0) {
            int i = this.f2695c - 1;
            this.f2695c = i;
            return this.f2696d.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f2695c - 1;
    }
}
