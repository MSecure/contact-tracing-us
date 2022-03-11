package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.c.k.w.m;
import f.b.c.k.w.n;
import f.b.c.k.w.o;
import h.a.c;
import h.a.c1;
import h.a.e;
import h.a.j1.x;
import h.a.n0;
import h.a.o0;
import java.net.SocketAddress;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public final class l implements x {
    public final x b;
    public final Executor c;

    /* loaded from: classes.dex */
    public class a extends m0 {
        public final z a;

        public a(z zVar, String str) {
            b.A(zVar, "delegate");
            this.a = zVar;
            b.A(str, "authority");
        }

        @Override // h.a.j1.m0
        public z b() {
            return this.a;
        }

        @Override // h.a.j1.w
        public u g(o0<?, ?> o0Var, n0 n0Var, c cVar) {
            e0 e0Var;
            h.a.b bVar = cVar.f4078d;
            if (bVar == null) {
                return this.a.g(o0Var, n0Var, cVar);
            }
            b2 b2Var = new b2(this.a, o0Var, n0Var, cVar);
            try {
                Executor executor = cVar.b;
                Executor executor2 = l.this.c;
                if (executor == null) {
                    Objects.requireNonNull(executor2, "Both parameters are null");
                    executor = executor2;
                }
                ((o) bVar).a.a().g(executor, new m(b2Var)).e(executor, new n(b2Var));
            } catch (Throwable th) {
                b2Var.b(c1.f4092k.g("Credentials should use fail() instead of throwing exceptions").f(th));
            }
            synchronized (b2Var.f4149f) {
                u uVar = b2Var.f4150g;
                e0Var = uVar;
                if (uVar == null) {
                    e0 e0Var2 = new e0();
                    b2Var.f4152i = e0Var2;
                    b2Var.f4150g = e0Var2;
                    e0Var = e0Var2;
                }
            }
            return e0Var;
        }
    }

    public l(x xVar, Executor executor) {
        b.A(xVar, "delegate");
        this.b = xVar;
        b.A(executor, "appExecutor");
        this.c = executor;
    }

    @Override // h.a.j1.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    @Override // h.a.j1.x
    public z f(SocketAddress socketAddress, x.a aVar, e eVar) {
        return new a(this.b.f(socketAddress, aVar, eVar), aVar.a);
    }

    @Override // h.a.j1.x
    public ScheduledExecutorService p() {
        return this.b.p();
    }
}
