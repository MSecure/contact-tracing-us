package f.b.a.a.a.p;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;

public final /* synthetic */ class e0 implements r {
    public final /* synthetic */ l3 a;

    public /* synthetic */ e0(l3 l3Var) {
        this.a = l3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        l3 l3Var = this.a;
        String str = (String) obj;
        int i2 = l3.a0;
        View view = l3Var.F;
        if (view != null) {
            Snackbar.j(view, str, 0).k();
        }
    }
}
