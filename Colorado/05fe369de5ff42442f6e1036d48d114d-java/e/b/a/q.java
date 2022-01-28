package e.b.a;

import android.view.View;
import e.i.i.m;
import e.i.i.u;
import java.util.concurrent.atomic.AtomicInteger;

public class q extends u {
    public final /* synthetic */ m a;

    public q(m mVar) {
        this.a = mVar;
    }

    @Override // e.i.i.t
    public void a(View view) {
        this.a.p.setAlpha(1.0f);
        this.a.s.d(null);
        this.a.s = null;
    }

    @Override // e.i.i.u, e.i.i.t
    public void b(View view) {
        this.a.p.setVisibility(0);
        this.a.p.sendAccessibilityEvent(32);
        if (this.a.p.getParent() instanceof View) {
            AtomicInteger atomicInteger = m.a;
            ((View) this.a.p.getParent()).requestApplyInsets();
        }
    }
}
