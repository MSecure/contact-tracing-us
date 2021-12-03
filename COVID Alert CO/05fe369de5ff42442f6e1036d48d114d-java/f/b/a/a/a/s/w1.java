package f.b.a.a.a.s;

import android.content.Context;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import e.p.t;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.b0;
import f.b.a.a.a.i.e0.a;
import gov.co.cdphe.exposurenotifications.R;
import l.b.a.f;
import l.b.a.r;

public final /* synthetic */ class w1 implements t {
    public final /* synthetic */ j6 a;

    public /* synthetic */ w1(j6 j6Var) {
        this.a = j6Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        int i2;
        f k2;
        int i3;
        j6 j6Var = this.a;
        h0 h0Var = (h0) obj;
        h0.e eVar = h0.e.NOT_ATTEMPTED;
        TextView textView = j6Var.g0.f2196l;
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
            String A = h0Var.k() == null ? j6Var.A(R.string.share_upload_select_a_date_choice) : j6Var.F0().b(h0Var.k());
            if (!j6Var.g0.f2188d.getText().toString().equals(A)) {
                j6Var.g0.f2188d.setText(A);
            }
            if (h0Var.h()) {
                j6Var.g0.n.setVisibility(8);
                j6Var.g0.f2188d.setEnabled(false);
                j6Var.g0.f2188d.setChecked(true);
                j6Var.g0.f2189e.setVisibility(0);
                TextView textView2 = j6Var.g0.f2189e;
                Context p0 = j6Var.p0();
                a aVar2 = b0.a;
                textView2.setText(j6Var.B(R.string.share_upload_symptoms_date_fixed_description, p0.getString(R.string.health_authority_name)));
            }
            if (j6Var.g0.c.getCheckedChipIds().isEmpty()) {
                j6Var.g0.f2188d.setChecked(true);
            }
        }
        j6Var.g0.f2188d.setOnClickListener(new a2(j6Var, h0Var));
        h0.e o = h0Var.o();
        if (!j6Var.a0.h() && !eVar.equals(o)) {
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
            ((Chip) j6Var.g0.r.findViewById(i3)).setChecked(true);
        }
        f.b.a.a.a.i.f0.a aVar3 = j6Var.c0;
        int ordinal3 = h0Var.d().ordinal();
        if (!(ordinal3 == 1 ? !((k2 = h0Var.k()) == null || !a5.c(aVar3, k2.A(r.f4321g).w().G())) : ordinal3 == 2 || ordinal3 == 3) || (!j6Var.a0.h() && h0Var.o() == eVar)) {
            z = false;
        }
        j6Var.g0.f2192h.setEnabled(z);
    }
}
