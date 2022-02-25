package e.i.a;

import android.app.Application;
import e.i.a.e;

public class c implements Runnable {
    public final /* synthetic */ Application b;
    public final /* synthetic */ e.a c;

    public c(Application application, e.a aVar) {
        this.b = application;
        this.c = aVar;
    }

    public void run() {
        this.b.unregisterActivityLifecycleCallbacks(this.c);
    }
}
