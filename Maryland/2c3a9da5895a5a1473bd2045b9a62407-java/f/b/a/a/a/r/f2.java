package f.b.a.a.a.r;

import android.os.CancellationSignal;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.t.n.d;
import f.b.a.a.a.y.b0;
import f.b.a.a.a.y.v;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class f2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ f2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        v vVar = (v) shareDiagnosisViewModel.c.a;
        Objects.requireNonNull(vVar);
        e.t.i v = e.t.i.v("SELECT revisionToken FROM RevisionTokenEntity WHERE revisionToken IS NOT NULL ORDER BY createdTimestampMs DESC LIMIT 1", 0);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return l.x(d.a(vVar.a, false, new b0(vVar, v, cancellationSignal), v, true, cancellationSignal)).y(new c3((f.b.a.a.a.n.u) obj), shareDiagnosisViewModel.q);
    }
}
