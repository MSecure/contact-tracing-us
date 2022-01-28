package e.b.a;

import android.os.Build;
import android.view.View;
import e.i.c.b;
import e.i.i.b0;
import e.i.i.v;

public class n implements e.i.i.n {
    public final /* synthetic */ m a;

    public n(m mVar) {
        this.a = mVar;
    }

    @Override // e.i.i.n
    public b0 a(View view, b0 b0Var) {
        int d2 = b0Var.d();
        int Y = this.a.Y(b0Var, null);
        if (d2 != Y) {
            int b = b0Var.b();
            int c = b0Var.c();
            int a2 = b0Var.a();
            int i2 = Build.VERSION.SDK_INT;
            b0.e dVar = i2 >= 30 ? new b0.d(b0Var) : i2 >= 29 ? new b0.c(b0Var) : new b0.b(b0Var);
            dVar.c(b.a(b, Y, c, a2));
            b0Var = dVar.a();
        }
        return v.p(view, b0Var);
    }
}
