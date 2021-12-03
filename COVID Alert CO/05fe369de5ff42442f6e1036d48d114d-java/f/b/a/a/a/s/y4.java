package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import l.b.a.d;

public final class y4 extends ShareDiagnosisViewModel.e {
    public final d a;
    public final Integer b;

    public y4(d dVar, Integer num, a aVar) {
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
        StringBuilder i2 = f.a.a.a.a.i("VerificationCodeRequestLimit{periodDuration=");
        i2.append(this.a);
        i2.append(", numOfRequests=");
        i2.append(this.b);
        i2.append("}");
        return i2.toString();
    }
}
