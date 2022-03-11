package f.b.a.a.a.r;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.y.c0;
import java.util.Objects;

public final /* synthetic */ class r implements View.OnClickListener {
    public final /* synthetic */ v3 b;
    public final /* synthetic */ c0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewModel f2267d;

    public /* synthetic */ r(v3 v3Var, c0 c0Var, ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.b = v3Var;
        this.c = c0Var;
        this.f2267d = shareDiagnosisViewModel;
    }

    public final void onClick(View view) {
        v3 v3Var = this.b;
        c0 c0Var = this.c;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.f2267d;
        Objects.requireNonNull(v3Var);
        boolean r0 = m.h.r0(c0Var);
        e.m.a.r m0 = v3Var.m0();
        if (r0) {
            ShareDiagnosisActivity.x(m0, shareDiagnosisViewModel);
        } else {
            m0.finish();
        }
    }
}
