package d.a.a.a.h;

import android.content.DialogInterface;
import gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisViewFragment;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class f0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewFragment f4718b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PositiveDiagnosisEntity f4719c;

    public /* synthetic */ f0(ShareDiagnosisViewFragment shareDiagnosisViewFragment, PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.f4718b = shareDiagnosisViewFragment;
        this.f4719c = positiveDiagnosisEntity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f4718b.d(this.f4719c, dialogInterface, i);
    }
}
