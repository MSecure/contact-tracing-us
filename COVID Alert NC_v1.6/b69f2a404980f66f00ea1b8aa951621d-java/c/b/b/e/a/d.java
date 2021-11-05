package c.b.b.e.a;

import c.b.a.a.c.n.c;
import c.b.b.a.e;
import c.b.b.e.a.b;
import c.b.b.e.a.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public abstract class d<I, O, F, T> extends l.a<O> implements Runnable {
    public u<? extends I> i;
    public F j;

    public static final class a<I, O> extends d<I, O, i<? super I, ? extends O>, u<? extends O>> {
        public a(u<? extends I> uVar, i<? super I, ? extends O> iVar) {
            super(uVar, iVar);
        }

        @Override // c.b.b.e.a.d
        public Object y(Object obj, Object obj2) {
            i iVar = (i) obj;
            u<O> a2 = iVar.a(obj2);
            c.u(a2, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", iVar);
            return a2;
        }

        @Override // c.b.b.e.a.d
        public void z(Object obj) {
            o((u) obj);
        }
    }

    public static final class b<I, O> extends d<I, O, e<? super I, ? extends O>, O> {
        public b(u<? extends I> uVar, e<? super I, ? extends O> eVar) {
            super(uVar, eVar);
        }

        @Override // c.b.b.e.a.d
        public Object y(Object obj, Object obj2) {
            return ((e) obj).a(obj2);
        }

        @Override // c.b.b.e.a.d
        public void z(O o) {
            m(o);
        }
    }

    public d(u<? extends I> uVar, F f) {
        if (uVar != null) {
            this.i = uVar;
            if (f != null) {
                this.j = f;
                return;
            }
            throw null;
        }
        throw null;
    }

    public static <I, O> u<O> w(u<I> uVar, e<? super I, ? extends O> eVar, Executor executor) {
        if (eVar != null) {
            b bVar = new b(uVar, eVar);
            if (executor != null) {
                if (executor != k.INSTANCE) {
                    executor = new x(executor, bVar);
                }
                uVar.b(bVar, executor);
                return bVar;
            }
            throw null;
        }
        throw null;
    }

    public static <I, O> u<O> x(u<I> uVar, i<? super I, ? extends O> iVar, Executor executor) {
        if (executor != null) {
            a aVar = new a(uVar, iVar);
            if (executor != k.INSTANCE) {
                executor = new x(executor, aVar);
            }
            uVar.b(aVar, executor);
            return aVar;
        }
        throw null;
    }

    @Override // c.b.b.e.a.b
    public final void c() {
        j(this.i);
        this.i = null;
        this.j = null;
    }

    @Override // c.b.b.e.a.b
    public String k() {
        String str;
        u<? extends I> uVar = this.i;
        F f = this.j;
        String k = super.k();
        if (uVar != null) {
            str = "inputFuture=[" + uVar + "], ";
        } else {
            str = "";
        }
        if (f != null) {
            return str + "function=[" + ((Object) f) + "]";
        } else if (k != null) {
            return c.a.a.a.a.o(str, k);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: c.b.b.e.a.d<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void run() {
        u<? extends I> uVar = this.i;
        F f = this.j;
        boolean z = true;
        boolean z2 = (this.f3368b instanceof b.c) | (uVar == null);
        if (f != null) {
            z = false;
        }
        if (!z2 && !z) {
            this.i = null;
            if (uVar.isCancelled()) {
                o(uVar);
                return;
            }
            try {
                try {
                    Object y = y(f, c.c1(uVar));
                    this.j = null;
                    z(y);
                } catch (Throwable th) {
                    this.j = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e2) {
                n(e2.getCause());
            } catch (RuntimeException e3) {
                n(e3);
            } catch (Error e4) {
                n(e4);
            }
        }
    }

    public abstract T y(F f, I i2);

    public abstract void z(T t);
}
