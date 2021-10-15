package b.b.k;

import android.view.View;
import b.i.l.m;
import b.i.l.t;

public class n extends t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f557a;

    public n(i iVar) {
        this.f557a = iVar;
    }

    @Override // b.i.l.s
    public void a(View view) {
        this.f557a.p.setAlpha(1.0f);
        this.f557a.s.d(null);
        this.f557a.s = null;
    }

    @Override // b.i.l.t, b.i.l.s
    public void b(View view) {
        this.f557a.p.setVisibility(0);
        this.f557a.p.sendAccessibilityEvent(32);
        if (this.f557a.p.getParent() instanceof View) {
            m.S((View) this.f557a.p.getParent());
        }
    }
}
