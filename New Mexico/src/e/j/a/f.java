package e.j.a;

import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class f implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public f(Object obj, Object obj2) {
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Method method = e.f1531d;
            if (method != null) {
                method.invoke(this.b, this.c, Boolean.FALSE, "AppCompat recreation");
            } else {
                e.f1532e.invoke(this.b, this.c, Boolean.FALSE);
            }
        } catch (RuntimeException e2) {
            if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                throw e2;
            }
        } catch (Throwable unused) {
        }
    }
}
