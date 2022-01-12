package kotlin.random;

import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Random.kt */
public abstract class Random {
    public static final Default Default = new Default(null);
    public static final Random defaultRandom = new FallbackThreadLocalRandom();

    /* compiled from: Random.kt */
    public static final class Default extends Random {
        public Default(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }
    }

    static {
        if (PlatformImplementationsKt.IMPLEMENTATIONS != null) {
            return;
        }
        throw null;
    }

    public abstract int nextInt();
}
