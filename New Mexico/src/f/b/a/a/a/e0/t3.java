package f.b.a.a.a.e0;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.c.a.c.a;
import f.b.a.a.a.n0.j0;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public final /* synthetic */ class t3 implements a {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ ShareDiagnosisViewModel.b b;

    public /* synthetic */ t3(ShareDiagnosisViewModel shareDiagnosisViewModel, ShareDiagnosisViewModel.b bVar) {
        this.a = shareDiagnosisViewModel;
        this.b = bVar;
    }

    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        ShareDiagnosisViewModel.b bVar = this.b;
        j0 j0Var = (j0) obj;
        k6 k6Var = shareDiagnosisViewModel.L;
        Context context = shareDiagnosisViewModel.J;
        ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.IS_CODE_NEEDED;
        ShareDiagnosisViewModel.b bVar3 = ShareDiagnosisViewModel.b.BEGIN;
        int ordinal = bVar.ordinal();
        if (ordinal != 1) {
            if (ordinal == 2) {
                return bVar2;
            }
            if (ordinal == 3) {
                int ordinal2 = k6Var.ordinal();
                if (ordinal2 != 1) {
                    if (ordinal2 == 2) {
                        return ShareDiagnosisViewModel.b.GET_CODE;
                    }
                    if ((!TextUtils.isEmpty(context.getString(R.string.self_report_website_url))) && !m.e.O0(j0Var)) {
                        return bVar2;
                    }
                }
            } else if (ordinal != 4) {
                return null;
            } else {
                if (!m.e.M0(j0Var)) {
                    return ShareDiagnosisViewModel.b.CODE;
                }
            }
        }
        return bVar3;
    }
}
