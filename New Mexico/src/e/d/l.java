package e.d;

import e.r.s;
import e.r.t;
/* loaded from: classes.dex */
public class l implements t<Boolean> {
    public final /* synthetic */ e a;

    public l(e eVar) {
        this.a = eVar;
    }

    @Override // e.r.t
    public void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.a.H0(1);
            this.a.I0();
            u uVar = this.a.X;
            if (uVar.w == null) {
                uVar.w = new s<>();
            }
            u.o(uVar.w, Boolean.FALSE);
        }
    }
}
