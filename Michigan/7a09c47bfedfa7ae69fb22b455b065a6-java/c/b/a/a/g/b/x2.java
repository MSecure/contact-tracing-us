package c.b.a.a.g.b;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class x2<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final int f3465b;

    /* renamed from: c  reason: collision with root package name */
    public List<c3> f3466c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f3467d = Collections.emptyMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f3468e;

    /* renamed from: f  reason: collision with root package name */
    public volatile e3 f3469f;

    /* renamed from: g  reason: collision with root package name */
    public Map<K, V> f3470g = Collections.emptyMap();

    public x2(int i, y2 y2Var) {
        this.f3465b = i;
    }

    public final int a(K k) {
        int size = this.f3466c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f3466c.get(size).f3236b);
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
            int compareTo2 = k.compareTo(this.f3466c.get(i2).f3236b);
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

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    /* renamed from: b */
    public final V put(K k, V v) {
        h();
        int a2 = a(k);
        if (a2 >= 0) {
            c3 c3Var = this.f3466c.get(a2);
            c3Var.f3238d.h();
            V v2 = c3Var.f3237c;
            c3Var.f3237c = v;
            return v2;
        }
        h();
        if (this.f3466c.isEmpty() && !(this.f3466c instanceof ArrayList)) {
            this.f3466c = new ArrayList(this.f3465b);
        }
        int i = -(a2 + 1);
        if (i >= this.f3465b) {
            return i().put(k, v);
        }
        int size = this.f3466c.size();
        int i2 = this.f3465b;
        if (size == i2) {
            c3 remove = this.f3466c.remove(i2 - 1);
            i().put(remove.f3236b, remove.f3237c);
        }
        this.f3466c.add(i, new c3(this, k, v));
        return null;
    }

    public void clear() {
        h();
        if (!this.f3466c.isEmpty()) {
            this.f3466c.clear();
        }
        if (!this.f3467d.isEmpty()) {
            this.f3467d.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.a.a.g.b.x2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f3467d.containsKey(comparable);
    }

    public final Map.Entry<K, V> d(int i) {
        return this.f3466c.get(i);
    }

    public final V e(int i) {
        h();
        V v = this.f3466c.remove(i).f3237c;
        if (!this.f3467d.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = i().entrySet().iterator();
            this.f3466c.add(new c3(this, it.next()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f3469f == null) {
            this.f3469f = new e3(this, null);
        }
        return this.f3469f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x2)) {
            return super.equals(obj);
        }
        x2 x2Var = (x2) obj;
        int size = size();
        if (size != x2Var.size()) {
            return false;
        }
        int f2 = f();
        if (f2 != x2Var.f()) {
            return entrySet().equals(x2Var.entrySet());
        }
        for (int i = 0; i < f2; i++) {
            if (!d(i).equals(x2Var.d(i))) {
                return false;
            }
        }
        if (f2 != size) {
            return this.f3467d.equals(x2Var.f3467d);
        }
        return true;
    }

    public final int f() {
        return this.f3466c.size();
    }

    public final Iterable<Map.Entry<K, V>> g() {
        return this.f3467d.isEmpty() ? (Iterable<Map.Entry<K, V>>) z2.f3491b : this.f3467d.entrySet();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.a.a.g.b.x2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f3466c.get(a2).f3237c;
        }
        return this.f3467d.get(comparable);
    }

    public final void h() {
        if (this.f3468e) {
            throw new UnsupportedOperationException();
        }
    }

    public int hashCode() {
        int f2 = f();
        int i = 0;
        for (int i2 = 0; i2 < f2; i2++) {
            i += this.f3466c.get(i2).hashCode();
        }
        return this.f3467d.size() > 0 ? i + this.f3467d.hashCode() : i;
    }

    public final SortedMap<K, V> i() {
        h();
        if (this.f3467d.isEmpty() && !(this.f3467d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f3467d = treeMap;
            this.f3470g = treeMap.descendingMap();
        }
        return (SortedMap) this.f3467d;
    }

    public void j() {
        if (!this.f3468e) {
            this.f3467d = this.f3467d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3467d);
            this.f3470g = this.f3470g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3470g);
            this.f3468e = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.a.a.g.b.x2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return (V) e(a2);
        }
        if (this.f3467d.isEmpty()) {
            return null;
        }
        return this.f3467d.remove(comparable);
    }

    public int size() {
        return this.f3467d.size() + this.f3466c.size();
    }
}
