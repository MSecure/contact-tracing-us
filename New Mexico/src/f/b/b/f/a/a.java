package f.b.b.f.a;

import f.b.b.a.g;
import f.b.b.f.a.l;
import java.lang.Throwable;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
/* loaded from: classes.dex */
public abstract class a<V, X extends Throwable, F, T> extends l.a<V> implements Runnable {

    /* renamed from: i */
    public u<? extends V> f3425i;

    /* renamed from: j */
    public Class<X> f3426j;

    /* renamed from: k */
    public F f3427k;

    /* renamed from: f.b.b.f.a.a$a */
    /* loaded from: classes.dex */
    public static final class C0110a<V, X extends Throwable> extends a<V, X, i<? super X, ? extends V>, u<? extends V>> {
        public C0110a(u<? extends V> uVar, Class<X> cls, i<? super X, ? extends V> iVar) {
            super(uVar, cls, iVar);
        }

        @Override // f.b.b.f.a.a
        public Object B(Object obj, Throwable th) {
            i iVar = (i) obj;
            u a = iVar.a(th);
            f.b.a.c.b.o.b.B(a, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", iVar);
            return a;
        }

        public void C(Object obj) {
            v((u) obj);
        }
    }

    /* loaded from: classes.dex */
    public static final class b<V, X extends Throwable> extends a<V, X, g<? super X, ? extends V>, V> {
        public b(u<? extends V> uVar, Class<X> cls, g<? super X, ? extends V> gVar) {
            super(uVar, cls, gVar);
        }

        @Override // f.b.b.f.a.a
        public Object B(Object obj, Throwable th) {
            return ((g) obj).a(th);
        }

        public void C(V v) {
            t(v);
        }
    }

    public a(u<? extends V> uVar, Class<X> cls, F f2) {
        Objects.requireNonNull(uVar);
        this.f3425i = uVar;
        Objects.requireNonNull(cls);
        this.f3426j = cls;
        Objects.requireNonNull(f2);
        this.f3427k = f2;
    }

    public abstract T B(F f2, X x);

    public abstract void C(T t);

    @Override // f.b.b.f.a.b
    public final void j() {
        q(this.f3425i);
        this.f3425i = null;
        this.f3426j = null;
        this.f3427k = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        String str;
        u<? extends V> uVar = this.f3425i;
        Class<X> cls = this.f3426j;
        F f2 = this.f3427k;
        String r = super.r();
        if (uVar != null) {
            str = "inputFuture=[" + uVar + "], ";
        } else {
            str = "";
        }
        if (cls != null && f2 != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + f2 + "]";
        } else if (r != null) {
            return f.a.a.a.a.x(str, r);
        } else {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    @Override // java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void run() {
        Object obj;
        Throwable th;
        u<? extends V> uVar = this.f3425i;
        Class<X> cls = this.f3426j;
        F f2 = this.f3427k;
        boolean z = true;
        boolean z2 = (uVar == null) | (cls == null);
        if (f2 != null) {
            z = false;
        }
        if ((!z && !z2) && !isCancelled()) {
            this.f3425i = null;
            try {
                th = uVar instanceof f.b.b.f.a.e0.a ? ((f.b.b.f.a.e0.a) uVar).b() : null;
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
            } catch (Throwable th2) {
                th = th2;
            }
            if (th == null) {
                obj = f.b.a.c.b.o.b.D0(uVar);
                if (th != null) {
                    t(obj);
                    return;
                } else if (!cls.isInstance(th)) {
                    v(uVar);
                    return;
                } else {
                    try {
                        Object B = B(f2, th);
                        this.f3426j = null;
                        this.f3427k = null;
                        C(B);
                        return;
                    } catch (Throwable th3) {
                        try {
                            u(th3);
                            this.f3426j = null;
                            this.f3427k = null;
                            return;
                        } catch (Throwable th4) {
                            this.f3426j = null;
                            this.f3427k = null;
                            throw th4;
                        }
                    }
                }
            }
            obj = null;
            if (th != null) {
            }
        }
    }
}
