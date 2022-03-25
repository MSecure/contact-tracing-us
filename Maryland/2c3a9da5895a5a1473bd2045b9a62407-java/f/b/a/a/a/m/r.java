package f.b.a.a.a.m;

import f.b.a.a.a.h.s.a;
import f.b.a.a.a.q.g;
import f.b.a.a.a.y.h0;
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
    public static final f.b.b.a.r f2170f;
    public final h0 a;
    public final g b;
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f2171d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2172e;

    static {
        m mVar = n.a;
        Objects.requireNonNull((n.b) n.a);
        h hVar = new h(Pattern.compile("\\s+"));
        Matcher matcher = hVar.b.matcher("");
        Objects.requireNonNull(matcher);
        b.s(!matcher.matches(), "The pattern may not match the empty string: %s", hVar);
        q qVar = new q(hVar);
        c.C0103c cVar = c.C0103c.b;
        c.d dVar = c.d.c;
        Objects.requireNonNull(dVar);
        f2170f = new f.b.b.a.r(qVar, true, dVar, Integer.MAX_VALUE);
    }

    public r(h0 h0Var, g gVar, a aVar, ExecutorService executorService, ExecutorService executorService2) {
        this.a = h0Var;
        this.b = gVar;
        this.c = aVar;
        this.f2171d = executorService;
        this.f2172e = executorService2;
    }
}
