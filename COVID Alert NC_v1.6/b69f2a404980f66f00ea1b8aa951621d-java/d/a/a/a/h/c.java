package d.a.a.a.h;

import gov.nc.dhhs.exposurenotification.notify.NotifyHomeFragment;
import gov.nc.dhhs.exposurenotification.notify.PositiveDiagnosisEntityAdapter;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class c implements PositiveDiagnosisEntityAdapter.OnPositiveDiagnosisClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotifyHomeFragment f4711a;

    public /* synthetic */ c(NotifyHomeFragment notifyHomeFragment) {
        this.f4711a = notifyHomeFragment;
    }

    @Override // gov.nc.dhhs.exposurenotification.notify.PositiveDiagnosisEntityAdapter.OnPositiveDiagnosisClickListener
    public final void onClick(PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.f4711a.i(positiveDiagnosisEntity);
    }
}
