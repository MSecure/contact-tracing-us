package f.b.a.c.i;

import e.b.a.m;
import f.b.a.a.a.c0.e;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class c0<TResult> extends h<TResult> {
    public final Object a = new Object();
    public final z<TResult> b = new z<>();
    public boolean c;

    /* renamed from: d */
    public volatile boolean f2836d;

    /* renamed from: e */
    public TResult f2837e;

    /* renamed from: f */
    public Exception f2838f;

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
        u();
        return this;
    }

    @Override // f.b.a.c.i.h
    public final h<TResult> c(Executor executor, d<TResult> dVar) {
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new r(executor, dVar));
        u();
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
        u();
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
        u();
        return this;
    }

    @Override // f.b.a.c.i.h
    public final <TContinuationResult> h<TContinuationResult> h(a<TResult, TContinuationResult> aVar) {
        Executor executor = j.a;
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new l(executor, aVar, c0Var));
        u();
        return c0Var;
    }

    @Override // f.b.a.c.i.h
    public final <TContinuationResult> h<TContinuationResult> i(a<TResult, h<TContinuationResult>> aVar) {
        return j(j.a, aVar);
    }

    @Override // f.b.a.c.i.h
    public final <TContinuationResult> h<TContinuationResult> j(Executor executor, a<TResult, h<TContinuationResult>> aVar) {
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new m(executor, aVar, c0Var));
        u();
        return c0Var;
    }

    @Override // f.b.a.c.i.h
    public final Exception k() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f2838f;
        }
        return exc;
    }

    @Override // f.b.a.c.i.h
    public final TResult l() {
        TResult tresult;
        synchronized (this.a) {
            m.e.t(this.c, "Task is not yet complete");
            if (this.f2836d) {
                throw new CancellationException("Task is already canceled.");
            } else if (this.f2838f == null) {
                tresult = this.f2837e;
            } else {
                throw new g(this.f2838f);
            }
        }
        return tresult;
    }

    @Override // f.b.a.c.i.h
    public final boolean m() {
        return this.f2836d;
    }

    @Override // f.b.a.c.i.h
    public final boolean n() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // f.b.a.c.i.h
    public final boolean o() {
        boolean z;
        synchronized (this.a) {
            z = this.c && !this.f2836d && this.f2838f == null;
        }
        return z;
    }

    @Override // f.b.a.c.i.h
    public final <TContinuationResult> h<TContinuationResult> p(e<TResult, TContinuationResult> eVar) {
        Executor executor = j.a;
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        int i2 = d0.a;
        zVar.b(new y(executor, eVar, c0Var));
        u();
        return c0Var;
    }

    public final void q(Exception exc) {
        m.e.r(exc, "Exception must not be null");
        synchronized (this.a) {
            t();
            this.c = true;
            this.f2838f = exc;
        }
        this.b.a(this);
    }

    public final void r(TResult tresult) {
        synchronized (this.a) {
            t();
            this.c = true;
            this.f2837e = tresult;
        }
        this.b.a(this);
    }

    public final boolean s() {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f2836d = true;
            this.b.a(this);
            return true;
        }
    }

    public final void t() {
        String str;
        if (this.c) {
            int i2 = b.b;
            if (n()) {
                Exception k2 = k();
                if (k2 != null) {
                    str = "failure";
                } else if (o()) {
                    String valueOf = String.valueOf(l());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 7);
                    sb.append("result ");
                    sb.append(valueOf);
                    str = sb.toString();
                } else {
                    str = m() ? "cancellation" : "unknown issue";
                }
                String valueOf2 = String.valueOf(str);
                throw new b(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), k2);
            }
            throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
    }

    public final void u() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }
}
