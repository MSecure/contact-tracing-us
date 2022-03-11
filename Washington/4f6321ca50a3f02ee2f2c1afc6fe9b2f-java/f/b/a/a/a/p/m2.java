package f.b.a.a.a.p;

import android.util.Log;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.l.a;
import f.b.a.a.a.l.r;
import f.b.a.a.a.l.t;
import f.b.a.c.b.o.b;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class m2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ m2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        t tVar = (t) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (!b.i1(tVar.a())) {
            return b.c1(tVar);
        }
        f.b.a.a.a.l.u uVar = shareDiagnosisViewModel.f371d;
        Objects.requireNonNull(uVar);
        Log.i("UploadController", "Submitting keys for verification certificate...");
        r rVar = uVar.a;
        Objects.requireNonNull(rVar);
        return m.h.f0(new a(rVar, tVar));
    }
}
