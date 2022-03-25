package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.c;
import h.a.c0;
import h.a.c1;
import h.a.d0;
import h.a.f;
import h.a.k0;
import h.a.n;
import h.a.o0;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public final class e2 extends k0 implements c0<Object> {
    static {
        Logger.getLogger(e2.class.getName());
    }

    @Override // h.a.d
    public String b() {
        return null;
    }

    @Override // h.a.c0
    public d0 c() {
        return null;
    }

    @Override // h.a.d
    public <RequestT, ResponseT> f<RequestT, ResponseT> h(o0<RequestT, ResponseT> o0Var, c cVar) {
        Executor executor = cVar.b;
        if (executor == null) {
            executor = null;
        }
        return new p(o0Var, executor, cVar, null, null, null, false);
    }

    @Override // h.a.k0
    public n j(boolean z) {
        return n.IDLE;
    }

    @Override // h.a.k0
    public void l() {
        throw null;
    }

    @Override // h.a.k0
    public k0 m() {
        c1.n.g("OobChannel.shutdownNow() called");
        throw null;
    }

    public String toString() {
        b.T1(this);
        throw null;
    }
}
