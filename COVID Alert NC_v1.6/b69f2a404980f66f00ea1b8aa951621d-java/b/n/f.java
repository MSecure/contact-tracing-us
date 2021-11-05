package b.n;

import java.util.concurrent.atomic.AtomicReference;

public abstract class f {

    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED
    }

    public f() {
        new AtomicReference();
    }

    public abstract void a(h hVar);
}
