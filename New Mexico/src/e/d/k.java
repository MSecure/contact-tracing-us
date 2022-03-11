package e.d;

import androidx.biometric.R$string;
import e.r.t;
/* loaded from: classes.dex */
public class k implements t<Boolean> {
    public final /* synthetic */ e a;

    public k(e eVar) {
        this.a = eVar;
    }

    @Override // e.r.t
    public void a(Boolean bool) {
        if (bool.booleanValue()) {
            if (this.a.K0()) {
                this.a.M0();
            } else {
                e eVar = this.a;
                CharSequence h2 = eVar.X.h();
                if (h2 == null) {
                    h2 = eVar.F(R$string.default_error_msg);
                }
                eVar.N0(13, h2);
                eVar.I0();
                eVar.H0(2);
            }
            this.a.X.n(false);
        }
    }
}
