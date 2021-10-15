package b.b0.y;

import android.annotation.SuppressLint;
import androidx.work.ListenableWorker;
import b.b0.y.s.r.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f1103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1104c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f1105d;

    public m(n nVar, c cVar, String str) {
        this.f1105d = nVar;
        this.f1103b = cVar;
        this.f1104c = str;
    }

    @SuppressLint({"SyntheticAccessor"})
    public void run() {
        try {
            ListenableWorker.a aVar = (ListenableWorker.a) this.f1103b.get();
            if (aVar == null) {
                b.b0.m.c().b(n.u, String.format("%s returned a null result. Treating it as a failure.", this.f1105d.f1110f.f1236c), new Throwable[0]);
            } else {
                b.b0.m.c().a(n.u, String.format("%s returned a %s result.", this.f1105d.f1110f.f1236c, aVar), new Throwable[0]);
                this.f1105d.h = aVar;
            }
        } catch (CancellationException e2) {
            b.b0.m.c().d(n.u, String.format("%s was cancelled", this.f1104c), e2);
        } catch (InterruptedException | ExecutionException e3) {
            b.b0.m.c().b(n.u, String.format("%s failed because it threw an exception/error", this.f1104c), e3);
        } catch (Throwable th) {
            this.f1105d.c();
            throw th;
        }
        this.f1105d.c();
    }
}
