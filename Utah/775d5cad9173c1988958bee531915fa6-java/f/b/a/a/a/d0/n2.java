package f.b.a.a.a.d0;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.s.d0.a;
import gov.ut.covid19.exposurenotifications.R;
import l.b.a.e;

public final /* synthetic */ class n2 implements View.OnClickListener {
    public final /* synthetic */ k6 b;

    public /* synthetic */ n2(k6 k6Var) {
        this.b = k6Var;
    }

    public final void onClick(View view) {
        k6 k6Var = this.b;
        int checkedRadioButtonId = k6Var.f0.f2396g.f2353d.getCheckedRadioButtonId();
        v0.i iVar = checkedRadioButtonId != R.id.no_radio_button ? checkedRadioButtonId != R.id.yes_radio_button ? v0.i.UNKNOWN : v0.i.VACCINATED : v0.i.NOT_VACCINATED;
        a aVar = k6.g0;
        StringBuilder h2 = f.a.a.a.a.h("setLastVaccinationResponse to ");
        h2.append(iVar.name());
        aVar.a(h2.toString());
        ShareDiagnosisViewModel shareDiagnosisViewModel = k6Var.b0;
        v0 v0Var = shareDiagnosisViewModel.f403h;
        e c = shareDiagnosisViewModel.f405j.c();
        if (v0Var.g()) {
            v0Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS", iVar.b).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS", c.G()).apply();
        }
        k6Var.I0();
    }
}
