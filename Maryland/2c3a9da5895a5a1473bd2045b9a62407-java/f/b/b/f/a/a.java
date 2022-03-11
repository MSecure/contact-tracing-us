package f.b.b.f.a;

import f.b.b.a.g;
import f.b.b.f.a.l;
import java.lang.Throwable;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public abstract class a<V, X extends Throwable, F, T> extends l.a<V> implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public u<? extends V> f3013i;

    /* renamed from: j  reason: collision with root package name */
    public Class<X> f3014j;

    /* renamed from: k  reason: collision with root package name */
    public F f3015k;

    /* renamed from: f.b.b.f.a.a$a  reason: collision with other inner class name */
    public static final class C0109a<V, X extends Throwable> extends a<V, X, i<? super X, ? extends V>, u<? extends V>> {
        public C0109a(u<? extends V> uVar, Class<X> cls, i<? super X, ? extends V> iVar) {
            super(uVar, cls, iVar);
        }

        @Override // f.b.b.f.a.a
        public Object B(Object obj, Throwable th) {
            i iVar = (i) obj;
            u a = iVar.a(th);
            f.b.a.c.b.o.b.B(a, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", iVar);
            return a;
        }

        @Override // f.b.b.f.a.a
        public void C(Object obj) {
            v((u) obj);
        }
    }

    public static final class b<V, X extends Throwable> extends a<V, X, g<? super X, ? extends V>, V> {
        public b(u<? extends V> uVar, Class<X> cls, g<? super X, ? extends V> gVar) {
            super(uVar, cls, gVar);
        }

        @Override // f.b.b.f.a.a
        public Object B(Object obj, Throwable th) {
            return ((g) obj).a(th);
        }

        @Override // f.b.b.f.a.a
        public void C(V v) {
            t(v);
        }
    }

    public a(u<? extends V> uVar, Class<X> cls, F f2) {
        Objects.requireNonNull(uVar);
        this.f3013i = uVar;
        Objects.requireNonNull(cls);
        this.f3014j = cls;
        Objects.requireNonNull(f2);
        this.f3015k = f2;
    }

    public abstract T B(F f2, X x);

    public abstract void C(T t);

    @Override // f.b.b.f.a.b
    public final void j() {
        q(this.f3013i);
        this.f3013i = null;
        this.f3014j = null;
        this.f3015k = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        String str;
        u<? extends V> uVar = this.f3013i;
        Class<X> cls = this.f3014j;
        F f2 = this.f3015k;
        String r = super.r();
        if (uVar != null) {
            str = "inputFuture=[" + uVar + "], ";
        } else {
            str = "";
        }
        if (cls != null && f2 != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + ((Object) f2) + "]";
        } else if (r != null) {
            return f.a.a.a.a.t(str, r);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: f.b.b.f.a.a<V, X extends java.lang.Throwable, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    public final void run() {
        Object obj;
        Throwable th;
        u<? extends V> uVar = this.f3013i;
        Class<X> cls = this.f3014j;
        F f2 = this.f3015k;
        boolean z = true;
        boolean z2 = (uVar == null) | (cls == null);
        if (f2 != null) {
            z = false;
        }
        if ((!z && !z2) && !isCancelled()) {
            this.f3013i = null;
            try {
                th = uVar instanceof f.b.b.f.a.e0.a ? ((f.b.b.f.a.e0.a) uVar).b() : null;
                if (th == null) {
                    obj = f.b.a.c.b.o.b.O0(uVar);
                    if (th != null) {
                        t(obj);
                        return;
                    } else if (!cls.isInstance(th)) {
                        v(uVar);
                        return;
                    } else {
                        try {
                            Object B = B(f2, th);
                            this.f3014j = null;
                            this.f3015k = null;
                            C(B);
                            return;
                        } catch (Throwable th2) {
                            this.f3014j = null;
                            this.f3015k = null;
                            throw th2;
                        }
                    }
                }
            } catch (ExecutionException e2) {
                Throwable cause = e2.getCause();
                if (cause == null) {
                    StringBuilder h2 = f.a.a.a.a.h("Future type ");
                    h2.append(uVar.getClass());
                    h2.append(" threw ");
                    h2.append(e2.getClass());
                    h2.append(" without a cause");
                    cause = new NullPointerException(h2.toString());
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
}
