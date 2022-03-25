package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import f.b.a.a.a.q.a;
import f.b.a.a.a.q.d;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.b.b;
import f.b.b.c.a;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import l.b.a.c;

public final /* synthetic */ class h2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ h2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        c cVar = ShareDiagnosisViewModel.B;
        Objects.requireNonNull(shareDiagnosisViewModel);
        b.z(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i2 = 0;
        for (TemporaryExposureKey temporaryExposureKey : (List) obj) {
            a aVar = d.a;
            a.b bVar = new a.b();
            bVar.b(144);
            bVar.c(1);
            bVar.a = new d.b(temporaryExposureKey.d());
            bVar.b = Integer.valueOf(temporaryExposureKey.c);
            bVar.b(temporaryExposureKey.f453e);
            d a2 = bVar.a();
            int i3 = i2 + 1;
            if (objArr.length < i3) {
                objArr = Arrays.copyOf(objArr, b.AbstractC0104b.b(objArr.length, i3));
            }
            objArr[i2] = a2;
            i2 = i3;
        }
        return f.b.b.b.c.p(objArr, i2);
    }
}
