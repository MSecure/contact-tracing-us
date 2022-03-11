package f.e.a;

import f.e.a.a;
import java.util.Objects;
/* loaded from: classes.dex */
public final class d {
    public final b a;
    public final a b;
    public final Object c = this;

    /* loaded from: classes.dex */
    public static class b {
        public b a;
        public a.b b = new a.b();

        public b a(String str, String str2) {
            a.b bVar = this.b;
            Objects.requireNonNull(bVar);
            if (!str.isEmpty()) {
                int length = str.length();
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = str.charAt(i3);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i3), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    for (int i4 = 0; i4 < length2; i4++) {
                        char charAt2 = str2.charAt(i4);
                        if (charAt2 <= 31 || charAt2 >= 127) {
                            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", Integer.valueOf(charAt2), Integer.valueOf(i4), str2));
                        }
                    }
                    while (i2 < bVar.a.size()) {
                        if (str.equalsIgnoreCase(bVar.a.get(i2))) {
                            bVar.a.remove(i2);
                            bVar.a.remove(i2);
                            i2 -= 2;
                        }
                        i2 += 2;
                    }
                    bVar.a.add(str);
                    bVar.a.add(str2.trim());
                    return this;
                }
                throw new IllegalArgumentException("value == null");
            }
            throw new IllegalArgumentException("name is empty");
        }
    }

    public d(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = new a(bVar.b, null);
    }

    public String toString() {
        StringBuilder j2 = f.a.a.a.a.j("Request{method=", "GET", ", url=");
        j2.append(this.a);
        j2.append(", tag=");
        Object obj = this.c;
        if (obj == this) {
            obj = null;
        }
        j2.append(obj);
        j2.append('}');
        return j2.toString();
    }
}
