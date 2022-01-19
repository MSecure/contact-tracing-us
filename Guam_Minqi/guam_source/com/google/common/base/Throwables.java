package com.google.common.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Throwables {
    public static final Object jla;

    static {
        Object jla2 = getJLA();
        jla = jla2;
        if (jla2 != null) {
            getJlaMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (jla != null) {
            try {
                Method jlaMethod = getJlaMethod("getStackTraceDepth", Throwable.class);
                if (jlaMethod != null) {
                    jlaMethod.invoke(getJLA(), new Throwable());
                }
            } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            }
        }
    }

    public static Object getJLA() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method getJlaMethod(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void throwIfUnchecked(Throwable th) {
        if (th == null) {
            throw null;
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
