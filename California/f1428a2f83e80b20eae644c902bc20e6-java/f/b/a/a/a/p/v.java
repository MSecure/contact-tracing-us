package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class v implements View.OnClickListener {
    public final /* synthetic */ j3 b;
    public final /* synthetic */ ShareDiagnosisViewModel c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b0 f2191d;

    public /* synthetic */ v(j3 j3Var, ShareDiagnosisViewModel shareDiagnosisViewModel, b0 b0Var) {
        this.b = j3Var;
        this.c = shareDiagnosisViewModel;
        this.f2191d = b0Var;
    }

    public final void onClick(View view) {
        j3 j3Var = this.b;
        this.c.f(n3.a(ShareDiagnosisViewModel.e.BEGIN, this.f2191d, j3Var.W));
    }
}
