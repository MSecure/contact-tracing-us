package j.k.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<T> implements Iterator<T> {
    public int b;
    public final T[] c;

    public a(T[] tArr) {
        e.c(tArr, "array");
        this.c = tArr;
    }

    public boolean hasNext() {
        return this.b < this.c.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.c;
            int i2 = this.b;
            this.b = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
