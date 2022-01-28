package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.r.d;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.b.b;
import f.b.b.b.c;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class j3 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ j3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        a aVar = ShareDiagnosisViewModel.O;
        Objects.requireNonNull(shareDiagnosisViewModel);
        ShareDiagnosisViewModel.O.a("Converting TEKs into DiagnosisKeys...");
        b.y(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i2 = 0;
        for (TemporaryExposureKey temporaryExposureKey : (List) obj) {
            d.a f2 = d.f();
            f2.c(temporaryExposureKey.d());
            f2.b(temporaryExposureKey.c);
            f2.d(temporaryExposureKey.f481e);
            d a2 = f2.a();
            int i3 = i2 + 1;
            if (objArr.length < i3) {
                objArr = Arrays.copyOf(objArr, b.AbstractC0103b.b(objArr.length, i3));
            }
            objArr[i2] = a2;
            i2 = i3;
        }
        return c.p(objArr, i2);
    }
}
