package f.b.a.c.e.c;

import java.util.NoSuchElementException;

public final class c3 extends g3 {
    public boolean b;
    public final /* synthetic */ Object c;

    public c3(Object obj) {
        this.c = obj;
    }

    public final boolean hasNext() {
        return !this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.b) {
            this.b = true;
            return this.c;
        }
        throw new NoSuchElementException();
    }
}
