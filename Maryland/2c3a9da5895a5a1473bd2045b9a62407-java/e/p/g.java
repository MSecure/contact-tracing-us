package e.p;

import java.util.concurrent.atomic.AtomicReference;

public abstract class g {

    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static a b(b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal == 1) {
                return ON_CREATE;
            }
            if (ordinal == 2) {
                return ON_START;
            }
            if (ordinal != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public b a() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        return b.RESUMED;
                    }
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return b.DESTROYED;
                            }
                            throw new IllegalArgumentException(this + " has no target state");
                        }
                    }
                }
                return b.STARTED;
            }
            return b.CREATED;
        }
    }

    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED
    }

    public g() {
        new AtomicReference();
    }

    public abstract void a(i iVar);

    public abstract void b(i iVar);
}
