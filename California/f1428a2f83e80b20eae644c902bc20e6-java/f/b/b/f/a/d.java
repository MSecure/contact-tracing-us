package f.b.b.f.a;

import f.b.b.a.g;
import f.b.b.f.a.l;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public abstract class d<I, O, F, T> extends l.a<O> implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public u<? extends I> f2931i;

    /* renamed from: j  reason: collision with root package name */
    public F f2932j;

    public static final class a<I, O> extends d<I, O, i<? super I, ? extends O>, u<? extends O>> {
        public a(u<? extends I> uVar, i<? super I, ? extends O> iVar) {
            super(uVar, iVar);
        }

        @Override // f.b.b.f.a.d
        public Object B(Object obj, Object obj2) {
            i iVar = (i) obj;
            u<O> a = iVar.a(obj2);
            f.b.a.c.b.o.b.B(a, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", iVar);
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
        this.f2931i = uVar;
        Objects.requireNonNull(f2);
        this.f2932j = f2;
    }

    public abstract T B(F f2, I i2);

    public abstract void C(T t);

    @Override // f.b.b.f.a.b
    public final void j() {
        q(this.f2931i);
        this.f2931i = null;
        this.f2932j = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        String str;
        u<? extends I> uVar = this.f2931i;
        F f2 = this.f2932j;
        String r = super.r();
        if (uVar != null) {
            str = "inputFuture=[" + uVar + "], ";
        } else {
            str = "";
        }
        if (f2 != null) {
            return str + "function=[" + ((Object) f2) + "]";
        } else if (r != null) {
            return f.a.a.a.a.t(str, r);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: f.b.b.f.a.d<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void run() {
        u<? extends I> uVar = this.f2931i;
        F f2 = this.f2932j;
        boolean z = true;
        boolean isCancelled = isCancelled() | (uVar == null);
        if (f2 != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.f2931i = null;
            if (uVar.isCancelled()) {
                v(uVar);
                return;
            }
            try {
                try {
                    Object B = B(f2, f.b.a.c.b.o.b.N0(uVar));
                    this.f2932j = null;
                    C(B);
                } catch (Throwable th) {
                    this.f2932j = null;
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
