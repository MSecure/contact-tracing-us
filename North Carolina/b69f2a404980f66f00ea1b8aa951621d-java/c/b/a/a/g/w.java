package c.b.a.a.g;

import java.util.concurrent.CancellationException;

public final class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f2892b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v f2893c;

    public w(v vVar, h hVar) {
        this.f2893c = vVar;
        this.f2892b = hVar;
    }

    public final void run() {
        try {
            h<TContinuationResult> a2 = this.f2893c.f2890b.a((TResult) this.f2892b.f());
            if (a2 == null) {
                v vVar = this.f2893c;
                vVar.f2891c.h(new NullPointerException("Continuation returned null"));
                return;
            }
            a2.d(j.f2858b, this.f2893c);
            a2.c(j.f2858b, this.f2893c);
            a2.a(j.f2858b, this.f2893c);
        } catch (f e2) {
            if (e2.getCause() instanceof Exception) {
                this.f2893c.f2891c.h((Exception) e2.getCause());
                return;
            }
            this.f2893c.f2891c.h(e2);
        } catch (CancellationException unused) {
            this.f2893c.f2891c.j();
        } catch (Exception e3) {
            this.f2893c.f2891c.h(e3);
        }
    }
}
