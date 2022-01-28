package h.a;

import h.a.n0;
import java.nio.charset.Charset;

public final class e0 {
    public static final Charset a = Charset.forName("US-ASCII");
    public static final f.b.b.c.a b = n0.f4263d;

    public interface a<T> extends n0.i<T> {
    }

    public static <T> n0.f<T> a(String str, a<T> aVar) {
        boolean z = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return n0.f.b(str, z, aVar);
    }
}
