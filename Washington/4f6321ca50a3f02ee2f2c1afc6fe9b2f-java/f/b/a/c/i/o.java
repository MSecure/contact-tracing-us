package f.b.a.c.i;

import java.util.concurrent.Executor;

public final class o implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ m c;

    public o(m mVar, h hVar) {
        this.c = mVar;
        this.b = hVar;
    }

    public final void run() {
        try {
            h<TContinuationResult> a = this.c.b.a(this.b);
            if (a == null) {
                m mVar = this.c;
                mVar.c.p(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = j.b;
            a.g(executor, this.c);
            a.e(executor, this.c);
            a.b(executor, this.c);
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.c.c.p((Exception) e2.getCause());
            } else {
                this.c.c.p(e2);
            }
        } catch (Exception e3) {
            this.c.c.p(e3);
        }
    }
}
