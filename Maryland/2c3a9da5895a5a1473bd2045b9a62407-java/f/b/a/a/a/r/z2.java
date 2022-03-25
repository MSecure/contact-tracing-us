package f.b.a.a.a.r;

import android.content.Context;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.c.a.c.a;
import f.b.a.a.a.y.c0;

public final /* synthetic */ class z2 implements a {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ ShareDiagnosisViewModel.d b;

    public /* synthetic */ z2(ShareDiagnosisViewModel shareDiagnosisViewModel, ShareDiagnosisViewModel.d dVar) {
        this.a = shareDiagnosisViewModel;
        this.b = dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (f.b.a.a.a.r.z3.b(r7) != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (f.b.a.a.a.r.z3.b(r7) != false) goto L_0x0046;
     */
    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        ShareDiagnosisViewModel.d dVar = this.b;
        c0 c0Var = (c0) obj;
        Context context = shareDiagnosisViewModel.x;
        ShareDiagnosisViewModel.d dVar2 = ShareDiagnosisViewModel.d.ONSET;
        ShareDiagnosisViewModel.d dVar3 = ShareDiagnosisViewModel.d.CODE;
        ShareDiagnosisViewModel.d dVar4 = ShareDiagnosisViewModel.d.BEGIN;
        int ordinal = dVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 6) {
                        return null;
                    }
                    if (!c0Var.g()) {
                        return dVar2;
                    }
                } else if (!z3.c(context)) {
                    return ShareDiagnosisViewModel.d.TRAVEL_STATUS;
                } else {
                    if (!c0Var.g()) {
                        return dVar2;
                    }
                }
            }
            return dVar3;
        }
        return dVar4;
    }
}
