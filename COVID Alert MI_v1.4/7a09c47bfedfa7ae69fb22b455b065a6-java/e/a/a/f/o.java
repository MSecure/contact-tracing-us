package e.a.a.f;

import android.view.View;
import gov.michigan.MiCovidExposure.notify.ShareDiagnosisOnsetDateFragment;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;

/* compiled from: lambda */
public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisOnsetDateFragment f6355b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExposureNotificationSharedPreferences f6356c;

    public /* synthetic */ o(ShareDiagnosisOnsetDateFragment shareDiagnosisOnsetDateFragment, ExposureNotificationSharedPreferences exposureNotificationSharedPreferences) {
        this.f6355b = shareDiagnosisOnsetDateFragment;
        this.f6356c = exposureNotificationSharedPreferences;
    }

    public final void onClick(View view) {
        this.f6355b.e(this.f6356c, view);
    }
}
