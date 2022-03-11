package h.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {
    public static final a b = new a(Collections.emptyMap());
    public final Map<c<?>, Object> a;

    /* loaded from: classes.dex */
    public static final class b {
        public a a;
        public Map<c<?>, Object> b;

        public b(a aVar, C0142a aVar2) {
            this.a = aVar;
        }

        public a a() {
            if (this.b != null) {
                for (Map.Entry<c<?>, Object> entry : this.a.a.entrySet()) {
                    if (!this.b.containsKey(entry.getKey())) {
                        this.b.put(entry.getKey(), entry.getValue());
                    }
                }
                this.a = new a(this.b, null);
                this.b = null;
            }
            return this.a;
        }

        public <T> b b(c<T> cVar, T t) {
            if (this.b == null) {
                this.b = new IdentityHashMap(1);
            }
            this.b.put(cVar, t);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c<T> {
        public final String a;

        public c(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    public a(Map<c<?>, Object> map) {
        this.a = map;
    }

    public a(Map map, C0142a aVar) {
        this.a = map;
    }

    public static b a() {
        return new b(b, null);
    }

    public b b() {
        return new b(this, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.a.size() != aVar.a.size()) {
            return false;
        }
        for (Map.Entry<c<?>, Object> entry : this.a.entrySet()) {
            if (!aVar.a.containsKey(entry.getKey()) || !f.b.a.c.b.o.b.n0(entry.getValue(), aVar.a.get(entry.getKey()))) {
                return false;
            }
            while (r2.hasNext()) {
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = 0;
        for (Map.Entry<c<?>, Object> entry : this.a.entrySet()) {
            i2 += Arrays.hashCode(new Object[]{entry.getKey(), entry.getValue()});
        }
        return i2;
    }

    public String toString() {
        return this.a.toString();
    }
}
