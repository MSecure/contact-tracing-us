package c.b.a.a.j;

import java.util.concurrent.CancellationException;

public final class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f4144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x f4145c;

    public w(x xVar, i iVar) {
        this.f4145c = xVar;
        this.f4144b = iVar;
    }

    public final void run() {
        try {
            i<TContinuationResult> a2 = this.f4145c.f4147b.a((TResult) this.f4144b.f());
            if (a2 == null) {
                x xVar = this.f4145c;
                xVar.f4148c.h(new NullPointerException("Continuation returned null"));
                return;
            }
            a2.d(k.f4111b, this.f4145c);
            a2.c(k.f4111b, this.f4145c);
            a2.a(k.f4111b, this.f4145c);
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.f4145c.f4148c.h((Exception) e2.getCause());
                return;
            }
            this.f4145c.f4148c.h(e2);
        } catch (CancellationException unused) {
            this.f4145c.f4148c.j();
        } catch (Exception e3) {
            this.f4145c.f4148c.h(e3);
        }
    }
}
