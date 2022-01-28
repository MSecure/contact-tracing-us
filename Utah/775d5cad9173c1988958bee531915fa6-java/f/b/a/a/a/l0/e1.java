package f.b.a.a.a.l0;

import f.a.a.a.a;
import java.util.Objects;
import l.b.a.e;

public abstract class e1 {
    public static e1 a(e eVar, e eVar2, String str) {
        Long l2 = 0L;
        Objects.requireNonNull(eVar, "Null requestTime");
        Objects.requireNonNull(str, "Null nonce");
        String str2 = l2 == null ? " id" : "";
        if (str2.isEmpty()) {
            return new p(l2.longValue(), eVar, eVar2, str, null);
        }
        throw new IllegalStateException(a.w("Missing required properties:", str2));
    }

    public abstract e b();

    public abstract long c();

    public abstract String d();

    public abstract e e();
}
