package b.z.y;

import android.annotation.SuppressLint;
import androidx.work.ListenableWorker;
import b.z.y.s.r.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f1976b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1977c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f1978d;

    public m(n nVar, c cVar, String str) {
        this.f1978d = nVar;
        this.f1976b = cVar;
        this.f1977c = str;
    }

    @SuppressLint({"SyntheticAccessor"})
    public void run() {
        try {
            ListenableWorker.a aVar = (ListenableWorker.a) this.f1976b.get();
            if (aVar == null) {
                b.z.m.c().b(n.u, String.format("%s returned a null result. Treating it as a failure.", this.f1978d.f.f2093c), new Throwable[0]);
            } else {
                b.z.m.c().a(n.u, String.format("%s returned a %s result.", this.f1978d.f.f2093c, aVar), new Throwable[0]);
                this.f1978d.h = aVar;
            }
        } catch (CancellationException e2) {
            b.z.m.c().d(n.u, String.format("%s was cancelled", this.f1977c), e2);
        } catch (InterruptedException | ExecutionException e3) {
            b.z.m.c().b(n.u, String.format("%s failed because it threw an exception/error", this.f1977c), e3);
        } catch (Throwable th) {
            this.f1978d.c();
            throw th;
        }
        this.f1978d.c();
    }
}
