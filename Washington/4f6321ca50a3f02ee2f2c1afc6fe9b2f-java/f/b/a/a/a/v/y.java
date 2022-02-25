package f.b.a.a.a.v;

import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.r;
import gov.wa.doh.exposurenotifications.R;

public final /* synthetic */ class y implements r {
    public final /* synthetic */ TextView a;

    public /* synthetic */ y(TextView textView) {
        this.a = textView;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        TextView textView = this.a;
        ExposureNotificationViewModel exposureNotificationViewModel = t0.Z;
        textView.setText(((Boolean) obj).booleanValue() ? R.string.settings_analytics_on : R.string.settings_analytics_off);
    }
}
