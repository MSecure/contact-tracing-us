package f.b.a.a.a.s;

import android.widget.Toast;
import e.p.t;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class p2 implements t {
    public final /* synthetic */ m6 a;

    public /* synthetic */ p2(m6 m6Var) {
        this.a = m6Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        m6 m6Var = this.a;
        Void r4 = (Void) obj;
        Toast.makeText(m6Var.e0, (int) R.string.delete_test_result_confirmed, 1).show();
        m6Var.C0();
    }
}
