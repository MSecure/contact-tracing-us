package j.h;

import java.util.Iterator;

public abstract class e implements Iterator<Integer> {
    public abstract int b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public Integer next() {
        return Integer.valueOf(b());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
