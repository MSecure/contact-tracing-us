package f.b.b.b;

import java.util.NoSuchElementException;

public final class f extends k<T> {
    public boolean b;
    public final /* synthetic */ Object c;

    public f(Object obj) {
        this.c = obj;
    }

    public boolean hasNext() {
        return !this.b;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!this.b) {
            this.b = true;
            return (T) this.c;
        }
        throw new NoSuchElementException();
    }
}
