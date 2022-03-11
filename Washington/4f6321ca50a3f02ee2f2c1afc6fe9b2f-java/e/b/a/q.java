package e.b.a;

import android.view.View;
import e.i.i.l;
import e.i.i.t;
import java.util.concurrent.atomic.AtomicInteger;

public class q extends t {
    public final /* synthetic */ m a;

    public q(m mVar) {
        this.a = mVar;
    }

    @Override // e.i.i.s
    public void a(View view) {
        this.a.p.setAlpha(1.0f);
        this.a.s.d(null);
        this.a.s = null;
    }

    @Override // e.i.i.s, e.i.i.t
    public void b(View view) {
        this.a.p.setVisibility(0);
        this.a.p.sendAccessibilityEvent(32);
        if (this.a.p.getParent() instanceof View) {
            AtomicInteger atomicInteger = l.a;
            ((View) this.a.p.getParent()).requestApplyInsets();
        }
    }
}
