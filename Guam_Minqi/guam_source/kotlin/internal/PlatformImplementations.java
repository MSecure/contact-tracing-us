package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformImplementations.kt */
public class PlatformImplementations {

    /* compiled from: PlatformImplementations.kt */
    public static final class ReflectThrowable {
        public static final Method addSuppressed;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r6, java.lang.Throwable.class) != false) goto L_0x0040;
         */
        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "throwableMethods");
            int length = methods.length;
            int i = 0;
            while (true) {
                method = null;
                if (i >= length) {
                    break;
                }
                Method method2 = methods[i];
                Intrinsics.checkNotNullExpressionValue(method2, "it");
                boolean z = true;
                if (Intrinsics.areEqual(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    Intrinsics.checkNotNullParameter(parameterTypes, "$this$singleOrNull");
                    if (parameterTypes.length == 1) {
                        method = parameterTypes[0];
                    }
                }
                z = false;
                if (z) {
                    method = method2;
                    break;
                }
                i++;
            }
            addSuppressed = method;
            for (Method method3 : methods) {
                Intrinsics.checkNotNullExpressionValue(method3, "it");
                if (Intrinsics.areEqual(method3.getName(), "getSuppressed")) {
                    return;
                }
            }
        }
    }

    public void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "cause");
        Intrinsics.checkNotNullParameter(th2, "exception");
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
