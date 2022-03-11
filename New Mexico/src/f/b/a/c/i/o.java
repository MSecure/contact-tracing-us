package f.b.a.c.i;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class o implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ m c;

    public o(m mVar, h hVar) {
        this.c = mVar;
        this.b = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            h hVar = (h) this.c.b.a(this.b);
            if (hVar == null) {
                m mVar = this.c;
                mVar.c.q(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = j.b;
            hVar.g(executor, this.c);
            hVar.e(executor, this.c);
            hVar.b(executor, this.c);
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.c.c.q((Exception) e2.getCause());
            } else {
                this.c.c.q(e2);
            }
        } catch (Exception e3) {
            this.c.c.q(e3);
        }
    }
}
