package j.m;

import java.util.Iterator;

public final class c implements Iterable<T> {
    public final /* synthetic */ b b;

    public c(b bVar) {
        this.b = bVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.b.iterator();
    }
}
