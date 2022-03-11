package f.b.a.a.a.r;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.y.c0;
import gov.md.covid19.exposurenotifications.R;

public class z3 {
    public static ShareDiagnosisViewModel.d a(ShareDiagnosisViewModel.d dVar, c0 c0Var, Context context) {
        ShareDiagnosisViewModel.d dVar2 = ShareDiagnosisViewModel.d.TRAVEL_STATUS;
        ShareDiagnosisViewModel.d dVar3 = ShareDiagnosisViewModel.d.REVIEW;
        int ordinal = dVar.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return c(context) ? dVar3 : dVar2;
                }
                if (ordinal != 6) {
                    return null;
                }
                return dVar3;
            }
        } else if (!b(c0Var)) {
            return ShareDiagnosisViewModel.d.CODE;
        }
        return c0Var.g() ? c(context) ? dVar3 : dVar2 : ShareDiagnosisViewModel.d.ONSET;
    }

    public static boolean b(c0 c0Var) {
        return c0Var.f() && m.h.r0(c0Var) && c0Var.k() != c0.c.SHARED;
    }

    public static boolean c(Context context) {
        return TextUtils.isEmpty(context.getResources().getString(R.string.share_travel_detail));
    }
}
