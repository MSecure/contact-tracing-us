package f.b.a.a.a.v;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper;
import e.q.f0;
import f.b.a.a.a.w.z0;
import g.b.a.c.c.d;
import g.b.a.c.c.g;
import g.b.b.b;

public abstract class m extends z0 implements b {
    public ContextWrapper X;
    public volatile g Y;
    public final Object Z = new Object();
    public boolean a0 = false;

    public final void G0() {
        if (this.X == null) {
            this.X = new ViewComponentManager$FragmentContextWrapper(super.j(), this);
        }
    }

    public void H0() {
        if (!this.a0) {
            this.a0 = true;
            ((o) e()).o((n) this);
        }
    }

    @Override // e.n.a.m
    public void M(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.X;
        if (!(contextWrapper == null || g.b(contextWrapper) == activity)) {
            z = false;
        }
        d.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        G0();
        H0();
    }

    @Override // e.n.a.m
    public void N(Context context) {
        super.N(context);
        G0();
        H0();
    }

    @Override // e.n.a.m
    public LayoutInflater X(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(t(), this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.Y == null) {
            synchronized (this.Z) {
                if (this.Y == null) {
                    this.Y = new g(this);
                }
            }
        }
        return this.Y.e();
    }

    @Override // e.n.a.m
    public Context j() {
        if (super.j() == null && this.X == null) {
            return null;
        }
        G0();
        return this.X;
    }

    @Override // e.q.g, e.n.a.m
    public f0.b l() {
        return f.b.a.c.b.o.b.F0(this, super.l());
    }
}
