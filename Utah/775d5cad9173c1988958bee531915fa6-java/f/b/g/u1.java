package f.b.g;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class u1 extends AbstractList<String> implements i0, RandomAccess {
    public final i0 b;

    public class a implements ListIterator<String> {
        public ListIterator<String> b;
        public final /* synthetic */ int c;

        public a(int i2) {
            this.c = i2;
            this.b = u1.this.b.listIterator(i2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.b.hasNext();
        }

        public boolean hasPrevious() {
            return this.b.hasPrevious();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator, java.util.ListIterator
        public String next() {
            return this.b.next();
        }

        public int nextIndex() {
            return this.b.nextIndex();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.ListIterator
        public String previous() {
            return this.b.previous();
        }

        public int previousIndex() {
            return this.b.previousIndex();
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
        public Iterator<String> b;

        public b() {
            this.b = u1.this.b.iterator();
        }

        public boolean hasNext() {
            return this.b.hasNext();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public String next() {
            return this.b.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public u1(i0 i0Var) {
        this.b = i0Var;
    }

    @Override // f.b.g.i0
    public i0 a() {
        return this;
    }

    @Override // f.b.g.i0
    public Object c(int i2) {
        return this.b.c(i2);
    }

    @Override // f.b.g.i0
    public void e(j jVar) {
        throw new UnsupportedOperationException();
    }

    @Override // f.b.g.i0
    public List<?> f() {
        return this.b.f();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public String get(int i2) {
        return (String) this.b.get(i2);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<String> listIterator(int i2) {
        return new a(i2);
    }

    public int size() {
        return this.b.size();
    }
}
