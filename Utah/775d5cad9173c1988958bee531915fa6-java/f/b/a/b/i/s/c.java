package f.b.a.b.i.s;

import f.b.a.a.a.z.l;
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
    public static final Logger f2594f = Logger.getLogger(m.class.getName());
    public final r a;
    public final Executor b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.b.i.s.i.c f2595d;

    /* renamed from: e  reason: collision with root package name */
    public final b f2596e;

    public c(Executor executor, e eVar, r rVar, f.b.a.b.i.s.i.c cVar, b bVar) {
        this.b = executor;
        this.c = eVar;
        this.a = rVar;
        this.f2595d = cVar;
        this.f2596e = bVar;
    }

    @Override // f.b.a.b.i.s.e
    public void a(i iVar, f fVar, l lVar) {
        this.b.execute(new a(this, iVar, lVar, fVar));
    }
}
