package f.b.a.b.i;

import f.b.a.b.i.a;
import java.util.HashMap;
import java.util.Map;

public abstract class f {

    public static abstract class a {
        public final a a(String str, String str2) {
            c().put(str, str2);
            return this;
        }

        public abstract f b();

        public abstract Map<String, String> c();
    }

    public final String a(String str) {
        String str2 = b().get(str);
        return str2 == null ? "" : str2;
    }

    public abstract Map<String, String> b();

    public abstract Integer c();

    public abstract e d();

    public abstract long e();

    public final int f(String str) {
        String str2 = b().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public abstract String g();

    public abstract long h();

    public a i() {
        a.b bVar = new a.b();
        bVar.f(g());
        bVar.b = c();
        bVar.d(d());
        bVar.e(e());
        bVar.g(h());
        bVar.f2573f = new HashMap(b());
        return bVar;
    }
}
