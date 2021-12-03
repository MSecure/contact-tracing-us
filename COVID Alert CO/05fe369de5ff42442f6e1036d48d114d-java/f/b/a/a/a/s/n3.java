package f.b.a.a.a.s;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.c.a.c.a;
import f.b.a.a.a.b0.h0;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class n3 implements a {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ ShareDiagnosisViewModel.b b;

    public /* synthetic */ n3(ShareDiagnosisViewModel shareDiagnosisViewModel, ShareDiagnosisViewModel.b bVar) {
        this.a = shareDiagnosisViewModel;
        this.b = bVar;
    }

    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        ShareDiagnosisViewModel.b bVar = this.b;
        h0 h0Var = (h0) obj;
        x5 x5Var = shareDiagnosisViewModel.I;
        Context context = shareDiagnosisViewModel.G;
        ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.IS_CODE_NEEDED;
        ShareDiagnosisViewModel.b bVar3 = ShareDiagnosisViewModel.b.BEGIN;
        int ordinal = bVar.ordinal();
        if (ordinal != 1) {
            if (ordinal == 2) {
                return bVar2;
            }
            if (ordinal == 3) {
                int ordinal2 = x5Var.ordinal();
                if (ordinal2 != 1) {
                    if (ordinal2 == 2) {
                        return ShareDiagnosisViewModel.b.GET_CODE;
                    }
                    if ((!TextUtils.isEmpty(context.getString(R.string.self_report_website_url))) && !m.h.A0(h0Var)) {
                        return bVar2;
                    }
                }
            } else if (ordinal != 4) {
                return null;
            } else {
                if (!m.h.z0(h0Var)) {
                    return ShareDiagnosisViewModel.b.CODE;
                }
            }
        }
        return bVar3;
    }
}
