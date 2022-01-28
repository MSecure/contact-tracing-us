package c.b.b.a;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final j f3330a = new b(null);

    public static final class b implements j {
        public b() {
        }

        public b(a aVar) {
        }
    }

    static {
        Logger.getLogger(k.class.getName());
    }

    public static d a(String str) {
        if (str == null) {
            throw null;
        } else if (((b) f3330a) != null) {
            return new f(Pattern.compile(str));
        } else {
            throw null;
        }
    }

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static boolean c(String str) {
        return str == null || str.isEmpty();
    }
}
