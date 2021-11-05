package c.b.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class z0<K, V> implements q1 {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f5946a = true;

    /* renamed from: b  reason: collision with root package name */
    public volatile d f5947b;

    /* renamed from: c  reason: collision with root package name */
    public c<K, V> f5948c;

    /* renamed from: d  reason: collision with root package name */
    public List<f1> f5949d;

    /* renamed from: e  reason: collision with root package name */
    public final a<K, V> f5950e;

    public interface a<K, V> {
    }

    public static class b<K, V> implements a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final x0<K, V> f5951a;

        public b(x0<K, V> x0Var) {
            this.f5951a = x0Var;
        }
    }

    public static class c<K, V> implements Map<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final q1 f5952b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<K, V> f5953c;

        public static class a<E> implements Collection<E> {

            /* renamed from: b  reason: collision with root package name */
            public final q1 f5954b;

            /* renamed from: c  reason: collision with root package name */
            public final Collection<E> f5955c;

            public a(q1 q1Var, Collection<E> collection) {
                this.f5954b = q1Var;
                this.f5955c = collection;
            }

            @Override // java.util.Collection
            public boolean add(E e2) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public void clear() {
                this.f5954b.a();
                this.f5955c.clear();
            }

            public boolean contains(Object obj) {
                return this.f5955c.contains(obj);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.f5955c.containsAll(collection);
            }

            public boolean equals(Object obj) {
                return this.f5955c.equals(obj);
            }

            public int hashCode() {
                return this.f5955c.hashCode();
            }

            public boolean isEmpty() {
                return this.f5955c.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f5954b, this.f5955c.iterator());
            }

            public boolean remove(Object obj) {
                this.f5954b.a();
                return this.f5955c.remove(obj);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.f5954b.a();
                return this.f5955c.removeAll(collection);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.f5954b.a();
                return this.f5955c.retainAll(collection);
            }

            public int size() {
                return this.f5955c.size();
            }

            public Object[] toArray() {
                return this.f5955c.toArray();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.f5955c.toArray(tArr);
            }

            public String toString() {
                return this.f5955c.toString();
            }
        }

        public static class b<E> implements Iterator<E> {

            /* renamed from: b  reason: collision with root package name */
            public final q1 f5956b;

            /* renamed from: c  reason: collision with root package name */
            public final Iterator<E> f5957c;

            public b(q1 q1Var, Iterator<E> it) {
                this.f5956b = q1Var;
                this.f5957c = it;
            }

            public boolean equals(Object obj) {
                return this.f5957c.equals(obj);
            }

            public boolean hasNext() {
                return this.f5957c.hasNext();
            }

            public int hashCode() {
                return this.f5957c.hashCode();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.f5957c.next();
            }

            public void remove() {
                this.f5956b.a();
                this.f5957c.remove();
            }

            public String toString() {
                return this.f5957c.toString();
            }
        }

        /* renamed from: c.b.d.z0$c$c  reason: collision with other inner class name */
        public static class C0118c<E> implements Set<E> {

            /* renamed from: b  reason: collision with root package name */
            public final q1 f5958b;

            /* renamed from: c  reason: collision with root package name */
            public final Set<E> f5959c;

            public C0118c(q1 q1Var, Set<E> set) {
                this.f5958b = q1Var;
                this.f5959c = set;
            }

            @Override // java.util.Collection, java.util.Set
            public boolean add(E e2) {
                this.f5958b.a();
                return this.f5959c.add(e2);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean addAll(Collection<? extends E> collection) {
                this.f5958b.a();
                return this.f5959c.addAll(collection);
            }

            public void clear() {
                this.f5958b.a();
                this.f5959c.clear();
            }

            public boolean contains(Object obj) {
                return this.f5959c.contains(obj);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return this.f5959c.containsAll(collection);
            }

            public boolean equals(Object obj) {
                return this.f5959c.equals(obj);
            }

            public int hashCode() {
                return this.f5959c.hashCode();
            }

            public boolean isEmpty() {
                return this.f5959c.isEmpty();
            }

            @Override // java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f5958b, this.f5959c.iterator());
            }

            public boolean remove(Object obj) {
                this.f5958b.a();
                return this.f5959c.remove(obj);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                this.f5958b.a();
                return this.f5959c.removeAll(collection);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                this.f5958b.a();
                return this.f5959c.retainAll(collection);
            }

            public int size() {
                return this.f5959c.size();
            }

            public Object[] toArray() {
                return this.f5959c.toArray();
            }

            @Override // java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.f5959c.toArray(tArr);
            }

            public String toString() {
                return this.f5959c.toString();
            }
        }

        public c(q1 q1Var, Map<K, V> map) {
            this.f5952b = q1Var;
            this.f5953c = map;
        }

        public void clear() {
            this.f5952b.a();
            this.f5953c.clear();
        }

        public boolean containsKey(Object obj) {
            return this.f5953c.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.f5953c.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new C0118c(this.f5952b, this.f5953c.entrySet());
        }

        public boolean equals(Object obj) {
            return this.f5953c.equals(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.f5953c.get(obj);
        }

        public int hashCode() {
            return this.f5953c.hashCode();
        }

        public boolean isEmpty() {
            return this.f5953c.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new C0118c(this.f5952b, this.f5953c.keySet());
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            this.f5952b.a();
            n0.a(k);
            if (v != null) {
                return this.f5953c.put(k, v);
            }
            throw null;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f5952b.a();
            for (Object obj : map.keySet()) {
                n0.a(obj);
                n0.a(map.get(obj));
            }
            this.f5953c.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            this.f5952b.a();
            return this.f5953c.remove(obj);
        }

        public int size() {
            return this.f5953c.size();
        }

        public String toString() {
            return this.f5953c.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new a(this.f5952b, this.f5953c.values());
        }
    }

    public enum d {
        MAP,
        LIST,
        BOTH
    }

    public z0(a<K, V> aVar, d dVar, Map<K, V> map) {
        this.f5950e = aVar;
        this.f5947b = dVar;
        this.f5948c = new c<>(this, map);
        this.f5949d = null;
    }

    @Override // c.b.d.q1
    public void a() {
        if (!this.f5946a) {
            throw new UnsupportedOperationException();
        }
    }

    public final c<K, V> b(List<f1> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (f1 f1Var : list) {
            if (((b) this.f5950e) != null) {
                x0 x0Var = (x0) f1Var;
                linkedHashMap.put(x0Var.f5912b, x0Var.f5913c);
            } else {
                throw null;
            }
        }
        return new c<>(this, linkedHashMap);
    }

    public final List<f1> c(c<K, V> cVar) {
        ArrayList arrayList = new ArrayList();
        c.b bVar = (c.b) ((c.C0118c) cVar.entrySet()).iterator();
        if (!bVar.hasNext()) {
            return arrayList;
        }
        Map.Entry entry = (Map.Entry) bVar.next();
        entry.getKey();
        entry.getValue();
        if (((b) this.f5950e).f5951a != null) {
            throw null;
        }
        throw null;
    }

    public List<f1> d() {
        d dVar = d.MAP;
        if (this.f5947b == dVar) {
            synchronized (this) {
                if (this.f5947b == dVar) {
                    this.f5949d = c(this.f5948c);
                    this.f5947b = d.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(this.f5949d);
    }

    public Map<K, V> e() {
        d dVar = d.LIST;
        if (this.f5947b == dVar) {
            synchronized (this) {
                if (this.f5947b == dVar) {
                    this.f5948c = b(this.f5949d);
                    this.f5947b = d.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(this.f5948c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z0)) {
            return false;
        }
        return a1.e(e(), ((z0) obj).e());
    }

    public List<f1> f() {
        d dVar = d.LIST;
        if (this.f5947b != dVar) {
            if (this.f5947b == d.MAP) {
                this.f5949d = c(this.f5948c);
            }
            this.f5948c = null;
            this.f5947b = dVar;
        }
        return this.f5949d;
    }

    public Map<K, V> g() {
        d dVar = d.MAP;
        if (this.f5947b != dVar) {
            if (this.f5947b == d.LIST) {
                this.f5948c = b(this.f5949d);
            }
            this.f5949d = null;
            this.f5947b = dVar;
        }
        return this.f5948c;
    }

    public int hashCode() {
        return a1.a(e());
    }
}
