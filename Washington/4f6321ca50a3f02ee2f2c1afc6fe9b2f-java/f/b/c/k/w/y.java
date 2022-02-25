package f.b.c.k.w;

import android.content.Context;
import f.b.a.c.b.f;
import f.b.a.c.b.g;
import f.b.a.c.b.o.b;
import f.b.a.c.g.a;
import f.b.c.k.s.e;
import f.b.c.k.x.c;
import f.b.c.k.x.m;
import f.b.d.a.k;
import h.a.c;
import h.a.i1.a;
import h.a.l0;
import h.a.m0;
import h.a.m1.c;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class y implements Callable {
    public final b0 a;

    public y(b0 b0Var) {
        this.a = b0Var;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        b0 b0Var = this.a;
        Context context = b0Var.f3138e;
        e eVar = b0Var.f3139f;
        try {
            a.a(context);
        } catch (f | g | IllegalStateException e2) {
            m.a(m.a.WARN, "GrpcCallProvider", "Failed to update ssl context: %s", e2);
        }
        String str = eVar.c;
        m0 m0Var = m0.b;
        if (m0Var != null) {
            l0<?> a2 = m0Var.a(str);
            if (!eVar.f3028d) {
                a2.c();
            }
            a2.b(30, TimeUnit.SECONDS);
            h.a.i1.a aVar = new h.a.i1.a(a2);
            aVar.b = context;
            a.b bVar = new a.b(aVar.a.a(), aVar.b);
            b0Var.b.b(new z(b0Var, bVar));
            c e3 = c.f3507k.e(h.a.m1.c.a, c.a.ASYNC);
            b.A(bVar, "channel");
            b.A(e3, "callOptions");
            h.a.b bVar2 = b0Var.f3140g;
            h.a.c cVar = new h.a.c(e3);
            cVar.f3508d = bVar2;
            b.A(bVar, "channel");
            b.A(cVar, "callOptions");
            c.ExecutorC0117c cVar2 = b0Var.b.a;
            Objects.requireNonNull(cVar);
            h.a.c cVar3 = new h.a.c(cVar);
            cVar3.b = cVar2;
            b0Var.c = new k.a(bVar, cVar3).b;
            m.a(m.a.DEBUG, "GrpcCallProvider", "Channel successfully reset.", new Object[0]);
            return bVar;
        }
        throw new m0.c("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }
}
