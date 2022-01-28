package b.e;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class f<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f807a;

    /* renamed from: b  reason: collision with root package name */
    public int f808b;

    /* renamed from: c  reason: collision with root package name */
    public int f809c;

    /* renamed from: d  reason: collision with root package name */
    public int f810d;

    /* renamed from: e  reason: collision with root package name */
    public int f811e;
    public int f;
    public int g;

    public f(int i) {
        if (i > 0) {
            this.f809c = i;
            this.f807a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V a(K k) {
        if (k != null) {
            synchronized (this) {
                V v = this.f807a.get(k);
                if (v != null) {
                    this.f++;
                    return v;
                }
                this.g++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V b(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f810d++;
            this.f808b++;
            put = this.f807a.put(k, v);
            if (put != null) {
                this.f808b--;
            }
        }
        c(this.f809c);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    public void c(int i) {
        while (true) {
            synchronized (this) {
                if (this.f808b < 0 || (this.f807a.isEmpty() && this.f808b != 0)) {
                } else if (this.f808b <= i) {
                    break;
                } else if (this.f807a.isEmpty()) {
                    break;
                } else {
                    Map.Entry<K, V> next = this.f807a.entrySet().iterator().next();
                    K key = next.getKey();
                    next.getValue();
                    this.f807a.remove(key);
                    this.f808b--;
                    this.f811e++;
                }
            }
        }
    }

    public final synchronized String toString() {
        int i;
        i = this.f + this.g;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f809c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i != 0 ? (this.f * 100) / i : 0));
    }
}
