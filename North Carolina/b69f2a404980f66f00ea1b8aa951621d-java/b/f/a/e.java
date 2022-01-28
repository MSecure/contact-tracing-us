package b.f.a;

import b.f.a.a;
import c.b.b.e.a.u;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class e<T> implements u<T> {

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<b<T>> f861b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f862c = new a();

    public class a extends a<T> {
        public a() {
        }

        @Override // b.f.a.a
        public String i() {
            b<T> bVar = e.this.f861b.get();
            if (bVar == null) {
                return "Completer object has been garbage collected, future will fail soon";
            }
            StringBuilder g = c.a.a.a.a.g("tag=[");
            g.append(bVar.f857a);
            g.append("]");
            return g.toString();
        }
    }

    public e(b<T> bVar) {
        this.f861b = new WeakReference<>(bVar);
    }

    @Override // c.b.b.e.a.u
    public void b(Runnable runnable, Executor executor) {
        this.f862c.b(runnable, executor);
    }

    public boolean cancel(boolean z) {
        b<T> bVar = this.f861b.get();
        boolean cancel = this.f862c.cancel(z);
        if (cancel && bVar != null) {
            bVar.f857a = null;
            bVar.f858b = null;
            bVar.f859c.k(null);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.f862c.get();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return this.f862c.get(j, timeUnit);
    }

    public boolean isCancelled() {
        return this.f862c.f835b instanceof a.c;
    }

    public boolean isDone() {
        return this.f862c.isDone();
    }

    public String toString() {
        return this.f862c.toString();
    }
}
