package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.a.a.a.a;
import f.b.b.a.l;
import java.util.Objects;

public final class e3 extends ShareDiagnosisViewModel.b {
    public final boolean a;
    public final l<String> b;

    public e3(boolean z, l<String> lVar) {
        this.a = z;
        Objects.requireNonNull(lVar, "Null verificationCodeToPrefill");
        this.b = lVar;
    }

    @Override // com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b
    public boolean a() {
        return this.a;
    }

    @Override // com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b
    public l<String> b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareDiagnosisViewModel.b)) {
            return false;
        }
        ShareDiagnosisViewModel.b bVar = (ShareDiagnosisViewModel.b) obj;
        return this.a == bVar.a() && this.b.equals(bVar.b());
    }

    public int hashCode() {
        return (((this.a ? 1231 : 1237) ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder h2 = a.h("EnterCodeStepReturnValue{revealPage=");
        h2.append(this.a);
        h2.append(", verificationCodeToPrefill=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
