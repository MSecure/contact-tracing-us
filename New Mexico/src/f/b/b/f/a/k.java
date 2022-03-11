package f.b.b.f.a;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public enum k implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
