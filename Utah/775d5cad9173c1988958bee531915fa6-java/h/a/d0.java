package h.a;

import f.b.a.c.b.o.b;
import java.util.concurrent.atomic.AtomicLong;

public final class d0 {

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicLong f3848d = new AtomicLong();
    public final String a;
    public final String b;
    public final long c;

    public d0(String str, String str2, long j2) {
        b.z(str, "typeName");
        b.o(!str.isEmpty(), "empty type");
        this.a = str;
        this.b = str2;
        this.c = j2;
    }

    public static d0 a(Class<?> cls, String str) {
        b.z(cls, "type");
        String simpleName = cls.getSimpleName();
        if (simpleName.isEmpty()) {
            simpleName = cls.getName().substring(cls.getPackage().getName().length() + 1);
        }
        return b(simpleName, str);
    }

    public static d0 b(String str, String str2) {
        return new d0(str, str2, f3848d.incrementAndGet());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a + "<" + this.c + ">");
        if (this.b != null) {
            sb.append(": (");
            sb.append(this.b);
            sb.append(')');
        }
        return sb.toString();
    }
}
