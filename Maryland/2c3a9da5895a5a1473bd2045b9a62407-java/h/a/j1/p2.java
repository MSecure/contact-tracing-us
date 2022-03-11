package h.a.j1;

import f.b.a.c.b.o.b;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class p2 implements Executor {

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f3810d = Logger.getLogger(p2.class.getName());
    public boolean b;
    public ArrayDeque<Runnable> c;

    public final void a() {
        while (true) {
            Runnable poll = this.c.poll();
            if (poll != null) {
                try {
                    poll.run();
                } catch (Throwable th) {
                    Logger logger = f3810d;
                    Level level = Level.SEVERE;
                    logger.log(level, "Exception while executing runnable " + poll, th);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r6.c == null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r6.c != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r6.b = false;
     */
    public void execute(Runnable runnable) {
        b.A(runnable, "'task' must not be null.");
        if (!this.b) {
            this.b = true;
            try {
                runnable.run();
            } catch (Throwable th) {
                if (this.c != null) {
                    a();
                }
                this.b = false;
                throw th;
            }
        } else {
            if (this.c == null) {
                this.c = new ArrayDeque<>(4);
            }
            this.c.add(runnable);
        }
    }
}
