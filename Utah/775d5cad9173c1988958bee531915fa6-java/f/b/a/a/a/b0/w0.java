package f.b.a.a.a.b0;

import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import f.b.a.a.a.s.x;
import f.b.a.a.a.y.e0;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class w0 implements i {
    public final /* synthetic */ SmsVerificationWorker a;
    public final /* synthetic */ String b;

    public /* synthetic */ w0(SmsVerificationWorker smsVerificationWorker, String str) {
        this.a = smsVerificationWorker;
        this.b = str;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        SmsVerificationWorker smsVerificationWorker = this.a;
        String str = this.b;
        Objects.requireNonNull(smsVerificationWorker);
        if (!((List) obj).isEmpty()) {
            return new s.a(new SmsVerificationWorker.c(null));
        }
        return smsVerificationWorker.f384i.b(e0.i(str, x.a(smsVerificationWorker.n)).a());
    }
}
