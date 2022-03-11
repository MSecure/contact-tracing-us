package f.b.g;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public class u1 extends AbstractList<String> implements i0, RandomAccess {
    public final i0 b;

    /* loaded from: classes.dex */
    public class a implements ListIterator<String> {
        public ListIterator<String> b;
        public final /* synthetic */ int c;

        public a(int i2) {
            this.c = i2;
            this.b = u1.this.b.listIterator(i2);
        }

        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            return this.b.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b.nextIndex();
        }

        @Override // java.util.ListIterator
        public String previous() {
            return this.b.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(String str) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Iterator<String> {
        public Iterator<String> b;

        public b() {
            this.b = u1.this.b.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public String next() {
            return this.b.next();
        }

        @Override // java.util.Iterator
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

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i2) {
        return (String) this.b.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i2) {
        return new a(i2);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.b.size();
    }
}
