package f.b.a.a.a.e0;

import android.text.Editable;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.k;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.t.w;
import f.b.b.a.g;
import gov.nm.covid19.exposurenotifications.R;
import l.b.a.f;
/* loaded from: classes.dex */
public class v6 extends w {
    public final /* synthetic */ w6 b;

    public v6(w6 w6Var) {
        this.b = w6Var;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        w6 w6Var = this.b;
        int checkedChipId = w6Var.k0.c.getCheckedChipId();
        String charSequence = w6Var.k0.f2442d.getText().toString();
        if (checkedChipId == R.id.has_symptom_confirmed_selected_date_choice && w6Var.P0(charSequence, h2.a)) {
            w6Var.b0.p(new g() { // from class: f.b.a.a.a.e0.w3
                @Override // f.b.b.a.g
                public final Object a(Object obj) {
                    f fVar = f.this;
                    a aVar = ShareDiagnosisViewModel.R;
                    j0.a r = ((j0) obj).r();
                    r.c(j0.b.YES);
                    k.b bVar = (k.b) r;
                    bVar.f2362h = fVar;
                    return bVar.a();
                }
            });
        }
    }
}
