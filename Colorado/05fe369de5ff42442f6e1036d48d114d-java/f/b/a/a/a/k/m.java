package f.b.a.a.a.k;

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

public abstract class m extends l implements b {
    public ContextWrapper Y;
    public volatile f Z;
    public final Object a0 = new Object();

    @Override // e.m.a.m
    public void I(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.Y;
        if (!(contextWrapper == null || f.b(contextWrapper) == activity)) {
            z = false;
        }
        c.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        I0();
    }

    public final void I0() {
        if (this.Y == null) {
            this.Y = new g(super.j(), this);
            ((k) e()).d((j) this);
        }
    }

    @Override // e.m.a.m
    public void J(Context context) {
        super.J(context);
        I0();
    }

    @Override // e.m.a.m
    public LayoutInflater T(Bundle bundle) {
        return LayoutInflater.from(new g(r(), this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.Z == null) {
            synchronized (this.a0) {
                if (this.Z == null) {
                    this.Z = new f(this);
                }
            }
        }
        return this.Z.e();
    }

    @Override // e.m.a.m
    public Context j() {
        return this.Y;
    }

    @Override // e.p.g, e.m.a.m
    public f0.b l() {
        f0.b E0 = f.b.a.c.b.o.b.E0(this);
        return E0 != null ? E0 : super.l();
    }
}
