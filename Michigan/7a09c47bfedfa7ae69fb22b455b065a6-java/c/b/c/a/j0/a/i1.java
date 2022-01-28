package c.b.c.a.j0.a;

import c.b.c.a.j0.a.u;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class i1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final int f4944b;

    /* renamed from: c  reason: collision with root package name */
    public List<i1<K, V>.c> f4945c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f4946d = Collections.emptyMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f4947e;

    /* renamed from: f  reason: collision with root package name */
    public volatile i1<K, V>.e f4948f;

    /* renamed from: g  reason: collision with root package name */
    public Map<K, V> f4949g = Collections.emptyMap();

    public class a extends i1<FieldDescriptorType, Object> {
        public a(int i) {
            super(i, null);
        }

        @Override // c.b.c.a.j0.a.i1
        public void h() {
            if (!this.f4947e) {
                for (int i = 0; i < e(); i++) {
                    Map.Entry<K, V> d2 = d(i);
                    if (((u.a) d2.getKey()).e()) {
                        d2.setValue((V) Collections.unmodifiableList(d2.getValue()));
                    }
                }
                for (Map.Entry<K, V> entry : f()) {
                    if (((u.a) entry.getKey()).e()) {
                        entry.setValue((V) Collections.unmodifiableList(entry.getValue()));
                    }
                }
            }
            i1.super.h();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f4950a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final Iterable<Object> f4951b = new C0101b();

        public class a implements Iterator<Object> {
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: c.b.c.a.j0.a.i1$b$b  reason: collision with other inner class name */
        public class C0101b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f4950a;
            }
        }
    }

    public class c implements Map.Entry<K, V>, Comparable<i1<K, V>.c> {

        /* renamed from: b  reason: collision with root package name */
        public final K f4952b;

        /* renamed from: c  reason: collision with root package name */
        public V f4953c;

        public c(K k, V v) {
            this.f4952b = k;
            this.f4953c = v;
        }

        public c(i1 i1Var, Map.Entry<K, V> entry) {
            V value = entry.getValue();
            i1.this = i1Var;
            this.f4952b = entry.getKey();
            this.f4953c = value;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(i1<K, V>.c cVar) {
            return this.f4952b.compareTo(cVar.f4952b);
        }

        public boolean equals(Object obj) {
            boolean z;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f4952b;
            Object key = entry.getKey();
            if (k == null ? key == null : k.equals(key)) {
                V v = this.f4953c;
                Object value = entry.getValue();
                if (v == null) {
                    z = value == null;
                } else {
                    z = v.equals(value);
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f4952b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4953c;
        }

        public int hashCode() {
            K k = this.f4952b;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f4953c;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            i1.this.c();
            V v2 = this.f4953c;
            this.f4953c = v;
            return v2;
        }

        public String toString() {
            return ((Object) this.f4952b) + "=" + ((Object) this.f4953c);
        }
    }

    public class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public int f4955b = -1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4956c;

        /* renamed from: d  reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f4957d;

        public d(a aVar) {
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K extends java.lang.Comparable<K>, V>> */
        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f4957d == null) {
                this.f4957d = i1.this.f4946d.entrySet().iterator();
            }
            return (Iterator<Map.Entry<K, V>>) this.f4957d;
        }

        public boolean hasNext() {
            if (this.f4955b + 1 < i1.this.f4945c.size()) {
                return true;
            }
            if (i1.this.f4946d.isEmpty() || !a().hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            this.f4956c = true;
            int i = this.f4955b + 1;
            this.f4955b = i;
            return i < i1.this.f4945c.size() ? i1.this.f4945c.get(this.f4955b) : a().next();
        }

        public void remove() {
            if (this.f4956c) {
                this.f4956c = false;
                i1.this.c();
                if (this.f4955b < i1.this.f4945c.size()) {
                    i1 i1Var = i1.this;
                    int i = this.f4955b;
                    this.f4955b = i - 1;
                    i1Var.k(i);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    public class e extends AbstractSet<Map.Entry<K, V>> {
        public e(a aVar) {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: c.b.c.a.j0.a.i1 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            i1.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            i1.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = i1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            i1.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return i1.this.size();
        }
    }

    public i1(int i, a aVar) {
        this.f4944b = i;
    }

    public static <FieldDescriptorType extends u.a<FieldDescriptorType>> i1<FieldDescriptorType, Object> i(int i) {
        return new a(i);
    }

    public final int b(K k) {
        int size = this.f4945c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f4945c.get(size).f4952b);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.f4945c.get(i2).f4952b);
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public final void c() {
        if (this.f4947e) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        c();
        if (!this.f4945c.isEmpty()) {
            this.f4945c.clear();
        }
        if (!this.f4946d.isEmpty()) {
            this.f4946d.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.c.a.j0.a.i1<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return b(comparable) >= 0 || this.f4946d.containsKey(comparable);
    }

    public Map.Entry<K, V> d(int i) {
        return this.f4945c.get(i);
    }

    public int e() {
        return this.f4945c.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f4948f == null) {
            this.f4948f = new e(null);
        }
        return this.f4948f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return super.equals(obj);
        }
        i1 i1Var = (i1) obj;
        int size = size();
        if (size != i1Var.size()) {
            return false;
        }
        int e2 = e();
        if (e2 != i1Var.e()) {
            return entrySet().equals(i1Var.entrySet());
        }
        for (int i = 0; i < e2; i++) {
            if (!d(i).equals(i1Var.d(i))) {
                return false;
            }
        }
        if (e2 != size) {
            return this.f4946d.equals(i1Var.f4946d);
        }
        return true;
    }

    public Iterable<Map.Entry<K, V>> f() {
        return this.f4946d.isEmpty() ? (Iterable<Map.Entry<K, V>>) b.f4951b : this.f4946d.entrySet();
    }

    public final SortedMap<K, V> g() {
        c();
        if (this.f4946d.isEmpty() && !(this.f4946d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f4946d = treeMap;
            this.f4949g = treeMap.descendingMap();
        }
        return (SortedMap) this.f4946d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.c.a.j0.a.i1<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return this.f4945c.get(b2).f4953c;
        }
        return this.f4946d.get(comparable);
    }

    public void h() {
        if (!this.f4947e) {
            this.f4946d = this.f4946d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f4946d);
            this.f4949g = this.f4949g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f4949g);
            this.f4947e = true;
        }
    }

    public int hashCode() {
        int e2 = e();
        int i = 0;
        for (int i2 = 0; i2 < e2; i2++) {
            i += this.f4945c.get(i2).hashCode();
        }
        return this.f4946d.size() > 0 ? i + this.f4946d.hashCode() : i;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    /* renamed from: j */
    public V put(K k, V v) {
        c();
        int b2 = b(k);
        if (b2 >= 0) {
            i1<K, V>.c cVar = this.f4945c.get(b2);
            i1.this.c();
            V v2 = cVar.f4953c;
            cVar.f4953c = v;
            return v2;
        }
        c();
        if (this.f4945c.isEmpty() && !(this.f4945c instanceof ArrayList)) {
            this.f4945c = new ArrayList(this.f4944b);
        }
        int i = -(b2 + 1);
        if (i >= this.f4944b) {
            return g().put(k, v);
        }
        int size = this.f4945c.size();
        int i2 = this.f4944b;
        if (size == i2) {
            i1<K, V>.c remove = this.f4945c.remove(i2 - 1);
            g().put(remove.f4952b, remove.f4953c);
        }
        this.f4945c.add(i, new c(k, v));
        return null;
    }

    public final V k(int i) {
        c();
        V v = this.f4945c.remove(i).f4953c;
        if (!this.f4946d.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f4945c.add(new c(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.c.a.j0.a.i1<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        c();
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return (V) k(b2);
        }
        if (this.f4946d.isEmpty()) {
            return null;
        }
        return this.f4946d.remove(comparable);
    }

    public int size() {
        return this.f4946d.size() + this.f4945c.size();
    }
}
