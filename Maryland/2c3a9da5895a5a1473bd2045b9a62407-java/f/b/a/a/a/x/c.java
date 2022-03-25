package f.b.a.a.a.x;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsActivity;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class c implements View.OnClickListener {
    public final /* synthetic */ AppAnalyticsActivity b;

    public /* synthetic */ c(AppAnalyticsActivity appAnalyticsActivity) {
        this.b = appAnalyticsActivity;
    }

    public final void onClick(View view) {
        AppAnalyticsActivity appAnalyticsActivity = this.b;
        Objects.requireNonNull(appAnalyticsActivity);
        appAnalyticsActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appAnalyticsActivity.getString(R.string.app_analytics_link))));
    }
}
