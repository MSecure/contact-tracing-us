package j.i;

import j.j.b.e;
import java.lang.reflect.Method;

public class a {

    /* renamed from: j.i.a$a  reason: collision with other inner class name */
    public static final class C0147a {
        public static final Method a;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
            if (j.j.b.e.a(r6, java.lang.Throwable.class) != false) goto L_0x0040;
         */
        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            e.b(methods, "throwableMethods");
            int length = methods.length;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                e.b(method2, "it");
                boolean z = true;
                if (e.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    e.b(parameterTypes, "it.parameterTypes");
                    e.c(parameterTypes, "$this$singleOrNull");
                    if (parameterTypes.length == 1) {
                        method = parameterTypes[0];
                    }
                }
                z = false;
                if (z) {
                    method = method2;
                    break;
                }
                i2++;
            }
            a = method;
            for (Method method3 : methods) {
                e.b(method3, "it");
                if (e.a(method3.getName(), "getSuppressed")) {
                    return;
                }
            }
        }
    }

    public void a(Throwable th, Throwable th2) {
        e.c(th, "cause");
        e.c(th2, "exception");
        Method method = C0147a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
