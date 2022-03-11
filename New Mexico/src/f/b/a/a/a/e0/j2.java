package f.b.a.a.a.e0;

import f.b.a.e.l.a;
import f.b.a.e.l.s;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.e;
import l.b.a.r;
import l.b.a.t;
import l.b.a.v.c;
/* loaded from: classes.dex */
public final /* synthetic */ class j2 implements s {
    public final /* synthetic */ w6 a;

    public /* synthetic */ j2(w6 w6Var) {
        this.a = w6Var;
    }

    @Override // f.b.a.e.l.s
    public final void a(Object obj) {
        w6 w6Var = this.a;
        c O0 = w6Var.O0();
        e z = e.z(((Long) obj).longValue());
        r rVar = r.f4641g;
        Objects.requireNonNull(z);
        String b = O0.b(t.I(z, rVar));
        w6Var.k0.f2442d.setText(b);
        int checkedChipId = w6Var.k0.c.getCheckedChipId();
        boolean z2 = false;
        boolean z3 = checkedChipId > 0;
        boolean z4 = checkedChipId == R.id.has_symptom_confirmed_selected_date_choice;
        a.c cVar = w6Var.g0;
        Objects.requireNonNull(cVar);
        boolean P0 = w6Var.P0(b, new a(cVar));
        if (z3 && (!z4 || P0)) {
            z2 = true;
        }
        if (!z2) {
            w6Var.R0(b);
        }
    }
}
