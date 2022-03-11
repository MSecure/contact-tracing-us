package e.i.a;

import android.util.Log;
import java.lang.reflect.Method;

public class d implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public d(Object obj, Object obj2) {
        this.b = obj;
        this.c = obj2;
    }

    public void run() {
        Boolean bool = Boolean.FALSE;
        try {
            Method method = e.f1384d;
            if (method != null) {
                method.invoke(this.b, this.c, bool, "AppCompat recreation");
                return;
            }
            e.f1385e.invoke(this.b, this.c, bool);
        } catch (RuntimeException e2) {
            if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                throw e2;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
