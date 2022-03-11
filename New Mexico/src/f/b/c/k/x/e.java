package f.b.c.k.x;

import f.b.c.k.x.c;
import java.lang.Thread;
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Thread.UncaughtExceptionHandler {
    public final c.ExecutorC0122c a;

    public e(c.ExecutorC0122c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        c.this.c(th);
    }
}
