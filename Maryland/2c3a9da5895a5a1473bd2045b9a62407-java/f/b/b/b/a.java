package f.b.b.b;

import f.b.a.c.b.o.b;
import f.b.b.b.c;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX WARN: Incorrect class signature, class is equals to this class: <E:Ljava/lang/Object;>Lf/b/b/b/a<TE;>; */
public abstract class a<E> extends k implements ListIterator {
    public final int b;
    public int c;

    public a(int i2, int i3) {
        b.D(i3, i2);
        this.b = i2;
        this.c = i3;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.c < this.b;
    }

    public final boolean hasPrevious() {
        return this.c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i2 = this.c;
            this.c = i2 + 1;
            return ((c.b) this).f2972d.get(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.c;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.c - 1;
            this.c = i2;
            return ((c.b) this).f2972d.get(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.c - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
