package b.b.k;

import android.view.View;
import b.i.l.m;
import b.i.l.t;

public class n extends t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f401a;

    public n(i iVar) {
        this.f401a = iVar;
    }

    @Override // b.i.l.s
    public void a(View view) {
        this.f401a.p.setAlpha(1.0f);
        this.f401a.s.d(null);
        this.f401a.s = null;
    }

    @Override // b.i.l.t, b.i.l.s
    public void b(View view) {
        this.f401a.p.setVisibility(0);
        this.f401a.p.sendAccessibilityEvent(32);
        if (this.f401a.p.getParent() instanceof View) {
            m.R((View) this.f401a.p.getParent());
        }
    }
}
