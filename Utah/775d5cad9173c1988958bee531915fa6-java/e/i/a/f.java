package e.i.a;

import java.lang.reflect.Method;

public class f implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public f(Object obj, Object obj2) {
        this.b = obj;
        this.c = obj2;
    }

    public void run() {
        try {
            Method method = e.f1447d;
            if (method != null) {
                method.invoke(this.b, this.c, Boolean.FALSE, "AppCompat recreation");
                return;
            }
            e.f1448e.invoke(this.b, this.c, Boolean.FALSE);
        } catch (RuntimeException e2) {
            if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                throw e2;
            }
        } catch (Throwable unused) {
        }
    }
}
