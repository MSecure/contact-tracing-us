package f.b.a.a.a.p;

import android.widget.Toast;
import e.p.r;
import gov.wi.covid19.exposurenotifications.R;

public final /* synthetic */ class r1 implements r {
    public final /* synthetic */ y3 a;

    public /* synthetic */ r1(y3 y3Var) {
        this.a = y3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        y3 y3Var = this.a;
        Void r4 = (Void) obj;
        if (y3Var.g() != null) {
            Toast.makeText(y3Var.W, (int) R.string.delete_test_result_confirmed, 1).show();
            y3Var.g().finish();
        }
    }
}
