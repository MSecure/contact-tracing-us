package b.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class g<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public g<K, V>.b f812a;

    /* renamed from: b  reason: collision with root package name */
    public g<K, V>.c f813b;

    /* renamed from: c  reason: collision with root package name */
    public g<K, V>.e f814c;

    public final class a<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public final int f815b;

        /* renamed from: c  reason: collision with root package name */
        public int f816c;

        /* renamed from: d  reason: collision with root package name */
        public int f817d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f818e = false;

        public a(int i) {
            this.f815b = i;
            this.f816c = g.this.d();
        }

        public boolean hasNext() {
            return this.f817d < this.f816c;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) g.this.b(this.f817d, this.f815b);
                this.f817d++;
                this.f818e = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f818e) {
                int i = this.f817d - 1;
                this.f817d = i;
                this.f816c--;
                this.f818e = false;
                g.this.h(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: b.e.g */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d2 = g.this.d();
            Iterator<? extends Map.Entry<K, V>> it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                g.this.g(entry.getKey(), entry.getValue());
            }
            return d2 != g.this.d();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e2 = g.this.e(entry.getKey());
            if (e2 < 0) {
                return false;
            }
            return d.c(g.this.b(e2, 1), entry.getValue());
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return g.j(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int d2 = g.this.d() - 1; d2 >= 0; d2--) {
                Object b2 = g.this.b(d2, 0);
                Object b3 = g.this.b(d2, 1);
                i += (b2 == null ? 0 : b2.hashCode()) ^ (b3 == null ? 0 : b3.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return g.this.d() == 0;
        }

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return g.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object obj) {
            return g.this.e(obj) >= 0;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Map<K, V> c2 = g.this.c();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!c2.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return g.j(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int d2 = g.this.d() - 1; d2 >= 0; d2--) {
                Object b2 = g.this.b(d2, 0);
                i += b2 == null ? 0 : b2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return g.this.d() == 0;
        }

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int e2 = g.this.e(obj);
            if (e2 < 0) {
                return false;
            }
            g.this.h(e2);
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            Map<K, V> c2 = g.this.c();
            int size = c2.size();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                c2.remove(it.next());
            }
            return size != c2.size();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return g.k(g.this.c(), collection);
        }

        public int size() {
            return g.this.d();
        }

        public Object[] toArray() {
            return g.this.l(0);
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) g.this.m(tArr, 0);
        }
    }

    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public int f821b;

        /* renamed from: c  reason: collision with root package name */
        public int f822c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f823d = false;

        public d() {
            this.f821b = g.this.d() - 1;
            this.f822c = -1;
        }

        public boolean equals(Object obj) {
            if (!this.f823d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return d.c(entry.getKey(), g.this.b(this.f822c, 0)) && d.c(entry.getValue(), g.this.b(this.f822c, 1));
            }
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f823d) {
                return (K) g.this.b(this.f822c, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f823d) {
                return (V) g.this.b(this.f822c, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f822c < this.f821b;
        }

        public int hashCode() {
            if (this.f823d) {
                int i = 0;
                Object b2 = g.this.b(this.f822c, 0);
                Object b3 = g.this.b(this.f822c, 1);
                int hashCode = b2 == null ? 0 : b2.hashCode();
                if (b3 != null) {
                    i = b3.hashCode();
                }
                return hashCode ^ i;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                this.f822c++;
                this.f823d = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f823d) {
                g.this.h(this.f822c);
                this.f822c--;
                this.f821b--;
                this.f823d = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f823d) {
                return (V) g.this.i(this.f822c, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object obj) {
            return g.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return g.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int f = g.this.f(obj);
            if (f < 0) {
                return false;
            }
            g.this.h(f);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d2 = g.this.d();
            int i = 0;
            boolean z = false;
            while (i < d2) {
                if (collection.contains(g.this.b(i, 1))) {
                    g.this.h(i);
                    i--;
                    d2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d2 = g.this.d();
            int i = 0;
            boolean z = false;
            while (i < d2) {
                if (!collection.contains(g.this.b(i, 1))) {
                    g.this.h(i);
                    i--;
                    d2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return g.this.d();
        }

        public Object[] toArray() {
            return g.this.l(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) g.this.m(tArr, 1);
        }
    }

    public static <T> boolean j(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean k(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i, int i2);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k, V v);

    public abstract void h(int i);

    public abstract V i(int i, V v);

    public Object[] l(int i) {
        int d2 = d();
        Object[] objArr = new Object[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] m(T[] tArr, int i) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2));
        }
        for (int i2 = 0; i2 < d2; i2++) {
            tArr[i2] = b(i2, i);
        }
        if (tArr.length > d2) {
            tArr[d2] = null;
        }
        return tArr;
    }
}
