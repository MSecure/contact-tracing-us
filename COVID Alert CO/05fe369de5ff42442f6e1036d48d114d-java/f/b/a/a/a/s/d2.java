package f.b.a.a.a.s;

import f.b.a.e.k.a;
import f.b.a.e.k.s;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;
import l.b.a.e;
import l.b.a.r;
import l.b.a.t;
import l.b.a.v.c;

public final /* synthetic */ class d2 implements s {
    public final /* synthetic */ j6 a;

    public /* synthetic */ d2(j6 j6Var) {
        this.a = j6Var;
    }

    @Override // f.b.a.e.k.s
    public final void a(Object obj) {
        j6 j6Var = this.a;
        c F0 = j6Var.F0();
        e z = e.z(((Long) obj).longValue());
        r rVar = r.f4321g;
        Objects.requireNonNull(z);
        String b = F0.b(t.I(z, rVar));
        j6Var.g0.f2188d.setText(b);
        int checkedChipId = j6Var.g0.c.getCheckedChipId();
        boolean z2 = false;
        boolean z3 = checkedChipId > 0;
        boolean z4 = checkedChipId == R.id.has_symptom_confirmed_selected_date_choice;
        a.c cVar = j6Var.d0;
        Objects.requireNonNull(cVar);
        boolean G0 = j6Var.G0(b, new a(cVar));
        if (z3 && (!z4 || G0)) {
            z2 = true;
        }
        if (!z2) {
            j6Var.I0(b);
        }
    }
}
