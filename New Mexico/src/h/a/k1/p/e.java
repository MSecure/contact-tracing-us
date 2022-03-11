package h.a.k1.p;

import f.a.a.a.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class e<T> {
    public final Class<?> a;
    public final String b;
    public final Class[] c;

    public e(Class<?> cls, String str, Class... clsArr) {
        this.a = cls;
        this.b = str;
        this.c = clsArr;
    }

    public static Method b(Class<?> cls, String str, Class[] clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            if ((cls.getModifiers() & 1) == 0) {
                return b(cls.getSuperclass(), str, clsArr);
            }
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public final Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.b;
        if (str == null) {
            return null;
        }
        Method b = b(cls, str, this.c);
        if (b == null || (cls2 = this.a) == null || cls2.isAssignableFrom(b.getReturnType())) {
            return b;
        }
        return null;
    }

    public Object c(T t, Object... objArr) {
        Method a = a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e2) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e2);
                throw assertionError;
            }
        } else {
            StringBuilder h2 = a.h("Method ");
            h2.append(this.b);
            h2.append(" not supported for object ");
            h2.append(t);
            throw new AssertionError(h2.toString());
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            Method a = a(t.getClass());
            if (a != null) {
                try {
                } catch (IllegalAccessException unused) {
                    return null;
                }
            }
            return a.invoke(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object e(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
