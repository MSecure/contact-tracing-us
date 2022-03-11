package f.b.a.a.a.r;

import android.widget.Toast;
import e.p.r;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class z0 implements r {
    public final /* synthetic */ e4 a;

    public /* synthetic */ z0(e4 e4Var) {
        this.a = e4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        e4 e4Var = this.a;
        Void r4 = (Void) obj;
        if (e4Var.g() != null) {
            Toast.makeText(e4Var.X, (int) R.string.delete_test_result_confirmed, 1).show();
            e4Var.g().finish();
        }
    }
}
