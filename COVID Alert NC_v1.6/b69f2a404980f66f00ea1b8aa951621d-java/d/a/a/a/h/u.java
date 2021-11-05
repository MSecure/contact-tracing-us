package d.a.a.a.h;

import android.view.View;
import gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisOnsetDateFragment;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;

/* compiled from: lambda */
public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisOnsetDateFragment f4753b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExposureNotificationSharedPreferences f4754c;

    public /* synthetic */ u(ShareDiagnosisOnsetDateFragment shareDiagnosisOnsetDateFragment, ExposureNotificationSharedPreferences exposureNotificationSharedPreferences) {
        this.f4753b = shareDiagnosisOnsetDateFragment;
        this.f4754c = exposureNotificationSharedPreferences;
    }

    public final void onClick(View view) {
        this.f4753b.d(this.f4754c, view);
    }
}
