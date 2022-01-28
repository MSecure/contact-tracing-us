package f.b.a.a.a.u;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper;
import e.q.f0;
import g.b.a.c.c.d;
import g.b.a.c.c.g;
import g.b.b.b;

public abstract class m extends l implements b {
    public ContextWrapper Y;
    public volatile g Z;
    public final Object a0 = new Object();
    public boolean b0 = false;

    @Override // e.n.a.m
    public void M(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.Y;
        if (!(contextWrapper == null || g.b(contextWrapper) == activity)) {
            z = false;
        }
        d.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        N0();
        O0();
    }

    @Override // e.n.a.m
    public void N(Context context) {
        super.N(context);
        N0();
        O0();
    }

    public final void N0() {
        if (this.Y == null) {
            this.Y = new ViewComponentManager$FragmentContextWrapper(super.j(), this);
        }
    }

    public void O0() {
        if (!this.b0) {
            this.b0 = true;
            ((k) e()).d((j) this);
        }
    }

    @Override // e.n.a.m
    public LayoutInflater X(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(t(), this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.Z == null) {
            synchronized (this.a0) {
                if (this.Z == null) {
                    this.Z = new g(this);
                }
            }
        }
        return this.Z.e();
    }

    @Override // e.n.a.m
    public Context j() {
        if (super.j() == null && this.Y == null) {
            return null;
        }
        N0();
        return this.Y;
    }

    @Override // e.q.g, e.n.a.m
    public f0.b l() {
        return f.b.a.c.b.o.b.F0(this, super.l());
    }
}
