package b.f.a;

import b.f.a.a;
import c.b.b.e.a.u;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class e<T> implements u<T> {

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<b<T>> f1448b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f1449c = new a();

    public class a extends a<T> {
        public a() {
        }

        @Override // b.f.a.a
        public String i() {
            b<T> bVar = e.this.f1448b.get();
            if (bVar == null) {
                return "Completer object has been garbage collected, future will fail soon";
            }
            StringBuilder h = c.a.a.a.a.h("tag=[");
            h.append(bVar.f1444a);
            h.append("]");
            return h.toString();
        }
    }

    public e(b<T> bVar) {
        this.f1448b = new WeakReference<>(bVar);
    }

    @Override // c.b.b.e.a.u
    public void b(Runnable runnable, Executor executor) {
        this.f1449c.b(runnable, executor);
    }

    public boolean cancel(boolean z) {
        b<T> bVar = this.f1448b.get();
        boolean cancel = this.f1449c.cancel(z);
        if (cancel && bVar != null) {
            bVar.f1444a = null;
            bVar.f1445b = null;
            bVar.f1446c.k(null);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.f1449c.get();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return this.f1449c.get(j, timeUnit);
    }

    public boolean isCancelled() {
        return this.f1449c.f1422b instanceof a.c;
    }

    public boolean isDone() {
        return this.f1449c.isDone();
    }

    public String toString() {
        return this.f1449c.toString();
    }
}
