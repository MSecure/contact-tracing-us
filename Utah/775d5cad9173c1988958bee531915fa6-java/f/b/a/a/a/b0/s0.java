package f.b.a.a.a.b0;

import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import f.b.a.a.a.l0.b;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.l0.i0;
import f.b.a.a.a.l0.k;
import f.b.a.a.a.y.e0;
import f.b.b.f.a.d0;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class s0 implements i {
    public final /* synthetic */ SmsVerificationWorker a;
    public final /* synthetic */ String b;

    public /* synthetic */ s0(SmsVerificationWorker smsVerificationWorker, String str) {
        this.a = smsVerificationWorker;
        this.b = str;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        SmsVerificationWorker smsVerificationWorker = this.a;
        String str = this.b;
        e0 e0Var = (e0) obj;
        Objects.requireNonNull(smsVerificationWorker);
        k.b bVar = (k.b) h0.q();
        bVar.f2301d = str;
        bVar.e(false);
        bVar.f(true);
        bVar.c = h0.c.NOT_ATTEMPTED;
        bVar.f2302e = e0Var.h();
        if (e0Var.o() != null) {
            bVar.g(true);
            bVar.f2305h = e0Var.o();
            bVar.c(h0.b.YES);
        }
        if (e0Var.p() != null) {
            bVar.f2304g = h0.d.a(e0Var.p());
        }
        smsVerificationWorker.q.s(smsVerificationWorker.p.c());
        i0 i0Var = smsVerificationWorker.f383h;
        b bVar2 = new b(i0Var, bVar.a());
        ExecutorService executorService = i0Var.b;
        d0 d0Var = new d0(bVar2);
        executorService.execute(d0Var);
        return d0Var;
    }
}
