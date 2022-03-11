package f.b.a.a.a.x;

import android.widget.CompoundButton;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;

public final /* synthetic */ class q implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PrivateAnalyticsViewModel a;

    public /* synthetic */ q(PrivateAnalyticsViewModel privateAnalyticsViewModel) {
        this.a = privateAnalyticsViewModel;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        PrivateAnalyticsViewModel privateAnalyticsViewModel = this.a;
        int i2 = PrivateAnalyticsActivity.t;
        privateAnalyticsViewModel.c.a.edit().remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME").apply();
        privateAnalyticsViewModel.c.m(z);
    }
}
