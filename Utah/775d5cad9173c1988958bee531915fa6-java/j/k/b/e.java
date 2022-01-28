package j.k.b;

import f.a.a.a.a;
import j.g;
import java.util.Arrays;

public class e {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(a.w(str, " must not be null"));
            d(nullPointerException, e.class.getName());
            throw nullPointerException;
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str);
            d(nullPointerException, e.class.getName());
            throw nullPointerException;
        }
    }

    public static <T extends Throwable> T d(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }

    public static void e(String str) {
        g gVar = new g(a.c("lateinit property ", str, " has not been initialized"));
        d(gVar, e.class.getName());
        throw gVar;
    }
}
