package f.b.a.a.a.v;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.p.b0;
import gov.wi.covid19.exposurenotifications.R;

public class t0 extends p0 {
    public static ExposureNotificationViewModel Z;

    public final void A0() {
        w0(new Intent("android.intent.action.VIEW", Uri.parse(z(R.string.enx_agencyPrivacyPolicy))));
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_settings_home, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        Z = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        view.findViewById(R.id.app_analytics_link).setOnClickListener(new v(this));
        ((AppAnalyticsViewModel) new b0(this).a(AppAnalyticsViewModel.class)).c.c.f(B(), new f0((TextView) view.findViewById(R.id.app_analytics_status)));
        View findViewById = view.findViewById(R.id.private_analytics_link);
        findViewById.setOnClickListener(new x(this));
        ((PrivateAnalyticsViewModel) new b0(this).a(PrivateAnalyticsViewModel.class)).c.f2280d.f(B(), new y((TextView) view.findViewById(R.id.private_analytics_status)));
        findViewById.setVisibility(8);
        view.findViewById(R.id.agency_link).setOnClickListener(new e0(this));
        view.findViewById(R.id.legal_link).setOnClickListener(new u(this));
        view.findViewById(R.id.privacy_policy_link).setOnClickListener(new a0(this, view));
        view.findViewById(R.id.help_and_support_link).setOnClickListener(new c0(this, view));
        view.findViewById(R.id.open_source_link).setOnClickListener(new d0(this));
        view.findViewById(R.id.exposure_notifications_link).setOnClickListener(new b0(this));
        Z.f333f.f(B(), new z((TextView) view.findViewById(R.id.exposure_notifications_status)));
        Z.c.f(B(), new w((ImageView) view.findViewById(R.id.exposure_notifications_error)));
        view.findViewById(R.id.debug_mode_link);
        ((Button) view.findViewById(R.id.share_app_button)).setOnClickListener(new t(this));
    }

    public final void z0() {
        w0(new Intent("android.intent.action.VIEW", Uri.parse(z(R.string.help_and_support_link))));
    }
}
