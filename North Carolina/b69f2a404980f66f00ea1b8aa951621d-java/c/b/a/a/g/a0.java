package c.b.a.a.g;

import b.b.k.i;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public final class a0<TResult> extends h<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2849a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final y<TResult> f2850b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f2851c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f2852d;

    /* renamed from: e  reason: collision with root package name */
    public TResult f2853e;
    public Exception f;

    @Override // c.b.a.a.g.h
    public final h<TResult> a(Executor executor, b bVar) {
        y<TResult> yVar = this.f2850b;
        c0.a(executor);
        yVar.b(new n(executor, bVar));
        k();
        return this;
    }

    @Override // c.b.a.a.g.h
    public final h<TResult> b(c<TResult> cVar) {
        Executor executor = j.f2857a;
        y<TResult> yVar = this.f2850b;
        c0.a(executor);
        yVar.b(new q(executor, cVar));
        k();
        return this;
    }

    @Override // c.b.a.a.g.h
    public final h<TResult> c(Executor executor, d dVar) {
        y<TResult> yVar = this.f2850b;
        c0.a(executor);
        yVar.b(new r(executor, dVar));
        k();
        return this;
    }

    @Override // c.b.a.a.g.h
    public final h<TResult> d(Executor executor, e<? super TResult> eVar) {
        y<TResult> yVar = this.f2850b;
        c0.a(executor);
        yVar.b(new u(executor, eVar));
        k();
        return this;
    }

    @Override // c.b.a.a.g.h
    public final Exception e() {
        Exception exc;
        synchronized (this.f2849a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // c.b.a.a.g.h
    public final TResult f() {
        TResult tresult;
        synchronized (this.f2849a) {
            i.j.v(this.f2851c, "Task is not yet complete");
            if (this.f2852d) {
                throw new CancellationException("Task is already canceled.");
            } else if (this.f == null) {
                tresult = this.f2853e;
            } else {
                throw new f(this.f);
            }
        }
        return tresult;
    }

    @Override // c.b.a.a.g.h
    public final boolean g() {
        boolean z;
        synchronized (this.f2849a) {
            z = this.f2851c && !this.f2852d && this.f == null;
        }
        return z;
    }

    public final void h(Exception exc) {
        i.j.t(exc, "Exception must not be null");
        synchronized (this.f2849a) {
            i.j.v(!this.f2851c, "Task is already complete");
            this.f2851c = true;
            this.f = exc;
        }
        this.f2850b.a(this);
    }

    public final void i(TResult tresult) {
        synchronized (this.f2849a) {
            i.j.v(!this.f2851c, "Task is already complete");
            this.f2851c = true;
            this.f2853e = tresult;
        }
        this.f2850b.a(this);
    }

    public final boolean j() {
        synchronized (this.f2849a) {
            if (this.f2851c) {
                return false;
            }
            this.f2851c = true;
            this.f2852d = true;
            this.f2850b.a(this);
            return true;
        }
    }

    public final void k() {
        synchronized (this.f2849a) {
            if (this.f2851c) {
                this.f2850b.a(this);
            }
        }
    }
}
