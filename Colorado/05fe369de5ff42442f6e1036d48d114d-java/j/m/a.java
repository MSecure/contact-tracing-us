package j.m;

import j.k.a.b;
import j.k.b.e;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<T> implements b<T> {
    public final b<T> a;
    public final boolean b;
    public final b<T, Boolean> c;

    /* renamed from: j.m.a$a  reason: collision with other inner class name */
    public static final class C0153a implements Iterator<T> {
        public final Iterator<T> b;
        public int c = -1;

        /* renamed from: d  reason: collision with root package name */
        public T f4256d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4257e;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C0153a(a aVar) {
            this.f4257e = aVar;
            this.b = aVar.a.iterator();
        }

        public final void b() {
            int i2;
            while (true) {
                if (!this.b.hasNext()) {
                    i2 = 0;
                    break;
                }
                T next = this.b.next();
                if (this.f4257e.c.d(next).booleanValue() == this.f4257e.b) {
                    this.f4256d = next;
                    i2 = 1;
                    break;
                }
            }
            this.c = i2;
        }

        public boolean hasNext() {
            if (this.c == -1) {
                b();
            }
            return this.c == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.c == -1) {
                b();
            }
            if (this.c != 0) {
                T t = this.f4256d;
                this.f4256d = null;
                this.c = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: j.m.b<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: j.k.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(b<? extends T> bVar, boolean z, b<? super T, Boolean> bVar2) {
        e.c(bVar, "sequence");
        e.c(bVar2, "predicate");
        this.a = bVar;
        this.b = z;
        this.c = bVar2;
    }

    @Override // j.m.b
    public Iterator<T> iterator() {
        return new C0153a(this);
    }
}
