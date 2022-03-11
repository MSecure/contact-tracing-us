package f.b.a.c.i;

import e.b.a.m;
import f.b.a.a.a.p.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public final class c0<TResult> extends h<TResult> {
    public final Object a = new Object();
    public final z<TResult> b = new z<>();
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f2650d;

    /* renamed from: e  reason: collision with root package name */
    public TResult f2651e;

    /* renamed from: f  reason: collision with root package name */
    public Exception f2652f;

    @Override // f.b.a.c.i.h
    public final h<TResult> a(c cVar) {
        b(j.a, cVar);
        return this;
    }

    @Override // f.b.a.c.i.h
    public final h<TResult> b(Executor executor, c cVar) {
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new q(executor, cVar));
        t();
        return this;
    }

    @Override // f.b.a.c.i.h
    public final h<TResult> c(Executor executor, d<TResult> dVar) {
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new r(executor, dVar));
        t();
        return this;
    }

    @Override // f.b.a.c.i.h
    public final h<TResult> d(e eVar) {
        e(j.a, eVar);
        return this;
    }

    @Override // f.b.a.c.i.h
    public final h<TResult> e(Executor executor, e eVar) {
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new u(executor, eVar));
        t();
        return this;
    }

    @Override // f.b.a.c.i.h
    public final h<TResult> f(f<? super TResult> fVar) {
        g(j.a, fVar);
        return this;
    }

    @Override // f.b.a.c.i.h
    public final h<TResult> g(Executor executor, f<? super TResult> fVar) {
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new v(executor, fVar));
        t();
        return this;
    }

    @Override // f.b.a.c.i.h
    public final <TContinuationResult> h<TContinuationResult> h(a<TResult, TContinuationResult> aVar) {
        Executor executor = j.a;
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new l(executor, aVar, c0Var));
        t();
        return c0Var;
    }

    @Override // f.b.a.c.i.h
    public final <TContinuationResult> h<TContinuationResult> i(Executor executor, a<TResult, h<TContinuationResult>> aVar) {
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new m(executor, aVar, c0Var));
        t();
        return c0Var;
    }

    @Override // f.b.a.c.i.h
    public final Exception j() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f2652f;
        }
        return exc;
    }

    @Override // f.b.a.c.i.h
    public final TResult k() {
        TResult tresult;
        synchronized (this.a) {
            m.h.r(this.c, "Task is not yet complete");
            if (this.f2650d) {
                throw new CancellationException("Task is already canceled.");
            } else if (this.f2652f == null) {
                tresult = this.f2651e;
            } else {
                throw new g(this.f2652f);
            }
        }
        return tresult;
    }

    @Override // f.b.a.c.i.h
    public final boolean l() {
        return this.f2650d;
    }

    @Override // f.b.a.c.i.h
    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // f.b.a.c.i.h
    public final boolean n() {
        boolean z;
        synchronized (this.a) {
            z = this.c && !this.f2650d && this.f2652f == null;
        }
        return z;
    }

    @Override // f.b.a.c.i.h
    public final <TContinuationResult> h<TContinuationResult> o(b<TResult, TContinuationResult> bVar) {
        Executor executor = j.a;
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new y(executor, bVar, c0Var));
        t();
        return c0Var;
    }

    public final void p(Exception exc) {
        m.h.p(exc, "Exception must not be null");
        synchronized (this.a) {
            s();
            this.c = true;
            this.f2652f = exc;
        }
        this.b.a(this);
    }

    public final void q(TResult tresult) {
        synchronized (this.a) {
            s();
            this.c = true;
            this.f2651e = tresult;
        }
        this.b.a(this);
    }

    public final boolean r() {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f2650d = true;
            this.b.a(this);
            return true;
        }
    }

    public final void s() {
        String str;
        if (this.c) {
            int i2 = b.b;
            if (m()) {
                Exception j2 = j();
                if (j2 != null) {
                    str = "failure";
                } else if (n()) {
                    String valueOf = String.valueOf(k());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 7);
                    sb.append("result ");
                    sb.append(valueOf);
                    str = sb.toString();
                } else {
                    str = l() ? "cancellation" : "unknown issue";
                }
                String valueOf2 = String.valueOf(str);
                throw new b(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), j2);
            }
            throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
    }

    public final void t() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }
}
