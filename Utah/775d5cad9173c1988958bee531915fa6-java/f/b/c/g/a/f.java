package f.b.c.g.a;

import f.b.c.g.a.d;
import f.b.c.g.a.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f<T> implements Iterable<T> {
    public final d<T, Void> b;

    public static class a<T> implements Iterator<T> {
        public final Iterator<Map.Entry<T, Void>> b;

        public a(Iterator<Map.Entry<T, Void>> it) {
            this.b = it;
        }

        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.b.next().getKey();
        }

        public void remove() {
            this.b.remove();
        }
    }

    public f(d<T, Void> dVar) {
        this.b = dVar;
    }

    public f(List<T> list, Comparator<T> comparator) {
        d<T, Void> dVar;
        Map emptyMap = Collections.emptyMap();
        int i2 = d.a.a;
        c cVar = c.a;
        if (list.size() < 25) {
            Collections.sort(list, comparator);
            int size = list.size();
            Object[] objArr = new Object[size];
            Object[] objArr2 = new Object[size];
            int i3 = 0;
            for (T t : list) {
                objArr[i3] = t;
                objArr2[i3] = emptyMap.get(t);
                i3++;
            }
            dVar = new b<>(comparator, objArr, objArr2);
        } else {
            dVar = l.b.b(list, emptyMap, cVar, comparator);
        }
        this.b = dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return this.b.equals(((f) obj).b);
    }

    public f<T> h(T t) {
        return new f<>(this.b.l(t, null));
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public f<T> i(T t) {
        d<T, Void> n = this.b.n(t);
        return n == this.b ? this : new f<>(n);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.b.iterator());
    }

    public int size() {
        return this.b.size();
    }
}
