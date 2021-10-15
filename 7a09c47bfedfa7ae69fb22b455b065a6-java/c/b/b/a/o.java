package c.b.b.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f4677a;

    static {
        Object a2 = a();
        f4677a = a2;
        if (a2 != null) {
            b("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (f4677a != null) {
            try {
                Method b2 = b("getStackTraceDepth", Throwable.class);
                if (b2 != null) {
                    b2.invoke(a(), new Throwable());
                }
            } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            }
        }
    }

    public static Object a() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method b(String str, Class<?>... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(Throwable th) {
        if (th == null) {
            throw null;
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
