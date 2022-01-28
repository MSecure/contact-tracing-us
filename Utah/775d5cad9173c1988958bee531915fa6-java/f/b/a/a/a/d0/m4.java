package f.b.a.a.a.d0;

import android.util.Pair;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.c.a.c.a;

public final /* synthetic */ class m4 implements a {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ m4(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r8 == r4) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r0 != 2) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r8 == r4) goto L_0x002d;
     */
    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        ShareDiagnosisViewModel.b bVar = (ShareDiagnosisViewModel.b) obj;
        w5 w5Var = this.a.I;
        int i2 = 3;
        int i3 = w5Var == w5.SELF_REPORT ? 3 : 2;
        ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.UPLOAD;
        ShareDiagnosisViewModel.b bVar3 = ShareDiagnosisViewModel.b.CODE;
        int ordinal = w5Var.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            if (bVar != bVar3) {
            }
            i2 = 1;
            return Pair.create(Integer.valueOf(i2), Integer.valueOf(i3));
        }
        if (bVar != ShareDiagnosisViewModel.b.GET_CODE) {
            if (bVar != bVar3) {
            }
            i2 = 2;
            return Pair.create(Integer.valueOf(i2), Integer.valueOf(i3));
        }
        i2 = 1;
        return Pair.create(Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
