package f.b.b.a;

import java.util.Arrays;
import java.util.Objects;

public final class k {
    public final String a;
    public final a b;
    public a c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2860d = false;

    public static final class a {
        public String a;
        public Object b;
        public a c;

        public a(j jVar) {
        }
    }

    public k(String str, j jVar) {
        a aVar = new a(null);
        this.b = aVar;
        this.c = aVar;
        this.a = str;
    }

    public k a(String str, int i2) {
        d(str, String.valueOf(i2));
        return this;
    }

    public k b(String str, long j2) {
        d(str, String.valueOf(j2));
        return this;
    }

    public k c(String str, boolean z) {
        d(str, String.valueOf(z));
        return this;
    }

    public final k d(String str, Object obj) {
        a aVar = new a(null);
        this.c.c = aVar;
        this.c = aVar;
        aVar.b = obj;
        Objects.requireNonNull(str);
        aVar.a = str;
        return this;
    }

    public String toString() {
        boolean z = this.f2860d;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        String str = "";
        for (a aVar = this.b.c; aVar != null; aVar = aVar.c) {
            Object obj = aVar.b;
            if (!z || obj != null) {
                sb.append(str);
                String str2 = aVar.a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
