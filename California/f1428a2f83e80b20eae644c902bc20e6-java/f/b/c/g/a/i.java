package f.b.c.g.a;

import java.util.Comparator;

public interface i<K, V> {

    public enum a {
        RED,
        BLACK
    }

    i<K, V> a();

    i<K, V> b(K k2, V v, a aVar, i<K, V> iVar, i<K, V> iVar2);

    i<K, V> c();

    i<K, V> d(K k2, V v, Comparator<K> comparator);

    i<K, V> e(K k2, Comparator<K> comparator);

    i<K, V> f();

    boolean g();

    K getKey();

    V getValue();

    boolean isEmpty();

    int size();
}
