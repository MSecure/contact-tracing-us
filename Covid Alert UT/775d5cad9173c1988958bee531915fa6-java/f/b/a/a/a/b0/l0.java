package f.b.a.a.a.b0;

import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import e.b.a.m;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class l0 implements i {
    public final /* synthetic */ SmsVerificationWorker a;

    public /* synthetic */ l0(SmsVerificationWorker smsVerificationWorker) {
        this.a = smsVerificationWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        SmsVerificationWorker smsVerificationWorker = this.a;
        Objects.requireNonNull(smsVerificationWorker);
        if (!((Boolean) obj).booleanValue()) {
            return new s.a(new SmsVerificationWorker.b(null));
        }
        return m.e.m0(smsVerificationWorker.f382g.a.a(), SmsVerificationWorker.r, smsVerificationWorker.m);
    }
}
