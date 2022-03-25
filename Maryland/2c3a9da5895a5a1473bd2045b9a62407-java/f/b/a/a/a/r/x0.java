package f.b.a.a.a.r;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;
import l.b.a.u.c;

public final /* synthetic */ class x0 implements r {
    public final /* synthetic */ e4 a;

    public /* synthetic */ x0(e4 e4Var) {
        this.a = e4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        e4 e4Var = this.a;
        String str = (String) obj;
        c cVar = e4.d0;
        View view = e4Var.F;
        if (view != null) {
            Snackbar.j(view, str, 0).k();
        }
    }
}
