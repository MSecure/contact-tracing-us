package kotlin.random;

import java.util.Random;

/* compiled from: PlatformRandom.kt */
public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal<Random> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    public Random initialValue() {
        return new Random();
    }
}
