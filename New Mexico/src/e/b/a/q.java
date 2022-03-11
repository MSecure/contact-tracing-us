package e.b.a;

import android.view.View;
import e.j.j.v;
import e.j.j.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class q extends z {
    public final /* synthetic */ m a;

    public q(m mVar) {
        this.a = mVar;
    }

    @Override // e.j.j.y
    public void a(View view) {
        this.a.p.setAlpha(1.0f);
        this.a.s.d(null);
        this.a.s = null;
    }

    @Override // e.j.j.z, e.j.j.y
    public void b(View view) {
        this.a.p.setVisibility(0);
        this.a.p.sendAccessibilityEvent(32);
        if (this.a.p.getParent() instanceof View) {
            AtomicInteger atomicInteger = v.a;
            v.h.c((View) this.a.p.getParent());
        }
    }
}
