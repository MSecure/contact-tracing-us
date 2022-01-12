package kotlin.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class Intrinsics {
    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(GeneratedOutlineSupport.outline10(str, " must not be null"));
            sanitizeStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException();
            sanitizeStackTrace(nullPointerException);
            throw nullPointerException;
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(GeneratedOutlineSupport.outline10(str, " must not be null"));
            sanitizeStackTrace(nullPointerException);
            throw nullPointerException;
        }
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(createParameterIsNullExceptionMessage(str));
            sanitizeStackTrace(nullPointerException);
            throw nullPointerException;
        }
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(createParameterIsNullExceptionMessage(str));
            sanitizeStackTrace(illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    public static String createParameterIsNullExceptionMessage(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static <T extends Throwable> T sanitizeStackTrace(T t) {
        sanitizeStackTrace(t, Intrinsics.class.getName());
        return t;
    }

    public static void throwNpe() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        sanitizeStackTrace(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(GeneratedOutlineSupport.outline11("lateinit property ", str, " has not been initialized"));
        sanitizeStackTrace(uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static <T extends Throwable> T sanitizeStackTrace(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
