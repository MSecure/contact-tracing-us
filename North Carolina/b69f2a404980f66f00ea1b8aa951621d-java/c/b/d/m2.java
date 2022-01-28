package c.b.d;

import c.b.d.s;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

public class m2 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, s.b> f4004a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final m2 f4005a = new m2(Collections.emptyMap());
    }

    static {
        Logger.getLogger(m2.class.getName());
    }

    public m2(Map<String, s.b> map) {
        this.f4004a = map;
    }

    public static m2 b() {
        return a.f4005a;
    }

    public final s.b a(String str) {
        String[] split = str.split("/");
        if (split.length != 1) {
            return this.f4004a.get(split[split.length - 1]);
        }
        throw new n0(c.a.a.a.a.o("Invalid type url found: ", str));
    }
}
