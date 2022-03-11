package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.a.a.a.a;
import f.b.a.a.a.l.t;
import f.b.a.a.a.w.b;
import f.b.a.a.a.w.b0;
import f.b.a.a.a.w.c0;
import f.b.a.a.a.w.j;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class o2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ o2(ShareDiagnosisViewModel shareDiagnosisViewModel, String str, boolean z) {
        this.a = shareDiagnosisViewModel;
        this.b = str;
        this.c = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        char c2;
        b0.d dVar;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        String str = this.b;
        boolean z = this.c;
        t tVar = (t) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        j.b bVar = (j.b) b0.o();
        bVar.f2270d = str;
        bVar.m = Boolean.valueOf(z);
        bVar.f2271e = tVar.h();
        if (tVar.n() != null) {
            bVar.e(true);
            bVar.f2274h = tVar.n();
            bVar.c(b0.b.YES);
        }
        if (tVar.o() != null) {
            String o = tVar.o();
            String lowerCase = o.toLowerCase();
            lowerCase.hashCode();
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1102761116) {
                if (hashCode != -804109473) {
                    if (hashCode == 921111605 && lowerCase.equals("negative")) {
                        c2 = 2;
                        if (c2 != 0) {
                            dVar = b0.d.LIKELY;
                        } else if (c2 == 1) {
                            dVar = b0.d.CONFIRMED;
                        } else if (c2 == 2) {
                            dVar = b0.d.NEGATIVE;
                        } else {
                            throw new IllegalArgumentException(a.t("Unsupported test type ", o));
                        }
                        bVar.f2273g = dVar;
                    }
                } else if (lowerCase.equals("confirmed")) {
                    c2 = 1;
                    if (c2 != 0) {
                    }
                    bVar.f2273g = dVar;
                }
            } else if (lowerCase.equals("likely")) {
                c2 = 0;
                if (c2 != 0) {
                }
                bVar.f2273g = dVar;
            }
            c2 = 65535;
            if (c2 != 0) {
            }
            bVar.f2273g = dVar;
        }
        c0 c0Var = shareDiagnosisViewModel.c;
        b bVar2 = new b(c0Var, bVar.a());
        ExecutorService executorService = c0Var.b;
        f.b.b.f.a.c0 c0Var2 = new f.b.b.f.a.c0(bVar2);
        executorService.execute(c0Var2);
        return c0Var2;
    }
}
