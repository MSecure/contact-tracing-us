package f.b.a.a.a.e0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import l.b.a.d;
/* loaded from: classes.dex */
public final class m5 extends ShareDiagnosisViewModel.e {
    public final d a;
    public final Integer b;

    public m5(d dVar, Integer num, a aVar) {
        this.a = dVar;
        this.b = num;
    }

    @Override // com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.e
    public Integer a() {
        return this.b;
    }

    @Override // com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.e
    public d b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareDiagnosisViewModel.e)) {
            return false;
        }
        ShareDiagnosisViewModel.e eVar = (ShareDiagnosisViewModel.e) obj;
        return this.a.equals(eVar.b()) && this.b.equals(eVar.a());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("VerificationCodeRequestLimit{periodDuration=");
        h2.append(this.a);
        h2.append(", numOfRequests=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
