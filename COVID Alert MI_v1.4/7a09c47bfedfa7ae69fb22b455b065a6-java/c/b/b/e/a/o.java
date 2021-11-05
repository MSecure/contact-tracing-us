package c.b.b.e.a;

import java.util.concurrent.Executor;

public abstract class o<V> extends n<V> implements u<V> {

    public static abstract class a<V> extends o<V> {

        /* renamed from: b  reason: collision with root package name */
        public final u<V> f4758b;

        public a(u<V> uVar) {
            if (uVar != null) {
                this.f4758b = uVar;
                return;
            }
            throw null;
        }
    }

    @Override // c.b.b.e.a.u
    public void b(Runnable runnable, Executor executor) {
        ((a) this).f4758b.b(runnable, executor);
    }
}
