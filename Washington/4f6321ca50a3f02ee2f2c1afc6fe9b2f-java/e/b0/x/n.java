package e.b0.x;

import androidx.work.ListenableWorker;
import e.b0.l;
import e.b0.x.t.p.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class n implements Runnable {
    public final /* synthetic */ c b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1035d;

    public n(o oVar, c cVar, String str) {
        this.f1035d = oVar;
        this.b = cVar;
        this.c = str;
    }

    public void run() {
        try {
            ListenableWorker.a aVar = (ListenableWorker.a) this.b.get();
            if (aVar == null) {
                l.c().b(o.u, String.format("%s returned a null result. Treating it as a failure.", this.f1035d.f1038f.c), new Throwable[0]);
            } else {
                l.c().a(o.u, String.format("%s returned a %s result.", this.f1035d.f1038f.c, aVar), new Throwable[0]);
                this.f1035d.f1040h = aVar;
            }
        } catch (CancellationException e2) {
            l.c().d(o.u, String.format("%s was cancelled", this.c), e2);
        } catch (InterruptedException | ExecutionException e3) {
            l.c().b(o.u, String.format("%s failed because it threw an exception/error", this.c), e3);
        } catch (Throwable th) {
            this.f1035d.c();
            throw th;
        }
        this.f1035d.c();
    }
}
