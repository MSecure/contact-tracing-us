package kotlin.coroutines.intrinsics;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: Intrinsics.kt */
public final class CoroutineSingletons extends Enum<CoroutineSingletons> {
    public static final /* synthetic */ CoroutineSingletons[] $VALUES;
    public static final CoroutineSingletons COROUTINE_SUSPENDED;

    static {
        CoroutineSingletons coroutineSingletons = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
        COROUTINE_SUSPENDED = coroutineSingletons;
        $VALUES = new CoroutineSingletons[]{coroutineSingletons, new CoroutineSingletons("UNDECIDED", 1), new CoroutineSingletons("RESUMED", 2)};
    }

    public CoroutineSingletons(String str, int i) {
    }

    public static CoroutineSingletons valueOf(String str) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, str);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) $VALUES.clone();
    }
}
