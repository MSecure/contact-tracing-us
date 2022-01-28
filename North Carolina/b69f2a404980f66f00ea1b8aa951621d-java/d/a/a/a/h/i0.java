package d.a.a.a.h;

import android.view.View;
import gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisViewFragment;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class i0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewFragment f4726b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PositiveDiagnosisEntity f4727c;

    public /* synthetic */ i0(ShareDiagnosisViewFragment shareDiagnosisViewFragment, PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.f4726b = shareDiagnosisViewFragment;
        this.f4727c = positiveDiagnosisEntity;
    }

    public final void onClick(View view) {
        this.f4726b.h(this.f4727c, view);
    }
}
