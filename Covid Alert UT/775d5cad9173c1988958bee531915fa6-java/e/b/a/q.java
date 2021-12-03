package e.b.a;

import android.view.View;
import e.i.i.v;
import e.i.i.z;
import java.util.concurrent.atomic.AtomicInteger;

public class q extends z {
    public final /* synthetic */ m a;

    public q(m mVar) {
        this.a = mVar;
    }

    @Override // e.i.i.y
    public void a(View view) {
        this.a.p.setAlpha(1.0f);
        this.a.s.d(null);
        this.a.s = null;
    }

    @Override // e.i.i.y, e.i.i.z
    public void b(View view) {
        this.a.p.setVisibility(0);
        this.a.p.sendAccessibilityEvent(32);
        if (this.a.p.getParent() instanceof View) {
            AtomicInteger atomicInteger = v.a;
            v.h.c((View) this.a.p.getParent());
        }
    }
}
