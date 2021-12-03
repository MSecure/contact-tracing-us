package f.b.a.a.a.z;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.p.f0;
import f.b.a.a.a.j.z;
import gov.co.cdphe.exposurenotifications.R;

public class d1 extends w0 {
    public z a0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = q().inflate(R.layout.fragment_settings, (ViewGroup) null, false);
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
                                        i2 = 16908332;
                                        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                                        if (imageButton != null) {
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
                                                                i2 = R.id.settings_activity_title;
                                                                TextView textView4 = (TextView) inflate.findViewById(R.id.settings_activity_title);
                                                                if (textView4 != null) {
                                                                    FrameLayout frameLayout = (FrameLayout) inflate;
                                                                    this.a0 = new z(frameLayout, linearLayout, linearLayout2, textView, linearLayout3, imageView, linearLayout4, textView2, linearLayout5, imageButton, linearLayout6, linearLayout7, linearLayout8, linearLayout9, textView3, textView4);
                                                                    return frameLayout;
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

    @Override // e.m.a.m
    public void Q() {
        this.D = true;
        this.a0 = null;
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.home_tab_settings_text);
        PrivateAnalyticsViewModel privateAnalyticsViewModel = (PrivateAnalyticsViewModel) new f0(this).a(PrivateAnalyticsViewModel.class);
        this.a0.f2243i.setOnClickListener(new c0(this));
        this.a0.c.setOnClickListener(new b0(this));
        ((AppAnalyticsViewModel) new f0(this).a(AppAnalyticsViewModel.class)).c.f2115d.f(C(), new i0(this));
        this.a0.m.setOnClickListener(new y(this));
        privateAnalyticsViewModel.c.f2116e.f(C(), new f0(this));
        this.a0.m.setVisibility(privateAnalyticsViewModel.f440d.a() ? 0 : 8);
        this.a0.b.setOnClickListener(new d0(this));
        this.a0.f2244j.setOnClickListener(new x(this));
        this.a0.f2246l.setOnClickListener(new e0(this));
        this.a0.f2242h.setOnClickListener(new g0(this));
        this.a0.f2245k.setOnClickListener(new j0(this));
        this.a0.f2240f.setOnClickListener(new a0(this));
        this.W.f336f.f(C(), new z(this));
        this.W.c.f(C(), new h0(this));
    }
}
