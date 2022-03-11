package f.b.a.a.a.q;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import e.m.a.l;
import e.p.b0;
import g.a.a.b.c.e;
import g.a.a.b.c.f;
import g.a.b.b;

public abstract class x extends l implements b {
    public ContextWrapper W;
    public volatile e X;
    public final Object Y = new Object();

    @Override // e.m.a.l
    public void J(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.W;
        if (!(contextWrapper == null || e.b(contextWrapper) == activity)) {
            z = false;
        }
        f.b.a.c.b.o.b.I(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        y0();
    }

    @Override // e.m.a.l
    public void K(Context context) {
        super.K(context);
        y0();
    }

    @Override // e.m.a.l
    public LayoutInflater T(Bundle bundle) {
        return LayoutInflater.from(new f(r(), this));
    }

    @Override // g.a.b.b
    public final Object d() {
        if (this.X == null) {
            synchronized (this.Y) {
                if (this.X == null) {
                    this.X = new e(this);
                }
            }
        }
        return this.X.d();
    }

    @Override // e.p.f, e.m.a.l
    public b0.b k() {
        b0.b Q0 = f.b.a.c.b.o.b.Q0(this);
        return Q0 != null ? Q0 : super.k();
    }

    @Override // e.m.a.l
    public Context l() {
        return this.W;
    }

    public final void y0() {
        if (this.W == null) {
            this.W = new f(super.l(), this);
            ((d0) d()).c((c0) this);
        }
    }
}
