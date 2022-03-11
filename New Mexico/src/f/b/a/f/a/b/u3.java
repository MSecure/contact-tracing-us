package f.b.a.f.a.b;

import f.b.a.f.a.e.u;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class u3 implements u<Executor> {
    @Override // f.b.a.f.a.e.u
    public final Executor a() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(l3.b);
        Objects.requireNonNull(newSingleThreadExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return newSingleThreadExecutor;
    }
}
