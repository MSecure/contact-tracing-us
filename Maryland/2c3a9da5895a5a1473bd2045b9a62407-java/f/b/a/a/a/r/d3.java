package f.b.a.a.a.r;

import android.util.Log;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.n.a;
import f.b.a.a.a.n.s;
import f.b.a.a.a.n.v;
import f.b.a.c.b.o.b;
import f.b.b.a.t;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class d3 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ d3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        f.b.a.a.a.n.u uVar = (f.b.a.a.a.n.u) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (!t.a(uVar.a())) {
            return b.d1(uVar);
        }
        v vVar = shareDiagnosisViewModel.f385d;
        Objects.requireNonNull(vVar);
        Log.i("UploadController", "Submitting keys for verification certificate...");
        s sVar = vVar.a;
        Objects.requireNonNull(sVar);
        return m.h.f0(new a(sVar, uVar));
    }
}
