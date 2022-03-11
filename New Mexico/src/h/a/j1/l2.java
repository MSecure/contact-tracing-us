package h.a.j1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class l2 implements l1 {
    public static final Logger b = Logger.getLogger(l2.class.getName());
    public static final Constructor<?> c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f4218d;

    /* renamed from: e  reason: collision with root package name */
    public static final RuntimeException f4219e;
    public final Object a;

    static {
        Constructor<?> constructor;
        Method method;
        Throwable th;
        Class<?> cls;
        int i2;
        RuntimeException runtimeException = null;
        try {
            cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            i2 = 0;
            method = cls.getMethod("add", Long.TYPE);
        } catch (Throwable th2) {
            th = th2;
            method = null;
        }
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
        } catch (Throwable th3) {
            th = th3;
            b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
            constructor = null;
            if (th == null) {
            }
            c = null;
            f4218d = null;
            runtimeException = new RuntimeException(th);
            f4219e = runtimeException;
        }
        if (th == null || constructor == null) {
            c = null;
            f4218d = null;
            runtimeException = new RuntimeException(th);
        } else {
            c = constructor;
            f4218d = method;
        }
        f4219e = runtimeException;
    }

    public l2() {
        RuntimeException runtimeException = f4219e;
        if (runtimeException == null) {
            try {
                this.a = c.newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InstantiationException e3) {
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
            f4218d.invoke(this.a, Long.valueOf(j2));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }
}
