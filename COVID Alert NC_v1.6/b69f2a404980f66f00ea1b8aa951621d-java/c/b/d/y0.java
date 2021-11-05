package c.b.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class y0<K, V> implements p1 {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f4393a = true;

    /* renamed from: b  reason: collision with root package name */
    public volatile d f4394b;

    /* renamed from: c  reason: collision with root package name */
    public c<K, V> f4395c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f4396d;

    /* renamed from: e  reason: collision with root package name */
    public final a<K, V> f4397e;

    public interface a<K, V> {
    }

    public static class b<K, V> implements a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final w0<K, V> f4398a;

        public b(w0<K, V> w0Var) {
            this.f4398a = w0Var;
        }
    }

    public static class c<K, V> implements Map<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final p1 f4399b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<K, V> f4400c;

        public static class a<E> implements Collection<E> {

            /* renamed from: b  reason: collision with root package name */
            public final p1 f4401b;

            /* renamed from: c  reason: collision with root package name */
            public final Collection<E> f4402c;

            public a(p1 p1Var, Collection<E> collection) {
                this.f4401b = p1Var;
                this.f4402c = collection;
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
                this.f4401b.a();
                this.f4402c.clear();
            }

            public boolean contains(Object obj) {
                return this.f4402c.contains(obj);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.f4402c.containsAll(collection);
            }

            public boolean equals(Object obj) {
                return this.f4402c.equals(obj);
            }

            public int hashCode() {
                return this.f4402c.hashCode();
            }

            public boolean isEmpty() {
                return this.f4402c.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f4401b, this.f4402c.iterator());
            }

            public boolean remove(Object obj) {
                this.f4401b.a();
                return this.f4402c.remove(obj);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.f4401b.a();
                return this.f4402c.removeAll(collection);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.f4401b.a();
                return this.f4402c.retainAll(collection);
            }

            public int size() {
                return this.f4402c.size();
            }

            public Object[] toArray() {
                return this.f4402c.toArray();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.f4402c.toArray(tArr);
            }

            public String toString() {
                return this.f4402c.toString();
            }
        }

        public static class b<E> implements Iterator<E> {

            /* renamed from: b  reason: collision with root package name */
            public final p1 f4403b;

            /* renamed from: c  reason: collision with root package name */
            public final Iterator<E> f4404c;

            public b(p1 p1Var, Iterator<E> it) {
                this.f4403b = p1Var;
                this.f4404c = it;
            }

            public boolean equals(Object obj) {
                return this.f4404c.equals(obj);
            }

            public boolean hasNext() {
                return this.f4404c.hasNext();
            }

            public int hashCode() {
                return this.f4404c.hashCode();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.f4404c.next();
            }

            public void remove() {
                this.f4403b.a();
                this.f4404c.remove();
            }

            public String toString() {
                return this.f4404c.toString();
            }
        }

        /* renamed from: c.b.d.y0$c$c  reason: collision with other inner class name */
        public static class C0109c<E> implements Set<E> {

            /* renamed from: b  reason: collision with root package name */
            public final p1 f4405b;

            /* renamed from: c  reason: collision with root package name */
            public final Set<E> f4406c;

            public C0109c(p1 p1Var, Set<E> set) {
                this.f4405b = p1Var;
                this.f4406c = set;
            }

            @Override // java.util.Collection, java.util.Set
            public boolean add(E e2) {
                this.f4405b.a();
                return this.f4406c.add(e2);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean addAll(Collection<? extends E> collection) {
                this.f4405b.a();
                return this.f4406c.addAll(collection);
            }

            public void clear() {
                this.f4405b.a();
                this.f4406c.clear();
            }

            public boolean contains(Object obj) {
                return this.f4406c.contains(obj);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return this.f4406c.containsAll(collection);
            }

            public boolean equals(Object obj) {
                return this.f4406c.equals(obj);
            }

            public int hashCode() {
                return this.f4406c.hashCode();
            }

            public boolean isEmpty() {
                return this.f4406c.isEmpty();
            }

            @Override // java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f4405b, this.f4406c.iterator());
            }

            public boolean remove(Object obj) {
                this.f4405b.a();
                return this.f4406c.remove(obj);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                this.f4405b.a();
                return this.f4406c.removeAll(collection);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                this.f4405b.a();
                return this.f4406c.retainAll(collection);
            }

            public int size() {
                return this.f4406c.size();
            }

            public Object[] toArray() {
                return this.f4406c.toArray();
            }

            @Override // java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.f4406c.toArray(tArr);
            }

            public String toString() {
                return this.f4406c.toString();
            }
        }

        public c(p1 p1Var, Map<K, V> map) {
            this.f4399b = p1Var;
            this.f4400c = map;
        }

        public void clear() {
            this.f4399b.a();
            this.f4400c.clear();
        }

        public boolean containsKey(Object obj) {
            return this.f4400c.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.f4400c.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new C0109c(this.f4399b, this.f4400c.entrySet());
        }

        public boolean equals(Object obj) {
            return this.f4400c.equals(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.f4400c.get(obj);
        }

        public int hashCode() {
            return this.f4400c.hashCode();
        }

        public boolean isEmpty() {
            return this.f4400c.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new C0109c(this.f4399b, this.f4400c.keySet());
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            this.f4399b.a();
            m0.a(k);
            if (v != null) {
                return this.f4400c.put(k, v);
            }
            throw null;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f4399b.a();
            for (Object obj : map.keySet()) {
                m0.a(obj);
                m0.a(map.get(obj));
            }
            this.f4400c.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            this.f4399b.a();
            return this.f4400c.remove(obj);
        }

        public int size() {
            return this.f4400c.size();
        }

        public String toString() {
            return this.f4400c.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new a(this.f4399b, this.f4400c.values());
        }
    }

    public enum d {
        MAP,
        LIST,
        BOTH
    }

    public y0(a<K, V> aVar, d dVar, Map<K, V> map) {
        this.f4397e = aVar;
        this.f4394b = dVar;
        this.f4395c = new c<>(this, map);
        this.f4396d = null;
    }

    @Override // c.b.d.p1
    public void a() {
        if (!this.f4393a) {
            throw new UnsupportedOperationException();
        }
    }

    public final c<K, V> b(List<e1> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (e1 e1Var : list) {
            if (((b) this.f4397e) != null) {
                w0 w0Var = (w0) e1Var;
                linkedHashMap.put(w0Var.f4363b, w0Var.f4364c);
            } else {
                throw null;
            }
        }
        return new c<>(this, linkedHashMap);
    }

    public final List<e1> c(c<K, V> cVar) {
        ArrayList arrayList = new ArrayList();
        c.b bVar = (c.b) ((c.C0109c) cVar.entrySet()).iterator();
        if (!bVar.hasNext()) {
            return arrayList;
        }
        Map.Entry entry = (Map.Entry) bVar.next();
        entry.getKey();
        entry.getValue();
        if (((b) this.f4397e).f4398a != null) {
            throw null;
        }
        throw null;
    }

    public List<e1> d() {
        d dVar = d.MAP;
        if (this.f4394b == dVar) {
            synchronized (this) {
                if (this.f4394b == dVar) {
                    this.f4396d = c(this.f4395c);
                    this.f4394b = d.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(this.f4396d);
    }

    public Map<K, V> e() {
        d dVar = d.LIST;
        if (this.f4394b == dVar) {
            synchronized (this) {
                if (this.f4394b == dVar) {
                    this.f4395c = b(this.f4396d);
                    this.f4394b = d.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(this.f4395c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y0)) {
            return false;
        }
        return z0.e(e(), ((y0) obj).e());
    }

    public List<e1> f() {
        d dVar = d.LIST;
        if (this.f4394b != dVar) {
            if (this.f4394b == d.MAP) {
                this.f4396d = c(this.f4395c);
            }
            this.f4395c = null;
            this.f4394b = dVar;
        }
        return this.f4396d;
    }

    public Map<K, V> g() {
        d dVar = d.MAP;
        if (this.f4394b != dVar) {
            if (this.f4394b == d.LIST) {
                this.f4395c = b(this.f4396d);
            }
            this.f4396d = null;
            this.f4394b = dVar;
        }
        return this.f4395c;
    }

    public int hashCode() {
        return z0.a(e());
    }
}
