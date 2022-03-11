package j.m;

import j.k.a.b;
import j.k.b.e;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class d<T, R> implements b<R> {
    public final b<T> a;
    public final b<T, R> b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<R> {
        public final Iterator<T> b;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            this.b = d.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return d.this.b.d(this.b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(b<? extends T> bVar, b<? super T, ? extends R> bVar2) {
        e.c(bVar, "sequence");
        e.c(bVar2, "transformer");
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // j.m.b
    public Iterator<R> iterator() {
        return new a();
    }
}
