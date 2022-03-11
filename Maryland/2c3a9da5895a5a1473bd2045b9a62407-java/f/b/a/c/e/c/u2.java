package f.b.a.c.e.c;

import java.util.NoSuchElementException;

public final class u2 extends y2 {
    public boolean b;
    public final /* synthetic */ Object c;

    public u2(Object obj) {
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
