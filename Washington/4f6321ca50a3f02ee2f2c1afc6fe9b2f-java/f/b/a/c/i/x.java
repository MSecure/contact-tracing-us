package f.b.a.c.i;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public final class x implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ y c;

    public x(y yVar, h hVar) {
        this.c = yVar;
        this.b = hVar;
    }

    public final void run() {
        try {
            h a = this.c.b.a(this.b.k());
            if (a == null) {
                y yVar = this.c;
                yVar.c.p(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = j.b;
            a.g(executor, this.c);
            a.e(executor, this.c);
            a.b(executor, this.c);
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.c.c.p((Exception) e2.getCause());
                return;
            }
            this.c.c.p(e2);
        } catch (CancellationException unused) {
            this.c.c.r();
        } catch (Exception e3) {
            this.c.c.p(e3);
        }
    }
}
