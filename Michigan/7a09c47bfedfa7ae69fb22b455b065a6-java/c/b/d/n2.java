package c.b.d;

import c.b.d.s;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

public class n2 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, s.b> f5444a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final n2 f5445a = new n2(Collections.emptyMap());
    }

    static {
        Logger.getLogger(n2.class.getName());
    }

    public n2(Map<String, s.b> map) {
        this.f5444a = map;
    }

    public static n2 b() {
        return a.f5445a;
    }

    public final s.b a(String str) {
        String[] split = str.split("/");
        if (split.length != 1) {
            return this.f5444a.get(split[split.length - 1]);
        }
        throw new o0(c.a.a.a.a.q("Invalid type url found: ", str));
    }
}
