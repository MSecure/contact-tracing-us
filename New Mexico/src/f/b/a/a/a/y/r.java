package f.b.a.a.a.y;

import f.b.a.a.a.d0.g;
import f.b.a.a.a.n0.p0;
import f.b.a.a.a.t.p0.a;
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
/* loaded from: classes.dex */
public class r {

    /* renamed from: f */
    public static final a f2505f = a.e("KeyFileUriResolver");

    /* renamed from: g */
    public static final f.b.b.a.r f2506g;
    public final p0 a;
    public final g b;
    public final f.b.a.a.a.t.q0.a c;

    /* renamed from: d */
    public final ExecutorService f2507d;

    /* renamed from: e */
    public final ExecutorService f2508e;

    static {
        m mVar = n.a;
        Objects.requireNonNull((n.b) n.a);
        h hVar = new h(Pattern.compile("\\s+"));
        Matcher matcher = hVar.b.matcher("");
        Objects.requireNonNull(matcher);
        b.t(!matcher.matches(), "The pattern may not match the empty string: %s", hVar);
        q qVar = new q(hVar);
        c.C0104c cVar = c.C0104c.b;
        c.d dVar = c.d.c;
        Objects.requireNonNull(dVar);
        f2506g = new f.b.b.a.r(qVar, true, dVar, Integer.MAX_VALUE);
    }

    public r(p0 p0Var, g gVar, f.b.a.a.a.t.q0.a aVar, ExecutorService executorService, ExecutorService executorService2) {
        this.a = p0Var;
        this.b = gVar;
        this.c = aVar;
        this.f2507d = executorService;
        this.f2508e = executorService2;
    }
}
