package c.b.b.b;

import b.x.t;
import c.b.b.b.c;
import java.util.NoSuchElementException;

public abstract class a<E> extends e<E> {

    /* renamed from: b  reason: collision with root package name */
    public final int f4678b;

    /* renamed from: c  reason: collision with root package name */
    public int f4679c;

    public a(int i, int i2) {
        if (i2 < 0 || i2 > i) {
            throw new IndexOutOfBoundsException(t.l(i2, i, "index"));
        }
        this.f4678b = i;
        this.f4679c = i2;
    }

    public final boolean hasNext() {
        return this.f4679c < this.f4678b;
    }

    public final boolean hasPrevious() {
        return this.f4679c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.f4679c;
            this.f4679c = i + 1;
            return ((c.b) this).f4685d.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f4679c;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.f4679c - 1;
            this.f4679c = i;
            return ((c.b) this).f4685d.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f4679c - 1;
    }
}
