package f.b.a.f.a.h;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class r<ResultT> {
    public final Object a = new Object();
    public final m<ResultT> b = new m<>();
    public boolean c;

    /* renamed from: d */
    public ResultT f3371d;

    /* renamed from: e */
    public Exception f3372e;

    public final r<ResultT> a(Executor executor, b bVar) {
        this.b.a(new i(executor, bVar));
        h();
        return this;
    }

    public final r<ResultT> b(Executor executor, c<? super ResultT> cVar) {
        this.b.a(new k(executor, cVar));
        h();
        return this;
    }

    public final Exception c() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f3372e;
        }
        return exc;
    }

    public final ResultT d() {
        ResultT resultt;
        synchronized (this.a) {
            if (this.c) {
                Exception exc = this.f3372e;
                if (exc == null) {
                    resultt = this.f3371d;
                } else {
                    throw new d(exc);
                }
            } else {
                throw new IllegalStateException("Task is not yet complete");
            }
        }
        return resultt;
    }

    public final boolean e() {
        boolean z;
        synchronized (this.a) {
            z = false;
            if (this.c && this.f3372e == null) {
                z = true;
            }
        }
        return z;
    }

    public final void f(Exception exc) {
        synchronized (this.a) {
            if (!this.c) {
                this.c = true;
                this.f3372e = exc;
            } else {
                throw new IllegalStateException("Task is already complete");
            }
        }
        this.b.b(this);
    }

    public final void g(ResultT resultt) {
        synchronized (this.a) {
            if (!this.c) {
                this.c = true;
                this.f3371d = resultt;
            } else {
                throw new IllegalStateException("Task is already complete");
            }
        }
        this.b.b(this);
    }

    public final void h() {
        synchronized (this.a) {
            if (this.c) {
                this.b.b(this);
            }
        }
    }
}
