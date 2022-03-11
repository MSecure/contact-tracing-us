package e.b.a;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import e.i.c.b;
import e.i.i.j;
import e.i.i.l;
import e.i.i.v;
import java.util.concurrent.atomic.AtomicInteger;

public class n implements j {
    public final /* synthetic */ m a;

    public n(m mVar) {
        this.a = mVar;
    }

    @Override // e.i.i.j
    public v a(View view, v vVar) {
        int d2 = vVar.d();
        int Y = this.a.Y(vVar, null);
        if (d2 != Y) {
            int b = vVar.b();
            int c = vVar.c();
            int a2 = vVar.a();
            int i2 = Build.VERSION.SDK_INT;
            v.d cVar = i2 >= 30 ? new v.c(vVar) : i2 >= 29 ? new v.b(vVar) : new v.a(vVar);
            cVar.c(b.a(b, Y, c, a2));
            vVar = cVar.a();
        }
        AtomicInteger atomicInteger = l.a;
        WindowInsets f2 = vVar.f();
        if (f2 == null) {
            return vVar;
        }
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f2);
        return !onApplyWindowInsets.equals(f2) ? v.h(onApplyWindowInsets, view) : vVar;
    }
}
