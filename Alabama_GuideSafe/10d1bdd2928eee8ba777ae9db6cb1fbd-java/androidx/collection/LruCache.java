package androidx.collection;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class LruCache<K, V> {
    public int evictionCount;
    public int hitCount;
    public final LinkedHashMap<K, V> map;
    public int maxSize;
    public int missCount;
    public int putCount;
    public int size;

    public LruCache(int i) {
        if (i > 0) {
            this.maxSize = i;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V get(K k) {
        if (k != null) {
            synchronized (this) {
                V v = this.map.get(k);
                if (v != null) {
                    this.hitCount++;
                    return v;
                }
                this.missCount++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size++;
            put = this.map.put(k, v);
            if (put != null) {
                this.size--;
            }
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final synchronized String toString() {
        int i;
        i = this.hitCount + this.missCount;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i != 0 ? (this.hitCount * 100) / i : 0));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    public void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                } else if (this.size <= i) {
                    break;
                } else if (this.map.isEmpty()) {
                    break;
                } else {
                    Map.Entry<K, V> next = this.map.entrySet().iterator().next();
                    K key = next.getKey();
                    next.getValue();
                    this.map.remove(key);
                    this.size--;
                    this.evictionCount++;
                }
            }
        }
    }
}
