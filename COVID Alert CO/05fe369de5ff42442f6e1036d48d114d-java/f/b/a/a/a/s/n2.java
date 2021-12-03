package f.b.a.a.a.s;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.e0.a;
import gov.co.cdphe.exposurenotifications.R;
import l.b.a.e;

public final /* synthetic */ class n2 implements View.OnClickListener {
    public final /* synthetic */ l6 b;

    public /* synthetic */ n2(l6 l6Var) {
        this.b = l6Var;
    }

    public final void onClick(View view) {
        l6 l6Var = this.b;
        int checkedRadioButtonId = l6Var.e0.f2201g.f2158d.getCheckedRadioButtonId();
        v0.i iVar = checkedRadioButtonId != R.id.no_radio_button ? checkedRadioButtonId != R.id.yes_radio_button ? v0.i.UNKNOWN : v0.i.VACCINATED : v0.i.NOT_VACCINATED;
        a aVar = l6.f0;
        StringBuilder i2 = f.a.a.a.a.i("setLastVaccinationResponse to ");
        i2.append(iVar.name());
        aVar.a(i2.toString());
        ShareDiagnosisViewModel shareDiagnosisViewModel = l6Var.a0;
        v0 v0Var = shareDiagnosisViewModel.f407h;
        e c = shareDiagnosisViewModel.f409j.c();
        if (v0Var.g()) {
            v0Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS", iVar.b).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS", c.G()).apply();
        }
        l6Var.C0();
    }
}
