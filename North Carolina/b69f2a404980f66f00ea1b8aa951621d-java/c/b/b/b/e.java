package c.b.b.b;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX WARN: Incorrect class signature, class is equals to this class: <E:Ljava/lang/Object;>Lc/b/b/b/e<TE;>;Ljava/util/ListIterator<TE;>; */
public abstract class e<E> implements ListIterator<E>, Iterator {
    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e2) {
        throw new UnsupportedOperationException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e2) {
        throw new UnsupportedOperationException();
    }
}
