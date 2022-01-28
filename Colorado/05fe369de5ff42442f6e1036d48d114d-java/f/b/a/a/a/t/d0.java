package f.b.a.a.a.t;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import e.p.f0;
import g.b.a.c.c.c;
import g.b.a.c.c.f;
import g.b.a.c.c.g;
import g.b.b.b;

public abstract class d0 extends b0 implements b {
    public ContextWrapper c0;
    public volatile f d0;
    public final Object e0 = new Object();

    public final void G0() {
        if (this.c0 == null) {
            this.c0 = new g(super.j(), this);
            ((h0) e()).B((g0) this);
        }
    }

    @Override // e.m.a.m
    public void I(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.c0;
        if (!(contextWrapper == null || f.b(contextWrapper) == activity)) {
            z = false;
        }
        c.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        G0();
    }

    @Override // e.m.a.m
    public void J(Context context) {
        super.J(context);
        G0();
    }

    @Override // e.m.a.m
    public LayoutInflater T(Bundle bundle) {
        return LayoutInflater.from(new g(r(), this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.d0 == null) {
            synchronized (this.e0) {
                if (this.d0 == null) {
                    this.d0 = new f(this);
                }
            }
        }
        return this.d0.e();
    }

    @Override // e.m.a.m
    public Context j() {
        return this.c0;
    }

    @Override // e.p.g, e.m.a.m
    public f0.b l() {
        f0.b E0 = f.b.a.c.b.o.b.E0(this);
        return E0 != null ? E0 : super.l();
    }
}
