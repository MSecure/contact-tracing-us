package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;

/* compiled from: Debug.kt */
public final class DebugKt {
    public static final boolean ASSERTIONS_ENABLED = CoroutineId.class.desiredAssertionStatus();
    public static final AtomicLong COROUTINE_ID = new AtomicLong(0);
    public static final boolean DEBUG;
    public static final boolean RECOVER_STACK_TRACES;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r0.equals("auto") != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r0.equals("on") != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r0.equals("") != false) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    static {
        boolean z;
        String systemProp = SystemPropsKt__SystemPropsKt.systemProp("kotlinx.coroutines.debug");
        boolean z2 = false;
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode != 109935) {
                        if (hashCode == 3005871) {
                        }
                    } else if (systemProp.equals("off")) {
                        z = false;
                        DEBUG = z;
                        if (z) {
                            String systemProp2 = SystemPropsKt__SystemPropsKt.systemProp("kotlinx.coroutines.stacktrace.recovery");
                            if (systemProp2 != null ? Boolean.parseBoolean(systemProp2) : true) {
                                z2 = true;
                            }
                        }
                        RECOVER_STACK_TRACES = z2;
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + systemProp + '\'').toString());
            }
            z = true;
            DEBUG = z;
            if (z) {
            }
            RECOVER_STACK_TRACES = z2;
        }
        z = ASSERTIONS_ENABLED;
        DEBUG = z;
        if (z) {
        }
        RECOVER_STACK_TRACES = z2;
    }
}
