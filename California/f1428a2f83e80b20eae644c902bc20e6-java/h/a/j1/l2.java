package h.a.j1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class l2 implements l1 {
    public static final Logger b = Logger.getLogger(l2.class.getName());
    public static final Constructor<?> c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f3640d;

    /* renamed from: e  reason: collision with root package name */
    public static final RuntimeException f3641e;
    public final Object a;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f A[ADDED_TO_REGION] */
    static {
        Constructor<?> constructor;
        Method method;
        Throwable th;
        RuntimeException runtimeException = null;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            int i2 = 0;
            method = cls.getMethod("add", Long.TYPE);
            try {
                cls.getMethod("sum", new Class[0]);
                Constructor<?>[] constructors = cls.getConstructors();
                int length = constructors.length;
                while (true) {
                    if (i2 >= length) {
                        constructor = null;
                        break;
                    }
                    constructor = constructors[i2];
                    if (constructor.getParameterTypes().length == 0) {
                        break;
                    }
                    i2++;
                }
                th = null;
            } catch (Throwable th2) {
                th = th2;
                b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                constructor = null;
                if (th == null) {
                }
                c = null;
                f3640d = null;
                runtimeException = new RuntimeException(th);
                f3641e = runtimeException;
            }
        } catch (Throwable th3) {
            th = th3;
            method = null;
            b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
            constructor = null;
            if (th == null) {
            }
            c = null;
            f3640d = null;
            runtimeException = new RuntimeException(th);
            f3641e = runtimeException;
        }
        if (th == null || constructor == null) {
            c = null;
            f3640d = null;
            runtimeException = new RuntimeException(th);
        } else {
            c = constructor;
            f3640d = method;
        }
        f3641e = runtimeException;
    }

    public l2() {
        RuntimeException runtimeException = f3641e;
        if (runtimeException == null) {
            try {
                this.a = c.newInstance(new Object[0]);
            } catch (InstantiationException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        } else {
            throw runtimeException;
        }
    }

    @Override // h.a.j1.l1
    public void a(long j2) {
        try {
            f3640d.invoke(this.a, Long.valueOf(j2));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }
}
