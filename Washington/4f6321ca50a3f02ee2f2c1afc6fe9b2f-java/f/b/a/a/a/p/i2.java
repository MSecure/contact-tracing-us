package f.b.a.a.a.p;

import android.content.res.Resources;
import android.util.Log;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.l.u;
import f.b.a.a.a.l.w;
import f.b.b.a.g;
import gov.wa.doh.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class i2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ i2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        String str;
        int i2;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Exception exc = (Exception) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        Log.e("ShareDiagnosisViewModel", "Failed to submit verification code.", exc);
        shareDiagnosisViewModel.f376i.j(Boolean.FALSE);
        shareDiagnosisViewModel.n.j(Boolean.TRUE);
        String string = shareDiagnosisViewModel.f373f.getString(R.string.generic_error_message);
        if (exc instanceof u.e) {
            string = shareDiagnosisViewModel.f373f.getString(R.string.network_error_server_error);
        } else if (exc instanceof u.d) {
            w wVar = ((u.d) exc).b;
            Resources resources = shareDiagnosisViewModel.f373f;
            int ordinal = wVar.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    str = resources.getString(R.string.network_error_code_expired, resources.getString(R.string.error_agency_name));
                } else if (ordinal != 3) {
                    str = ordinal != 5 ? resources.getString(R.string.generic_error_message) : resources.getString(R.string.network_error_server_error);
                } else {
                    i2 = R.string.network_error_unsupported_test_type;
                }
                string = str;
            } else {
                i2 = R.string.network_error_code_invalid;
            }
            str = resources.getString(i2);
            string = str;
        }
        shareDiagnosisViewModel.u.j(string);
        return null;
    }
}
