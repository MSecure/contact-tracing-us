package c.b.c.a.j0.a;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class o1 extends AbstractList<String> implements g0, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final g0 f3617b;

    public class a implements ListIterator<String> {

        /* renamed from: b  reason: collision with root package name */
        public ListIterator<String> f3618b = o1.this.f3617b.listIterator(this.f3619c);

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3619c;

        public a(int i) {
            this.f3619c = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f3618b.hasNext();
        }

        public boolean hasPrevious() {
            return this.f3618b.hasPrevious();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator, java.util.ListIterator
        public String next() {
            return this.f3618b.next();
        }

        public int nextIndex() {
            return this.f3618b.nextIndex();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.ListIterator
        public String previous() {
            return this.f3618b.previous();
        }

        public int previousIndex() {
            return this.f3618b.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.ListIterator
        public void set(String str) {
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator<String> {

        /* renamed from: b  reason: collision with root package name */
        public Iterator<String> f3621b = o1.this.f3617b.iterator();

        public b() {
        }

        public boolean hasNext() {
            return this.f3621b.hasNext();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public String next() {
            return this.f3621b.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public o1(g0 g0Var) {
        this.f3617b = g0Var;
    }

    @Override // c.b.c.a.j0.a.g0
    public g0 b() {
        return this;
    }

    @Override // c.b.c.a.j0.a.g0
    public Object f(int i) {
        return this.f3617b.f(i);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public String get(int i) {
        return (String) this.f3617b.get(i);
    }

    @Override // c.b.c.a.j0.a.g0
    public List<?> i() {
        return this.f3617b.i();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<String> listIterator(int i) {
        return new a(i);
    }

    @Override // c.b.c.a.j0.a.g0
    public void n(i iVar) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f3617b.size();
    }
}
