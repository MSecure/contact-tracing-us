package f.b.c.k.x;

import f.b.c.k.x.c;
import java.lang.Thread;

public final /* synthetic */ class e implements Thread.UncaughtExceptionHandler {
    public final c.ExecutorC0121c a;

    public e(c.ExecutorC0121c cVar) {
        this.a = cVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        c.this.c(th);
    }
}
