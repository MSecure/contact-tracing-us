package f.b.a.a.a.e0;

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

public abstract class f0 extends d0 implements b {
    public ContextWrapper c0;
    public volatile g d0;
    public final Object e0 = new Object();
    public boolean f0 = false;

    public final void L0() {
        if (this.c0 == null) {
            this.c0 = new ViewComponentManager$FragmentContextWrapper(super.j(), this);
        }
    }

    @Override // e.n.a.m
    public void M(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.c0;
        if (!(contextWrapper == null || g.b(contextWrapper) == activity)) {
            z = false;
        }
        d.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        L0();
        M0();
    }

    public void M0() {
        if (!this.f0) {
            this.f0 = true;
            ((j0) e()).B((i0) this);
        }
    }

    @Override // e.n.a.m
    public void N(Context context) {
        super.N(context);
        L0();
        M0();
    }

    @Override // e.n.a.m
    public LayoutInflater X(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(t(), this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.d0 == null) {
            synchronized (this.e0) {
                if (this.d0 == null) {
                    this.d0 = new g(this);
                }
            }
        }
        return this.d0.e();
    }

    @Override // e.n.a.m
    public Context j() {
        if (super.j() == null && this.c0 == null) {
            return null;
        }
        L0();
        return this.c0;
    }

    @Override // e.q.g, e.n.a.m
    public f0.b l() {
        return f.b.a.c.b.o.b.F0(this, super.l());
    }
}
