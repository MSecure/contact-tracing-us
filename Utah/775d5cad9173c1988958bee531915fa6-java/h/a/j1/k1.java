package h.a.j1;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.b.a.v;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class k1 implements Runnable {
    public static final Logger c = Logger.getLogger(k1.class.getName());
    public final Runnable b;

    public k1(Runnable runnable) {
        b.z(runnable, "task");
        this.b = runnable;
    }

    public void run() {
        try {
            this.b.run();
        } catch (Throwable th) {
            Logger logger = c;
            Level level = Level.SEVERE;
            StringBuilder h2 = a.h("Exception while executing runnable ");
            h2.append(this.b);
            logger.log(level, h2.toString(), th);
            v.c(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        StringBuilder h2 = a.h("LogExceptionRunnable(");
        h2.append(this.b);
        h2.append(")");
        return h2.toString();
    }
}
