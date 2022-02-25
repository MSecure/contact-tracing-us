package f.b.a.a.a.k;

import f.b.a.a.a.h.s.a;
import f.b.a.a.a.o.g;
import f.b.a.a.a.w.g0;
import f.b.a.c.b.o.b;
import f.b.b.a.c;
import f.b.b.a.h;
import f.b.b.a.m;
import f.b.b.a.n;
import f.b.b.a.q;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class r {

    /* renamed from: f  reason: collision with root package name */
    public static final f.b.b.a.r f2091f;
    public final g0 a;
    public final g b;
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f2092d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2093e;

    static {
        m mVar = n.a;
        Objects.requireNonNull((n.b) n.a);
        h hVar = new h(Pattern.compile("\\s+"));
        Matcher matcher = hVar.b.matcher("");
        Objects.requireNonNull(matcher);
        b.s(!matcher.matches(), "The pattern may not match the empty string: %s", hVar);
        q qVar = new q(hVar);
        c.C0099c cVar = c.C0099c.b;
        c.d dVar = c.d.c;
        Objects.requireNonNull(dVar);
        f2091f = new f.b.b.a.r(qVar, true, dVar, Integer.MAX_VALUE);
    }

    public r(g0 g0Var, g gVar, a aVar, ExecutorService executorService, ExecutorService executorService2) {
        this.a = g0Var;
        this.b = gVar;
        this.c = aVar;
        this.f2092d = executorService;
        this.f2093e = executorService2;
    }
}
