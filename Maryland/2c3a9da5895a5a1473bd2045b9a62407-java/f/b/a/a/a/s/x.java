package f.b.a.a.a.s;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import e.m.a.l;
import e.p.b0;
import g.a.a.c.c.e;
import g.a.a.c.c.f;
import g.a.b.b;

public abstract class x extends l implements b {
    public ContextWrapper X;
    public volatile e Y;
    public final Object Z = new Object();

    @Override // e.m.a.l
    public void J(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.X;
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
    public final Object e() {
        if (this.Y == null) {
            synchronized (this.Z) {
                if (this.Y == null) {
                    this.Y = new e(this);
                }
            }
        }
        return this.Y.e();
    }

    @Override // e.m.a.l
    public Context k() {
        return this.X;
    }

    @Override // e.p.f, e.m.a.l
    public b0.b l() {
        b0.b R0 = f.b.a.c.b.o.b.R0(this);
        return R0 != null ? R0 : super.l();
    }

    public final void y0() {
        if (this.X == null) {
            this.X = new f(super.k(), this);
            ((d0) e()).e((c0) this);
        }
    }
}
