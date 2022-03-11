package e.c0.a0.t.s;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public enum b implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "DirectExecutor";
    }
}
