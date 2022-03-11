package f.b.a.a.a.x;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.p.b0;
import f.b.a.a.a.i.s;
import gov.md.covid19.exposurenotifications.R;

public class r0 extends n0 {
    public static ExposureNotificationViewModel b0;
    public s a0;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_settings_home, viewGroup, false);
        int i2 = R.id.agency_link;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.agency_link);
        if (linearLayout != null) {
            i2 = R.id.app_analytics_link;
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.app_analytics_link);
            if (linearLayout2 != null) {
                i2 = R.id.app_analytics_status;
                TextView textView = (TextView) inflate.findViewById(R.id.app_analytics_status);
                if (textView != null) {
                    i2 = R.id.debug_mode_link;
                    LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.debug_mode_link);
                    if (linearLayout3 != null) {
                        i2 = R.id.exposure_notifications_error;
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.exposure_notifications_error);
                        if (imageView != null) {
                            i2 = R.id.exposure_notifications_link;
                            LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.exposure_notifications_link);
                            if (linearLayout4 != null) {
                                i2 = R.id.exposure_notifications_status;
                                TextView textView2 = (TextView) inflate.findViewById(R.id.exposure_notifications_status);
                                if (textView2 != null) {
                                    i2 = R.id.help_and_support_link;
                                    LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.help_and_support_link);
                                    if (linearLayout5 != null) {
                                        i2 = R.id.legal_link;
                                        LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.legal_link);
                                        if (linearLayout6 != null) {
                                            i2 = R.id.open_source_link;
                                            LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.open_source_link);
                                            if (linearLayout7 != null) {
                                                i2 = R.id.privacy_policy_link;
                                                LinearLayout linearLayout8 = (LinearLayout) inflate.findViewById(R.id.privacy_policy_link);
                                                if (linearLayout8 != null) {
                                                    i2 = R.id.private_analytics_link;
                                                    LinearLayout linearLayout9 = (LinearLayout) inflate.findViewById(R.id.private_analytics_link);
                                                    if (linearLayout9 != null) {
                                                        i2 = R.id.private_analytics_status;
                                                        TextView textView3 = (TextView) inflate.findViewById(R.id.private_analytics_status);
                                                        if (textView3 != null) {
                                                            i2 = R.id.settings_fragment_title;
                                                            TextView textView4 = (TextView) inflate.findViewById(R.id.settings_fragment_title);
                                                            if (textView4 != null) {
                                                                i2 = R.id.share_app_button;
                                                                Button button = (Button) inflate.findViewById(R.id.share_app_button);
                                                                if (button != null) {
                                                                    LinearLayout linearLayout10 = (LinearLayout) inflate;
                                                                    this.a0 = new s(linearLayout10, linearLayout, linearLayout2, textView, linearLayout3, imageView, linearLayout4, textView2, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, textView3, textView4, button);
                                                                    return linearLayout10;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        b0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        this.a0.c.setOnClickListener(new w(this));
        ((AppAnalyticsViewModel) new b0(this).a(AppAnalyticsViewModel.class)).c.c.f(B(), new a0(this));
        this.a0.f2135l.setOnClickListener(new x(this));
        ((PrivateAnalyticsViewModel) new b0(this).a(PrivateAnalyticsViewModel.class)).c.f2357d.f(B(), new r(this));
        this.a0.f2135l.setVisibility(0);
        this.a0.b.setOnClickListener(new d0(this));
        this.a0.f2132i.setOnClickListener(new v(this));
        this.a0.f2134k.setOnClickListener(new y(this));
        this.a0.f2131h.setOnClickListener(new s(this));
        this.a0.f2133j.setOnClickListener(new c0(this));
        this.a0.f2129f.setOnClickListener(new b0(this));
        b0.f343g.f(B(), new z(this));
        b0.f340d.f(B(), new u(this));
        this.a0.n.setOnClickListener(new t(this));
    }
}
