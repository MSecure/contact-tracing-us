package e.a.a.f;

import android.content.DialogInterface;
import gov.michigan.MiCovidExposure.notify.ShareDiagnosisViewFragment;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class n0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewFragment f6353b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PositiveDiagnosisEntity f6354c;

    public /* synthetic */ n0(ShareDiagnosisViewFragment shareDiagnosisViewFragment, PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.f6353b = shareDiagnosisViewFragment;
        this.f6354c = positiveDiagnosisEntity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f6353b.d(this.f6354c, dialogInterface, i);
    }
}
