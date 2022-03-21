package j.l;

import j.j.a.b;
import j.j.b.e;
import java.util.Iterator;

public final class d<T, R> implements b<R> {
    public final b<T> a;
    public final b<T, R> b;

    public static final class a implements Iterator<R> {
        public final Iterator<T> b;
        public final /* synthetic */ d c;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(d dVar) {
            this.c = dVar;
            this.b = dVar.a.iterator();
        }

        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return this.c.b.d(this.b.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: j.l.b<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: j.j.a.b<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(b<? extends T> bVar, b<? super T, ? extends R> bVar2) {
        e.c(bVar, "sequence");
        e.c(bVar2, "transformer");
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // j.l.b
    public Iterator<R> iterator() {
        return new a(this);
    }
}
