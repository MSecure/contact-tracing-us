package f.b.a.a.a.i;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.a0;
import e.p.b0;
import e.p.c0;
import f.a.a.a.a;
import f.b.a.a.a.h.r;
import f.b.a.a.a.t.d;
import f.b.a.a.a.w.k0;
import f.b.a.a.a.w.l0;
import f.b.a.a.a.w.m0;
import f.b.a.a.a.w.n0;
import gov.ca.covid19.exposurenotifications.R;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class l extends o {
    public static final /* synthetic */ int b0 = 0;
    public ExposureNotificationViewModel Z;
    public ExposureHomeViewModel a0;

    public final void A0(d dVar, boolean z) {
        int i2;
        View view = this.F;
        if (view != null) {
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.exposures_banner_flipper);
            ViewFlipper viewFlipper2 = (ViewFlipper) view.findViewById(R.id.exposure_information_flipper);
            TextView textView = (TextView) view.findViewById(R.id.exposure_details_date_exposed_text);
            TextView textView2 = (TextView) view.findViewById(R.id.exposure_details_url_text);
            TextView textView3 = (TextView) view.findViewById(R.id.exposure_details_text);
            int i3 = 8;
            if (dVar.b() != 0 || z) {
                viewFlipper2.setDisplayedChild(1);
                viewFlipper2.setVisibility(0);
                long a = dVar.a();
                Locale locale = v().getConfiguration().locale;
                SecureRandom secureRandom = r.a;
                long millis = TimeUnit.DAYS.toMillis(a);
                DateFormat dateInstance = DateFormat.getDateInstance(1, locale);
                dateInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
                textView.setText(dateInstance.format(Long.valueOf(millis)));
                if (z) {
                    textView2.setText(R.string.exposure_details_url_revoked);
                    i2 = R.string.exposure_details_text_revoked;
                } else {
                    int b = dVar.b();
                    if (b == 1) {
                        textView2.setText(R.string.exposure_details_url_1);
                        i2 = R.string.exposure_details_text_1;
                    } else if (b == 2) {
                        textView2.setText(R.string.exposure_details_url_2);
                        i2 = R.string.exposure_details_text_2;
                    } else if (b == 3) {
                        textView2.setText(R.string.exposure_details_url_3);
                        i2 = R.string.exposure_details_text_3;
                    } else if (b == 4) {
                        textView2.setText(R.string.exposure_details_url_4);
                        i2 = R.string.exposure_details_text_4;
                    }
                }
                textView3.setText(i2);
            } else if (this.Z.c.d() == ExposureNotificationViewModel.a.ENABLED) {
                viewFlipper2.setDisplayedChild(0);
                viewFlipper2.setVisibility(0);
                viewFlipper.setDisplayedChild(1);
                viewFlipper.setVisibility(0);
            } else {
                viewFlipper2.setVisibility(8);
            }
            ViewFlipper viewFlipper3 = (ViewFlipper) view.findViewById(R.id.edge_case_flipper);
            View findViewById = view.findViewById(R.id.view_flipper_divider);
            if (((ViewFlipper) view.findViewById(R.id.exposure_information_flipper)).getVisibility() == 0 && viewFlipper3.getVisibility() == 0) {
                i3 = 0;
            }
            findViewById.setVisibility(i3);
        }
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_exposure_home, viewGroup, false);
    }

    @Override // e.m.a.l
    public void c0() {
        this.D = true;
        this.Z.d();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.Z = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        b0.b k2 = k();
        c0 h2 = h();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String t = a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            a0 a0Var = h2.a.get(t);
            if (!ExposureHomeViewModel.class.isInstance(a0Var)) {
                a0Var = k2 instanceof b0.c ? ((b0.c) k2).c(t, ExposureHomeViewModel.class) : k2.a(ExposureHomeViewModel.class);
                a0 put = h2.a.put(t, a0Var);
                if (put != null) {
                    put.a();
                }
            } else if (k2 instanceof b0.e) {
                ((b0.e) k2).b(a0Var);
            }
            this.a0 = (ExposureHomeViewModel) a0Var;
            this.Z.c.f(B(), new d(this));
            Button button = (Button) view.findViewById(R.id.start_api_button);
            button.setOnClickListener(new e(this));
            this.Z.f331d.f(B(), new k(button));
            view.findViewById(R.id.ble_settings_button).setOnClickListener(new b(this));
            view.findViewById(R.id.location_settings_button).setOnClickListener(new h(this));
            view.findViewById(R.id.location_ble_settings_button).setOnClickListener(new a(this));
            view.findViewById(R.id.manage_storage_button).setOnClickListener(new g(this));
            view.findViewById(R.id.exposure_details_url_text).setOnClickListener(new f(this));
            n0 n0Var = this.a0.c;
            Objects.requireNonNull(n0Var);
            new l0(n0Var, n0Var.a, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY").f(B(), new c((TextView) view.findViewById(R.id.exposure_details_new_badge)));
            n0 n0Var2 = this.a0.c;
            Objects.requireNonNull(n0Var2);
            new m0(n0Var2, n0Var2.a, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY").f(B(), new j((TextView) view.findViewById(R.id.exposure_date_new_badge)));
            n0 n0Var3 = this.a0.c;
            Objects.requireNonNull(n0Var3);
            new k0(n0Var3, n0Var3.a, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY").f(B(), new i(this));
            ExposureHomeViewModel exposureHomeViewModel = this.a0;
            n0.b bVar = n0.b.NEW;
            n0.b bVar2 = n0.b.SEEN;
            exposureHomeViewModel.d(bVar, bVar2);
            this.a0.c(bVar, bVar2);
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final void z0() {
        w0(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
    }
}
