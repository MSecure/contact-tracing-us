package f.b.a.b.i.s;

import f.b.a.a.a.o.d;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import f.b.a.b.i.m;
import f.b.a.b.i.p.e;
import f.b.a.b.i.s.h.r;
import f.b.a.b.i.t.b;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class c implements e {

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f2451f = Logger.getLogger(m.class.getName());
    public final r a;
    public final Executor b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.b.i.s.i.c f2452d;

    /* renamed from: e  reason: collision with root package name */
    public final b f2453e;

    public c(Executor executor, e eVar, r rVar, f.b.a.b.i.s.i.c cVar, b bVar) {
        this.b = executor;
        this.c = eVar;
        this.a = rVar;
        this.f2452d = cVar;
        this.f2453e = bVar;
    }

    @Override // f.b.a.b.i.s.e
    public void a(i iVar, f fVar, d dVar) {
        this.b.execute(new a(this, iVar, dVar, fVar));
    }
}
