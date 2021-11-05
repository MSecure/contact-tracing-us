package c.b.a.a.j;

import b.x.t;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public final class b0<TResult> extends i<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4101a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final y<TResult> f4102b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f4103c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4104d;

    /* renamed from: e  reason: collision with root package name */
    public TResult f4105e;

    /* renamed from: f  reason: collision with root package name */
    public Exception f4106f;

    @Override // c.b.a.a.j.i
    public final i<TResult> a(Executor executor, c cVar) {
        y<TResult> yVar = this.f4102b;
        c0.a(executor);
        yVar.b(new p(executor, cVar));
        k();
        return this;
    }

    @Override // c.b.a.a.j.i
    public final i<TResult> b(d<TResult> dVar) {
        Executor executor = k.f4110a;
        y<TResult> yVar = this.f4102b;
        c0.a(executor);
        yVar.b(new q(executor, dVar));
        k();
        return this;
    }

    @Override // c.b.a.a.j.i
    public final i<TResult> c(Executor executor, e eVar) {
        y<TResult> yVar = this.f4102b;
        c0.a(executor);
        yVar.b(new t(executor, eVar));
        k();
        return this;
    }

    @Override // c.b.a.a.j.i
    public final i<TResult> d(Executor executor, f<? super TResult> fVar) {
        y<TResult> yVar = this.f4102b;
        c0.a(executor);
        yVar.b(new u(executor, fVar));
        k();
        return this;
    }

    @Override // c.b.a.a.j.i
    public final Exception e() {
        Exception exc;
        synchronized (this.f4101a) {
            exc = this.f4106f;
        }
        return exc;
    }

    @Override // c.b.a.a.j.i
    public final TResult f() {
        TResult tresult;
        synchronized (this.f4101a) {
            t.I(this.f4103c, "Task is not yet complete");
            if (this.f4104d) {
                throw new CancellationException("Task is already canceled.");
            } else if (this.f4106f == null) {
                tresult = this.f4105e;
            } else {
                throw new g(this.f4106f);
            }
        }
        return tresult;
    }

    @Override // c.b.a.a.j.i
    public final boolean g() {
        boolean z;
        synchronized (this.f4101a) {
            z = this.f4103c && !this.f4104d && this.f4106f == null;
        }
        return z;
    }

    public final void h(Exception exc) {
        t.D(exc, "Exception must not be null");
        synchronized (this.f4101a) {
            if (!this.f4103c) {
                this.f4103c = true;
                this.f4106f = exc;
            } else {
                throw b.a(this);
            }
        }
        this.f4102b.a(this);
    }

    public final void i(TResult tresult) {
        synchronized (this.f4101a) {
            if (!this.f4103c) {
                this.f4103c = true;
                this.f4105e = tresult;
            } else {
                throw b.a(this);
            }
        }
        this.f4102b.a(this);
    }

    public final boolean j() {
        synchronized (this.f4101a) {
            if (this.f4103c) {
                return false;
            }
            this.f4103c = true;
            this.f4104d = true;
            this.f4102b.a(this);
            return true;
        }
    }

    public final void k() {
        synchronized (this.f4101a) {
            if (this.f4103c) {
                this.f4102b.a(this);
            }
        }
    }
}
