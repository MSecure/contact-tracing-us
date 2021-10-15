package e.a.a.f;

import gov.michigan.MiCovidExposure.notify.NotifyHomeFragment;
import gov.michigan.MiCovidExposure.notify.PositiveDiagnosisEntityAdapter;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class a implements PositiveDiagnosisEntityAdapter.OnPositiveDiagnosisClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotifyHomeFragment f6319a;

    public /* synthetic */ a(NotifyHomeFragment notifyHomeFragment) {
        this.f6319a = notifyHomeFragment;
    }

    @Override // gov.michigan.MiCovidExposure.notify.PositiveDiagnosisEntityAdapter.OnPositiveDiagnosisClickListener
    public final void onClick(PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.f6319a.i(positiveDiagnosisEntity);
    }
}
