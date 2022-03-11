package f.b.a.a.a.p;

import android.os.CancellationSignal;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.t.n.d;
import f.b.a.a.a.l.t;
import f.b.a.a.a.w.a0;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class b2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ b2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        f.b.a.a.a.w.u uVar = (f.b.a.a.a.w.u) shareDiagnosisViewModel.c.a;
        Objects.requireNonNull(uVar);
        e.t.i v = e.t.i.v("SELECT revisionToken FROM RevisionTokenEntity WHERE revisionToken IS NOT NULL ORDER BY createdTimestampMs DESC LIMIT 1", 0);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return l.x(d.a(uVar.a, false, new a0(uVar, v, cancellationSignal), v, true, cancellationSignal)).y(new c2((t) obj), shareDiagnosisViewModel.o);
    }
}
