package c.b.d;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class u2 extends AbstractList<String> implements t0, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final t0 f5883b;

    public class a implements ListIterator<String> {

        /* renamed from: b  reason: collision with root package name */
        public ListIterator<String> f5884b = u2.this.f5883b.listIterator(this.f5885c);

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f5885c;

        public a(int i) {
            this.f5885c = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f5884b.hasNext();
        }

        public boolean hasPrevious() {
            return this.f5884b.hasPrevious();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator, java.util.ListIterator
        public String next() {
            return this.f5884b.next();
        }

        public int nextIndex() {
            return this.f5884b.nextIndex();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.ListIterator
        public String previous() {
            return this.f5884b.previous();
        }

        public int previousIndex() {
            return this.f5884b.previousIndex();
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
        public Iterator<String> f5887b = u2.this.f5883b.iterator();

        public b() {
        }

        public boolean hasNext() {
            return this.f5887b.hasNext();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public String next() {
            return this.f5887b.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public u2(t0 t0Var) {
        this.f5883b = t0Var;
    }

    @Override // c.b.d.t0
    public void D(j jVar) {
        throw new UnsupportedOperationException();
    }

    @Override // c.b.d.t0
    public Object b(int i) {
        return this.f5883b.b(i);
    }

    @Override // c.b.d.t0
    public t0 d() {
        return this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public String get(int i) {
        return (String) this.f5883b.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // c.b.d.t0
    public List<?> k() {
        return this.f5883b.k();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<String> listIterator(int i) {
        return new a(i);
    }

    public int size() {
        return this.f5883b.size();
    }
}
