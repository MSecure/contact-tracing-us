package f.b.a.a.a.l;

import f.b.a.a.a.l.q;
import f.b.a.a.a.o.d;
import f.b.b.b.c;
import f.b.b.b.g;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import l.b.a.e;

public abstract class t {
    public static final SecureRandom a = new SecureRandom();
    public static final f.b.b.c.a b = f.b.b.c.a.a;

    public static abstract class a {
        public abstract t a();

        public abstract a b(boolean z);

        public abstract a c(Collection<d> collection);
    }

    public static a i(String str) {
        f.b.b.b.a<Object> aVar = c.c;
        return j(g.f2882f, str);
    }

    public static a j(List<d> list, String str) {
        c<String> cVar;
        q.b bVar = new q.b();
        Objects.requireNonNull(str, "Null verificationCode");
        bVar.a = str;
        bVar.c(c.s(list));
        byte[] bArr = new byte[16];
        a.nextBytes(bArr);
        bVar.f2107g = b.c(bArr);
        bVar.b(false);
        bVar.m = 0;
        c<Object> cVar2 = g.f2882f;
        if (cVar2 == null) {
            cVar = null;
        } else {
            cVar = c.s(cVar2);
        }
        bVar.f2104d = cVar;
        bVar.f2112l = Boolean.FALSE;
        return bVar;
    }

    public abstract String a();

    public abstract e b();

    public abstract boolean c();

    public abstract String d();

    public abstract String e();

    public abstract boolean f();

    public abstract c<d> g();

    public abstract String h();

    public abstract int k();

    public abstract c<String> l();

    public abstract String m();

    public abstract e n();

    public abstract String o();

    public abstract a p();

    public abstract String q();
}
