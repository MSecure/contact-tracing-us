package f.b.a.a.a.p;

import android.widget.Toast;
import e.p.r;
import gov.ca.covid19.exposurenotifications.R;

public final /* synthetic */ class a1 implements r {
    public final /* synthetic */ s3 a;

    public /* synthetic */ a1(s3 s3Var) {
        this.a = s3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        s3 s3Var = this.a;
        Void r4 = (Void) obj;
        if (s3Var.g() != null) {
            Toast.makeText(s3Var.W, (int) R.string.delete_test_result_confirmed, 1).show();
            s3Var.g().finish();
        }
    }
}
