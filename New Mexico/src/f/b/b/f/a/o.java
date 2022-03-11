package f.b.b.f.a;

import java.util.Objects;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class o<V> extends n<V> implements u<V> {

    /* loaded from: classes.dex */
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
