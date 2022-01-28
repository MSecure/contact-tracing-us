package e.b0;

import f.a.a.a.a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b implements ThreadFactory {
    public final AtomicInteger b = new AtomicInteger(0);
    public final /* synthetic */ boolean c;

    public b(c cVar, boolean z) {
        this.c = z;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder h2 = a.h(this.c ? "WM.task-" : "androidx.work-");
        h2.append(this.b.incrementAndGet());
        return new Thread(runnable, h2.toString());
    }
}
