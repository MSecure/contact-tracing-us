package c.b.b.b;

import c.b.a.a.c.n.c;
import c.b.b.b.c;
import java.util.NoSuchElementException;

public abstract class a<E> extends e<E> {

    /* renamed from: b  reason: collision with root package name */
    public final int f3339b;

    /* renamed from: c  reason: collision with root package name */
    public int f3340c;

    public a(int i, int i2) {
        if (i2 < 0 || i2 > i) {
            throw new IndexOutOfBoundsException(c.l(i2, i, "index"));
        }
        this.f3339b = i;
        this.f3340c = i2;
    }

    public final boolean hasNext() {
        return this.f3340c < this.f3339b;
    }

    public final boolean hasPrevious() {
        return this.f3340c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.f3340c;
            this.f3340c = i + 1;
            return ((c.b) this).f3346d.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f3340c;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.f3340c - 1;
            this.f3340c = i;
            return ((c.b) this).f3346d.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f3340c - 1;
    }
}
