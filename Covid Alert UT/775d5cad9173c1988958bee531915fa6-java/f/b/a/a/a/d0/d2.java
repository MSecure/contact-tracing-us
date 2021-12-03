package f.b.a.a.a.d0;

import f.b.a.e.l.a;
import f.b.a.e.l.s;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.e;
import l.b.a.r;
import l.b.a.t;
import l.b.a.v.c;

public final /* synthetic */ class d2 implements s {
    public final /* synthetic */ i6 a;

    public /* synthetic */ d2(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // f.b.a.e.l.s
    public final void a(Object obj) {
        i6 i6Var = this.a;
        c L0 = i6Var.L0();
        e z = e.z(((Long) obj).longValue());
        r rVar = r.f4386g;
        Objects.requireNonNull(z);
        String b = L0.b(t.I(z, rVar));
        i6Var.h0.f2383d.setText(b);
        int checkedChipId = i6Var.h0.c.getCheckedChipId();
        boolean z2 = false;
        boolean z3 = checkedChipId > 0;
        boolean z4 = checkedChipId == R.id.has_symptom_confirmed_selected_date_choice;
        a.c cVar = i6Var.e0;
        Objects.requireNonNull(cVar);
        boolean M0 = i6Var.M0(b, new a(cVar));
        if (z3 && (!z4 || M0)) {
            z2 = true;
        }
        if (!z2) {
            i6Var.O0(b);
        }
    }
}
