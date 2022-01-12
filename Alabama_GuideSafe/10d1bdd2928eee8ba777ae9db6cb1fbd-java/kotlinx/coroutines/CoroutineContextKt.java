package kotlinx.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;

/* compiled from: CoroutineContext.kt */
public final class CoroutineContextKt {
    public static final boolean useCoroutinesScheduler;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0.equals("on") != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r0.equals("") != false) goto L_0x0033;
     */
    static {
        boolean z;
        String systemProp = SystemPropsKt__SystemPropsKt.systemProp("kotlinx.coroutines.scheduler");
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode == 109935 && systemProp.equals("off")) {
                        z = false;
                        useCoroutinesScheduler = z;
                    }
                }
            }
            throw new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + systemProp + '\'').toString());
        }
        z = true;
        useCoroutinesScheduler = z;
    }

    public static final String getCoroutineName(CoroutineContext coroutineContext) {
        CoroutineId coroutineId;
        if (!DebugKt.DEBUG || (coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.Key)) == null) {
            return null;
        }
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        return "coroutine" + '#' + coroutineId.id;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        CoroutineContext plus2 = DebugKt.DEBUG ? plus.plus(new CoroutineId(DebugKt.COROUTINE_ID.incrementAndGet())) : plus;
        return (plus == Dispatchers.Default || plus.get(ContinuationInterceptor.Key) != null) ? plus2 : plus2.plus(Dispatchers.Default);
    }
}
