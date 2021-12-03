package f.b.a.a.a.m;

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

public abstract class d1 extends z0 implements b {
    public ContextWrapper X;
    public volatile f Y;
    public final Object Z = new Object();

    public final void B0() {
        if (this.X == null) {
            this.X = new g(super.j(), this);
            ((g1) e()).k((f1) this);
        }
    }

    @Override // e.m.a.m
    public void I(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.X;
        if (!(contextWrapper == null || f.b(contextWrapper) == activity)) {
            z = false;
        }
        c.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        B0();
    }

    @Override // e.m.a.m
    public void J(Context context) {
        super.J(context);
        B0();
    }

    @Override // e.m.a.m
    public LayoutInflater T(Bundle bundle) {
        return LayoutInflater.from(new g(r(), this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.Y == null) {
            synchronized (this.Z) {
                if (this.Y == null) {
                    this.Y = new f(this);
                }
            }
        }
        return this.Y.e();
    }

    @Override // e.m.a.m
    public Context j() {
        return this.X;
    }

    @Override // e.p.g, e.m.a.m
    public f0.b l() {
        f0.b E0 = f.b.a.c.b.o.b.E0(this);
        return E0 != null ? E0 : super.l();
    }
}
