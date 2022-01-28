package f.b.a.a.a.q;

import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import f.b.a.a.a.o.f0;
import f.b.a.a.a.o.h0;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import l.b.a.d;

public final /* synthetic */ class u0 implements i {
    public static final /* synthetic */ u0 a = new u0();

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        f0.d dVar = (f0.d) obj;
        d dVar2 = SmsVerificationWorker.p;
        if (h0.RATE_LIMITED.equals(dVar.b) || h0.SERVER_ERROR.equals(dVar.b)) {
            return new s.a(new SmsVerificationWorker.d(null));
        }
        return new s.a(new SmsVerificationWorker.b(null));
    }
}
