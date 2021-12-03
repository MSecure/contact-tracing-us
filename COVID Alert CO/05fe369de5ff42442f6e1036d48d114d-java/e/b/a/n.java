package e.b.a;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import e.i.c.b;
import e.i.i.k;
import e.i.i.m;
import e.i.i.w;
import java.util.concurrent.atomic.AtomicInteger;

public class n implements k {
    public final /* synthetic */ m a;

    public n(m mVar) {
        this.a = mVar;
    }

    @Override // e.i.i.k
    public w a(View view, w wVar) {
        int d2 = wVar.d();
        int Y = this.a.Y(wVar, null);
        if (d2 != Y) {
            int b = wVar.b();
            int c = wVar.c();
            int a2 = wVar.a();
            int i2 = Build.VERSION.SDK_INT;
            w.d cVar = i2 >= 30 ? new w.c(wVar) : i2 >= 29 ? new w.b(wVar) : new w.a(wVar);
            cVar.c(b.a(b, Y, c, a2));
            wVar = cVar.a();
        }
        AtomicInteger atomicInteger = m.a;
        WindowInsets f2 = wVar.f();
        if (f2 == null) {
            return wVar;
        }
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f2);
        return !onApplyWindowInsets.equals(f2) ? w.h(onApplyWindowInsets, view) : wVar;
    }
}
