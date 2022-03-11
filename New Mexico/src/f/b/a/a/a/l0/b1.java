package f.b.a.a.a.l0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.o.a.r;
import e.r.f0;
import e.r.t;
import f.b.a.a.a.u.c0;
import f.b.a.a.a.x.z0;
import f.b.a.c.b.o.b;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public class b1 extends v0 {
    public c0 b0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = t().inflate(R.layout.fragment_settings, (ViewGroup) null, false);
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
                                                                    this.b0 = new c0(frameLayout, linearLayout, linearLayout2, textView, linearLayout3, imageView, linearLayout4, textView2, linearLayout5, imageButton, linearLayout6, linearLayout7, linearLayout8, linearLayout9, textView3, textView4);
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

    @Override // e.o.a.m
    public void W() {
        this.D = true;
        this.b0 = null;
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.home_tab_settings_text);
        PrivateAnalyticsViewModel privateAnalyticsViewModel = (PrivateAnalyticsViewModel) new f0(this).a(PrivateAnalyticsViewModel.class);
        this.b0.f2403i.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1.this.u0().onBackPressed();
            }
        });
        this.b0.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1 b1Var = b1.this;
                Objects.requireNonNull(b1Var);
                m0 m0Var = new m0();
                r u0 = b1Var.u0();
                b.o(u0 instanceof z0);
                ((z0) u0).B(m0Var);
            }
        });
        ((AppAnalyticsViewModel) new f0(this).a(AppAnalyticsViewModel.class)).c.f2313d.f(H(), new t() { // from class: f.b.a.a.a.l0.i0
            @Override // e.r.t
            public final void a(Object obj) {
                b1.this.b0.f2398d.setText(((Boolean) obj).booleanValue() ? R.string.settings_analytics_on : R.string.settings_analytics_off);
            }
        });
        this.b0.m.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1 b1Var = b1.this;
                Objects.requireNonNull(b1Var);
                z0 z0Var = new z0();
                r u0 = b1Var.u0();
                b.o(u0 instanceof z0);
                ((z0) u0).B(z0Var);
            }
        });
        privateAnalyticsViewModel.c.f2314e.f(H(), new t() { // from class: f.b.a.a.a.l0.f0
            @Override // e.r.t
            public final void a(Object obj) {
                b1.this.b0.n.setText(((Boolean) obj).booleanValue() ? R.string.settings_analytics_on : R.string.settings_analytics_off);
            }
        });
        this.b0.m.setVisibility(privateAnalyticsViewModel.f446d.a() ? 0 : 8);
        this.b0.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1 b1Var = b1.this;
                Objects.requireNonNull(b1Var);
                k0 k0Var = new k0();
                r u0 = b1Var.u0();
                b.o(u0 instanceof z0);
                ((z0) u0).B(k0Var);
            }
        });
        this.b0.f2404j.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1 b1Var = b1.this;
                Objects.requireNonNull(b1Var);
                w0 w0Var = new w0();
                r u0 = b1Var.u0();
                b.o(u0 instanceof z0);
                ((z0) u0).B(w0Var);
            }
        });
        this.b0.f2406l.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1 b1Var = b1.this;
                f.b.a.a.a.o0.b.a(b1Var.b0.a, b1Var.F(R.string.enx_agencyPrivacyPolicy));
            }
        });
        this.b0.f2402h.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1 b1Var = b1.this;
                f.b.a.a.a.o0.b.a(b1Var.b0.a, b1Var.F(R.string.help_and_support_link));
            }
        });
        this.b0.f2405k.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1 b1Var = b1.this;
                Objects.requireNonNull(b1Var);
                y0 y0Var = new y0();
                r u0 = b1Var.u0();
                b.o(u0 instanceof z0);
                ((z0) u0).B(y0Var);
            }
        });
        this.b0.f2400f.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b1 b1Var = b1.this;
                Objects.requireNonNull(b1Var);
                o0 o0Var = new o0();
                r u0 = b1Var.u0();
                b.o(u0 instanceof z0);
                ((z0) u0).B(o0Var);
            }
        });
        this.W.f343f.f(H(), new t() { // from class: f.b.a.a.a.l0.z
            @Override // e.r.t
            public final void a(Object obj) {
                b1.this.b0.f2401g.setText(((Boolean) obj).booleanValue() ? R.string.settings_exposure_notifications_on : R.string.settings_exposure_notifications_off);
            }
        });
        this.W.c.f(H(), new t() { // from class: f.b.a.a.a.l0.h0
            @Override // e.r.t
            public final void a(Object obj) {
                ImageView imageView;
                int i2;
                b1 b1Var = b1.this;
                Objects.requireNonNull(b1Var);
                int ordinal = ((ExposureNotificationViewModel.b) obj).ordinal();
                if (ordinal == 0 || ordinal == 1) {
                    imageView = b1Var.b0.f2399e;
                    i2 = 8;
                } else if (ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
                    imageView = b1Var.b0.f2399e;
                    i2 = 0;
                } else {
                    return;
                }
                imageView.setVisibility(i2);
            }
        });
    }
}
