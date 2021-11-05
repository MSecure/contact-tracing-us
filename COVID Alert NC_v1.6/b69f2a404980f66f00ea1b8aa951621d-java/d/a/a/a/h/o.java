package d.a.a.a.h;

import android.view.View;
import gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisOnsetDateFragment;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;

/* compiled from: lambda */
public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisOnsetDateFragment f4742b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExposureNotificationSharedPreferences f4743c;

    public /* synthetic */ o(ShareDiagnosisOnsetDateFragment shareDiagnosisOnsetDateFragment, ExposureNotificationSharedPreferences exposureNotificationSharedPreferences) {
        this.f4742b = shareDiagnosisOnsetDateFragment;
        this.f4743c = exposureNotificationSharedPreferences;
    }

    public final void onClick(View view) {
        this.f4742b.e(this.f4743c, view);
    }
}
