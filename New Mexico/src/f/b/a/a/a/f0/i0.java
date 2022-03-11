package f.b.a.a.a.f0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper;
import e.r.f0;
import f.b.a.a.a.x.a1;
import g.b.a.c.c.d;
import g.b.a.c.c.g;
import g.b.b.b;
/* loaded from: classes.dex */
public abstract class i0 extends a1 implements b {
    public ContextWrapper X;
    public volatile g Y;
    public final Object Z = new Object();
    public boolean a0 = false;

    public final void J0() {
        if (this.X == null) {
            this.X = new ViewComponentManager$FragmentContextWrapper(super.k(), this);
        }
    }

    public void K0() {
        if (!this.a0) {
            this.a0 = true;
            ((p0) e()).t((o0) this);
        }
    }

    @Override // e.o.a.m
    public void O(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.X;
        if (!(contextWrapper == null || g.b(contextWrapper) == activity)) {
            z = false;
        }
        d.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        J0();
        K0();
    }

    @Override // e.o.a.m
    public void P(Context context) {
        super.P(context);
        J0();
        K0();
    }

    @Override // e.o.a.m
    public LayoutInflater Z(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(u(), this));
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

    @Override // e.o.a.m
    public Context k() {
        if (super.k() == null && this.X == null) {
            return null;
        }
        J0();
        return this.X;
    }

    @Override // e.o.a.m, e.r.g
    public f0.b l() {
        return f.b.a.c.b.o.b.G0(this, super.l());
    }
}
