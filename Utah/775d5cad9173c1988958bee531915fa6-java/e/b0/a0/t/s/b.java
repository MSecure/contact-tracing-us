package e.b0.a0.t.s;

import java.util.concurrent.Executor;

public enum b implements Executor {
    INSTANCE;

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "DirectExecutor";
    }
}
