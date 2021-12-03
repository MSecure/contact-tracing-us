package f.b.a.a.a.d0;

import android.content.Context;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import e.q.t;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.a0;
import f.b.a.a.a.s.d0.a;
import gov.ut.covid19.exposurenotifications.R;
import l.b.a.f;
import l.b.a.r;

public final /* synthetic */ class w1 implements t {
    public final /* synthetic */ i6 a;

    public /* synthetic */ w1(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        int i2;
        f k2;
        int i3;
        i6 i6Var = this.a;
        h0 h0Var = (h0) obj;
        h0.e eVar = h0.e.NOT_ATTEMPTED;
        TextView textView = i6Var.h0.f2391l;
        a aVar = a5.a;
        boolean z = true;
        if (h0Var.n() != null) {
            int ordinal = h0Var.n().ordinal();
            i2 = ordinal != 1 ? ordinal != 2 ? R.string.share_upload_status_confirmed : R.string.share_upload_status_negative : R.string.share_upload_status_likely;
        } else {
            i2 = R.string.share_review_status_confirmed;
        }
        textView.setText(i2);
        if (h0Var.d() == h0.b.YES) {
            String E = h0Var.k() == null ? i6Var.E(R.string.share_upload_select_a_date_choice) : i6Var.L0().b(h0Var.k());
            if (!i6Var.h0.f2383d.getText().toString().equals(E)) {
                i6Var.h0.f2383d.setText(E);
            }
            if (h0Var.h()) {
                i6Var.h0.n.setVisibility(8);
                i6Var.h0.f2383d.setEnabled(false);
                i6Var.h0.f2383d.setChecked(true);
                i6Var.h0.f2384e.setVisibility(0);
                TextView textView2 = i6Var.h0.f2384e;
                Context t0 = i6Var.t0();
                a aVar2 = a0.a;
                textView2.setText(i6Var.F(R.string.share_upload_symptoms_date_fixed_description, t0.getString(R.string.health_authority_name)));
            }
            if (i6Var.h0.c.getCheckedChipIds().isEmpty()) {
                i6Var.h0.f2383d.setChecked(true);
            }
        }
        i6Var.h0.f2383d.setOnClickListener(new a2(i6Var, h0Var));
        h0.e o = h0Var.o();
        if (!i6Var.b0.h() && !eVar.equals(o)) {
            int ordinal2 = o.ordinal();
            if (ordinal2 == 1) {
                i3 = R.id.travel_confirmed_choice;
            } else if (ordinal2 == 2) {
                i3 = R.id.no_travel_choice;
            } else if (ordinal2 == 3) {
                i3 = R.id.skip_travel_history_choice;
            } else {
                throw new IllegalStateException("Failed to map travel status to radio button id");
            }
            ((Chip) i6Var.h0.r.findViewById(i3)).setChecked(true);
        }
        f.b.a.a.a.s.e0.a aVar3 = i6Var.d0;
        int ordinal3 = h0Var.d().ordinal();
        if (!(ordinal3 == 1 ? !((k2 = h0Var.k()) == null || !a5.c(aVar3, k2.A(r.f4386g).w().G())) : ordinal3 == 2 || ordinal3 == 3) || (!i6Var.b0.h() && h0Var.o() == eVar)) {
            z = false;
        }
        i6Var.h0.f2387h.setEnabled(z);
    }
}
