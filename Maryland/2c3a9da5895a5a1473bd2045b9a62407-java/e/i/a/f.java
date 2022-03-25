package e.i.a;

import android.util.Log;
import java.lang.reflect.Method;

public class f implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public f(Object obj, Object obj2) {
        this.b = obj;
        this.c = obj2;
    }

    public void run() {
        Boolean bool = Boolean.FALSE;
        try {
            Method method = g.f1398d;
            if (method != null) {
                method.invoke(this.b, this.c, bool, "AppCompat recreation");
                return;
            }
            g.f1399e.invoke(this.b, this.c, bool);
        } catch (RuntimeException e2) {
            if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                throw e2;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
