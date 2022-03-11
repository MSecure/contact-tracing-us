package f.b.a.a.a.z;

import f.b.a.a.a.d0.d;
import f.b.a.a.a.z.a0;
import f.b.b.b.c;
import f.b.b.b.g;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import l.b.a.f;
/* loaded from: classes.dex */
public abstract class e0 {

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract e0 a();

        public abstract a b(boolean z);

        public abstract a c(Collection<d> collection);
    }

    public static a i(String str, String str2) {
        f.b.b.b.a<Object> aVar = c.c;
        return j(g.f3390f, str, str2);
    }

    public static a j(List<d> list, String str, String str2) {
        c<String> cVar;
        a0.b bVar = new a0.b();
        Objects.requireNonNull(str, "Null verificationCode");
        bVar.a = str;
        bVar.c(c.s(list));
        bVar.f2521g = str2;
        bVar.b(false);
        bVar.n = 0;
        c<Object> cVar2 = g.f3390f;
        if (cVar2 == null) {
            cVar = null;
        } else {
            cVar = c.s(cVar2);
        }
        bVar.f2518d = cVar;
        bVar.d(false);
        return bVar;
    }

    public abstract String a();

    public abstract f b();

    public abstract boolean c();

    public abstract String d();

    public abstract String e();

    public abstract boolean f();

    public abstract c<d> g();

    public abstract String h();

    public abstract String k();

    public abstract int l();

    public abstract c<String> m();

    public abstract String n();

    public abstract f o();

    public abstract String p();

    public abstract a q();

    public abstract String r();
}
