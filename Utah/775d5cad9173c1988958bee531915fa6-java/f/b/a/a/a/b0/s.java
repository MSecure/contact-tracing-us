package f.b.a.a.a.b0;

import android.text.TextUtils;
import com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker;
import f.b.a.a.a.y.e0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class s implements i {
    public final /* synthetic */ PreAuthTEKsReceivedWorker a;

    public /* synthetic */ s(PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker) {
        this.a = preAuthTEKsReceivedWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker = this.a;
        e0 e0Var = (e0) obj;
        Objects.requireNonNull(preAuthTEKsReceivedWorker);
        return TextUtils.isEmpty(e0Var.a()) ? preAuthTEKsReceivedWorker.f371h.c(e0Var) : b.Q0(e0Var);
    }
}
