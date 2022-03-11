package e.g.a;

import e.g.a.a;
import f.b.b.f.a.u;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class e<T> implements u<T> {
    public final WeakReference<b<T>> b;
    public final a<T> c = new a();

    /* loaded from: classes.dex */
    public class a extends a<T> {
        public a() {
        }

        @Override // e.g.a.a
        public String g() {
            b<T> bVar = e.this.b.get();
            if (bVar == null) {
                return "Completer object has been garbage collected, future will fail soon";
            }
            StringBuilder h2 = f.a.a.a.a.h("tag=[");
            h2.append(bVar.a);
            h2.append("]");
            return h2.toString();
        }
    }

    public e(b<T> bVar) {
        this.b = new WeakReference<>(bVar);
    }

    @Override // f.b.b.f.a.u
    public void a(Runnable runnable, Executor executor) {
        this.c.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        b<T> bVar = this.b.get();
        boolean cancel = this.c.cancel(z);
        if (cancel && bVar != null) {
            bVar.a = null;
            bVar.b = null;
            bVar.c.i(null);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.c.get();
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) {
        return this.c.get(j2, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.c.b instanceof a.c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.c.isDone();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.c.toString();
    }
}
