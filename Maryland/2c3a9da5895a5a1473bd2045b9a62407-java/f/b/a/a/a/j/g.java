package f.b.a.a.a.j;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.m.a.r;
import f.b.a.a.a.y.c0;
import java.util.Objects;

public final /* synthetic */ class g implements View.OnClickListener {
    public final /* synthetic */ p b;
    public final /* synthetic */ c0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewModel f2156d;

    public /* synthetic */ g(p pVar, c0 c0Var, ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.b = pVar;
        this.c = c0Var;
        this.f2156d = shareDiagnosisViewModel;
    }

    public final void onClick(View view) {
        p pVar = this.b;
        c0 c0Var = this.c;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.f2156d;
        Objects.requireNonNull(pVar);
        boolean r0 = m.h.r0(c0Var);
        r m0 = pVar.m0();
        if (r0) {
            ShareDiagnosisActivity.x(m0, shareDiagnosisViewModel);
        } else {
            m0.finish();
        }
    }
}
