package f.b.a.a.a.j0;

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
import e.q.f0;
import f.b.a.a.a.t.z;
import gov.ut.covid19.exposurenotifications.R;

public class b1 extends v0 {
    public z b0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = s().inflate(R.layout.fragment_settings, (ViewGroup) null, false);
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
                                                                    this.b0 = new z(frameLayout, linearLayout, linearLayout2, textView, linearLayout3, imageView, linearLayout4, textView2, linearLayout5, imageButton, linearLayout6, linearLayout7, linearLayout8, linearLayout9, textView3, textView4);
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

    @Override // e.n.a.m
    public void U() {
        this.D = true;
        this.b0 = null;
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.home_tab_settings_text);
        PrivateAnalyticsViewModel privateAnalyticsViewModel = (PrivateAnalyticsViewModel) new f0(this).a(PrivateAnalyticsViewModel.class);
        this.b0.f2441i.setOnClickListener(new c0(this));
        this.b0.c.setOnClickListener(new b0(this));
        ((AppAnalyticsViewModel) new f0(this).a(AppAnalyticsViewModel.class)).c.f2312d.f(G(), new i0(this));
        this.b0.m.setOnClickListener(new y(this));
        privateAnalyticsViewModel.c.f2313e.f(G(), new f0(this));
        this.b0.m.setVisibility(privateAnalyticsViewModel.f436d.a() ? 0 : 8);
        this.b0.b.setOnClickListener(new d0(this));
        this.b0.f2442j.setOnClickListener(new x(this));
        this.b0.f2444l.setOnClickListener(new e0(this));
        this.b0.f2440h.setOnClickListener(new g0(this));
        this.b0.f2443k.setOnClickListener(new j0(this));
        this.b0.f2438f.setOnClickListener(new a0(this));
        this.W.f341f.f(G(), new z(this));
        this.W.c.f(G(), new h0(this));
    }
}
