package e.i.a;

import android.app.Application;
import e.i.a.g;

public class e implements Runnable {
    public final /* synthetic */ Application b;
    public final /* synthetic */ g.a c;

    public e(Application application, g.a aVar) {
        this.b = application;
        this.c = aVar;
    }

    public void run() {
        this.b.unregisterActivityLifecycleCallbacks(this.c);
    }
}
