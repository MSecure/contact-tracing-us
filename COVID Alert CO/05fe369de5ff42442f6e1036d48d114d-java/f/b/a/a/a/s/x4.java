package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.a.a.a.a;
import f.b.b.a.l;
import java.util.Objects;

public final class x4 extends ShareDiagnosisViewModel.a {
    public final boolean a;
    public final l<String> b;

    public x4(boolean z, l<String> lVar) {
        this.a = z;
        Objects.requireNonNull(lVar, "Null verificationCodeToPrefill");
        this.b = lVar;
    }

    @Override // com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.a
    public boolean a() {
        return this.a;
    }

    @Override // com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.a
    public l<String> b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareDiagnosisViewModel.a)) {
            return false;
        }
        ShareDiagnosisViewModel.a aVar = (ShareDiagnosisViewModel.a) obj;
        return this.a == aVar.a() && this.b.equals(aVar.b());
    }

    public int hashCode() {
        return (((this.a ? 1231 : 1237) ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder i2 = a.i("EnterCodeStepReturnValue{revealPage=");
        i2.append(this.a);
        i2.append(", verificationCodeToPrefill=");
        i2.append(this.b);
        i2.append("}");
        return i2.toString();
    }
}
