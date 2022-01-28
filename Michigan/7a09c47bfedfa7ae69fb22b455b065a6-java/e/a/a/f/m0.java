package e.a.a.f;

import android.view.View;
import gov.michigan.MiCovidExposure.notify.ShareDiagnosisViewFragment;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class m0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewFragment f6350b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PositiveDiagnosisEntity f6351c;

    public /* synthetic */ m0(ShareDiagnosisViewFragment shareDiagnosisViewFragment, PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.f6350b = shareDiagnosisViewFragment;
        this.f6351c = positiveDiagnosisEntity;
    }

    public final void onClick(View view) {
        this.f6350b.h(this.f6351c, view);
    }
}
