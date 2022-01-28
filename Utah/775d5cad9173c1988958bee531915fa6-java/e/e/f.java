package e.e;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class f<K, V> {
    public final LinkedHashMap<K, V> a;
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f1219d;

    /* renamed from: e  reason: collision with root package name */
    public int f1220e;

    /* renamed from: f  reason: collision with root package name */
    public int f1221f;

    /* renamed from: g  reason: collision with root package name */
    public int f1222g;

    public f(int i2) {
        if (i2 > 0) {
            this.c = i2;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V a(K k2) {
        Objects.requireNonNull(k2, "key == null");
        synchronized (this) {
            V v = this.a.get(k2);
            if (v != null) {
                this.f1221f++;
                return v;
            }
            this.f1222g++;
            return null;
        }
    }

    public final V b(K k2, V v) {
        V put;
        if (k2 == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f1219d++;
            this.b++;
            put = this.a.put(k2, v);
            if (put != null) {
                this.b--;
            }
        }
        c(this.c);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    public void c(int i2) {
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                } else if (this.b <= i2) {
                    break;
                } else if (this.a.isEmpty()) {
                    break;
                } else {
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    K key = next.getKey();
                    next.getValue();
                    this.a.remove(key);
                    this.b--;
                    this.f1220e++;
                }
            }
        }
    }

    public final synchronized String toString() {
        int i2;
        int i3;
        i2 = this.f1221f;
        i3 = this.f1222g + i2;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.f1221f), Integer.valueOf(this.f1222g), Integer.valueOf(i3 != 0 ? (i2 * 100) / i3 : 0));
    }
}
