package j.i;

import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class e implements Iterator<Integer> {
    public abstract int b();

    @Override // java.util.Iterator
    public Integer next() {
        return Integer.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
