package c.b.d;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class t2 extends AbstractList<String> implements s0, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final s0 f4333b;

    public class a implements ListIterator<String> {

        /* renamed from: b  reason: collision with root package name */
        public ListIterator<String> f4334b = t2.this.f4333b.listIterator(this.f4335c);

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4335c;

        public a(int i) {
            this.f4335c = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f4334b.hasNext();
        }

        public boolean hasPrevious() {
            return this.f4334b.hasPrevious();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator, java.util.ListIterator
        public String next() {
            return this.f4334b.next();
        }

        public int nextIndex() {
            return this.f4334b.nextIndex();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.ListIterator
        public String previous() {
            return this.f4334b.previous();
        }

        public int previousIndex() {
            return this.f4334b.previousIndex();
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
        public Iterator<String> f4337b = t2.this.f4333b.iterator();

        public b() {
        }

        public boolean hasNext() {
            return this.f4337b.hasNext();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public String next() {
            return this.f4337b.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public t2(s0 s0Var) {
        this.f4333b = s0Var;
    }

    @Override // c.b.d.s0
    public s0 b() {
        return this;
    }

    @Override // c.b.d.s0
    public Object f(int i) {
        return this.f4333b.f(i);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public String get(int i) {
        return (String) this.f4333b.get(i);
    }

    @Override // c.b.d.s0
    public List<?> i() {
        return this.f4333b.i();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // c.b.d.s0
    public void l(j jVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<String> listIterator(int i) {
        return new a(i);
    }

    public int size() {
        return this.f4333b.size();
    }
}
