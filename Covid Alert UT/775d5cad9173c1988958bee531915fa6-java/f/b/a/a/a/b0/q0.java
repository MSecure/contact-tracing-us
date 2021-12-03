package f.b.a.a.a.b0;

import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import f.b.a.a.a.y.f0;
import f.b.a.c.b.o.b;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class q0 implements i {
    public final /* synthetic */ SmsVerificationWorker a;
    public final /* synthetic */ l b;

    public /* synthetic */ q0(SmsVerificationWorker smsVerificationWorker, l lVar) {
        this.a = smsVerificationWorker;
        this.b = lVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        SmsVerificationWorker smsVerificationWorker = this.a;
        l lVar = this.b;
        Void r6 = (Void) obj;
        Objects.requireNonNull(smsVerificationWorker);
        if (!lVar.b()) {
            return new s.a(new Exception());
        }
        String str = (String) lVar.a();
        f.b.b.f.a.l y = f.b.b.f.a.l.x(smsVerificationWorker.f383h.c(str)).z(new w0(smsVerificationWorker, str), smsVerificationWorker.f387l).z(new s0(smsVerificationWorker, str), smsVerificationWorker.f386k).y(t0.a, smsVerificationWorker.f387l);
        p0 p0Var = p0.a;
        ExecutorService executorService = smsVerificationWorker.f387l;
        a.C0108a aVar = new a.C0108a(y, f0.c.class, p0Var);
        y.a(aVar, b.j1(executorService, aVar));
        u0 u0Var = u0.a;
        ExecutorService executorService2 = smsVerificationWorker.f387l;
        a.C0108a aVar2 = new a.C0108a(aVar, f0.d.class, u0Var);
        aVar.a(aVar2, b.j1(executorService2, aVar2));
        return aVar2;
    }
}
