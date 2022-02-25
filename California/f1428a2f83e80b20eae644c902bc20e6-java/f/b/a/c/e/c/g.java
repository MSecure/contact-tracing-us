package f.b.a.c.e.c;

import f.b.a.c.b.l.l.k;
import f.b.a.c.f.b.a;
import f.b.a.c.f.b.b;
import f.b.a.c.i.i;
import java.util.Objects;

public final /* synthetic */ class g implements k {
    public final s2 a;
    public final b b;
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2490d;

    public g(s2 s2Var, b bVar, a aVar, String str) {
        this.a = s2Var;
        this.b = bVar;
        this.c = aVar;
        this.f2490d = str;
    }

    @Override // f.b.a.c.b.l.l.k
    public final void a(Object obj, Object obj2) {
        s2 s2Var = this.a;
        b bVar = this.b;
        a aVar = this.c;
        String str = this.f2490d;
        Objects.requireNonNull(s2Var);
        v1 v1Var = new v1(null);
        v1Var.f2510e = bVar;
        v1Var.f2512g = new r(aVar);
        v1Var.c = new n((i) obj2);
        v1Var.f2511f = str;
        ((i1) ((q2) obj).t()).v(v1Var);
    }
}
