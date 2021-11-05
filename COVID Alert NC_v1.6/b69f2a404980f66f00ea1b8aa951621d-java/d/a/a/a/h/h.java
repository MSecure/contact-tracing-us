package d.a.a.a.h;

import android.view.View;
import gov.nc.dhhs.exposurenotification.notify.PositiveDiagnosisEntityAdapter;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PositiveDiagnosisEntityAdapter.PositiveDiagnosisViewHolder f4722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PositiveDiagnosisEntity f4723c;

    public /* synthetic */ h(PositiveDiagnosisEntityAdapter.PositiveDiagnosisViewHolder positiveDiagnosisViewHolder, PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.f4722b = positiveDiagnosisViewHolder;
        this.f4723c = positiveDiagnosisEntity;
    }

    public final void onClick(View view) {
        this.f4722b.a(this.f4723c, view);
    }
}
