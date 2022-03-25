package f.b.a.a.a.r;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;

public final /* synthetic */ class b0 implements r {
    public final /* synthetic */ x3 a;

    public /* synthetic */ b0(x3 x3Var) {
        this.a = x3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        x3 x3Var = this.a;
        String str = (String) obj;
        int i2 = x3.c0;
        View view = x3Var.F;
        if (view != null) {
            Snackbar.j(view, str, 0).k();
        }
    }
}
