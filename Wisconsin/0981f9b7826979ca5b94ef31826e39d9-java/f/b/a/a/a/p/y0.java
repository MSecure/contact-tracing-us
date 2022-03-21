package f.b.a.a.a.p;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;
import l.b.a.u.c;

public final /* synthetic */ class y0 implements r {
    public final /* synthetic */ s3 a;

    public /* synthetic */ y0(s3 s3Var) {
        this.a = s3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        s3 s3Var = this.a;
        String str = (String) obj;
        c cVar = s3.b0;
        View view = s3Var.F;
        if (view != null) {
            Snackbar.j(view, str, 0).k();
        }
    }
}
