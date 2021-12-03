package f.b.b.f.a;

import f.b.b.a.g;
import f.b.b.f.a.l;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public abstract class d<I, O, F, T> extends l.a<O> implements Runnable {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f3127k = 0;

    /* renamed from: i  reason: collision with root package name */
    public u<? extends I> f3128i;

    /* renamed from: j  reason: collision with root package name */
    public F f3129j;

    public static final class a<I, O> extends d<I, O, i<? super I, ? extends O>, u<? extends O>> {
        public a(u<? extends I> uVar, i<? super I, ? extends O> iVar) {
            super(uVar, iVar);
        }

        @Override // f.b.b.f.a.d
        public Object B(Object obj, Object obj2) {
            i iVar = (i) obj;
            u<O> a = iVar.a(obj2);
            f.b.a.c.b.o.b.A(a, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", iVar);
            return a;
        }

        @Override // f.b.b.f.a.d
        public void C(Object obj) {
            v((u) obj);
        }
    }

    public static final class b<I, O> extends d<I, O, g<? super I, ? extends O>, O> {
        public b(u<? extends I> uVar, g<? super I, ? extends O> gVar) {
            super(uVar, gVar);
        }

        @Override // f.b.b.f.a.d
        public Object B(Object obj, Object obj2) {
            return ((g) obj).a(obj2);
        }

        @Override // f.b.b.f.a.d
        public void C(O o) {
            t(o);
        }
    }

    public d(u<? extends I> uVar, F f2) {
        Objects.requireNonNull(uVar);
        this.f3128i = uVar;
        Objects.requireNonNull(f2);
        this.f3129j = f2;
    }

    public abstract T B(F f2, I i2);

    public abstract void C(T t);

    @Override // f.b.b.f.a.b
    public final void j() {
        q(this.f3128i);
        this.f3128i = null;
        this.f3129j = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        String str;
        u<? extends I> uVar = this.f3128i;
        F f2 = this.f3129j;
        String r = super.r();
        if (uVar != null) {
            str = "inputFuture=[" + uVar + "], ";
        } else {
            str = "";
        }
        if (f2 != null) {
            return str + "function=[" + ((Object) f2) + "]";
        } else if (r != null) {
            return f.a.a.a.a.c(str, r);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: f.b.b.f.a.d<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void run() {
        u<? extends I> uVar = this.f3128i;
        F f2 = this.f3129j;
        boolean z = true;
        boolean isCancelled = isCancelled() | (uVar == null);
        if (f2 != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.f3128i = null;
            if (uVar.isCancelled()) {
                v(uVar);
                return;
            }
            try {
                try {
                    Object B = B(f2, f.b.a.c.b.o.b.A0(uVar));
                    this.f3129j = null;
                    C(B);
                } catch (Throwable th) {
                    this.f3129j = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e2) {
                u(e2.getCause());
            } catch (RuntimeException e3) {
                u(e3);
            } catch (Error e4) {
                u(e4);
            }
        }
    }
}
