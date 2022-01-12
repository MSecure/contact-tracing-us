package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformRandom.kt */
public abstract class AbstractPlatformRandom extends Random {
    @Override // kotlin.random.Random
    public int nextInt() {
        Object obj = ((FallbackThreadLocalRandom) this).implStorage.get();
        Intrinsics.checkNotNullExpressionValue(obj, "implStorage.get()");
        return ((Random) obj).nextInt();
    }
}
