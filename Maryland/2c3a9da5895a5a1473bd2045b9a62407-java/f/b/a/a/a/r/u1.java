package f.b.a.a.a.r;

import android.widget.Toast;
import e.p.r;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class u1 implements r {
    public final /* synthetic */ k4 a;

    public /* synthetic */ u1(k4 k4Var) {
        this.a = k4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        k4 k4Var = this.a;
        Void r4 = (Void) obj;
        if (k4Var.g() != null) {
            Toast.makeText(k4Var.X, (int) R.string.delete_test_result_confirmed, 1).show();
            k4Var.g().finish();
        }
    }
}
