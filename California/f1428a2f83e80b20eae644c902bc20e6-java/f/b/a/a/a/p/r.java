package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.m.a.o;
import f.b.a.a.a.w.b0;
import java.util.Objects;

public final /* synthetic */ class r implements View.OnClickListener {
    public final /* synthetic */ j3 b;
    public final /* synthetic */ b0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewModel f2187d;

    public /* synthetic */ r(j3 j3Var, b0 b0Var, ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.b = j3Var;
        this.c = b0Var;
        this.f2187d = shareDiagnosisViewModel;
    }

    public final void onClick(View view) {
        j3 j3Var = this.b;
        b0 b0Var = this.c;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.f2187d;
        Objects.requireNonNull(j3Var);
        boolean q0 = m.h.q0(b0Var);
        o m0 = j3Var.m0();
        if (q0) {
            ShareDiagnosisActivity.w(m0, shareDiagnosisViewModel);
        } else {
            m0.finish();
        }
    }
}
