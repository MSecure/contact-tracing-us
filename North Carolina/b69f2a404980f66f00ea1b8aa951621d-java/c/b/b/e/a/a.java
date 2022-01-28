package c.b.b.e.a;

import c.b.a.a.c.n.c;
import c.b.b.a.e;
import c.b.b.e.a.b;
import c.b.b.e.a.l;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public abstract class a<V, X extends Throwable, F, T> extends l.a<V> implements Runnable {
    public u<? extends V> i;
    public Class<X> j;
    public F k;

    /* renamed from: c.b.b.e.a.a$a  reason: collision with other inner class name */
    public static final class C0080a<V, X extends Throwable> extends a<V, X, i<? super X, ? extends V>, u<? extends V>> {
        public C0080a(u<? extends V> uVar, Class<X> cls, i<? super X, ? extends V> iVar) {
            super(uVar, cls, iVar);
        }

        @Override // c.b.b.e.a.a
        public Object y(Object obj, Throwable th) {
            i iVar = (i) obj;
            u a2 = iVar.a(th);
            c.u(a2, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", iVar);
            return a2;
        }

        @Override // c.b.b.e.a.a
        public void z(Object obj) {
            o((u) obj);
        }
    }

    public static final class b<V, X extends Throwable> extends a<V, X, e<? super X, ? extends V>, V> {
        public b(u<? extends V> uVar, Class<X> cls, e<? super X, ? extends V> eVar) {
            super(uVar, cls, eVar);
        }

        @Override // c.b.b.e.a.a
        public Object y(Object obj, Throwable th) {
            return ((e) obj).a(th);
        }

        @Override // c.b.b.e.a.a
        public void z(V v) {
            m(v);
        }
    }

    public a(u<? extends V> uVar, Class<X> cls, F f) {
        if (uVar != null) {
            this.i = uVar;
            if (cls != null) {
                this.j = cls;
                if (f != null) {
                    this.k = f;
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public static <V, X extends Throwable> u<V> w(u<? extends V> uVar, Class<X> cls, e<? super X, ? extends V> eVar, Executor executor) {
        b bVar = new b(uVar, cls, eVar);
        if (executor != null) {
            if (executor != k.INSTANCE) {
                executor = new x(executor, bVar);
            }
            uVar.b(bVar, executor);
            return bVar;
        }
        throw null;
    }

    public static <X extends Throwable, V> u<V> x(u<? extends V> uVar, Class<X> cls, i<? super X, ? extends V> iVar, Executor executor) {
        C0080a aVar = new C0080a(uVar, cls, iVar);
        if (executor != null) {
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
        this.k = null;
    }

    @Override // c.b.b.e.a.b
    public String k() {
        String str;
        u<? extends V> uVar = this.i;
        Class<X> cls = this.j;
        F f = this.k;
        String k2 = super.k();
        if (uVar != null) {
            str = "inputFuture=[" + uVar + "], ";
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + ((Object) f) + "]";
        } else if (k2 != null) {
            return c.a.a.a.a.o(str, k2);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: c.b.b.e.a.a<V, X extends java.lang.Throwable, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    public final void run() {
        Object obj;
        Throwable th;
        u<? extends V> uVar = this.i;
        Class<X> cls = this.j;
        F f = this.k;
        boolean z = true;
        boolean z2 = (uVar == null) | (cls == null);
        if (f != null) {
            z = false;
        }
        if ((!z && !z2) && !(this.f3368b instanceof b.c)) {
            this.i = null;
            try {
                th = uVar instanceof c.b.b.e.a.d0.a ? c.t2((c.b.b.e.a.d0.a) uVar) : null;
                if (th == null) {
                    obj = c.c1(uVar);
                    if (th != null) {
                        m(obj);
                        return;
                    } else if (!cls.isInstance(th)) {
                        o(uVar);
                        return;
                    } else {
                        try {
                            Object y = y(f, th);
                            this.j = null;
                            this.k = null;
                            z(y);
                            return;
                        } catch (Throwable th2) {
                            this.j = null;
                            this.k = null;
                            throw th2;
                        }
                    }
                }
            } catch (ExecutionException e2) {
                Throwable cause = e2.getCause();
                if (cause == null) {
                    StringBuilder g = c.a.a.a.a.g("Future type ");
                    g.append(uVar.getClass());
                    g.append(" threw ");
                    g.append(e2.getClass());
                    g.append(" without a cause");
                    cause = new NullPointerException(g.toString());
                }
                th = cause;
            } catch (Throwable th3) {
                th = th3;
            }
            obj = null;
            if (th != null) {
            }
        }
    }

    public abstract T y(F f, X x);

    public abstract void z(T t);
}
