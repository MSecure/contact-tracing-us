package f.b.a.a.a.p;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.w.b0;
import gov.ca.covid19.exposurenotifications.R;

public class n3 {
    public static ShareDiagnosisViewModel.e a(ShareDiagnosisViewModel.e eVar, b0 b0Var, Context context) {
        ShareDiagnosisViewModel.e eVar2 = ShareDiagnosisViewModel.e.TRAVEL_STATUS;
        ShareDiagnosisViewModel.e eVar3 = ShareDiagnosisViewModel.e.REVIEW;
        int ordinal = eVar.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return d(context) ? eVar3 : eVar2;
                }
                if (ordinal != 6) {
                    return null;
                }
                return eVar3;
            }
        } else if (!c(b0Var)) {
            return ShareDiagnosisViewModel.e.CODE;
        }
        return b0Var.g() ? d(context) ? eVar3 : eVar2 : ShareDiagnosisViewModel.e.ONSET;
    }

    public static ShareDiagnosisViewModel.e b(ShareDiagnosisViewModel.e eVar, b0 b0Var, Context context) {
        ShareDiagnosisViewModel.e eVar2 = ShareDiagnosisViewModel.e.ONSET;
        ShareDiagnosisViewModel.e eVar3 = ShareDiagnosisViewModel.e.CODE;
        ShareDiagnosisViewModel.e eVar4 = ShareDiagnosisViewModel.e.BEGIN;
        int ordinal = eVar.ordinal();
        if (ordinal == 1) {
            return eVar4;
        }
        if (ordinal == 2) {
            return c(b0Var) ? eVar4 : eVar3;
        }
        if (ordinal == 3) {
            return d(context) ? b0Var.g() ? eVar3 : eVar2 : ShareDiagnosisViewModel.e.TRAVEL_STATUS;
        }
        if (ordinal != 6) {
            return null;
        }
        return b0Var.g() ? c(b0Var) ? eVar4 : eVar3 : eVar2;
    }

    public static boolean c(b0 b0Var) {
        return b0Var.f() && m.h.q0(b0Var) && b0Var.k() != b0.c.SHARED;
    }

    public static boolean d(Context context) {
        return TextUtils.isEmpty(context.getResources().getString(R.string.share_travel_detail));
    }
}
