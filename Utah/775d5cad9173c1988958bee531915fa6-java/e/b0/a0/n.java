package e.b0.a0;

import androidx.work.ListenableWorker;
import e.b0.a0.t.s.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class n implements Runnable {
    public final /* synthetic */ c b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1034d;

    public n(o oVar, c cVar, String str) {
        this.f1034d = oVar;
        this.b = cVar;
        this.c = str;
    }

    public void run() {
        try {
            ListenableWorker.a aVar = (ListenableWorker.a) this.b.get();
            if (aVar == null) {
                e.b0.n.c().b(o.u, String.format("%s returned a null result. Treating it as a failure.", this.f1034d.f1037f.c), new Throwable[0]);
            } else {
                e.b0.n.c().a(o.u, String.format("%s returned a %s result.", this.f1034d.f1037f.c, aVar), new Throwable[0]);
                this.f1034d.f1040i = aVar;
            }
        } catch (CancellationException e2) {
            e.b0.n.c().d(o.u, String.format("%s was cancelled", this.c), e2);
        } catch (InterruptedException | ExecutionException e3) {
            e.b0.n.c().b(o.u, String.format("%s failed because it threw an exception/error", this.c), e3);
        } catch (Throwable th) {
            this.f1034d.c();
            throw th;
        }
        this.f1034d.c();
    }
}
