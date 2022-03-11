package e.d;

import androidx.biometric.R$string;
import e.r.s;
import e.r.t;
/* loaded from: classes.dex */
public class j implements t<Boolean> {
    public final /* synthetic */ e a;

    public j(e eVar) {
        this.a = eVar;
    }

    @Override // e.r.t
    public void a(Boolean bool) {
        if (bool.booleanValue()) {
            e eVar = this.a;
            if (eVar.L0()) {
                eVar.P0(eVar.F(R$string.fingerprint_not_recognized));
            }
            u uVar = eVar.X;
            if (uVar.m) {
                uVar.f().execute(new f(eVar));
            }
            u uVar2 = this.a.X;
            if (uVar2.t == null) {
                uVar2.t = new s<>();
            }
            u.o(uVar2.t, Boolean.FALSE);
        }
    }
}
