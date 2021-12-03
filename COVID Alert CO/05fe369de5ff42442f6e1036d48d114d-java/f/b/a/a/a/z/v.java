package f.b.a.a.a.z;

import android.widget.CompoundButton;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;

public final /* synthetic */ class v implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PrivateAnalyticsViewModel a;

    public /* synthetic */ v(PrivateAnalyticsViewModel privateAnalyticsViewModel) {
        this.a = privateAnalyticsViewModel;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        PrivateAnalyticsViewModel privateAnalyticsViewModel = this.a;
        int i2 = a1.b0;
        privateAnalyticsViewModel.c.a.edit().remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_EXPOSURE_TIME").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_REPORT_TYPE").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS").apply();
        privateAnalyticsViewModel.c.u(z);
    }
}
