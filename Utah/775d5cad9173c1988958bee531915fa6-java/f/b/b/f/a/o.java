package f.b.b.f.a;

import java.util.Objects;
import java.util.concurrent.Executor;

public abstract class o<V> extends n<V> implements u<V> {

    public static abstract class a<V> extends o<V> {
        public final u<V> b;

        public a(u<V> uVar) {
            Objects.requireNonNull(uVar);
            this.b = uVar;
        }
    }

    @Override // f.b.b.f.a.u
    public void a(Runnable runnable, Executor executor) {
        ((a) this).b.a(runnable, executor);
    }
}
