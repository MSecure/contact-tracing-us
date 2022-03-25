package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.a.a.a.a;
import f.b.a.a.a.y.b;
import f.b.a.a.a.y.c0;
import f.b.a.a.a.y.d0;
import f.b.a.a.a.y.j;
import f.b.a.a.a.y.q0;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import l.b.a.d;

public final /* synthetic */ class i2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ i2(ShareDiagnosisViewModel shareDiagnosisViewModel, String str, boolean z) {
        this.a = shareDiagnosisViewModel;
        this.b = str;
        this.c = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        char c2;
        c0.d dVar;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        String str = this.b;
        boolean z = this.c;
        f.b.a.a.a.n.u uVar = (f.b.a.a.a.n.u) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        j.b bVar = (j.b) c0.o();
        bVar.f2347d = str;
        bVar.m = Boolean.valueOf(z);
        bVar.f2348e = uVar.h();
        if (uVar.n() != null) {
            bVar.e(true);
            bVar.f2351h = uVar.n();
            bVar.c(c0.b.YES);
        }
        if (uVar.o() != null) {
            String o = uVar.o();
            String lowerCase = o.toLowerCase();
            lowerCase.hashCode();
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1102761116) {
                if (hashCode != -804109473) {
                    if (hashCode == 921111605 && lowerCase.equals("negative")) {
                        c2 = 2;
                        if (c2 != 0) {
                            dVar = c0.d.LIKELY;
                        } else if (c2 == 1) {
                            dVar = c0.d.CONFIRMED;
                        } else if (c2 == 2) {
                            dVar = c0.d.NEGATIVE;
                        } else {
                            throw new IllegalArgumentException(a.t("Unsupported test type ", o));
                        }
                        bVar.f2350g = dVar;
                    }
                } else if (lowerCase.equals("confirmed")) {
                    c2 = 1;
                    if (c2 != 0) {
                    }
                    bVar.f2350g = dVar;
                }
            } else if (lowerCase.equals("likely")) {
                c2 = 0;
                if (c2 != 0) {
                }
                bVar.f2350g = dVar;
            }
            c2 = 65535;
            if (c2 != 0) {
            }
            bVar.f2350g = dVar;
        }
        q0 q0Var = shareDiagnosisViewModel.f389h;
        d b2 = shareDiagnosisViewModel.f390i.b();
        if (q0Var.f()) {
            q0Var.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME", b2.E()).apply();
        }
        d0 d0Var = shareDiagnosisViewModel.c;
        b bVar2 = new b(d0Var, bVar.a());
        ExecutorService executorService = d0Var.b;
        f.b.b.f.a.d0 d0Var2 = new f.b.b.f.a.d0(bVar2);
        executorService.execute(d0Var2);
        return d0Var2;
    }
}
