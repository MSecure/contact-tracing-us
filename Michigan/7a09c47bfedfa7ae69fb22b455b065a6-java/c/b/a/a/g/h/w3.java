package c.b.a.a.g.h;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class w3 implements Iterator<Object> {
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
