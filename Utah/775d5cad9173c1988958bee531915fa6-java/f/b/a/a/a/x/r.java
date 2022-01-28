package f.b.a.a.a.x;

import f.b.a.a.a.c0.g;
import f.b.a.a.a.l0.m0;
import f.b.a.a.a.s.d0.a;
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
    public static final a f2457f = a.e("KeyFileUriResolver");

    /* renamed from: g  reason: collision with root package name */
    public static final f.b.b.a.r f2458g;
    public final m0 a;
    public final g b;
    public final f.b.a.a.a.s.e0.a c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f2459d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2460e;

    static {
        m mVar = n.a;
        Objects.requireNonNull((n.b) n.a);
        h hVar = new h(Pattern.compile("\\s+"));
        Matcher matcher = hVar.b.matcher("");
        Objects.requireNonNull(matcher);
        b.s(!matcher.matches(), "The pattern may not match the empty string: %s", hVar);
        q qVar = new q(hVar);
        c.C0102c cVar = c.C0102c.b;
        c.d dVar = c.d.c;
        Objects.requireNonNull(dVar);
        f2458g = new f.b.b.a.r(qVar, true, dVar, Integer.MAX_VALUE);
    }

    public r(m0 m0Var, g gVar, f.b.a.a.a.s.e0.a aVar, ExecutorService executorService, ExecutorService executorService2) {
        this.a = m0Var;
        this.b = gVar;
        this.c = aVar;
        this.f2459d = executorService;
        this.f2460e = executorService2;
    }
}
