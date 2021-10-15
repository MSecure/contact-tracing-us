package c.b.c.a.j0.a;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class o1 extends AbstractList<String> implements g0, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final g0 f4994b;

    public class a implements ListIterator<String> {

        /* renamed from: b  reason: collision with root package name */
        public ListIterator<String> f4995b = o1.this.f4994b.listIterator(this.f4996c);

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4996c;

        public a(int i) {
            this.f4996c = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f4995b.hasNext();
        }

        public boolean hasPrevious() {
            return this.f4995b.hasPrevious();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator, java.util.ListIterator
        public String next() {
            return this.f4995b.next();
        }

        public int nextIndex() {
            return this.f4995b.nextIndex();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.ListIterator
        public String previous() {
            return this.f4995b.previous();
        }

        public int previousIndex() {
            return this.f4995b.previousIndex();
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
        public Iterator<String> f4998b = o1.this.f4994b.iterator();

        public b() {
        }

        public boolean hasNext() {
            return this.f4998b.hasNext();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public String next() {
            return this.f4998b.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public o1(g0 g0Var) {
        this.f4994b = g0Var;
    }

    @Override // c.b.c.a.j0.a.g0
    public void L(i iVar) {
        throw new UnsupportedOperationException();
    }

    @Override // c.b.c.a.j0.a.g0
    public Object b(int i) {
        return this.f4994b.b(i);
    }

    @Override // c.b.c.a.j0.a.g0
    public g0 d() {
        return this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public String get(int i) {
        return (String) this.f4994b.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // c.b.c.a.j0.a.g0
    public List<?> k() {
        return this.f4994b.k();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<String> listIterator(int i) {
        return new a(i);
    }

    public int size() {
        return this.f4994b.size();
    }
}
