package e.a.a.f;

import android.view.View;
import gov.michigan.MiCovidExposure.notify.ShareDiagnosisOnsetDateFragment;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;

/* compiled from: lambda */
public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisOnsetDateFragment f6363b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExposureNotificationSharedPreferences f6364c;

    public /* synthetic */ s(ShareDiagnosisOnsetDateFragment shareDiagnosisOnsetDateFragment, ExposureNotificationSharedPreferences exposureNotificationSharedPreferences) {
        this.f6363b = shareDiagnosisOnsetDateFragment;
        this.f6364c = exposureNotificationSharedPreferences;
    }

    public final void onClick(View view) {
        this.f6363b.d(this.f6364c, view);
    }
}
