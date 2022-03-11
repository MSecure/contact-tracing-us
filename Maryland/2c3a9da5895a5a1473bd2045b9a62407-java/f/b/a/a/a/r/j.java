package f.b.a.a.a.r;

import android.widget.Toast;
import e.p.r;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class j implements r {
    public final /* synthetic */ q3 a;

    public /* synthetic */ j(q3 q3Var) {
        this.a = q3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        q3 q3Var = this.a;
        Void r3 = (Void) obj;
        if (q3Var.g() != null) {
            Toast.makeText(q3Var.X, (int) R.string.delete_test_result_confirmed, 1).show();
        }
    }
}
